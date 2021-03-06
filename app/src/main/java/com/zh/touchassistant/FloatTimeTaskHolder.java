package com.zh.touchassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.controller.FloatButtonWindowController;
import com.zh.touchassistant.util.AppBroadcastManager;
import com.zh.touchassistant.widget.FloatButton;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> FloatTimeTaskHolder <br>
 * <b>Create Date:</b> 2018/12/13  下午7:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatTimeTaskHolder {
    private final Handler mMainHandler;
    private Context mContext;
    private FloatButtonWindowController mFloatButtonVC;
    private boolean isLoop = false;
    private final BroadcastReceiver mOpenReceiver;
    private final BroadcastReceiver mOffReceiver;

    private FloatTimeTaskHolder(Context context, FloatButtonWindowController floatButtonVC) {
        this.mContext = context;
        this.mFloatButtonVC = floatButtonVC;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        //开始循环，2秒检查一次
        startLoopCheck();
        //注册悬浮球广播，开时关闭循环，关时开启循环
        mOpenReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                cancelLoopCheck();
            }
        };
        AppBroadcastManager.registerReceiver(context, mOpenReceiver, AccessibilityConstant.Action.ACTION_FLOAT_BUTTON_OPEN);
        mOffReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                startLoopCheck();
            }
        };
        AppBroadcastManager.registerReceiver(context, mOffReceiver, AccessibilityConstant.Action.ACTION_FLOAT_BUTTON_CLOSE);
    }

    public void startLoopCheck() {
        this.mMainHandler
                .postDelayed(mTask, 3000);
        isLoop = true;
    }

    public void cancelLoopCheck() {
        if (!isLoop) {
            return;
        }
        this.mMainHandler.removeCallbacksAndMessages(mTask);
        isLoop = false;
    }

    private Runnable mTask = new Runnable() {

        @Override
        public void run() {
            if (mFloatButtonVC != null) {
                //不在拽托时并且不能在打开，才减少透明图
                if (!mFloatButtonVC.getFloatWindow().isDragging()) {
                    FloatButton view = mFloatButtonVC
                            .getView();
                    if (mFloatButtonVC.isOpen()) {
                        view.clearAnimation();
                    } else {
                        if (view.getAlpha() != AccessibilityConstant.Config.ALPHA_HIDDEN) {
                            view
                                    .animate()
                                    .alpha(AccessibilityConstant.Config.ALPHA_HIDDEN)
                                    .setDuration(400)
                                    .start();
                        }
                    }
                }
            }
            startLoopCheck();
        }
    };

    public static FloatTimeTaskHolder create(Context context, FloatButtonWindowController floatButtonVC) {
        return new FloatTimeTaskHolder(context, floatButtonVC);
    }

    /**
     * 通知销毁
     */
    public void dispatchDestroy() {
        cancelLoopCheck();
        if (mOpenReceiver != null) {
            AppBroadcastManager.unregisterReceiver(this.mContext, mOpenReceiver);
        }
        if (mOffReceiver != null) {
            AppBroadcastManager.unregisterReceiver(this.mContext, mOffReceiver);
        }
    }
}