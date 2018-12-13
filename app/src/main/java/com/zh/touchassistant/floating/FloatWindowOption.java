package com.zh.touchassistant.floating;

import android.animation.TimeInterpolator;

/**
 * <b>Package:</b> com.zh.touchassistant.floating <br>
 * <b>FileName:</b> FloatWindowOption <br>
 * <b>Create Date:</b> 2018/12/5  下午6:32 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowOption {
    private int mX;
    private int mY;
    private boolean mIsShowDesktop;
    private FloatMoveEnum mMoveType;
    private FloatWindowViewStateCallback mViewStateCallback;
    private TimeInterpolator mInterpolator;
    private long mDuration;
    private Boolean isShow;
    private int mBoundOffset;

    public static FloatWindowOption create(Builder builder) {
        return new FloatWindowOption(builder);
    }

    private FloatWindowOption(Builder builder) {
        this.mX = builder.mX > 0 ? builder.mX : 0;
        this.mY = builder.mY > 0 ? builder.mY : 0;
        this.mIsShowDesktop = builder.mIsShowDesktop;
        this.mMoveType = builder.mMoveType != null ? builder.mMoveType : FloatMoveEnum.INACTIVE;
        this.mViewStateCallback = builder.mViewStateCallback;
        this.mInterpolator = builder.mInterpolator;
        this.mDuration = builder.mDuration <= 0 ? 450 : builder.mDuration;
        this.isShow = builder.isShow == null ? true : builder.isShow;
        this.mBoundOffset = builder.mBoundOffset;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public boolean isShowDesktop() {
        return mIsShowDesktop;
    }

    public FloatMoveEnum getMoveType() {
        return mMoveType;
    }

    public FloatWindowViewStateCallback getViewStateCallback() {
        return mViewStateCallback;
    }

    public TimeInterpolator getInterpolator() {
        return mInterpolator;
    }

    public long getDuration() {
        return mDuration;
    }

    public Boolean isShow() {
        return isShow;
    }

    public int getBoundOffset() {
        return mBoundOffset;
    }

    public static class Builder {
        private int mX;
        private int mY;
        private boolean mIsShowDesktop;
        private FloatMoveEnum mMoveType;
        private FloatWindowViewStateCallback mViewStateCallback;
        private TimeInterpolator mInterpolator;
        private long mDuration;
        private Boolean isShow;
        /**
         * 边界偏移量，只在自动贴边时生效，距离屏幕左或右的偏移量
         */
        private int mBoundOffset;

        public Builder setX(int x) {
            mX = x;
            return this;
        }

        public Builder setY(int y) {
            mY = y;
            return this;
        }

        public Builder desktopShow(boolean isShow) {
            mIsShowDesktop = isShow;
            return this;
        }

        public Builder setFloatMoveType(FloatMoveEnum moveType) {
            this.mMoveType = moveType;
            return this;
        }

        public Builder setViewStateCallback(FloatWindowViewStateCallback callback) {
            this.mViewStateCallback = callback;
            return this;
        }

        public Builder setInterpolator(TimeInterpolator interpolator) {
            this.mInterpolator = interpolator;
            return this;
        }

        public Builder setShow(boolean show) {
            this.isShow = show;
            return this;
        }

        public Builder setDuration(long duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder setBoundOffset(int boundOffset) {
            this.mBoundOffset = boundOffset;
            return this;
        }
    }
}