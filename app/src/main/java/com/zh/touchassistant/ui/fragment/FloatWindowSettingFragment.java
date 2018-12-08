package com.zh.touchassistant.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;

import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.service.CoreService;
import com.zh.touchassistant.ui.activity.CustomMenuActivity;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> FloatWindowSettingFragment <br>
 * <b>Create Date:</b> 2018/12/7  下午8:15 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowSettingFragment extends PreferenceFragmentCompat {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //开关悬浮球
        findPreference("enabled").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Intent intent = new Intent(getActivity(), CoreService.class);
                intent.setAction(CoreService.Action.ACTION_TOGGLE_FLOATING_WINDOW);
                getActivity().startService(intent);
                return true;
            }
        });
        //自定义菜单
        findPreference("function_settings").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getActivity(), CustomMenuActivity.class));
                return true;
            }
        });
        //指定页面隐藏悬浮球
        findPreference("auto_hide").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });
        //恢复到默认设置
        findPreference("restore_to_default").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                return false;
            }
        });
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String rootKey) {
        //设置SharedPreferences文件名
        getPreferenceManager().setSharedPreferencesName(Const.Config.APP_SP_FILE_NAME);
        addPreferencesFromResource(R.xml.main);
    }
}