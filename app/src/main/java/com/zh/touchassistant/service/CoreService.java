package com.zh.touchassistant.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.FloatMoveEnum;
import com.zh.touchassistant.floating.FloatWindowController;
import com.zh.touchassistant.floating.FloatWindowOption;
import com.zh.touchassistant.floating.IFloatWindowAgent;
import com.zh.touchassistant.floating.SimpleFloatWindowPermissionCallback;
import com.zh.touchassistant.floating.SimpleFloatWindowViewStateCallback;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.PropertyHelper;
import com.zh.touchassistant.util.ScreenUtil;
import com.zh.touchassistant.widget.ControlPanelView;
import com.zh.touchassistant.widget.ForegroundImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> CoreService <br>
 * <b>Create Date:</b> 2018/12/6  上午12:39 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CoreService extends AccessibilityService {
    private static final String TAG_BUTTON = "button_tag";
    private static final String TAG_PANEL = "panel_tag";

    private FloatWindowController mFloatWindowController;
    private LayoutInflater mInflater;

    public static class Action {
        public static final String ACTION_SHOW_FLOATING_WINDOW = "com.zh.touchassistant.SHOW_FLOATING_WINDOW";
        public static final String ACTION_HIDE_FLOATING_WINDOW = "com.zh.touchassistant.HIDE_FLOATING_WINDOW";
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override
    public void onInterrupt() {
    }

    private LayoutInflater getLayoutInflater() {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(getApplicationContext());
        }
        return mInflater;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mFloatWindowController = FloatWindowController.getInstance();
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
        //填充浮动按钮和浮动面板
        View buttonView = getLayoutInflater().inflate(R.layout.float_button, null);
        final View panelLayout = getLayoutInflater().inflate(R.layout.view_float_control_panel, null);
        final ControlPanelView floatControlPanelView = panelLayout.findViewById(R.id.control_panel_view);
        final ForegroundImageView floatButton = buttonView.findViewById(R.id.float_btn);
        //读取配置的Action数据
        HashMap<FloatWindowActionModel, IFloatWindowAction> actions = FloatWindowSetting.getInstance().getFloatWindowActions();
        for (final Map.Entry<FloatWindowActionModel, IFloatWindowAction> entry : actions.entrySet()) {
            ForegroundImageView actionView = new ForegroundImageView(getApplicationContext());
            int iconSize = getApplication().getResources().getDimensionPixelSize(R.dimen.float_icon_size);
            int iconPadding = getApplication().getResources().getDimensionPixelSize(R.dimen.float_icon_padding);
            FrameLayout.LayoutParams params = new ControlPanelView.LayoutParams(iconSize, iconSize);
            params.gravity = Gravity.CENTER;
            actionView.setPadding(iconPadding, iconPadding, iconPadding, iconPadding);
            actionView.setImageResource(entry.getKey().getActionIcon());
            actionView.setBackground(getResources().getDrawable(R.drawable.float_icon_bg));
            actionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    floatControlPanelView.toggleControlPanel();
                    entry.getValue().onAction();
                }
            });
            actionView.setVisibility(View.GONE);
            floatControlPanelView.addView(actionView, params);
        }
        //面板区域
        mFloatWindowController
                .makeFloatWindow(this,
                        panelLayout,
                        TAG_PANEL,
                        FloatWindowOption.create(new FloatWindowOption.Builder()
                                .desktopShow(true)
                                .setFloatMoveType(FloatMoveEnum.INACTIVE)));
        //悬浮球
        mFloatWindowController
                .makeFloatWindow(this,
                        buttonView,
                        TAG_BUTTON,
                        FloatWindowOption.create(new FloatWindowOption.Builder()
                                .desktopShow(true)
                                .setFloatMoveType(FloatMoveEnum.ACTIVE)
                                .setViewStateCallback(new SimpleFloatWindowViewStateCallback() {
                                    private ControlPanelView getPanelView() {
                                        return mFloatWindowController
                                                .getView(TAG_PANEL)
                                                .findViewById(R.id.control_panel_view);
                                    }

                                    @Override
                                    public void onShow(IFloatWindowAgent agent) {
                                        super.onShow(agent);
                                        mFloatWindowController.updateXY(TAG_BUTTON,
                                                PropertyHelper.getProperty(Const.Config.KEY_FLOAT_BUTTON_X, 0),
                                                PropertyHelper.getProperty(Const.Config.KEY_FLOAT_BUTTON_Y, 0));
                                        mFloatWindowController.updateXY(TAG_PANEL,
                                                PropertyHelper.getProperty(Const.Config.KEY_FLOAT_PANEL_X, 0),
                                                PropertyHelper.getProperty(Const.Config.KEY_FLOAT_PANEL_Y, 0));
                                    }

                                    @Override
                                    public void onPositionUpdate(IFloatWindowAgent agent, int x, int y) {
                                        super.onPositionUpdate(agent, x, y);
                                        ControlPanelView panelView = getPanelView();
                                        if (panelView.isAnimationRuning()) {
                                            return;
                                        }
                                        //如果正在打开，先关闭
                                        boolean isOpen = panelView.isOpen();
                                        if (isOpen) {
                                            panelView.toggleControlPanel();
                                        }
                                        //判断在屏幕左边还是右边，切换位置
                                        int halfScreenWidth = ScreenUtil.getScreenWidth(getApplicationContext()) / 2;
                                        if (x < halfScreenWidth) {
                                            //左边
                                            panelView.setOrientation(true);
                                        } else {
                                            //右边
                                            panelView.setOrientation(false);
                                        }
                                        //跟随
                                        IFloatWindowAgent floatWindowAgent = mFloatWindowController
                                                .getFloatWindowAgent(TAG_PANEL);
                                        int[] result = panelView.fixFollowPosition(x, y);
                                        floatWindowAgent.updateX(result[0]);
                                        floatWindowAgent.updateY(result[1]);
                                        //记录位置
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_BUTTON_X, x);
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_BUTTON_Y, y);
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_PANEL_X, result[0]);
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_PANEL_Y, result[1]);
                                    }
                                })
                                .setFloatWindowPermissionCallback(new SimpleFloatWindowPermissionCallback() {

                                    @Override
                                    public void onPermissionReject(IFloatWindowAgent agent) {
                                        Toast.makeText(getApplicationContext(),
                                                "允许权限才能使用悬浮球喔", Toast.LENGTH_SHORT).show();
                                    }
                                })));
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (floatControlPanelView.isAnimationRuning()) {
                    return;
                }
                boolean isOpen = floatControlPanelView.isOpen();
                if (isOpen) {
                    floatButton.setSelected(false);
                } else {
                    floatButton.setSelected(true);
                }
                floatControlPanelView.toggleControlPanel();
            }
        });
        floatControlPanelView.setOnTogglePanelListener(new ControlPanelView.OnTogglePanelListener() {
            @Override
            public void onToggleChange(boolean isOpen) {
                //最新为打开
                if (isOpen) {
                    floatButton.setSelected(true);
                    floatButton
                            .animate()
                            .scaleX(0.8f)
                            .scaleY(0.8f)
                            .alpha(1.0f)
                            .start();
                    mFloatWindowController
                            .getFloatWindowAgent(TAG_PANEL)
                            .show();
                } else {
                    floatButton.setSelected(false);
                    floatButton
                            .animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(0.2f)
                            .start();
                    mFloatWindowController
                            .getFloatWindowAgent(TAG_PANEL)
                            .hide();
                }
            }
        });
    }

    private void hideFloatWindow() {
        mFloatWindowController
                .getFloatWindowAgent(TAG_BUTTON)
                .hide();
        mFloatWindowController.getFloatWindowAgent(TAG_PANEL)
                .hide();
    }
}
