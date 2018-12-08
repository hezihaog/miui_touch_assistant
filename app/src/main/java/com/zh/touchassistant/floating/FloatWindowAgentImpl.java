package com.zh.touchassistant.floating;

import android.content.Context;
import android.view.View;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.IFloatWindow;
import com.yhao.floatwindow.MoveType;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.ViewStateListener;

/**
 * <b>Package:</b> com.zh.touchassistant.floating <br>
 * <b>FileName:</b> FloatWindowAgentImpl <br>
 * <b>Create Date:</b> 2018/12/5  下午6:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowAgentImpl implements IFloatWindowAgent {
    private String mTag;
    private Context mContext;

    @Override
    public void setContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void makeFloatWindow(View view, String tag, final FloatWindowOption option) {
        this.mTag = tag;
        int moveType;
        if (option.getMoveType() == FloatMoveEnum.INACTIVE) {
            moveType = MoveType.inactive;
        } else if (option.getMoveType() == FloatMoveEnum.ACTIVE) {
            moveType = MoveType.active;
        } else if (option.getMoveType() == FloatMoveEnum.SLIDE) {
            moveType = MoveType.slide;
        } else {
            moveType = MoveType.inactive;
        }
        ViewStateListener viewStateListener = null;
        PermissionListener permissionListener = null;
        if (option.getViewStateCallback() != null) {
            viewStateListener = new ViewStateListener() {
                @Override
                public void onPositionUpdate(int x, int y) {
                    option.getViewStateCallback().onPositionUpdate(FloatWindowAgentImpl.this, x, y);
                }

                @Override
                public void onShow() {
                    option.getViewStateCallback().onShow(FloatWindowAgentImpl.this);
                }

                @Override
                public void onHide() {
                    option.getViewStateCallback().onHide(FloatWindowAgentImpl.this);
                }

                @Override
                public void onDismiss() {
                    option.getViewStateCallback().onDismiss(FloatWindowAgentImpl.this);
                }

                @Override
                public void onMoveAnimStart() {
                    option.getViewStateCallback().onMoveAnimStart(FloatWindowAgentImpl.this);
                }

                @Override
                public void onMoveAnimEnd() {
                    option.getViewStateCallback().onMoveAnimEnd(FloatWindowAgentImpl.this);
                }

                @Override
                public void onBackToDesktop() {
                    option.getViewStateCallback().onBackToDesktop(FloatWindowAgentImpl.this);
                }
            };
        }
        if (option.getPermissionCallback() != null) {
            permissionListener = new PermissionListener() {
                @Override
                public void onSuccess() {
                    option.getPermissionCallback().onPermissionAllow(FloatWindowAgentImpl.this);
                }

                @Override
                public void onFail() {
                    option.getPermissionCallback().onPermissionReject(FloatWindowAgentImpl.this);
                }
            };
        }
        FloatWindow
                .with(mContext)
                .setTag(tag)
                .setView(view)
                .setX(option.getX())
                .setY(option.getY())
                .setDesktopShow(option.isShowDesktop())
                .setMoveType(moveType)
                .setViewStateListener(viewStateListener)
                .setPermissionListener(permissionListener)
                .build();
    }

    @Override
    public void show() {
        FloatWindow
                .get(mTag)
                .show();
    }

    @Override
    public void hide() {
        FloatWindow
                .get(mTag)
                .hide();
    }

    @Override
    public boolean isShowing() {
        return FloatWindow
                .get(mTag)
                .isShowing();
    }

    @Override
    public int getX() {
        return FloatWindow
                .get(mTag)
                .getX();
    }

    @Override
    public int getY() {
        return FloatWindow
                .get(mTag)
                .getY();
    }

    @Override
    public void updateX(int newY) {
        FloatWindow
                .get(mTag)
                .updateX(newY);
    }

    @Override
    public void updateY(int newY) {
        FloatWindow
                .get(mTag)
                .updateY(newY);
    }

    @Override
    public void updateXY(int newX, int newY) {
        IFloatWindow floatWindow = FloatWindow
                .get(mTag);
        floatWindow.updateX(newX);
        floatWindow
                .updateY(newY);
    }

    @Override
    public View getView() {
        return FloatWindow
                .get(mTag)
                .getView();
    }

    @Override
    public String getTag() {
        return mTag;
    }

    @Override
    public void destroy() {
        FloatWindow
                .destroy(mTag);
    }
}