package com.zh.touchassistant.ui.activity;

import android.app.ActionBar;

import com.zh.touchassistant.R;
import com.zh.touchassistant.base.BaseTouchAssistantActivity;
import com.zh.touchassistant.ui.fragment.CustomMenuFragment;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.activity <br>
 * <b>FileName:</b> CustomMenuActivity <br>
 * <b>Create Date:</b> 2018/12/7  下午8:39 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuSettingActivity extends BaseTouchAssistantActivity {

    @Override
    public int onLayoutId() {
        return R.layout.activity_custom_menu;
    }

    @Override
    public void onLayoutAfter() {
        super.onLayoutAfter();
        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("自定义菜单");
        //隐藏小图标
        actionBar.setDisplayShowHomeEnabled(false);
        if (getSupportFragmentManager().findFragmentByTag(CustomMenuFragment.class.getName()) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, CustomMenuFragment.newInstance(), CustomMenuFragment.class.getName())
                    .commit();
        }
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return super.onNavigateUp();
    }
}