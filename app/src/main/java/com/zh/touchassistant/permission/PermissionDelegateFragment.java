package com.zh.touchassistant.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.SparseArrayCompat;

import com.zh.touchassistant.lifecycle.BaseDelegateFragment;
import com.zh.touchassistant.lifecycle.SimpleFragmentLifecycleAdapter;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Hezihao on 2017/7/10.
 * 权限申请委托fragment
 */

public class PermissionDelegateFragment extends BaseDelegateFragment {
    //权限回调的标识
    private static final int REQUEST_CODE = 0X0122;
    private SparseArrayCompat<RequestEntry> callbacks = new SparseArrayCompat<RequestEntry>();

    public static PermissionDelegateFragment newInstance() {
        return new PermissionDelegateFragment();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        popAll();
        getProxyLifecycle().removeAllListener();
    }

    /**
     * 请求操作必须在OnAttach后调用
     *
     * @param entry 请求包装对象
     */
    private void pushStack(final RequestEntry entry) {
        callbacks.put(entry.hashCode(), entry);
        this.getProxyLifecycle().addListener(new SimpleFragmentLifecycleAdapter() {
            @Override
            public void onAttach() {
                super.onAttach();
                callbacks.get(entry.hashCode()).getRunnable().run();
                getProxyLifecycle().removeListener(this);
            }
        });
    }

    /**
     * 结束任务，在集合中移除
     *
     * @param entry 要移除的请求包装对象
     */
    private void popStack(RequestEntry entry) {
        callbacks.remove(entry.hashCode());
    }

    /**
     * 移除所有callback
     */
    private void popAll() {
        if (callbacks != null && callbacks.size() > 0) {
            callbacks.clear();
        }
    }


    /**
     * 批量申请权限
     *
     * @param context  上下文
     * @param callback 权限允许、拒绝回调
     * @param perms    要申请的权限数组
     */
    public void requestPermission(final Context context, final PermissionCallback callback, final String[] perms) {
        if (!Util.isNeedCheck(context)) {
            callback.onGranted();
            return;
        }
        pushStack(RequestEntry.newBuilder().withCallback(callback).withRunnable(new Runnable() {
            @Override
            public void run() {
                //只申请用户未允许的权限
                List<String> unGrantedList = new ArrayList<String>();
                for (String permission : perms) {
                    if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                        unGrantedList.add(permission);
                    }
                }
                if (unGrantedList.size() > 0) {
                    PermissionDelegateFragment.this.requestPermissions(unGrantedList.toArray(new String[]{}), REQUEST_CODE);
                } else {
                    if (callback != null) {
                        callback.onGranted();
                    }
                }
            }
        }).build());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && callbacks != null && callbacks.size() > 0) {
                    for (int i = 0; i < callbacks.size(); i++) {
                        RequestEntry entry = callbacks.valueAt(i);
                        PermissionCallback callback = entry.getCallback();
                        //找出拒绝的权限
                        List<String> deniedList = new ArrayList<String>();
                        for (int j = 0; j < grantResults.length; j++) {
                            int grantResult = grantResults[j];
                            String permission = permissions[j];
                            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                                deniedList.add(permission);
                            }
                        }
                        //已全部允许
                        if (deniedList.isEmpty()) {
                            callback.onGranted();
                        } else {
                            callback.onDenied(deniedList);
                        }
                        popStack(entry);
                    }
                }
                break;
            default:
                //其他情况，基本不存在，因为请求码这里只用一个
                break;
        }
    }
}
