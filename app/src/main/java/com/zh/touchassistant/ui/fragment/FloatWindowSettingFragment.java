package com.zh.touchassistant.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.FloatWindowPermissionCallback;
import com.zh.touchassistant.floating.WindowPermissionAgent;
import com.zh.touchassistant.floating.WindowPermissionUtil;
import com.zh.touchassistant.service.CoreService;
import com.zh.touchassistant.ui.activity.CustomMenuActivity;
import com.zh.touchassistant.util.Property;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> FloatWindowSettingFragment <br>
 * <b>Create Date:</b> 2018/12/7  下午8:15 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowSettingFragment extends Fragment {

    private WindowPermissionAgent mPermissionAgent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_float_window_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //开关悬浮球
        SwitchCompat enableSwitch = view.findViewById(R.id.enable_switch);
        //自定义菜单
        TextView customMenuTv = view.findViewById(R.id.custom_menu_tv);
        //指定页面隐藏悬浮球
        LinearLayout hideTouchAssistantLayout = view.findViewById(R.id.hide_touch_assistant_ll);
        //恢复到默认设置
        TextView restoreDefaultTv = view.findViewById(R.id.restore_default_tv);
        //回显
        executeWindowAction(new Runnable() {
            @Override
            public void run() {
                boolean isEnable = Property.getDefault().getProperty(Const.Config.KEY_ENABLE, false);
                setEnableFloatWindow(isEnable);
            }
        });
        //设置监听
        enableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                if (isChecked) {
                    executeWindowAction(new Runnable() {
                        @Override
                        public void run() {
                            setEnableFloatWindow(isChecked);
                            Property.getDefault().setProperty(Const.Config.KEY_ENABLE, isChecked);
                        }
                    });
                }
            }
        });
        customMenuTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CustomMenuActivity.class));
            }
        });
        hideTouchAssistantLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        restoreDefaultTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mPermissionAgent != null) {
            mPermissionAgent.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void executeWindowAction(Runnable action) {
        mPermissionAgent = new WindowPermissionAgent(getActivity(), new PermissionCallback(getActivity(), action));
        if (WindowPermissionUtil.hasPermission(getContext())) {
            mPermissionAgent.getCallback().onPermissionAllow();
        } else {
            //请求权限
            mPermissionAgent.requestPermission();
        }
    }

    private static class PermissionCallback implements FloatWindowPermissionCallback {
        private Activity mActivity;
        private Runnable mAction;

        public PermissionCallback(Activity activity, Runnable action) {
            this.mActivity = activity;
            this.mAction = action;
        }

        @Override
        public void onPermissionAllow() {
            mAction.run();
        }

        @Override
        public void onPermissionReject() {
            Toast.makeText(mActivity,
                    "请允许" + mActivity.getResources().getString(R.string.app_name) + "出现在顶部",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 开关悬浮窗
     */
    private void setEnableFloatWindow(boolean isEnable) {
        Intent intent = new Intent(getActivity(), CoreService.class);
        if (isEnable) {
            intent.setAction(CoreService.Action.ACTION_SHOW_FLOATING_WINDOW);
        } else {
            intent.setAction(CoreService.Action.ACTION_HIDE_FLOATING_WINDOW);
        }
        getActivity().startService(intent);
    }
}