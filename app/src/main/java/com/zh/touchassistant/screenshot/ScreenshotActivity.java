package com.zh.touchassistant.screenshot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
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
        //透明掉Activity状态栏，不然因为主题是默认，状态栏是黑条。
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
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
        if (resultCode == Activity.RESULT_CANCELED) {
            finish();
            return;
        }
        if (mCaptureAgent != null) {
            mCaptureAgent.onActivityResult(requestCode, resultCode, data);
        }
    }
}