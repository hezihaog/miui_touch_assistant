package com.zh.touchassistant.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * <b>Package:</b> com.zh.touchassistant.controller <br>
 * <b>FileName:</b> BaseViewController <br>
 * <b>Create Date:</b> 2018/12/7  下午11:53 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class BaseViewController {
    protected Context mContext;
    protected LayoutInflater mInflater;

    public BaseViewController(Context context) {
        this.mContext = context;
    }

    protected Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    protected LayoutInflater getLayoutInflater() {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(getApplicationContext());
        }
        return mInflater;
    }

    public abstract View getView();
}