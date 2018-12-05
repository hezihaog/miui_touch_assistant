package com.miui.touchassistant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.zh.touchassistant.R;

/**
 * <b>Package:</b> com.miui.touchassistant <br>
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

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}