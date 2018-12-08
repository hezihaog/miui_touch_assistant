package com.zh.touchassistant.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.controller.FloatButtonViewController;
import com.zh.touchassistant.controller.FloatPanelViewController;
import com.zh.touchassistant.floating.FloatWindowController;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> CoreService <br>
 * <b>Create Date:</b> 2018/12/6  上午12:39 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CoreService extends AccessibilityService {
    private FloatButtonViewController mFloatButtonVC;
    private FloatPanelViewController mFloatPanelVC;
    private boolean isOpen = false;

    public static class Action {
        public static final String ACTION_SHOW_FLOATING_WINDOW = "com.zh.touchassistant.SHOW_FLOATING_WINDOW";
        public static final String ACTION_HIDE_FLOATING_WINDOW = "com.zh.touchassistant.HIDE_FLOATING_WINDOW";
        public static final String ACTION_TOGGLE_FLOATING_WINDOW = "com.zh.touchassistant.TOGGLE_FLOATING_WINDOW";
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((AssistantApp) getApplication()).setAccessibility(this);
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
        } else if (Action.ACTION_TOGGLE_FLOATING_WINDOW.equals(intent.getAction())) {
            if (isOpen) {
                hideFloatWindow();
            } else {
                showFloatWindow();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FloatWindowController
                .getInstance()
                .destroyAll();
    }

    private void showFloatWindow() {
        //填充和浮动面板浮动按钮
        mFloatPanelVC = new FloatPanelViewController(this);
        mFloatButtonVC = new FloatButtonViewController(this);
        mFloatButtonVC.setOnFloatButtonPositionUpdateListener(new FloatButtonViewController.OnFloatButtonPositionUpdateListener() {
            @Override
            public void onFloatButtonPositionUpdate(int newX, int newY) {
                mFloatPanelVC.followButtonPosition(newX, newY);
            }
        });
        mFloatButtonVC.setOnFloatButtonStatusChangeListener(new FloatButtonViewController.OnFloatButtonStatusChangeListener() {
            @Override
            public boolean onPrepareStatusChange(int prepareStatus) {
                if (mFloatPanelVC.isCanChangeStatus()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onStatusChange(int newStatus) {
                mFloatPanelVC.toggle();
            }
        });
    }

    private void hideFloatWindow() {
        if (mFloatButtonVC != null) {
            mFloatButtonVC.hide();
        }
        if (mFloatPanelVC != null) {
            mFloatPanelVC.hide();
        }
    }
}
