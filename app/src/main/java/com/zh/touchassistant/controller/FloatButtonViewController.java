package com.zh.touchassistant.controller;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.FloatMoveEnum;
import com.zh.touchassistant.floating.FloatWindowController;
import com.zh.touchassistant.floating.FloatWindowOption;
import com.zh.touchassistant.floating.IFloatWindowAgent;
import com.zh.touchassistant.floating.SimpleFloatWindowPermissionCallback;
import com.zh.touchassistant.floating.SimpleFloatWindowViewStateCallback;
import com.zh.touchassistant.util.PropertyHelper;
import com.zh.touchassistant.widget.FloatButton;

/**
 * <b>Package:</b> com.zh.touchassistant.controller <br>
 * <b>FileName:</b> FloatButtonViewController <br>
 * <b>Create Date:</b> 2018/12/7  下午10:27 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatButtonViewController extends BaseViewController {
    private static final String TAG_BUTTON = "button_tag";

    public static final int STATUS_OFF = 0;
    public static final int STATUS_OPEN = 1;

    private FloatButton mFloatButtonView;
    private int mCurrentStatus = STATUS_OFF;

    private OnStatusChangeListener mStatusChangeListener;
    private FloatWindowController mFloatWindowController;
    private OnFloatButtonPositionUpdateListener mButtonPositionUpdateListener;

    public FloatButtonViewController(Context context) {
        super(context);
        init();
    }

    private void init() {
        mFloatButtonView = (FloatButton) getLayoutInflater().inflate(R.layout.float_button, null);
        mFloatWindowController = FloatWindowController.getInstance();
        initListener();
        attachFloatWindow();
    }

    private void initListener() {
        mFloatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    private void attachFloatWindow() {
        mFloatWindowController
                .makeFloatWindow(getApplicationContext(),
                        mFloatButtonView,
                        TAG_BUTTON,
                        FloatWindowOption.create(new FloatWindowOption.Builder()
                                .desktopShow(true)
                                .setFloatMoveType(FloatMoveEnum.ACTIVE)
                                .setViewStateCallback(new SimpleFloatWindowViewStateCallback() {

                                    @Override
                                    public void onShow(IFloatWindowAgent agent) {
                                        super.onShow(agent);
                                        agent
                                                .updateXY(PropertyHelper.getProperty(Const.Config.KEY_FLOAT_BUTTON_X, 0),
                                                        PropertyHelper.getProperty(Const.Config.KEY_FLOAT_BUTTON_Y, 0));
                                    }

                                    @Override
                                    public void onPositionUpdate(IFloatWindowAgent agent, int x, int y) {
                                        super.onPositionUpdate(agent, x, y);
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_BUTTON_X, x);
                                        PropertyHelper.setProperty(Const.Config.KEY_FLOAT_BUTTON_Y, y);
                                        //如果正在打开，则关闭
                                        if (isOpen()) {
                                            toggle();
                                        }
                                        //让面板跟随按钮
                                        if (mButtonPositionUpdateListener != null) {
                                            mButtonPositionUpdateListener.onFloatButtonPositionUpdate(x, y);
                                        }
                                    }
                                })
                                .setFloatWindowPermissionCallback(new SimpleFloatWindowPermissionCallback() {

                                    @Override
                                    public void onPermissionReject(IFloatWindowAgent agent) {
                                        Toast.makeText(getApplicationContext(),
                                                "允许权限才能使用悬浮球喔", Toast.LENGTH_SHORT).show();
                                    }
                                })));
    }

    public interface OnFloatButtonPositionUpdateListener {
        void onFloatButtonPositionUpdate(int newX, int newY);
    }

    public void setOnFloatButtonPositionUpdateListener(OnFloatButtonPositionUpdateListener buttonPositionUpdateListener) {
        this.mButtonPositionUpdateListener = buttonPositionUpdateListener;
    }

    @Override
    public FloatButton getView() {
        return mFloatButtonView;
    }

    public void toggle() {
        if (mCurrentStatus == STATUS_OPEN) {
            off();
        } else {
            open();
        }
    }

    public boolean isOpen() {
        return mCurrentStatus == STATUS_OPEN;
    }

    public void hide() {
        mFloatWindowController
                .getFloatWindowAgent(TAG_BUTTON)
                .hide();
    }

    private void open() {
        if (this.mCurrentStatus != STATUS_OPEN) {
            if (mStatusChangeListener != null) {
                //不能改变则打断
                boolean isCanChange = mStatusChangeListener.onPrepareStatusChange(STATUS_OPEN);
                if (!isCanChange) {
                    return;
                }
            }
            mFloatButtonView.setSelected(true);
            this.mCurrentStatus = STATUS_OPEN;
            mFloatButtonView
                    .animate()
                    .scaleX(0.8f)
                    .scaleY(0.8f)
                    .alpha(1.0f)
                    .start();
            if (mStatusChangeListener != null) {
                mStatusChangeListener.onStatusChange(this.mCurrentStatus);
            }
        }
    }

    private void off() {
        if (this.mCurrentStatus != STATUS_OFF) {
            mFloatButtonView.setSelected(false);
            this.mCurrentStatus = STATUS_OFF;
            mFloatButtonView
                    .animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(0.2f)
                    .start();
            if (mStatusChangeListener != null) {
                mStatusChangeListener.onStatusChange(this.mCurrentStatus);
            }
        }
    }

    public interface OnStatusChangeListener {
        /**
         * 当准备状态改变时回调
         *
         * @param prepareStatus 准备改变的状态
         * @return 返回true代表允许改变，false代表拦截改变
         */
        boolean onPrepareStatusChange(int prepareStatus);

        /**
         * 状态改变时回调
         *
         * @param newStatus 新状态
         */
        void onStatusChange(int newStatus);
    }

    public void setOnStatusChangeListener(OnStatusChangeListener listener) {
        this.mStatusChangeListener = listener;
    }
}