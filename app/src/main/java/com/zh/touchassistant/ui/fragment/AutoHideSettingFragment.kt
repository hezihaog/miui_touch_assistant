package com.zh.touchassistant.ui.fragment

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lzh.easythread.EasyThread
import com.pnikosis.materialishprogress.ProgressWheel
import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantFragment
import com.zh.touchassistant.database.biz.IAutoHideFloatBiz
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz
import com.zh.touchassistant.ext.isNull
import com.zh.touchassistant.ext.setGone
import com.zh.touchassistant.ext.setVisible
import com.zh.touchassistant.itembinder.AutoHideViewBinder
import com.zh.touchassistant.listener.DelayOnClickListener
import com.zh.touchassistant.model.AutoHideModel
import com.zh.touchassistant.provider.ContextProvider
import com.zh.touchassistant.util.AppInfoUtil
import com.zh.touchassistant.util.singleton.ISingletonStorage
import com.zh.touchassistant.widget.TopBar
import kotterknife.bindView
import me.drakeet.multitype.MultiTypeAdapter

/**
 * **Package:** com.zh.touchassistant.ui.fragment <br></br>
 * **FileName:** AutoHideSettingFragment <br></br>
 * **Create Date:** 2018/12/17  下午4:19 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class AutoHideSettingFragment : BaseTouchAssistantFragment() {
    private val mTopBar: TopBar by bindView(R.id.top_bar)
    private val mRecyclerView: RecyclerView by bindView(R.id.recycler_view)
    private val mWaitProgressWheel: ProgressWheel by bindView(R.id.wait_progress_wheel)
    private val mAdapter: MultiTypeAdapter by lazy {
        val typeAdapter = MultiTypeAdapter(mDatas)
        typeAdapter.register(AutoHideModel::class.java, AutoHideViewBinder())
        return@lazy typeAdapter
    }
    private val mDatas: MutableList<AutoHideModel> by lazy {
        mutableListOf<AutoHideModel>()
    }

    //之前设置的数据
    private val autoHideAppPackageNameList: MutableList<String>
        get() {
            val result = mutableListOf<String>()
            val storage = ContextProvider.get().application as ISingletonStorage
            val biz = storage.getInstance<AutoHideFloatBiz>(IAutoHideFloatBiz::class.java, AutoHideFloatBiz::class.java)
            val autoHideAppList = biz.autoHideAppList
            for (vo in autoHideAppList) {
                result.add(vo.appPackageName)
            }
            return result
        }

    override fun onLayoutId(): Int {
        return R.layout.fragment_auto_hide
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        if (context.isNull()) return
        val context = context!!
        mTopBar.apply {
            setTitle("隐藏悬浮球")
            addLeftBackImageButton().setOnClickListener(object : DelayOnClickListener() {
                override fun onDelayClick(view: View) {
                    activity?.finish()
                }
            })
        }
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
        mWaitProgressWheel.setVisible()
        EasyThread.Builder.createCacheable().build().execute {
            //本机App列表
            val installAppInfoList = AppInfoUtil
                    .getInstallAppInfoList(context, true)
            val autoHideAppPackageNameList = autoHideAppPackageNameList
            //过滤掉本应用
            autoHideAppPackageNameList.remove(context.packageName)
            for (installAppInfoModel in installAppInfoList) {
                val autoHideModel = AutoHideModel()
                //是自动隐藏
                autoHideModel.isAutoHide = autoHideAppPackageNameList.contains(installAppInfoModel.packageName)
                autoHideModel.appIcon = installAppInfoModel.appIcon
                autoHideModel.appName = installAppInfoModel.appName
                autoHideModel.packageName = installAppInfoModel.packageName
                mDatas.add(autoHideModel)
            }
            val activity = activity
            if (activity != null && !activity.isFinishing) {
                activity.runOnUiThread {
                    mAdapter.notifyDataSetChanged()
                    mWaitProgressWheel.setGone()
                }
            }
        }
    }

    companion object {
        fun newInstance(): AutoHideSettingFragment {
            return AutoHideSettingFragment()
        }
    }
}