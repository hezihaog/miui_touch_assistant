package com.zh.touchassistant.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.util.FloatServiceUtil;

/**
 * <b>Package:</b> com.zh.touchassistant.receiver <br>
 * <b>FileName:</b> ScreenLockReceiver <br>
 * <b>Create Date:</b> 2018/12/23  下午5:43 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ScreenLockReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            //锁屏
            FloatServiceUtil.stopLoopCheck(context);
        } else if (Intent.ACTION_SCREEN_ON.equals(action)) {
            //开屏幕
            FloatServiceUtil.startLoopCheck(context);
        }
    }
}