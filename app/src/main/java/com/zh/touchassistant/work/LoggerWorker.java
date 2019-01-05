package com.zh.touchassistant.work;

import android.content.Context;
import android.content.res.Configuration;

import com.zh.touchassistant.base.AppDelegate;
import com.zh.touchassistant.util.logger.FSLogger;
import com.zh.touchassistant.util.logger.LoggerImpl;

/**
 * <b>Package:</b> com.zh.touchassistant.work <br>
 * <b>FileName:</b> LoggerWorker <br>
 * <b>Create Date:</b> 2019/1/5  12:54 AM <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class LoggerWorker implements AppDelegate.IWorker {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Context context, Boolean isDebug) {
        //Logger
        FSLogger.setDelegate(new LoggerImpl(isDebug));
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onExecute() {

    }

    @Override
    public Integer getId() {
        return 1;
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