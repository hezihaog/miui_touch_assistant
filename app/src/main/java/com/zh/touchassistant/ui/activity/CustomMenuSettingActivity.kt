package com.zh.touchassistant.ui.activity

import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantActivity
import com.zh.touchassistant.ui.fragment.CustomMenuFragment

/**
 * **Package:** com.zh.touchassistant.ui.activity <br></br>
 * **FileName:** CustomMenuActivity <br></br>
 * **Create Date:** 2018/12/7  下午8:39 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class CustomMenuSettingActivity : BaseTouchAssistantActivity() {

    override fun onLayoutId(): Int {
        return R.layout.activity_custom_menu
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        if (supportFragmentManager.findFragmentByTag(CustomMenuFragment::class.java.name) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, CustomMenuFragment.newInstance(), CustomMenuFragment::class.java.name)
                    .commit()
        }
    }
}