package com.zh.touchassistant.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;

import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> NotifyUtil <br>
 * <b>Create Date:</b> 2018/12/14  下午8:11 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class NotifyUtil {
    private NotifyUtil() {
    }

    /**
     * 插入图片信息到数据库，并且发送添加广播
     */
    public static void notifyImageGalleryUpdate(Context context, String fileName) {
        //4.4以上需要自己插入到数据库
        final ContentValues values = new ContentValues(2);
        values.put(MediaStore.Video.Media.MIME_TYPE, "image/jpeg/jpg");
        values.put(MediaStore.Video.Media.DATA, fileName);
        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //发送添加广播，4.4以下有效
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://" + fileName)));
    }

    /**
     * 发送截图的通知消息
     *
     * @param smallIconResId 显示的图标资源Id
     * @param contentTitle   标题
     * @param contentText    内容
     * @param bitmap         大图
     * @param imageFile      图片文件File对象
     */
    public static void sendScreenshotNotification(Context context,
                                                  int smallIconResId,
                                                  String contentTitle,
                                                  String contentText,
                                                  Bitmap bitmap,
                                                  File imageFile) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(smallIconResId);
        builder.setContentTitle(contentTitle);
        builder.setContentText(contentText);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(bitmap);
        builder.setStyle(bigPictureStyle);
        Intent openAlbumIntent = new Intent(Intent.ACTION_VIEW);
        Uri imgUri = FileProvider7.getUriForFile(context, imageFile);
        openAlbumIntent.setDataAndType(imgUri, "image/jpg");
        openAlbumIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                0,
                openAlbumIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        //适配9.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //第三个参数设置通知的优先级别
            NotificationChannel channel =
                    new NotificationChannel("10086", "截图通知渠道", NotificationManager.IMPORTANCE_DEFAULT);
            channel.canBypassDnd();//是否可以绕过请勿打扰模式
            channel.canShowBadge();//是否可以显示icon角标
            channel.enableLights(true);//是否显示通知闪灯
            channel.enableVibration(true);//收到小时时震动提示
            channel.setBypassDnd(true);//设置绕过免打扰
            channel.setLockscreenVisibility(NotificationCompat.VISIBILITY_SECRET);
            channel.setLightColor(Color.RED);//设置闪光灯颜色
            channel.getAudioAttributes();//获取设置铃声设置
            channel.setVibrationPattern(new long[]{100, 200, 100});//设置震动模式
            channel.shouldShowLights();//是否会闪光
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
            builder.setChannelId(channel.getId());//这个id参数要与上面channel构建的第一个参数对应
        }
        manager.notify(0, builder.build());
    }
}