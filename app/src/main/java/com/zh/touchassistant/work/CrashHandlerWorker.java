package com.zh.touchassistant.work;

import android.content.Context;
import android.content.res.Configuration;

import com.zh.touchassistant.base.AppDelegate;
import com.zh.touchassistant.util.CrashHandler;


/**
 * Package: me.wally.arch.appdelegate.worker
 * FileName: CrashHandlerWorker
 * Date: on 2018/11/13  上午8:05
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class CrashHandlerWorker implements AppDelegate.IWorker {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Context context, Boolean isDebug) {
        CrashHandler.init(context);
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