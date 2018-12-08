package com.zh.touchassistant.util;

import android.app.Activity;
import android.view.WindowManager;

/**
 * 状态栏工具类
 */
public class StatusBarUtil {
    private StatusBarUtil() {
    }

    public static void hideStatusBar(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            activity.getWindow().setAttributes(attrs);
        }
    }

    public static void showStatusBar(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            activity.getWindow().setAttributes(attrs);
        }
    }
}