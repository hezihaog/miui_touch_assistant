package com.zh.touchassistant.work;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.zh.touchassistant.base.AppDelegate;
import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz;
import com.zh.touchassistant.model.ForegroundAppInfoModel;
import com.zh.touchassistant.util.AppBroadcastManager;
import com.zh.touchassistant.util.FloatServiceUtil;

/**
 * <b>Package:</b> com.zh.touchassistant.work <br>
 * <b>FileName:</b> ForegroundGuardWorker <br>
 * <b>Create Date:</b> 2019/1/5  12:57 AM <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ForegroundGuardWorker implements AppDelegate.IWorker {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Context context, Boolean isDebug) {
        final AutoHideFloatBiz biz = new AutoHideFloatBiz();
        //监听前台App
        AppBroadcastManager.registerReceiver(context, new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                //前台Activity发生改变
                ForegroundAppInfoModel foregroundAppInfoModel = (ForegroundAppInfoModel) intent.getSerializableExtra(AccessibilityConstant.Extras.EXTRAS_FOREGROUND_APP_DATA);
                //查数据库，是否添加过该包名
                if (biz.isAutoHideApp(foregroundAppInfoModel.getForegroundAppPackageName())) {
                    FloatServiceUtil.hideFloatWindow(context);
                } else {
                    FloatServiceUtil.showFloatWindow(context);
                }
            }
        }, AccessibilityConstant.Action.ACTION_FOREGROUND_APP_CHANGE);
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onExecute() {

    }

    @Override
    public Integer getId() {
        return null;
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