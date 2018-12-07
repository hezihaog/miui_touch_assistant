package com.zh.touchassistant;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.fanjun.keeplive.KeepLive;
import com.fanjun.keeplive.config.ForegroundNotification;
import com.fanjun.keeplive.config.ForegroundNotificationClickListener;
import com.fanjun.keeplive.config.KeepLiveService;
import com.zh.touchassistant.floating.FloatWindowController;
import com.zh.touchassistant.service.CoreService;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.AccessibilityHelper;
import com.zh.touchassistant.util.PropertyHelper;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> AssistantApp <br>
 * <b>Create Date:</b> 2018/12/6  上午1:03 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AssistantApp extends Application {
    private AccessibilityHelper mAccessibilityHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        PropertyHelper.init(this);
        FloatWindowSetting
                .getInstance()
                .initDefaultFloatWindowAction();
        //保活
        //定义前台服务的默认样式。即标题、描述和图标
        ForegroundNotification foregroundNotification =
                new ForegroundNotification(getResources().getString(R.string.app_name),
                        "悬浮球正在运行",
                        R.drawable.ic_launcher,
                        //定义前台服务的通知点击事件
                        new ForegroundNotificationClickListener() {

                            @Override
                            public void foregroundNotificationClick(Context context, Intent intent) {
                            }
                        });
        //启动保活服务
        KeepLive.startWork(this, KeepLive.RunMode.ROGUE, foregroundNotification,
                //你需要保活的服务，如socket连接、定时任务等，建议不用匿名内部类的方式在这里写
                new KeepLiveService() {
                    /**
                     * 运行中
                     * 由于服务可能会多次自动启动，该方法可能重复调用
                     * @param context 所在服务上下文
                     */
                    @Override
                    public void onWorking(Context context) {
                        Intent intent = new Intent(getApplicationContext(), CoreService.class);
                        startService(intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW));
                    }

                    /**
                     * 服务终止
                     * 由于服务可能会被多次终止，该方法可能重复调用，需同onWorking配套使用，如注册和注销broadcast
                     * @param context 所在服务上下文
                     */
                    @Override
                    public void onStop(Context context) {
                        FloatWindowController
                                .getInstance()
                                .destroyAll();
                    }
                }
        );
    }

    public void setAccessibility(AccessibilityService service) {
        this.mAccessibilityHelper = new AccessibilityHelper(service);
    }

    public AccessibilityHelper getAccessibilityHelper() {
        return mAccessibilityHelper;
    }
}