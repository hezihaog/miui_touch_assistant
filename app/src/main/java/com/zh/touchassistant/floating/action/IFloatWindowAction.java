package com.zh.touchassistant.floating.action;

import android.graphics.drawable.Drawable;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> IFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:10 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface IFloatWindowAction {
    /**
     * 该Action对应操作
     */
    void onAction();

    /**
     * 返回Action的Id
     */
    int getActionId();

    /**
     * 返回Action的名字
     */
    String getActionName();

    /**
     * 返回Action的图标Drawable
     */
    Drawable getActionIconDrawable();
}