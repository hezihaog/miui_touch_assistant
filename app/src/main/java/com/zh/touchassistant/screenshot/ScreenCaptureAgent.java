package com.zh.touchassistant.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.zh.touchassistant.R;
import com.zh.touchassistant.util.FileUtil;
import com.zh.touchassistant.util.NotifyUtil;
import com.zh.touchassistant.util.ScreenUtil;

import java.io.File;
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
            //Image转Bitmap
            Image image = params[0];
            int width = image.getWidth();
            int height = image.getHeight();
            final Image.Plane[] planes = image.getPlanes();
            final ByteBuffer buffer = planes[0].getBuffer();
            //每个像素的间距
            int pixelStride = planes[0].getPixelStride();
            //总的间距
            int rowStride = planes[0].getRowStride();
            int rowPadding = rowStride - pixelStride * width;
            Bitmap bitmap = Bitmap.createBitmap(width + rowPadding / pixelStride, height, Bitmap.Config.ARGB_8888);
            bitmap.copyPixelsFromBuffer(buffer);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
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
                        //刷新图库
                        Context context = mActivityWeakReference.get().getApplicationContext();
                        NotifyUtil.notifyImageGalleryUpdate(context, fileImage.getName());
                        //发送截图成功的通知
                        NotifyUtil.sendScreenshotNotification(context
                                , R.mipmap.ic_launcher,
                                "截图成功",
                                "点击打开截图",
                                bitmap,
                                fileImage);
                    }
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