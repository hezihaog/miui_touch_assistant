package com.zh.touchassistant.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.service.CoreService;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> BootReceiver <br>
 * <b>Create Date:</b> 2018/12/6  上午12:51 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, CoreService.class);
        serviceIntent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW);
        context.startService(serviceIntent);
    }
}