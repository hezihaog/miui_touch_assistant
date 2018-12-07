package com.zh.touchassistant.floating.action;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> BackFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:14 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class BackFloatWindowAction extends AbsFloatWindowAction {

    @Override
    public void onAction() {
        if (checkAccessibilityIsOpen()) {
            getAccessibilityHelper().doBack();
        }
    }

    @Override
    public int getActionId() {
        return 0;
    }
}