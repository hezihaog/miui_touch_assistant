package com.zh.touchassistant.base;

import android.content.Context;
import android.content.res.Configuration;

import java.util.List;

/**
 * Package: me.wally.arch.appdelegate
 * FileName: IUIApplication
 * Date: on 2018/11/12  下午9:21
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class UIApplicationHelper {
    private AppDelegate mAppDelegate;
    private Context mContext;
    private boolean mIsDebug;

    public UIApplicationHelper(Context context, boolean isDebug) {
        this.mContext = context;
        this.mIsDebug = isDebug;
        this.mAppDelegate = new AppDelegate(getApplicationContext());
    }

    public Context getApplicationContext() {
        return mContext;
    }

    public void dispatchInitWorkers(List<AppDelegate.IWorker> workers) {
        mAppDelegate.addWorkers(workers);
    }

    public void dispatchOnCreate() {
        mAppDelegate.dispatchCreate(getApplicationContext(), mIsDebug);
    }

    public void dispatchOnAttachBaseContext(Context base) {
        if (mAppDelegate != null) {
            mAppDelegate.dispatchAttachBaseContext(base);
        }
    }

    public void dispatchOnTerminate() {
        if (mAppDelegate != null) {
            mAppDelegate.dispatchTerminate();
        }
    }

    public void dispatchOnLowMemory() {
        if (mAppDelegate != null) {
            mAppDelegate.dispatchLowMemory();
        }
    }

    public void dispatchOnTrimMemory(int level) {
        if (mAppDelegate != null) {
            mAppDelegate.dispatchTrimMemory(level);
        }
    }

    public void dispatchOnConfigurationChanged(Configuration newConfig) {
        if (mAppDelegate != null) {
            mAppDelegate.dispatchConfigurationChanged(newConfig);
        }
    }

    public AppDelegate getAppDelegate() {
        return this.mAppDelegate;
    }
}