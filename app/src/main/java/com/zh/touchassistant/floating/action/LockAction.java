package com.zh.touchassistant.floating.action;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zh.touchassistant.ContextProvider;
import com.zh.touchassistant.R;
import com.zh.touchassistant.lock.OneScreenLockActivity;
import com.zh.touchassistant.util.LockUtil;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> LockFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:14 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class LockAction extends AbsFloatWindowAction {

    @Override
    public void onAction() {
        Context context = ContextProvider
                .get()
                .getContext();
        if (context == null) {
            return;
        }
        //如果已经有权限，则不需要跳转到代理申请的Activity
        if (LockUtil.hasLockPermission(context)) {
            LockUtil.lockNow(context);
        } else {
            Intent intent = new Intent(context, OneScreenLockActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Toast.makeText(context, "请开启" + context.getResources().getString(R.string.app_name) + "辅助管理器", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getActionId() {
        return 2;
    }
}