package com.zh.touchassistant;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;

import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AccessibilityHelper;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.json.GsonParserImpl;
import com.zh.touchassistant.util.json.JsonParser;
import com.zh.touchassistant.util.logger.FSLogger;
import com.zh.touchassistant.util.logger.LoggerImpl;

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
        //Logger
        FSLogger.setDelegate(new LoggerImpl(BuildConfig.DEBUG));
        //SP工具
        new Property.PropertyBuilder().fileName(Const.Config.APP_SP_FILE_NAME).installDefaultProperty();
        //Json解析器
        JsonParser jsonParser = new GsonParserImpl();
        //初始化悬浮按钮数据
        FloatWindowSetting
                .getInstance()
                .initFloatWindowActions(jsonParser);
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