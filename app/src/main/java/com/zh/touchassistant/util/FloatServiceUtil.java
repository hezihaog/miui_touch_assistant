package com.zh.touchassistant.util;

import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.service.CoreService;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> FloatServiceUtil <br>
 * <b>Create Date:</b> 2018/12/14  下午11:23 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatServiceUtil {
    private FloatServiceUtil() {
    }

    /**
     * 开关悬浮窗
     */
    public static void setEnableFloatWindow(Context context, boolean isEnable) {
        Intent intent = new Intent(context, CoreService.class);
        if (isEnable) {
            intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW);
        } else {
            intent.setAction(CoreService.Action.ACTION_HIDE_FLOATING_WINDOW);
        }
        context.startService(intent);
    }
}