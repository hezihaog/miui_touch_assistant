package com.zh.touchassistant.floating.action;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> MenuFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:13 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class MenuFloatWindowAction extends AbsFloatWindowAction {
    @Override
    public void onAction() {
        if (checkAccessibilityIsOpen()) {
            getAccessibilityHelper().doGoTask();
        }
    }

    @Override
    public int getActionId() {
        return 3;
    }
}