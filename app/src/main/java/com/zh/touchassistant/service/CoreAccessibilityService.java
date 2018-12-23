package com.zh.touchassistant.service;

import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.FloatTimeTaskHolder;
import com.zh.touchassistant.FloatViewLiveData;
import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.controller.FloatButtonWindowController;
import com.zh.touchassistant.controller.FloatForegroundWindowController;
import com.zh.touchassistant.controller.FloatPanelWindowController;
import com.zh.touchassistant.floating.FloatWindowManager;
import com.zh.touchassistant.model.ForegroundAppInfoModel;
import com.zh.touchassistant.receiver.ScreenLockReceiver;
import com.zh.touchassistant.util.AppBroadcastManager;
import com.zh.touchassistant.util.logger.FSLogger;
import com.zh.touchassistant.widget.ControlPanelView;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> CoreService <br>
 * <b>Create Date:</b> 2018/12/6  上午12:39 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b> 核心辅助服务 <br>
 */
public class CoreAccessibilityService extends AccessibilityService {
    private static final int NOTIFICATION_ID = 1234;

    private FloatButtonWindowController mFloatButtonVC;
    private FloatPanelWindowController mFloatPanelVC;
    private FloatForegroundWindowController mFloatForegroundVC;
    private boolean isFirst = true;
    private FloatTimeTaskHolder mFloatTimeTaskHolder;
    private ScreenLockReceiver mScreenLockReceiver;

    public static class Action {
        public static final String ACTION_SHOW_FLOATING_WINDOW = "com.zh.touchassistant.SHOW_FLOATING_WINDOW";
        public static final String ACTION_HIDE_FLOATING_WINDOW = "com.zh.touchassistant.HIDE_FLOATING_WINDOW";
        public static final String ACTION_START_LOOP_CHECK = "com.zh.touchassistant.START_LOOP_CHECK";
        public static final String ACTION_STOP_LOOP_CHECK = "com.zh.touchassistant.STOP_LOOP_CHECK";
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //窗口改变，即当前Activity切换了
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            //前台App的完整包名
            CharSequence foregroundAppPackageName = event.getPackageName();
            //前台App的Activity类名
            CharSequence foregroundActivityClassName = event.getClassName();
            if (!TextUtils.isEmpty(foregroundAppPackageName)
                    && !TextUtils.isEmpty(foregroundActivityClassName)) {
                FSLogger.d("onAccessibilityEvent: 前台App的完整包名： -- <" + foregroundAppPackageName + ">");
                FSLogger.d("onAccessibilityEvent: 前台App的Activity类名： -- <" + foregroundActivityClassName + ">");
                ForegroundAppInfoModel foregroundAppInfoModel = new ForegroundAppInfoModel(
                        foregroundAppPackageName.toString(), foregroundActivityClassName.toString());
                Bundle args = new Bundle();
                args.putSerializable(Const.Extras.EXTRAS_FOREGROUND_APP_DATA, foregroundAppInfoModel);
                AppBroadcastManager
                        .sendBroadcast(this.getApplicationContext(),
                                Const.Action.ACTION_FOREGROUND_APP_CHANGE, args);
            }
        }
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //在系统将要关闭Service时被调用。在这个方法主要做释放资源的工作。
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((AssistantApp) getApplication()).setAccessibility(this);
        mScreenLockReceiver = new ScreenLockReceiver();
        //接收锁屏广播
        AppBroadcastManager
                .registerReceiver(this.getApplicationContext(),
                        mScreenLockReceiver, Intent.ACTION_SCREEN_OFF, Intent.ACTION_USER_PRESENT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatTimeTaskHolder != null) {
            mFloatTimeTaskHolder.dispatchDestroy();
        }
        if (mScreenLockReceiver != null) {
            AppBroadcastManager
                    .unregisterReceiver(this.getApplicationContext(),
                            mScreenLockReceiver);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return super.onStartCommand(intent, flags, startId);
        }
        if (Action.ACTION_SHOW_FLOATING_WINDOW.equals(intent.getAction())) {
            showFloatWindow();
        } else if (Action.ACTION_HIDE_FLOATING_WINDOW.equals(intent.getAction())) {
            hideFloatWindow();
        } else if (Action.ACTION_START_LOOP_CHECK.equals(intent.getAction())) {
            if (mFloatTimeTaskHolder != null) {
                mFloatTimeTaskHolder.startLoopCheck();
            }
        } else if (Action.ACTION_START_LOOP_CHECK.equals(intent.getAction())) {
            if (mFloatTimeTaskHolder != null) {
                mFloatTimeTaskHolder.cancelLoopCheck();
            }
        }
        //大于9.0不保活
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            //保活使用
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
                //18以前空通知栏即可
                startForeground(NOTIFICATION_ID, new Notification());
            } else {
                Intent innerIntent = new Intent(this, KeepAliveInnerService.class);
                startService(innerIntent);
                startForeground(NOTIFICATION_ID, new Notification());
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private static class KeepAliveInnerService extends Service {

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(NOTIFICATION_ID, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }
    }

    private void showFloatWindow() {
        if (isFirst) {
            AssistantApp assistantApp = (AssistantApp) getApplication();
            FloatWindowManager floatWindowManager = new FloatWindowManager(this);
            //填充和浮动面板浮动按钮
            mFloatPanelVC = new FloatPanelWindowController(this, floatWindowManager);
            mFloatButtonVC = new FloatButtonWindowController(this, floatWindowManager, mFloatPanelVC);
            mFloatForegroundVC = new FloatForegroundWindowController(this, floatWindowManager);
            mFloatButtonVC.setOnFloatButtonPositionUpdateListener(new FloatButtonWindowController.OnFloatButtonPositionUpdateListener() {
                @Override
                public void onFloatButtonPositionUpdate(int newX, int newY) {
                    mFloatPanelVC.followButtonPosition(newX, newY);
                }
            });
            mFloatPanelVC.setOnPanelSizeChangeCallback(new ControlPanelView.OnPanelSizeChangeCallback() {
                @Override
                public void onPanelSizeChange(int newWidth, int newHeight) {
                    //使用该监听，主要是为了解决第一次进入时，没有手动移动过悬浮球，控制面板没有跟随位置的问题
                    int buttonX = mFloatButtonVC.getFloatWindow().getX();
                    int buttonY = mFloatButtonVC.getFloatWindow().getY();
                    mFloatPanelVC.followButtonPosition(buttonX, buttonY);
                }
            });
            mFloatButtonVC.setOnStatusChangeListener(new FloatButtonWindowController.OnStatusChangeListener() {
                @Override
                public boolean onPrepareStatusChange(int prepareStatus) {
                    return mFloatPanelVC.isCanChangeStatus();
                }

                @Override
                public void onStatusChange(int newStatus) {
                }
            });
            mFloatTimeTaskHolder = FloatTimeTaskHolder.create(CoreAccessibilityService.this.getApplicationContext(), mFloatButtonVC);
            FloatViewLiveData floatViewLiveData = assistantApp.getFloatViewLiveData();
            floatViewLiveData.addOnDataChangeCallback(new FloatViewLiveData.OnDataChangeCallback() {
                @Override
                public void onDataChange(boolean isOpen) {
                    //这里统一做UI切换
                    if (isOpen) {
                        mFloatButtonVC.open();
                        mFloatPanelVC.open();
                        AppBroadcastManager
                                .sendBroadcast(CoreAccessibilityService.this,
                                        Const.Action.ACTION_FLOAT_BUTTON_OPEN);
                    } else {
                        mFloatButtonVC.off();
                        mFloatPanelVC.off();
                        AppBroadcastManager
                                .sendBroadcast(CoreAccessibilityService.this,
                                        Const.Action.ACTION_FLOAT_BUTTON_CLOSE);
                    }
                }
            });
            isFirst = false;
        } else {
            mFloatButtonVC.showFloatWindow();
            mFloatForegroundVC.showFloatWindow();
        }
    }

    private void hideFloatWindow() {
        if (mFloatButtonVC != null) {
            mFloatButtonVC.hideFloatWindow();
        }
        if (mFloatForegroundVC != null) {
            mFloatForegroundVC.hideFloatWindow();
        }
    }
}
