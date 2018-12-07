package com.zh.touchassistant.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.zh.touchassistant.util.FileUtil;
import com.zh.touchassistant.util.ScreenUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/**
 * <b>Package:</b> com.zh.touchassistant.screenshot <br>
 * <b>FileName:</b> ScreenCaptureAgent <br>
 * <b>Create Date:</b> 2018/12/7  下午12:45 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ScreenCaptureAgent {
    private static final int REQUEST_CODE_SCREEN_CAPTURE = 1000;

    private Activity mActivity;
    private SaveScreenshotCallback mCallback;
    private MediaProjection mMediaProjection;
    private VirtualDisplay mVirtualDisplay;

    public ScreenCaptureAgent(Activity activity) {
        mActivity = activity;
    }

    public Activity getActivity() {
        return mActivity;
    }

    private MediaProjectionManager getMediaProjectionManager() {
        return (MediaProjectionManager) getActivity().getSystemService(Context.MEDIA_PROJECTION_SERVICE);
    }

    /**
     * 开始截图
     */
    public void startScreenCapture(SaveScreenshotCallback callback) {
        this.mCallback = callback;
        MediaProjectionManager mediaProjectionManager = getMediaProjectionManager();
        getActivity().startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_CODE_SCREEN_CAPTURE);
    }

    public void onActivityDestroy() {
        if (mVirtualDisplay != null) {
            mVirtualDisplay.release();
            mVirtualDisplay = null;
        }
    }

    public void onActivityResult(int requestCode, final int resultCode, final Intent data) {
        if (requestCode == REQUEST_CODE_SCREEN_CAPTURE && resultCode == Activity.RESULT_OK && data != null) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    mMediaProjection = getMediaProjectionManager().getMediaProjection(resultCode, data);
                    int screenWidth = ScreenUtil.getScreenWidth(getActivity());
                    int screenHeight = ScreenUtil.getScreenHeight(getActivity());
                    //将屏幕画面放入ImageReader关联的Surface中
                    final ImageReader imageReader = ImageReader.newInstance(
                            screenWidth,
                            screenHeight,
                            PixelFormat.RGBA_8888,
                            1);
                    mVirtualDisplay = mMediaProjection.createVirtualDisplay("screen-mirror",
                            screenWidth,
                            screenHeight,
                            Resources.getSystem().getDisplayMetrics().densityDpi,
                            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                            imageReader.getSurface(),
                            null,
                            null);
                    //保存截屏，因为截图需要一定时间，必须设置监听
                    imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                        @Override
                        public void onImageAvailable(ImageReader reader) {
                            SaveScreenshotTask task = new SaveScreenshotTask(getActivity(), mCallback);
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, reader.acquireLatestImage());
                            imageReader.setOnImageAvailableListener(null, null);
                            if (mMediaProjection != null) {
                                mMediaProjection.stop();
                                mMediaProjection = null;
                            }
                        }
                    }, getBackgroundHandler());
                    imageReader.acquireLatestImage();
                }
            };
            new Handler(Looper.getMainLooper()).postDelayed(runnable, 100);
        }
    }

    private Handler mBackgroundHandler;

    private Handler getBackgroundHandler() {
        if (mBackgroundHandler == null) {
            HandlerThread backgroundThread =
                    new HandlerThread("cat_window", android.os.Process
                            .THREAD_PRIORITY_BACKGROUND);
            backgroundThread.start();
            mBackgroundHandler = new Handler(backgroundThread.getLooper());
        }
        return mBackgroundHandler;
    }

    public interface SaveScreenshotCallback {
        /**
         * 保存成功
         */
        void onSaveSuccess();

        /**
         * 保存失败
         */
        void onSaveFail();
    }

    private static class SaveScreenshotTask extends AsyncTask<Image, Void, Bitmap> {
        private final WeakReference<Activity> mActivityWeakReference;
        private SaveScreenshotCallback mCallback;

        public SaveScreenshotTask(Activity activity, SaveScreenshotCallback callback) {
            this.mActivityWeakReference = new WeakReference<>(activity);
            this.mCallback = callback;
        }

        @Override
        protected Bitmap doInBackground(Image... params) {
            Display display = ((WindowManager) mActivityWeakReference.get().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getRealMetrics(metrics);
            Point point = new Point();
            display.getRealSize(point);
            int width = point.x;
            int height = point.y;
            Image image = params[0];
            //Image转换成Bitmap
            final Image.Plane[] planes = image.getPlanes();
            final ByteBuffer buffer = planes[0].getBuffer();
            //Image中的行宽，大于Bitmap所设的真实行宽
            int rowStride = planes[0].getRowStride();
            byte[] oldBuffer = new byte[rowStride * height];
            buffer.get(oldBuffer);
            byte[] newBuffer = new byte[width * 4 * height];
            Bitmap bitmap = Bitmap.createBitmap(metrics, width, height, Bitmap.Config.ARGB_8888);
            for (int i = 0; i < height; ++i) {
                //跳过多余的行宽部分，关键代码
                System.arraycopy(oldBuffer, i * rowStride, newBuffer, i * width * 4, width * 4);
            }
            //用byte数组填充bitmap，关键代码
            bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(newBuffer));
            image.close();
            File fileImage = null;
            if (bitmap != null) {
                try {
                    //通知相册更新
                    String dirPath = FileUtil.getScreenShotPath(mActivityWeakReference.get().getApplicationContext());
                    String fileName = FileUtil.getScreenShotsName();
                    fileImage = new File(dirPath, fileName);
                    if (!fileImage.exists()) {
                        fileImage.createNewFile();
                    }
                    FileOutputStream out = new FileOutputStream(fileImage);
                    if (out != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                        out.flush();
                        out.close();
                        Intent media = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        Uri contentUri = Uri.fromFile(fileImage);
                        media.setData(contentUri);
                        mActivityWeakReference.get().sendBroadcast(media);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    fileImage = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    fileImage = null;
                }
            }
            if (fileImage != null) {
                return bitmap;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                if (mCallback != null) {
                    mCallback.onSaveSuccess();
                }
            } else {
                if (mCallback != null) {
                    mCallback.onSaveFail();
                }
            }
        }
    }
}