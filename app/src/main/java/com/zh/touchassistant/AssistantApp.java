package com.zh.touchassistant;

import android.os.Build;

import com.zh.touchassistant.base.AppDelegate;
import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AppShortcutManager;
import com.zh.touchassistant.util.json.GsonHandlerImpl;
import com.zh.touchassistant.util.singleton.SingletonStorageApplication;
import com.zh.touchassistant.work.CrashHandlerWorker;
import com.zh.touchassistant.work.ForegroundGuardWorker;
import com.zh.touchassistant.work.LoggerWorker;
import com.zh.touchassistant.work.PropertyWorker;

import java.util.ArrayList;
import java.util.List;

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
        //初始化悬浮按钮数据
        FloatWindowSetting
                .getInstance()
                .initFloatWindowActions(new GsonHandlerImpl());
        mFloatViewLiveData = new FloatViewLiveData();
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

    @Override
    public List<AppDelegate.IWorker> onInitWorkers() {
        ArrayList<AppDelegate.IWorker> workers = new ArrayList<>();
        workers.add(new LoggerWorker());
        workers.add(new PropertyWorker());
        workers.add(new CrashHandlerWorker());
        workers.add(new ForegroundGuardWorker());
        return workers;
    }

    @Override
    public boolean isDebug() {
        return AccessibilityConstant.isDebug;
    }
}