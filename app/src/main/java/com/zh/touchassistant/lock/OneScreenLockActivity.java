package com.zh.touchassistant.lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.zh.touchassistant.R;
import com.zh.touchassistant.util.logger.FSLogger;

/**
 * <b>Package:</b> com.zh.touchassistant.lockNow <br>
 * <b>FileName:</b> OneScreenLockActivity <br>
 * <b>Create Date:</b> 2018/12/7  下午12:09 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class OneScreenLockActivity extends Activity {
    private LockAgent mAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAgent = new LockAgent(this);
        mAgent.setOnLockListener(new LockAgent.SimpleOnLockListener() {
            @Override
            public void onLockSuccess() {
                super.onLockSuccess();
                finish();
            }

            @Override
            public void onLockFail(Throwable error) {
                super.onLockFail(error);
                FSLogger.d("Lock Fail： " + error.getMessage());
                finish();
            }

            @Override
            public void onLockPermissionCancel() {
                super.onLockPermissionCancel();
                FSLogger.d("Lock Permission Cancel");
                toast(getString(R.string.request_lock_permission_fail));
                finish();
            }
        });
        mAgent.lockNow();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mAgent != null) {
            mAgent.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void toast(String msg) {
        Toast
                .makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT)
                .show();
    }
}