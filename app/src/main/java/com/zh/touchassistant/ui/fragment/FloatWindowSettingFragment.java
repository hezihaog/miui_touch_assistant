package com.zh.touchassistant.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zh.touchassistant.R;
import com.zh.touchassistant.base.BaseTouchAssistantFragment;
import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.floating.FloatWindowPermissionCallback;
import com.zh.touchassistant.floating.WindowPermissionAgent;
import com.zh.touchassistant.floating.WindowPermissionUtil;
import com.zh.touchassistant.ui.activity.AutoHideSettingActivity;
import com.zh.touchassistant.ui.activity.CustomMenuSettingActivity;
import com.zh.touchassistant.util.FloatServiceUtil;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.logger.FSLogger;
import com.zh.touchassistant.widget.SwitchButton;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> FloatWindowSettingFragment <br>
 * <b>Create Date:</b> 2018/12/7  下午8:15 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowSettingFragment extends BaseTouchAssistantFragment {
    private WindowPermissionAgent mPermissionAgent;

    @Override
    public int onLayoutId() {
        return R.layout.fragment_float_window_setting;
    }

    @Override
    public void onLayoutAfter() {
        super.onLayoutAfter();
        View view = getView();
        //开关悬浮球
        final SwitchButton enableSwitch = view.findViewById(R.id.enable_switch);
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
                FloatServiceUtil.setEnableFloatWindow(getActivity(), isEnable);
                enableSwitch.setChecked(isEnable);
            }
        });
        //设置监听
        enableSwitch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton button, final boolean isChecked) {
                FSLogger.d("isChecked -> " + isChecked);
                executeWindowAction(new Runnable() {
                    @Override
                    public void run() {
                        FloatServiceUtil.setEnableFloatWindow(getActivity(), isChecked);
                        Property.getDefault().setProperty(Const.Config.KEY_ENABLE, isChecked);
                    }
                });
            }
        });
        customMenuTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CustomMenuSettingActivity.class));
            }
        });
        hideTouchAssistantLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AutoHideSettingActivity.class));
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
}