package com.zh.touchassistant.ui.activity;

import android.Manifest;
import android.widget.Toast;

import com.zh.touchassistant.R;
import com.zh.touchassistant.base.BaseTouchAssistantActivity;
import com.zh.touchassistant.permission.PermissionCallback;
import com.zh.touchassistant.permission.PermissionHelper;
import com.zh.touchassistant.ui.fragment.FloatWindowSettingFragment;

import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> MainActivity <br>
 * <b>Create Date:</b> 2018/12/2  下午4:43 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class MainActivity extends BaseTouchAssistantActivity {

    @Override
    public int onLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onLayoutAfter() {
        super.onLayoutAfter();
        PermissionHelper.request(this, new PermissionCallback() {
            @Override
            public void onGranted() {
                if (getSupportFragmentManager().findFragmentByTag(FloatWindowSettingFragment.class.getName()) == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.main_container,
                                    new FloatWindowSettingFragment(),
                                    FloatWindowSettingFragment.class.getName())
                            .commit();
                }
            }

            @Override
            public void onDenied(List<String> perms) {
                Toast.makeText(MainActivity.this, "请允许存储权限", Toast.LENGTH_SHORT).show();
                finish();
            }
        }, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}