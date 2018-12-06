package com.zh.touchassistant.floating;

import android.content.Context;
import android.view.View;

/**
 * <b>Package:</b> com.zh.touchassistant.floating <br>
 * <b>FileName:</b> IFloatWindowAgent <br>
 * <b>Create Date:</b> 2018/12/5  下午6:25 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface IFloatWindowAgent {
    void setContext(Context context);

    /**
     * 创建悬浮窗
     *
     * @param view   悬浮的布局
     * @param tag    查找悬浮窗时使用的标记
     * @param option 可选参数
     */
    void makeFloatWindow(View view, String tag, FloatWindowOption option);

    /**
     * 展示悬浮窗
     */
    void show();

    /**
     * 隐藏悬浮窗
     */
    void hide();

    /**
     * 悬浮窗当前是否展示
     */
    boolean isShowing();

    /**
     * 获取悬浮床当前的X坐标
     */
    int getX();

    /**
     * 获取悬浮窗当前的Y坐标
     */
    int getY();

    /**
     * 更新悬浮窗的X坐标
     */
    void updateX(int newX);

    /**
     * 更新悬浮窗的Y坐标
     */
    void updateY(int newY);

    /**
     * 获取悬浮窗View
     */
    View getView();

    /**
     * 获取当前悬浮窗的Tag
     */
    String getTag();

    /**
     * 销毁
     */
    void destroy();
}