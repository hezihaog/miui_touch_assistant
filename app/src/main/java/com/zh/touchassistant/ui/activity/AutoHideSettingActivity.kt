package com.zh.touchassistant.ui.activity

import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantActivity
import com.zh.touchassistant.ui.fragment.AutoHideSettingFragment

/**
 * **Package:** com.zh.touchassistant.ui.activity <br></br>
 * **FileName:** AutoHideSettingActivity <br></br>
 * **Create Date:** 2018/12/17  下午4:29 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class AutoHideSettingActivity : BaseTouchAssistantActivity() {

    override fun onLayoutId(): Int {
        return R.layout.activity_auto_hide
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        if (supportFragmentManager.findFragmentByTag(AutoHideSettingFragment::class.java.name) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, AutoHideSettingFragment.newInstance())
                    .commit()
        }
    }
}