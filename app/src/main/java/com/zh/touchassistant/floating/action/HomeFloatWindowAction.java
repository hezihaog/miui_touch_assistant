package com.zh.touchassistant.floating.action;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> HomeFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:12 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class HomeFloatWindowAction extends AbsFloatWindowAction {

    @Override
    public void onAction() {
        if (checkAccessibilityIsOpen()) {
            getAccessibilityHelper().doGoHome();
        }
    }

    @Override
    public int getActionId() {
        return 4;
    }
}