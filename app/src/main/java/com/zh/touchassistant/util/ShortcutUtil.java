package com.zh.touchassistant.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.zh.touchassistant.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> ShortcutUtil <br>
 * <b>Create Date:</b> 2018/12/23  下午8:25 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ShortcutUtil {
    private ShortcutUtil() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    private static ShortcutManager getShortcutManager(Context context) {
        return context.getSystemService(android.content.pm.ShortcutManager.class);
    }

    /**
     * 新增一个Shortcut
     *
     * @param targetActivityClazz 要跳转的Activity
     * @param shortcutId          Shortcut的唯一Id
     * @param longLabel           长名称，默认会显示长名称
     * @param shortLabel          短名称，长名称显示不下时会显示短名称
     */
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public static void addShortcut(Context context,
                                   Class<? extends Activity> targetActivityClazz,
                                   String shortcutId, String shortLabel, String longLabel) {
        ShortcutManager shortcutManager = getShortcutManager(context);
        List<ShortcutInfo> infos = new ArrayList<>();
        Intent intent = new Intent(context, targetActivityClazz);
        intent.setAction(Intent.ACTION_VIEW);
        ShortcutInfo info = new ShortcutInfo.Builder(context, shortcutId)
                .setShortLabel(shortLabel)
                .setLongLabel(longLabel)
                .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher))
                .setIntent(intent)
                .build();
        infos.add(info);
        //创建
        shortcutManager.addDynamicShortcuts(infos);
    }

    /**
     * 批量更新
     */
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public static void updateShortcuts(Context context, List<ShortcutInfo> shortcutInfoList) {
        ShortcutManager shortcutManager = getShortcutManager(context);
        //更新
        shortcutManager.updateShortcuts(shortcutInfoList);
    }

    /**
     * 批量删除
     */
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public static void deleteShortcuts(Context context, List<String> shortcutIds) {
        ShortcutManager shortcutManager = getShortcutManager(context);
        //删除一个
        shortcutManager.removeDynamicShortcuts(shortcutIds);
    }
}