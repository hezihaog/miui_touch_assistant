package com.zh.touchassistant.util;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.provider.Settings;

/**
 * Created by wangxiandeng on 2016/11/25.
 */
public class AccessibilityHelper {
    private AccessibilityService mService;

    public AccessibilityHelper(AccessibilityService service) {
        this.mService = service;
    }

    /**
     * 单击返回功能
     */
    public void doBack() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
    }

    /**
     * 下拉打开通知栏
     */
    public void doPullDownNotificationBar() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
    }

    /**
     * 上拉返回桌面
     */
    public void doGoHome() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
    }

    /**
     * 左右滑动打开多任务
     */
    public void doGoTask() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
    }

    /**
     * 检查是否开启了辅助服务
     */
    public boolean isAccessibilitySettingsOn(Context context) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        if (accessibilityEnabled == 1) {
            String services = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (services != null) {
                return services.toLowerCase().contains(context.getPackageName().toLowerCase());
            }
        }
        return false;
    }
}