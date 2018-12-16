package com.zh.touchassistant.floating.action;

import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.zh.touchassistant.AssistantApp;
import com.zh.touchassistant.R;
import com.zh.touchassistant.screenshot.ScreenshotActivity;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> ScreenshotFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:16 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ScreenshotAction extends BaseFloatWindowAction {
    @Override
    public void onAction() {
        AssistantApp application = getApplication();
        if (application != null) {
            Intent intent = new Intent(application, ScreenshotActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            application.startActivity(intent);
        }
    }

    @Override
    public int getActionId() {
        return 1;
    }

    @Override
    public String getActionName() {
        return "Screenshot";
    }

    @Override
    public Drawable getActionIconDrawable() {
        return getResDrawable(R.drawable.ic_toggle_screenshot);
    }
}