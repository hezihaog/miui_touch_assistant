package com.miui.touchassistant;

import android.app.Application;
import android.content.Intent;

import com.miui.touchassistant.service.CoreService;

/**
 * <b>Package:</b> com.miui.touchassistant <br>
 * <b>FileName:</b> AssistantApp <br>
 * <b>Create Date:</b> 2018/12/6  上午1:03 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AssistantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, CoreService.class);
        startService(intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW));
    }
}