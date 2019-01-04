package com.zh.touchassistant.util;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by wangxiandeng on 2016/11/25.
 */
public class AccessibilityHelper {
    private AccessibilityService mService;

    public AccessibilityHelper(AccessibilityService service) {
        this.mService = service;
    }

    /**
     * 执行返回键
     */
    public void doBack() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
    }

    /**
     * 执行拉下通知栏
     */
    public void doPullDownNotificationBar() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
    }

    /**
     * 执行桌面键
     */
    public void doGoHome() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
    }

    /**
     * 执行任务键
     */
    public void doGoTask() {
        this.mService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
    }

    /**
     * 检查辅助服务是否开启
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

    /**
     * 跳转到辅助服务设置
     */
    public void goToAccessibilitySetting(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 检查服务服务，如果未开启就引导跳转开启辅助服务
     */
    public boolean checkAccessibilityIsOpen(Context context) {
        if (context != null) {
            boolean isOpen = isAccessibilitySettingsOn(context);
            if (!isOpen) {
                // 引导至辅助功能设置页面
                goToAccessibilitySetting(context);
                Toast.makeText(context, "请先开启MIUI悬浮球辅助功能", Toast.LENGTH_SHORT).show();
            }
            return isOpen;
        } else {
            throw new NullPointerException("Application must be not null");
        }
    }
}