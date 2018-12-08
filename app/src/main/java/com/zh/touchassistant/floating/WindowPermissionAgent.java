package com.zh.touchassistant.floating;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;


public class WindowPermissionAgent {
    private static final int REQUEST_CODE = 6666;

    private Activity mActivity;
    private FloatWindowPermissionCallback mCallback;

    public WindowPermissionAgent(Activity activity, FloatWindowPermissionCallback callback) {
        this.mActivity = activity;
        this.mCallback = callback;
    }

    public FloatWindowPermissionCallback getCallback() {
        return mCallback;
    }

    public void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestAlertWindowPermission();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (WindowPermissionUtil.hasPermissionOnActivityResult(mActivity)) {
                if (mCallback != null) {
                    mCallback.onPermissionAllow();
                }
            } else {
                if (mCallback != null) {
                    mCallback.onPermissionReject();
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestAlertWindowPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + mActivity.getPackageName()));
        mActivity.startActivityForResult(intent, REQUEST_CODE);
    }
}