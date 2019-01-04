package com.zh.touchassistant.floating.action;

import android.graphics.drawable.Drawable;

import com.zh.touchassistant.R;
import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.util.AppBroadcastManager;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> MenuFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:13 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class MenuAction extends BaseFloatWindowAction {
    @Override
    public void onAction() {
        AppBroadcastManager
                .sendBroadcast(getApplication(), AccessibilityConstant.Action.ACTION_DO_GO_TASK);
    }

    @Override
    public int getActionId() {
        return 3;
    }

    @Override
    public String getActionName() {
        return "Menu";
    }

    @Override
    public Drawable getActionIconDrawable() {
        return getResDrawable(R.drawable.ic_key_menu);
    }
}