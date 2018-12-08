package com.zh.touchassistant.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.zh.touchassistant.R;
import com.zh.touchassistant.service.CoreService;
import com.zh.touchassistant.ui.fragment.FloatWindowSettingFragment;

import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> MainActivity <br>
 * <b>Create Date:</b> 2018/12/2  下午4:43 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class MainActivity extends AppCompatActivity {
    //布局文件中 含有 vector矢量图 的 Activity 还需要添加一句以下代码
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.tool_bar);
        if (getSupportFragmentManager().findFragmentByTag(FloatWindowSettingFragment.class.getName()) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_container, new FloatWindowSettingFragment(), FloatWindowSettingFragment.class.getName())
            .commit();
        }
        AndPermission
                .with(this)
                .permission(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(getApplicationContext(), CoreService.class);
                        startService(intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW));
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Toast.makeText(MainActivity.this, "请允许存储权限", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).start();
    }
}