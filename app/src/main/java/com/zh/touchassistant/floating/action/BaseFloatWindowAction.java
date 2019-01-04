package com.zh.touchassistant.floating.action;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.provider.ContextProvider;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> AbsFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/7  上午11:34 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class BaseFloatWindowAction implements IFloatWindowAction {
    protected AssistantApp getApplication() {
        Application application = ContextProvider
                .get()
                .getApplication();
        if (application != null) {
            return (AssistantApp) application;
        } else {
            throw new NullPointerException("Application must be not null");
        }
    }

    protected Drawable getResDrawable(int resId) {
        return getApplication().getResources().getDrawable(resId);
    }
}