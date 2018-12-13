package com.zh.touchassistant;

import android.view.View;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> DelayOnClickListener <br>
 * <b>Create Date:</b> 2018/12/13  下午10:45 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class DelayOnClickListener implements View.OnClickListener {
    private static final int DELAY_TIME = 300;
    /**
     * 上一次的点击时间
     */
    private long mLastClickTime;

    @Override
    public final void onClick(View view) {
        if (System.currentTimeMillis() - mLastClickTime < DELAY_TIME) {
            return;
        }
        onDelayClick(view);
        this.mLastClickTime = System.currentTimeMillis();
    }

    public abstract void onDelayClick(View view);
}