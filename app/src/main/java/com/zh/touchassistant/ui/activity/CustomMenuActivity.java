package com.zh.touchassistant.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zh.touchassistant.R;
import com.zh.touchassistant.ui.fragment.CustomMenuFragment;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.activity <br>
 * <b>FileName:</b> CustomMenuActivity <br>
 * <b>Create Date:</b> 2018/12/7  下午8:39 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_menu);
        if (getSupportFragmentManager().findFragmentByTag(CustomMenuFragment.class.getName()) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, CustomMenuFragment.newInstance(), CustomMenuFragment.class.getName())
                    .commit();
        }
    }
}