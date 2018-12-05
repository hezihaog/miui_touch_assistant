package com.zh.touchassistant.floating;

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
    private FloatWindowPermissionCallback mPermissionCallback;

    public static FloatWindowOption create(Builder builder) {
        return new FloatWindowOption(builder);
    }

    private FloatWindowOption(Builder builder) {
        this.mX = builder.mX > 0 ? builder.mX : 0;
        this.mY = builder.mY > 0 ? builder.mY : 0;
        this.mIsShowDesktop = builder.mIsShowDesktop;
        this.mMoveType = builder.mMoveType != null ? builder.mMoveType : FloatMoveEnum.INACTIVE;
        this.mViewStateCallback = builder.mViewStateCallback;
        this.mPermissionCallback = builder.mPermissionCallback;
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

    public void setViewStateCallback(FloatWindowViewStateCallback viewStateCallback) {
        mViewStateCallback = viewStateCallback;
    }

    public FloatWindowPermissionCallback getPermissionCallback() {
        return mPermissionCallback;
    }

    public void setPermissionCallback(FloatWindowPermissionCallback permissionCallback) {
        mPermissionCallback = permissionCallback;
    }

    public static class Builder {
        private int mX;
        private int mY;
        private boolean mIsShowDesktop;
        private FloatMoveEnum mMoveType;
        private FloatWindowViewStateCallback mViewStateCallback;
        private FloatWindowPermissionCallback mPermissionCallback;

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

        public Builder setFloatWindowPermissionCallback(FloatWindowPermissionCallback callback) {
            this.mPermissionCallback = callback;
            return this;
        }
    }
}