package com.zh.touchassistant.lock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.zh.touchassistant.util.LockUtil;

/**
 * <b>Package:</b> com.zh.lockNow <br>
 * <b>FileName:</b> LockAgent <br>
 * <b>Create Date:</b> 2018/12/2  下午2:41 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b> 锁屏逻辑代理 <br>
 */
public class LockAgent {
    private static final int LOCK_REQUEST_CODE = 9999;
    private Activity mActivity;

    private DevicePolicyManager mPolicyManager;
    private ComponentName mComponentName;
    private OnLockListener mListener;

    public LockAgent(Activity activity) {
        this.mActivity = activity;
    }

    private Activity getActivity() {
        return this.mActivity;
    }

    public void lockNow() {
        mPolicyManager = (DevicePolicyManager) getActivity().getSystemService(Context.DEVICE_POLICY_SERVICE);
        mComponentName = new ComponentName(getActivity(), OneScreenLockAdminReceiver.class);
        boolean isActive = LockUtil.hasLockPermission(getActivity());
        //没有授权
        if (!isActive) {
            activeManage();
        } else {
            //授权了，直接锁屏
            LockUtil.lockNow(getActivity());
            if (mListener != null) {
                mListener.onLockSuccess();
            }
        }
    }

    /**
     * 申请授权
     */
    private void activeManage() {
        //启动设备管理(隐式Intent) - 在AndroidManifest.xml中设定相应过滤器
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        //权限列表
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
        //描述(additional explanation)
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "激活后才可以使用锁屏功能");
        getActivity().startActivityForResult(intent, LOCK_REQUEST_CODE);
    }

    /**
     * 代理Activity的onActivityResult
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOCK_REQUEST_CODE && resultCode == Activity.RESULT_CANCELED) {
            //直接返回界面
            if (mListener != null) {
                mListener.onLockPermissionCancel();
            }
        } else if (requestCode == LOCK_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                if (!mPolicyManager.isAdminActive(mComponentName)) {
                    //没有授予权限
                    if (mListener != null) {
                        mListener.onLockPermissionCancel();
                    }
                } else {
                    //授予了权限，锁屏
                    LockUtil.lockNow(getActivity());
                    if (mListener != null) {
                        mListener.onLockSuccess();
                    }
                }
            } catch (Exception error) {
                error.printStackTrace();
                if (mListener != null) {
                    mListener.onLockFail(error);
                }
            }
        }
    }

    public interface OnLockListener {
        /**
         * 锁屏成功回调
         */
        void onLockSuccess();

        /**
         * 锁屏失败回调
         *
         * @param error 异常对象
         */
        void onLockFail(Throwable error);

        /**
         * 权限取消
         */
        void onLockPermissionCancel();
    }

    public static class SimpleOnLockListener implements OnLockListener {

        @Override
        public void onLockSuccess() {

        }

        @Override
        public void onLockFail(Throwable error) {

        }

        @Override
        public void onLockPermissionCancel() {

        }
    }

    public void setOnLockListener(OnLockListener listener) {
        this.mListener = listener;
    }
}