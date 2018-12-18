package com.zh.touchassistant.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * <b>Package:</b> com.zh.touchassistant.base <br>
 * <b>FileName:</b> BaseActivity <br>
 * <b>Create Date:</b> 2018/12/18  上午10:05 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class BaseTouchAssistantActivity extends FragmentActivity implements LayoutCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLayoutBefore();
        int layoutId = onLayoutId();
        if (layoutId > 0) {
            setContentView(layoutId);
        }
        onLayoutAfter();
    }

    @Override
    public void onLayoutBefore() {

    }

    @Override
    public void onLayoutAfter() {

    }
}