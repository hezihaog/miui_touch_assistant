package com.zh.touchassistant.lock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * <b>Package:</b> me.wally.arch.onescreenlock <br>
 * <b>FileName:</b> OneScreenLockAdminReceiver <br>
 * <b>Create Date:</b> 2018/11/14  下午3:23 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class OneScreenLockAdminReceiver extends DeviceAdminReceiver {
    private final static String TAG = OneScreenLockAdminReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.i(TAG, "接收到锁屏请求");
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Log.i(TAG, "激活锁屏管理器");
    }
    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Log.i(TAG, "取消锁屏管理器");
    }
}