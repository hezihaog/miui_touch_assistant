package com.zh.touchassistant.work;

import android.content.Context;
import android.content.res.Configuration;

import com.zh.touchassistant.base.AppDelegate;
import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.util.Property;

/**
 * <b>Package:</b> com.zh.touchassistant.work <br>
 * <b>FileName:</b> PropertyWorker <br>
 * <b>Create Date:</b> 2019/1/5  12:56 AM <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class PropertyWorker implements AppDelegate.IWorker {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Context context, Boolean isDebug) {
        new Property.PropertyBuilder()
                .fileName(AccessibilityConstant.Config.APP_SP_FILE_NAME)
                .installDefaultProperty();
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onExecute() {

    }

    @Override
    public Integer getId() {
        return 2;
    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }
}