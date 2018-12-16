package com.zh.touchassistant.floating.action;

import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.widget.Toast;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.util.AccessibilityHelper;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> AbsFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/7  上午11:34 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class BaseFloatWindowAction implements IFloatWindowAction {
    /**
     * 检查辅助服务是否开启
     */
    protected boolean checkAccessibilityIsOpen() {
        AssistantApp application = getApplication();
        if (application != null) {
            boolean isOpen = application.getAccessibilityHelper().isAccessibilitySettingsOn(application);
            if (!isOpen) {
                // 引导至辅助功能设置页面
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                application.startActivity(intent);
                Toast.makeText(application, "请先开启MIUI悬浮球辅助功能", Toast.LENGTH_SHORT).show();
            }
            return isOpen;
        } else {
            throw new NullPointerException("Application must be not null");
        }
    }

    protected AccessibilityHelper getAccessibilityHelper() {
        return getApplication().getAccessibilityHelper();
    }

    protected AssistantApp getApplication() {
        Application application = ContextProvider
                .get()
                .getApplication();
        if (application != null) {
            return (AssistantApp) application;
        } else {
            throw new NullPointerException("Application must be not null");
        }
    }

    protected Drawable getResDrawable(int resId) {
        return getApplication().getResources().getDrawable(resId);
    }
}