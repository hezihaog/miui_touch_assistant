package com.zh.touchassistant.ui.fragment

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.zh.touchassistant.CustomMenuItemTouchCallback
import com.zh.touchassistant.R
import com.zh.touchassistant.base.BaseTouchAssistantFragment
import com.zh.touchassistant.itembinder.FloatWindowActionViewBinder
import com.zh.touchassistant.listener.DelayOnClickListener
import com.zh.touchassistant.model.FloatWindowActionModel
import com.zh.touchassistant.setting.FloatWindowSetting
import com.zh.touchassistant.widget.TopBar
import kotterknife.bindView
import me.drakeet.multitype.MultiTypeAdapter
import java.util.*

/**
 * **Package:** com.zh.touchassistant.ui.fragment <br></br>
 * **FileName:** CustomMenuFragment <br></br>
 * **Create Date:** 2018/12/7  下午3:54 <br></br>
 * **Author:** zihe <br></br>
 * **Description:**  <br></br>
 */
class CustomMenuFragment : BaseTouchAssistantFragment() {
    private val mTopBar: TopBar by bindView(R.id.top_bar)
    private val mRecyclerView: RecyclerView by bindView(R.id.recycler_view)
    private val mAdapter: MultiTypeAdapter by lazy {
        val adapter = MultiTypeAdapter(mDatas)
        adapter.register(FloatWindowActionModel::class.java, FloatWindowActionViewBinder(FloatWindowSetting.getInstance().actionMap))
        return@lazy adapter
    }
    private val mDatas: ArrayList<FloatWindowActionModel> by lazy {
        ArrayList<FloatWindowActionModel>()
    }

    override fun onLayoutId(): Int {
        return R.layout.fragment_custom_menu
    }

    override fun onLayoutAfter() {
        super.onLayoutAfter()
        mTopBar.apply {
            setTitle("自定义菜单")
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
        val currentActions = FloatWindowSetting.getInstance().currentActions
        for ((key) in currentActions) {
            mDatas.add(key)
        }
        val touchCallback = CustomMenuItemTouchCallback(object : CustomMenuItemTouchCallback.OnItemMoveCallback {
            override fun isCanMove(current: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return current.itemViewType == target.itemViewType
            }

            override fun onItemMove(fromPosition: Int, toPosition: Int) {
                //交换数据
                Collections.swap(mDatas, fromPosition, toPosition)
                mAdapter.notifyItemMoved(fromPosition, toPosition)
                //将新数据保存
                FloatWindowSetting.getInstance().saveNewActions(mDatas)
            }
        })
        val itemTouchHelper = ItemTouchHelper(touchCallback)
        itemTouchHelper.attachToRecyclerView(mRecyclerView)
    }

    companion object {
        fun newInstance(): CustomMenuFragment {
            return CustomMenuFragment()
        }
    }
}