package com.zh.touchassistant.floating.action;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> IFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:10 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface IFloatWindowAction {
    /**
     * 对应操作
     */
    void onAction();

    /**
     * Action的Id
     */
    int getActionId();
}