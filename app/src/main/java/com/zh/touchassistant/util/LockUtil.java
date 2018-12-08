package com.zh.touchassistant.util;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

import com.zh.touchassistant.lock.OneScreenLockAdminReceiver;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> LockUtil <br>
 * <b>Create Date:</b> 2018/12/8  下午11:09 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class LockUtil {
    /**
     * 检查是否激活了锁屏权限
     */
    public static boolean hasLockPermission(Context context) {
        DevicePolicyManager policyManager = (DevicePolicyManager) context
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = new ComponentName(context, OneScreenLockAdminReceiver.class);
        return policyManager.isAdminActive(componentName);
    }

    public static void lockNow(Context context) {
        DevicePolicyManager policyManager = (DevicePolicyManager) context
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        policyManager.lockNow();
    }
}