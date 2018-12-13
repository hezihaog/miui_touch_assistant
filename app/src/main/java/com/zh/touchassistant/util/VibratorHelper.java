package com.zh.touchassistant.util;

import android.content.Context;
import android.os.Vibrator;

import com.zh.touchassistant.ContextProvider;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> VibratorHelper <br>
 * <b>Create Date:</b> 2018/12/13  下午6:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class VibratorHelper {
    private VibratorHelper() {
    }

    /**
     * 震动
     */
    public static void startVibrator() {
        Vibrator vibrator = (Vibrator) ContextProvider.get().getContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(20);
    }
}