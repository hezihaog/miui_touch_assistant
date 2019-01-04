package com.zh.touchassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.database.biz.IAutoHideFloatBiz;
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz;
import com.zh.touchassistant.model.ForegroundAppInfoModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AppBroadcastManager;
import com.zh.touchassistant.util.AppShortcutManager;
import com.zh.touchassistant.util.FloatServiceUtil;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.json.GsonHandlerImpl;
import com.zh.touchassistant.util.json.JsonHandler;
import com.zh.touchassistant.util.logger.FSLogger;
import com.zh.touchassistant.util.logger.LoggerImpl;
import com.zh.touchassistant.util.singleton.SingletonStorageApplication;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> AssistantApp <br>
 * <b>Create Date:</b> 2018/12/6  上午1:03 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AssistantApp extends SingletonStorageApplication {
    private FloatViewLiveData mFloatViewLiveData;

    @Override
    public void onCreate() {
        super.onCreate();
        //Logger
        FSLogger.setDelegate(new LoggerImpl(AccessibilityConstant.isDebug));
        //SP工具
        new Property.PropertyBuilder().fileName(AccessibilityConstant.Config.APP_SP_FILE_NAME).installDefaultProperty();
        //Json解析器
        JsonHandler jsonHandler = new GsonHandlerImpl();
        //初始化悬浮按钮数据
        FloatWindowSetting
                .getInstance()
                .initFloatWindowActions(jsonHandler);
        mFloatViewLiveData = new FloatViewLiveData();
        //监听前台App
        AppBroadcastManager.registerReceiver(this, new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                //前台Activity发生改变
                ForegroundAppInfoModel foregroundAppInfoModel = (ForegroundAppInfoModel) intent.getSerializableExtra(AccessibilityConstant.Extras.EXTRAS_FOREGROUND_APP_DATA);
                AutoHideFloatBiz biz = getInstance(IAutoHideFloatBiz.class, AutoHideFloatBiz.class);
                //查数据库，是否添加过该包名
                if (biz != null) {
                    if (biz.isAutoHideApp(foregroundAppInfoModel.getForegroundAppPackageName())) {
                        FloatServiceUtil.hideFloatWindow(getApplicationContext());
                    } else {
                        FloatServiceUtil.showFloatWindow(getApplicationContext());
                    }
                }
            }
        }, AccessibilityConstant.Action.ACTION_FOREGROUND_APP_CHANGE);
        //创建Shortcut
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            AppShortcutManager
                    .getInstance()
                    .createAppShortcuts();
        }
    }

    public FloatViewLiveData getFloatViewLiveData() {
        return mFloatViewLiveData;
    }
}