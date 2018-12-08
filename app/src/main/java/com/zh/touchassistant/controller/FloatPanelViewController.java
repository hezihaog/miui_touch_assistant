package com.zh.touchassistant.controller;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.FloatMoveEnum;
import com.zh.touchassistant.floating.FloatWindow;
import com.zh.touchassistant.floating.FloatWindowManager;
import com.zh.touchassistant.floating.FloatWindowOption;
import com.zh.touchassistant.floating.SimpleFloatWindowViewStateCallback;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.ScreenUtil;
import com.zh.touchassistant.widget.ControlPanelView;
import com.zh.touchassistant.widget.FloatActionButton;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Package:</b> com.zh.touchassistant.controller <br>
 * <b>FileName:</b> FloatPanelViewController <br>
 * <b>Create Date:</b> 2018/12/7  下午11:30 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatPanelViewController extends BaseViewController {
    private static final String TAG_PANEL = "panel_tag";

    private boolean isOpen = false;

    private View mPanelContainerLayout;
    private ControlPanelView mFloatControlPanelView;
    private OnStatusChangeListener mListener;
    private FloatWindowManager mFloatWindowManager;

    public FloatPanelViewController(Context context, FloatWindowManager floatWindowManager) {
        super(context);
        this.mFloatWindowManager = floatWindowManager;
        init();
    }

    private void init() {
        mPanelContainerLayout = getLayoutInflater().inflate(R.layout.view_float_control_panel, null);
        mFloatControlPanelView = mPanelContainerLayout.findViewById(R.id.control_panel_view);
        //根据数据添加子View
        addActionButton();
        //恢复上一次保存的位置
        mFloatControlPanelView.setOrientation(Property.getDefault().getProperty(Const.Config.KEY_FLOAT_WINDOW_IS_LEFT, false));
        initListener();
        attachFloatWindow();
    }

    private void attachFloatWindow() {
        mFloatWindowManager
                .makeFloatWindow(
                        mPanelContainerLayout,
                        TAG_PANEL,
                        FloatWindowOption
                                .create(new FloatWindowOption.Builder()
                                        .setX(Property.getDefault().getProperty(Const.Config.KEY_FLOAT_PANEL_X, 0))
                                        .setY(Property.getDefault().getProperty(Const.Config.KEY_FLOAT_PANEL_Y, 0))
                                        .desktopShow(true)
                                        .setShow(false)
                                        .setFloatMoveType(FloatMoveEnum.INACTIVE)
                                        .setViewStateCallback(new SimpleFloatWindowViewStateCallback() {
                                            @Override
                                            public void onShow() {
                                                super.onShow();
                                            }
                                        })));
    }

    private void initListener() {
        mFloatControlPanelView.setOnTogglePanelListener(new ControlPanelView.OnTogglePanelListener() {
            @Override
            public void onToggleChange(boolean isOpen) {
                //最新为打开
                if (isOpen) {
                    mFloatWindowManager
                            .getFloatWindow(TAG_PANEL)
                            .show();
                } else {
                    mFloatWindowManager
                            .getFloatWindow(TAG_PANEL)
                            .hide();
                }
            }
        });
    }

    private void addActionButton() {
        HashMap<FloatWindowActionModel, IFloatWindowAction> actions = FloatWindowSetting.getInstance().getCurrentActions();
        for (final Map.Entry<FloatWindowActionModel, IFloatWindowAction> entry : actions.entrySet()) {
            FloatActionButton actionView = new FloatActionButton(getApplicationContext());
            int iconSize = getApplicationContext().getResources().getDimensionPixelSize(R.dimen.float_icon_size);
            int iconPadding = getApplicationContext().getResources().getDimensionPixelSize(R.dimen.float_icon_padding);
            FrameLayout.LayoutParams params = new ControlPanelView.LayoutParams(iconSize, iconSize);
            params.gravity = Gravity.CENTER;
            actionView.setPadding(iconPadding, iconPadding, iconPadding, iconPadding);
            actionView.setImageResource(entry.getKey().getActionIcon());
            actionView.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.float_icon_bg));
            actionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFloatControlPanelView.toggleControlPanel();
                    if (mListener != null) {
                        mListener.onStatusChange(isOpen);
                    }
                    entry.getValue().onAction();
                }
            });
            actionView.setVisibility(View.GONE);
            mFloatControlPanelView.addView(actionView, params);
        }
    }

    @Override
    public View getView() {
        return mPanelContainerLayout;
    }

    /**
     * 跟随浮动按钮的位置
     */
    public void followButtonPosition(int buttonX, int buttonY) {
        //切换方向设置
        ControlPanelView panelView = mFloatControlPanelView;
        if (panelView.isAnimationRunning()) {
            return;
        }
        //如果正在打开，先关闭
        boolean isOpen = panelView.isOpen();
        if (isOpen) {
            panelView.toggleControlPanel();
        }
        //判断在屏幕左边还是右边，切换位置
        int halfScreenWidth = ScreenUtil.getScreenWidth(getApplicationContext()) / 2;
        boolean isLeft;
        if (buttonX < halfScreenWidth) {
            //左边
            isLeft = true;
        } else {
            //右边
            isLeft = false;
        }
        panelView.setOrientation(isLeft);
        Property.getDefault().setProperty(Const.Config.KEY_FLOAT_WINDOW_IS_LEFT, isLeft);
        //更新浮窗
        FloatWindow floatWindow = mFloatWindowManager.getFloatWindow(TAG_PANEL);
        int[] result = mFloatControlPanelView.followButtonPosition(buttonX, buttonY);
        int fixX = result[0];
        int fixY = result[1];
        floatWindow.updateX(fixX);
        floatWindow.updateY(fixY);
        //记录位置
        Property.getDefault().setProperty(Const.Config.KEY_FLOAT_PANEL_X, fixX);
        Property.getDefault().setProperty(Const.Config.KEY_FLOAT_PANEL_Y, fixY);
    }

    /**
     * 是否可以进行状态改变
     */
    public boolean isCanChangeStatus() {
        //动画还未结束时，不能改变
        return !mFloatControlPanelView.isAnimationRunning();
    }

    public void toggle() {
        mFloatControlPanelView.toggleControlPanel();
        this.isOpen = !isOpen;
    }

    public void showFloatWindow() {
        mFloatWindowManager
                .getFloatWindow(TAG_PANEL)
                .show();
    }

    public void hideFloatWindow() {
        mFloatWindowManager
                .getFloatWindow(TAG_PANEL)
                .hide();
    }

    public interface OnStatusChangeListener {
        /**
         * 状态改变时回调
         *
         * @param isOpen 是否打开
         */
        void onStatusChange(boolean isOpen);
    }

    public void setOnStatusChangeListener(OnStatusChangeListener listener) {
        this.mListener = listener;
    }
}