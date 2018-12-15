package com.zh.touchassistant.permission;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.zh.touchassistant.lifecycle.DelegateFragmentFinder;


/**
 * Created by Hezihao on 2017/7/10.
 * 权限管理器
 */

public class PermissionHelper {
    private PermissionHelper() {
    }

    /**
     * 检查指定权限是否已经获取
     */
    public static boolean isAccept(Context context, String permission) {
        return Util.isAccept(context, permission);
    }

    /**
     * 使用Activity申请权限
     *
     * @param activity 要注入权限申请代理的FragmentActivity
     * @param callback 权限申请 成功、失败回调
     * @param perms    权限列表数组
     */
    public static void request(FragmentActivity activity, PermissionCallback callback, String[] perms) {
        PermissionDelegateFragment delegate = findDelegate(activity);
        if (delegate != null) {
            delegate.requestPermission(activity, callback, perms);
        }
    }

    /**
     * 使用Fragment申请权限
     *
     * @param fragment 使用的Fragment
     * @param callback 权限申请 成功、失败回调
     * @param perms    权限列表数组
     */
    public static void request(Fragment fragment, PermissionCallback callback, String[] perms) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            PermissionDelegateFragment delegate = findDelegate(activity);
            if (delegate != null) {
                delegate.requestPermission(activity, callback, perms);
            }
        }
    }

    /**
     * 构建申请权限用的隐藏的fragment
     */
    private static PermissionDelegateFragment findDelegate(FragmentActivity activity) {
        return DelegateFragmentFinder.getInstance().find(activity, PermissionDelegateFragment.class);
    }
}