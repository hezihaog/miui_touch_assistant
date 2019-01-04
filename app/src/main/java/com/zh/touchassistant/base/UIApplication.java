package com.zh.touchassistant.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Package: me.wally.arch.appdelegate
 * FileName: UIApplication
 * Date: on 2018/11/12  下午9:46
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public abstract class UIApplication extends Application implements IUIApplication {
    private static UIApplication mSelf;
    private UIApplicationHelper mUiApplicationHelper;

    @Override
    public void onCreateUIApplicationHelperBefore() {
    }

    @Override
    public void onCreateUIApplicationHelperAfter() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        getUiApplicationHelper().dispatchInitWorkers(onInitWorkers());
        getUiApplicationHelper().dispatchOnCreate();
    }

    public UIApplicationHelper getUiApplicationHelper() {
        if (mUiApplicationHelper == null) {
            onCreateUIApplicationHelperBefore();
            mUiApplicationHelper = new UIApplicationHelper(this, isDebug());
            onCreateUIApplicationHelperAfter();
        }
        return mUiApplicationHelper;
    }

    public AppDelegate getAppDelegate() {
        return mUiApplicationHelper.getAppDelegate();
    }

    public static UIApplication shareInstance() {
        return mSelf;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        getUiApplicationHelper().dispatchOnAttachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        getUiApplicationHelper().dispatchOnTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        getUiApplicationHelper().dispatchOnLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        getUiApplicationHelper().dispatchOnTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getUiApplicationHelper().dispatchOnConfigurationChanged(newConfig);
    }
}