package com.zh.touchassistant.base;

/**
 * <b>Package:</b> com.zh.touchassistant.base <br>
 * <b>FileName:</b> LayoutCallback <br>
 * <b>Create Date:</b> 2018/12/18  上午10:00 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface LayoutCallback {
    void onLayoutBefore();

    int onLayoutId();

    void onLayoutAfter();
}