package com.zh.touchassistant;

import android.accessibilityservice.AccessibilityService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.database.biz.IAutoHideFloatBiz;
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz;
import com.zh.touchassistant.model.ForegroundAppInfoModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AccessibilityHelper;
import com.zh.touchassistant.util.AppBroadcastManager;
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
    private AccessibilityHelper mAccessibilityHelper;
    private FloatViewLiveData mFloatViewLiveData;

    @Override
    public void onCreate() {
        super.onCreate();
        //Logger
        FSLogger.setDelegate(new LoggerImpl(Const.isDebug));
        //SP工具
        new Property.PropertyBuilder().fileName(Const.Config.APP_SP_FILE_NAME).installDefaultProperty();
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
                ForegroundAppInfoModel foregroundAppInfoModel = (ForegroundAppInfoModel) intent.getSerializableExtra(Const.Extras.EXTRAS_FOREGROUND_APP_DATA);
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
        }, Const.Action.ACTION_FOREGROUND_APP_CHANGE);
    }

    public FloatViewLiveData getFloatViewLiveData() {
        return mFloatViewLiveData;
    }

    public void setAccessibility(AccessibilityService service) {
        this.mAccessibilityHelper = new AccessibilityHelper(service);
        //检查辅助服务
        this.mAccessibilityHelper.guideAccessibilityIsOpen(this);
    }

    public AccessibilityHelper getAccessibilityHelper() {
        return mAccessibilityHelper;
    }
}