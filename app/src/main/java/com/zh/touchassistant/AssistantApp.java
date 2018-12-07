package com.zh.touchassistant;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.content.Intent;

import com.zh.touchassistant.service.CoreService;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AccessibilityHelper;
import com.zh.touchassistant.util.PropertyHelper;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> AssistantApp <br>
 * <b>Create Date:</b> 2018/12/6  上午1:03 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AssistantApp extends Application {
    private AccessibilityHelper mAccessibilityHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        PropertyHelper.init(this);
        FloatWindowSetting
                .getInstance()
                .initFloatWindowActions();
        Intent intent = new Intent(getApplicationContext(), CoreService.class);
        startService(intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW));
    }

    public void setAccessibility(AccessibilityService service) {
        this.mAccessibilityHelper = new AccessibilityHelper(service);
    }

    public AccessibilityHelper getAccessibilityHelper() {
        return mAccessibilityHelper;
    }
}