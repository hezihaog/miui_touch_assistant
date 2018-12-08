package com.zh.touchassistant.floating;

/**
 * <b>Package:</b> com.zh.touchassistant.floating <br>
 * <b>FileName:</b> FloatWindowViewStateCallback <br>
 * <b>Create Date:</b> 2018/12/5  下午6:54 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface FloatWindowViewStateCallback {
    /**
     * 当悬浮窗位置更新时回调
     *
     * @param x x坐标
     * @param y y坐标
     */
    void onPositionUpdate(int x, int y);

    /**
     * 当显示时回调
     */
    void onShow();

    /**
     * 当隐藏时回调
     */
    void onHide();

    /**
     * 当被移除时回调
     */
    void onRemove();

    /**
     * 当准备拖动时回调
     *
     * @return 返回true标识允许拖动，false则不允许
     */
    boolean onPrepareDrag();

    /**
     * 当移动动画开始时回调
     */
    void onMoveAnimStart();

    /**
     * 当移动动画结束时回调
     */
    void onMoveAnimEnd();

    /**
     * 当返回桌面时回调
     */
    void onBackToDesktop();
}