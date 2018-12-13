package com.zh.touchassistant;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;

import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AccessibilityHelper;
import com.zh.touchassistant.util.Property;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> AssistantApp <br>
 * <b>Create Date:</b> 2018/12/6  上午1:03 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AssistantApp extends Application {
    private AccessibilityHelper mAccessibilityHelper;
    private FloatViewLiveData mFloatViewLiveData;

    @Override
    public void onCreate() {
        super.onCreate();
        new Property.PropertyBuilder().fileName(Const.Config.APP_SP_FILE_NAME).installDefaultProperty();
        FloatWindowSetting
                .getInstance()
                .initFloatWindowActions();
        mFloatViewLiveData = new FloatViewLiveData();
    }

    public FloatViewLiveData getFloatViewLiveData() {
        return mFloatViewLiveData;
    }

    public void setAccessibility(AccessibilityService service) {
        this.mAccessibilityHelper = new AccessibilityHelper(service);
    }

    public AccessibilityHelper getAccessibilityHelper() {
        return mAccessibilityHelper;
    }
}