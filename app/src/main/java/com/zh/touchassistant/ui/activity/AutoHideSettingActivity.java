package com.zh.touchassistant.ui.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.zh.touchassistant.R;
import com.zh.touchassistant.ui.fragment.AutoHideSettingFragment;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.activity <br>
 * <b>FileName:</b> AutoHideSettingActivity <br>
 * <b>Create Date:</b> 2018/12/17  下午4:29 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideSettingActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_hide);
        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("隐藏悬浮球");
        actionBar.setDisplayShowHomeEnabled(false);
        if (getSupportFragmentManager().findFragmentByTag(AutoHideSettingFragment.class.getName()) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, AutoHideSettingFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return super.onNavigateUp();
    }
}