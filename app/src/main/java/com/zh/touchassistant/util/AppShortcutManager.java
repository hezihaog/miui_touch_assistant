package com.zh.touchassistant.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.ui.activity.AutoHideSettingActivity;
import com.zh.touchassistant.ui.activity.CustomMenuSettingActivity;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> AppShortcutManager <br>
 * <b>Create Date:</b> 2018/12/23  下午8:36 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AppShortcutManager {
    private AppShortcutManager() {
    }

    private static final class SingleHolder {
        private static final AppShortcutManager INSTANCE = new AppShortcutManager();
    }

    public static AppShortcutManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void createAppShortcuts() {
        Context context = ContextProvider.get().getContext();
        ShortcutUtil.addShortcut(context,
                CustomMenuSettingActivity.class,
                CustomMenuSettingActivity.class.getName(),
                "自定义菜单",
                "打开自定义菜单");
        ShortcutUtil.addShortcut(context,
                AutoHideSettingActivity.class,
                AutoHideSettingActivity.class.getName(),
                "隐藏悬浮球",
                "打开隐藏悬浮球");
    }
}