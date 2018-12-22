package com.zh.touchassistant.ui.activity

import android.Manifest
import android.widget.Toast

import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantActivity
import com.zh.touchassistant.permission.PermissionCallback
import com.zh.touchassistant.permission.PermissionHelper
import com.zh.touchassistant.ui.fragment.FloatWindowSettingFragment

/**
 * **Package:** com.zh.touchassistant <br></br>
 * **FileName:** MainActivity <br></br>
 * **Create Date:** 2018/12/2  下午4:43 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class MainActivity : BaseTouchAssistantActivity() {

    override fun onLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        PermissionHelper.request(this, object : PermissionCallback {
            override fun onGranted() {
                if (supportFragmentManager.findFragmentByTag(FloatWindowSettingFragment::class.java.name) == null) {
                    supportFragmentManager
                            .beginTransaction()
                            .add(R.id.main_container,
                                    FloatWindowSettingFragment(),
                                    FloatWindowSettingFragment::class.java.name)
                            .commit()
                }
            }

            override fun onDenied(perms: List<String>) {
                Toast.makeText(this@MainActivity, "请允许存储权限", Toast.LENGTH_SHORT).show()
                finish()
            }
        }, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}