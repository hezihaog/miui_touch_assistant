package com.zh.touchassistant.ui.activity;

import com.zh.touchassistant.R;
import com.zh.touchassistant.base.BaseTouchAssistantActivity;
import com.zh.touchassistant.ui.fragment.AutoHideSettingFragment;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.activity <br>
 * <b>FileName:</b> AutoHideSettingActivity <br>
 * <b>Create Date:</b> 2018/12/17  下午4:29 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideSettingActivity extends BaseTouchAssistantActivity {

    @Override
    public int onLayoutId() {
        return R.layout.activity_auto_hide;
    }

    @Override
    public void onLayoutAfter() {
        super.onLayoutAfter();
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