package com.zh.touchassistant.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> FileUtil <br>
 * <b>Create Date:</b> 2018/12/7  下午12:52 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FileUtil {
    /**
     * 系统保存截图的路径
     */
    public static final String SCREEN_CAPTURE_PATH = "ScreenCapture" + File.separator + "Screenshots" + File.separator;
    public static final String SCREENSHOT_NAME = "Screenshot";

    public static String getAppPath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return Environment.getExternalStorageDirectory().toString();
        } else {
            return context.getFilesDir().toString();
        }
    }

    public static String getScreenShotPath(Context context) {
        StringBuffer stringBuffer = new StringBuffer(getAppPath(context));
        stringBuffer.append(File.separator);
        stringBuffer.append(SCREEN_CAPTURE_PATH);
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuffer.toString();
    }

    public static String getScreenShotsName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String date = simpleDateFormat.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SCREENSHOT_NAME);
        stringBuffer.append("_");
        stringBuffer.append(date);
        stringBuffer.append(".png");
        return stringBuffer.toString();
    }
}