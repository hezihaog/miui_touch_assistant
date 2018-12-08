package com.zh.touchassistant.floating.action;

import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.ContextProvider;
import com.zh.touchassistant.lock.OneScreenLockActivity;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> LockFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:14 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class LockAction extends AbsFloatWindowAction{

    @Override
    public void onAction() {
        Context context = ContextProvider
                .get()
                .getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, OneScreenLockActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public int getActionId() {
        return 2;
    }
}