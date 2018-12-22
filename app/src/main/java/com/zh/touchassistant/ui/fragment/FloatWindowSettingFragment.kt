package com.zh.touchassistant.ui.fragment

import android.app.Activity
import android.content.Intent
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantFragment
import com.zh.touchassistant.constant.Const
import com.zh.touchassistant.ext.isNull
import com.zh.touchassistant.floating.FloatWindowPermissionCallback
import com.zh.touchassistant.floating.WindowPermissionAgent
import com.zh.touchassistant.floating.WindowPermissionUtil
import com.zh.touchassistant.ui.activity.AutoHideSettingActivity
import com.zh.touchassistant.ui.activity.CustomMenuSettingActivity
import com.zh.touchassistant.util.FloatServiceUtil
import com.zh.touchassistant.util.Property
import com.zh.touchassistant.util.logger.FSLogger
import com.zh.touchassistant.widget.SwitchButton
import kotterknife.bindView

/**
 * **Package:** com.zh.touchassistant.ui.fragment <br></br>
 * **FileName:** FloatWindowSettingFragment <br></br>
 * **Create Date:** 2018/12/7  下午8:15 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class FloatWindowSettingFragment : BaseTouchAssistantFragment() {
    //开关悬浮球
    private val mEnableSwitch: SwitchButton by bindView(R.id.enable_switch)
    //自定义菜单
    private val mCustomMenuTv: TextView by bindView(R.id.custom_menu_tv)
    //指定页面隐藏悬浮球
    private val mHideTouchAssistantLayout: LinearLayout by bindView(R.id.hide_touch_assistant_ll)
    //恢复到默认设置
    private val mRestoreDefaultTv: TextView by bindView(R.id.restore_default_tv)

    private lateinit var mPermissionAgent: WindowPermissionAgent

    override fun onLayoutId(): Int {
        return R.layout.fragment_float_window_setting
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        if (activity.isNull()) return
        //回显
        executeWindowAction(Runnable {
            val isEnable = Property.getDefault().getProperty(Const.Config.KEY_ENABLE, false)
            FloatServiceUtil.setEnableFloatWindow(activity, isEnable)
            mEnableSwitch.isChecked = isEnable
        })
        //设置监听
        mEnableSwitch.setOnCheckedChangeListener(object : SwitchButton.OnCheckedChangeListener {
            override fun onCheckedChanged(button: SwitchButton?, isChecked: Boolean) {
                FSLogger.d("isChecked -> $isChecked")
                executeWindowAction(Runnable {
                    FloatServiceUtil.setEnableFloatWindow(activity, isChecked)
                    Property.getDefault().setProperty(Const.Config.KEY_ENABLE, isChecked)
                })
            }
        })
        mCustomMenuTv.setOnClickListener {
            startActivity(Intent(activity, CustomMenuSettingActivity::class.java))
        }
        mHideTouchAssistantLayout.setOnClickListener {
            startActivity(Intent(activity, AutoHideSettingActivity::class.java))
        }
        mRestoreDefaultTv.setOnClickListener {
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        this.mPermissionAgent.onActivityResult(requestCode, resultCode, data)
    }

    private fun executeWindowAction(action: Runnable) {
        this.mPermissionAgent = WindowPermissionAgent(activity, PermissionCallback(activity!!, action))
        if (WindowPermissionUtil.hasPermission(context)) {
            mPermissionAgent.callback.onPermissionAllow()
        } else {
            //请求权限
            mPermissionAgent.requestPermission()
        }
    }

    private class PermissionCallback(private val mActivity: Activity, private val mAction: Runnable) : FloatWindowPermissionCallback {

        override fun onPermissionAllow() {
            mAction.run()
        }

        override fun onPermissionReject() {
            Toast.makeText(mActivity,
                    "请允许" + mActivity.resources.getString(R.string.app_name) + "出现在顶部",
                    Toast.LENGTH_SHORT).show()
        }
    }
}