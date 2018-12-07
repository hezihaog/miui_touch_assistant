package com.zh.touchassistant.screenshot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * <b>Package:</b> com.zh.touchassistant.screenshot <br>
 * <b>FileName:</b> ScreenshotActivity <br>
 * <b>Create Date:</b> 2018/12/7  下午12:17 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ScreenshotActivity extends FragmentActivity {
    private ScreenCaptureAgent mCaptureAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCaptureAgent = new ScreenCaptureAgent(this);
        mCaptureAgent.startScreenCapture(new ScreenCaptureAgent.SaveScreenshotCallback() {
            @Override
            public void onSaveSuccess() {
                Toast.makeText(ScreenshotActivity.this, "截图成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onSaveFail() {
                Toast.makeText(ScreenshotActivity.this, "截图失败请重试", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCaptureAgent != null) {
            mCaptureAgent.onActivityDestroy();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mCaptureAgent != null) {
            mCaptureAgent.onActivityResult(requestCode, resultCode, data);
        }
    }
}