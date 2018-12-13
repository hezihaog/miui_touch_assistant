package com.zh.touchassistant.controller;

import android.content.Context;
import android.view.View;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.Const;
import com.zh.touchassistant.FloatViewLiveData;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.FloatMoveEnum;
import com.zh.touchassistant.floating.FloatWindowManager;
import com.zh.touchassistant.floating.FloatWindowOption;
import com.zh.touchassistant.floating.SimpleFloatWindowViewStateCallback;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.ScreenUtil;
import com.zh.touchassistant.util.VibratorHelper;
import com.zh.touchassistant.widget.FloatButton;

/**
 * <b>Package:</b> com.zh.touchassistant.controller <br>
 * <b>FileName:</b> FloatButtonViewController <br>
 * <b>Create Date:</b> 2018/12/7  下午10:27 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatButtonWindowController extends BaseFloatWindowController {
    private static final String TAG_BUTTON = "button_tag";

    public static final int STATUS_OFF = 0;
    public static final int STATUS_OPEN = 1;

    private FloatButton mFloatButtonView;
    private int mCurrentStatus = STATUS_OFF;

    private OnStatusChangeListener mStatusChangeListener;
    private OnFloatButtonPositionUpdateListener mButtonPositionUpdateListener;
    private FloatWindowManager mFloatWindowManager;
    private FloatPanelWindowController mPanelViewController;

    public FloatButtonWindowController(Context context, FloatWindowManager floatWindowManager, FloatPanelWindowController panelViewController) {
        super(context);
        this.mFloatWindowManager = floatWindowManager;
        this.mPanelViewController = panelViewController;
        init();
    }

    private void init() {
        mFloatButtonView = (FloatButton) getLayoutInflater().inflate(R.layout.float_button, null);
        initListener();
        attachFloatWindow();
    }

    private void initListener() {
        mFloatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssistantApp assistantApp = (AssistantApp) getApplicationContext();
                FloatViewLiveData floatViewLiveData = assistantApp.getFloatViewLiveData();
                if (floatViewLiveData.isOpen()) {
                    floatViewLiveData.setValue(false);
                } else {
                    floatViewLiveData.setValue(true);
                }
            }
        });
    }

    private void attachFloatWindow() {
        mFloatWindowManager
                .makeFloatWindow(
                        mFloatButtonView,
                        TAG_BUTTON,
                        FloatWindowOption.create(new FloatWindowOption.Builder()
                                .setX(Property.getDefault().getProperty(Const.Config.KEY_FLOAT_BUTTON_X,
                                        ScreenUtil.getPointFromScreenWidthRatio(getApplicationContext(), 0.8f)))
                                .setY(Property.getDefault().getProperty(Const.Config.KEY_FLOAT_BUTTON_Y,
                                        ScreenUtil.getPointFromScreenHeightRatio(getApplicationContext(), 0.3f)))
                                .desktopShow(true)
                                .setFloatMoveType(FloatMoveEnum.SLIDE)
                                .setBoundOffset(ScreenUtil.dip2px(getApplicationContext(), 5f))
                                .setViewStateCallback(new SimpleFloatWindowViewStateCallback() {

                                    @Override
                                    public void onPositionUpdate(int oldX, int oldY, int newX, int newY) {
                                        super.onPositionUpdate(oldX, oldY, newX, newY);
                                        Property.getDefault().setProperty(Const.Config.KEY_FLOAT_BUTTON_X, newX);
                                        Property.getDefault().setProperty(Const.Config.KEY_FLOAT_BUTTON_Y, newY);
                                        //让面板跟随按钮
                                        if (mButtonPositionUpdateListener != null) {
                                            mButtonPositionUpdateListener.onFloatButtonPositionUpdate(newX, newY);
                                        }
                                    }

                                    @Override
                                    public void onPrepareDrag() {
                                        //拽托时，震动一下
                                        VibratorHelper.startVibrator();
                                    }

                                    @Override
                                    public void onDragging() {
                                        super.onDragging();
                                        //将Alpha调整到1.0f
                                        getView().setAlpha(1.0f);
                                    }

                                    @Override
                                    public void onDragFinish() {
                                        super.onDragFinish();
                                        //拽托结束后，设置回Alpha为0.2f
                                        getView()
                                                .animate()
                                                .alpha(0.2f)
                                                .setDuration(300)
                                                .start();
                                    }

                                    @Override
                                    public boolean isCanDrag() {
                                        //准备拽托时，如果是打开状态，不能拽托
                                        return !isOpen();
                                    }

                                    @Override
                                    public void onClickFloatOutsideArea(float x, float y) {
                                        super.onClickFloatOutsideArea(x, y);
                                        //因为控制面板也是一个悬浮窗，点击面板的按钮时，也算点击悬浮按钮以外区域
                                        // 所以当面板打开时，不算点击以外范围，并且如果点击的在面板区域内也不算
                                        if (mPanelViewController.isOpen()
                                                && mPanelViewController.isInPanelArea(x, y)) {
                                            return;
                                        }
                                        //当点击悬浮按钮区域外时，如果是打开状态，则关闭
                                        if (isOpen()) {
                                            toggle();
                                        }
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

    public void showFloatWindow() {
        this.mFloatWindowManager
                .getFloatWindow(TAG_BUTTON)
                .show();
    }

    public void hideFloatWindow() {
        this.mFloatWindowManager
                .getFloatWindow(TAG_BUTTON)
                .hide();
    }

    public void open() {
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

    public void off() {
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