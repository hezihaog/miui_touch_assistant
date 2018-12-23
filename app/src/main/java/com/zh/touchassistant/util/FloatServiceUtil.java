package com.zh.touchassistant.util;

import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.FloatViewLiveData;
import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.service.CoreAccessibilityService;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> FloatServiceUtil <br>
 * <b>Create Date:</b> 2018/12/14  下午11:23 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatServiceUtil {
    private FloatServiceUtil() {
    }

    public static int getFloatButtonX(Context context) {
        return Property.getDefault().getProperty(Const.Config.KEY_FLOAT_BUTTON_X,
                ScreenUtil.getPointFromScreenWidthRatio(context.getApplicationContext(), 0.8f));
    }

    public static int getFloatButtonY(Context context) {
        return Property.getDefault().getProperty(Const.Config.KEY_FLOAT_BUTTON_Y,
                ScreenUtil.getPointFromScreenHeightRatio(context.getApplicationContext(), 0.3f));
    }

    public static int getFloatPanelX() {
        return Property.getDefault().getProperty(Const.Config.KEY_FLOAT_PANEL_X, 0);
    }

    public static int getFloatPanelY() {
        return Property.getDefault().getProperty(Const.Config.KEY_FLOAT_PANEL_Y, 0);
    }

    public static void openFloatButton() {
        AssistantApp assistantApp = (AssistantApp) ContextProvider.get().getApplication();
        assistantApp.getFloatViewLiveData().setValue(true);
    }

    public static void closeFloatButton() {
        AssistantApp assistantApp = (AssistantApp) ContextProvider.get().getApplication();
        assistantApp.getFloatViewLiveData().setValue(false);
    }

    public static boolean isFloatButtonOpen() {
        AssistantApp assistantApp = (AssistantApp) ContextProvider.get().getApplication();
        FloatViewLiveData floatViewLiveData = assistantApp.getFloatViewLiveData();
        return floatViewLiveData.isOpen();
    }

    public static void toggleFloatButton() {
        if (isFloatButtonOpen()) {
            closeFloatButton();
        } else {
            openFloatButton();
        }
    }

    /**
     * 显示悬浮球
     */
    public static void showFloatWindow(Context context) {
        setEnableFloatWindow(context, true);
    }

    /**
     * 隐藏悬浮球
     */
    public static void hideFloatWindow(Context context) {
        setEnableFloatWindow(context, false);
    }

    /**
     * 开启循环检测
     */
    public static void startLoopCheck(Context context) {
        setEnableLoopCheck(context, true);
    }

    /**
     * 停止循环检测
     */
    public static void stopLoopCheck(Context context) {
        setEnableLoopCheck(context, false);
    }

    /**
     * 开关悬浮窗
     */
    public static void setEnableFloatWindow(Context context, boolean isEnable) {
        Intent intent = new Intent(context, CoreAccessibilityService.class);
        if (isEnable) {
            intent.setAction(CoreAccessibilityService.Action.ACTION_SHOW_FLOATING_WINDOW);
        } else {
            intent.setAction(CoreAccessibilityService.Action.ACTION_HIDE_FLOATING_WINDOW);
        }
        context.startService(intent);
    }

    /**
     * 开关循环检测
     */
    public static void setEnableLoopCheck(Context context, boolean isEnable) {
        Intent intent = new Intent(context, CoreAccessibilityService.class);
        if (isEnable) {
            intent.setAction(CoreAccessibilityService.Action.ACTION_START_LOOP_CHECK);
        } else {
            intent.setAction(CoreAccessibilityService.Action.ACTION_STOP_LOOP_CHECK);
        }
        context.startService(intent);
    }
}