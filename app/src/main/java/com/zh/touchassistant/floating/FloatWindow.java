package com.zh.touchassistant.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

public class FloatWindow {
    private Context mContext;
    private String mTag;

    private View mView;
    private boolean isShow = false;
    private boolean isRemove = false;
    private int mX;
    private int mY;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    private final FloatWindowOption mWindowOption;
    private final int mSlop;
    private ValueAnimator mAnimator;
    private TimeInterpolator mAnimatorInterpolator;
    private float downX;
    private float downY;
    private float upX;
    private float upY;
    private boolean mClick = false;

    public FloatWindow(Context context, String mTag, View view, FloatWindowOption option) {
        this.mContext = context;
        this.mTag = mTag;
        this.mView = view;
        mWindowOption = option;
        mWindowManager = getWindowManager();
        mLayoutParams = new WindowManager.LayoutParams();
        mLayoutParams.format = PixelFormat.RGBA_8888;
        mLayoutParams.flags =
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams.windowAnimations = 0;
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = option.getX();
        mLayoutParams.y = option.getY();
        mLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //7.0使用新的Type类型
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        mSlop = ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop();
        //处理手势
        handleGesture();
        mWindowManager.addView(mView, mLayoutParams);
    }

    private void handleGesture() {
        final FloatMoveEnum moveType = this.mWindowOption.getMoveType();
        switch (moveType) {
            case INACTIVE:
                break;
            default:
                getView().setOnTouchListener(new View.OnTouchListener() {
                    float lastX, lastY, changeX, changeY;
                    int newX, newY;

                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                downX = event.getRawX();
                                downY = event.getRawY();
                                lastX = event.getRawX();
                                lastY = event.getRawY();
                                cancelAnimator();
                                break;
                            case MotionEvent.ACTION_MOVE:
                                changeX = event.getRawX() - lastX;
                                changeY = event.getRawY() - lastY;
                                newX = (int) (getX() + changeX);
                                newY = (int) (getY() + changeY);
                                updateXY(newX, newY);
                                if (mWindowOption.getViewStateCallback() != null) {
                                    mWindowOption.getViewStateCallback().onPositionUpdate(newX, newY);
                                }
                                lastX = event.getRawX();
                                lastY = event.getRawY();
                                break;
                            case MotionEvent.ACTION_UP:
                                upX = event.getRawX();
                                upY = event.getRawY();
                                mClick = (Math.abs(upX - downX) > mSlop) || (Math.abs(upY - downY) > mSlop);
                                break;
                            default:
                                break;
                        }
                        return mClick;
                    }
                });
                break;
        }
    }

    private void startAnimator() {
        mAnimatorInterpolator =
                mWindowOption.getInterpolator() == null ? new DecelerateInterpolator() : mWindowOption.getInterpolator();
        mAnimator.setInterpolator(mAnimatorInterpolator);
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimator.removeAllUpdateListeners();
                mAnimator.removeAllListeners();
                mAnimator = null;
                if (mWindowOption.getViewStateCallback() != null) {
                    mWindowOption.getViewStateCallback().onMoveAnimEnd();
                }
            }
        });
        mAnimator.setDuration(mWindowOption.getDuration()).start();
        if (mWindowOption.getViewStateCallback() != null) {
            mWindowOption.getViewStateCallback().onMoveAnimStart();
        }
    }

    private void cancelAnimator() {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
    }

    protected WindowManager getWindowManager() {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        }
        return mWindowManager;
    }

    /**
     * 展示悬浮窗
     */
    public void show() {
        if (!isShow) {
            getView().setVisibility(View.VISIBLE);
            isShow = !isShow;
            if (this.mWindowOption.getViewStateCallback() != null) {
                this.mWindowOption.getViewStateCallback().onShow();
            }
        }
    }

    /**
     * 隐藏悬浮窗
     */
    public void hide() {
        if (isShow) {
            getView().setVisibility(View.GONE);
            isShow = !isShow;
            if (this.mWindowOption.getViewStateCallback() != null) {
                this.mWindowOption.getViewStateCallback().onHide();
            }
        }
    }

    public void remove() {
        if (mView != null) {
            getWindowManager().removeView(mView);
            isRemove = true;
            mView = null;
            if (this.mWindowOption.getViewStateCallback() != null) {
                this.mWindowOption.getViewStateCallback().onRemove();
            }
        }
    }

    /**
     * 悬浮窗当前是否展示
     */
    public boolean isShowing() {
        return isShow;
    }

    /**
     * 是否已经移除
     */
    public boolean isRemove() {
        return isRemove;
    }

    public void setSize(int width, int height) {
        mLayoutParams.width = width;
        mLayoutParams.height = height;
    }

    /**
     * 获取悬浮床当前的X坐标
     */
    public int getX() {
        return mX;
    }

    /**
     * 获取悬浮窗当前的Y坐标
     */
    public int getY() {
        return mY;
    }

    /**
     * 更新悬浮窗的X坐标
     */
    public void updateX(int newX) {
        if (isRemove) {
            return;
        }
        mLayoutParams.x = newX;
        mX = newX;
        getWindowManager().updateViewLayout(mView, mLayoutParams);
    }

    /**
     * 更新悬浮窗的Y坐标
     */
    public void updateY(int newY) {
        if (isRemove) {
            return;
        }
        mLayoutParams.y = newY;
        mY = newY;
        getWindowManager().updateViewLayout(mView, mLayoutParams);
    }

    public void updateXY(int newX, int newY) {
        if (isRemove) {
            return;
        }
        mLayoutParams.x = newX;
        mLayoutParams.y = newY;
        mX = newX;
        mY = newY;
        getWindowManager().updateViewLayout(mView, mLayoutParams);
    }

    /**
     * 获取悬浮窗View
     */
    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    /**
     * 获取当前悬浮窗的Tag
     */
    public String getTag() {
        return this.mTag;
    }
}