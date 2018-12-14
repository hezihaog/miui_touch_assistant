package com.zh.touchassistant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.zh.touchassistant.R;
import com.zh.touchassistant.adapter.CustomMenuItemDragAdapter;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.util.ScreenUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> CustomMenuFragment <br>
 * <b>Create Date:</b> 2018/12/7  下午3:54 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<FloatWindowActionModel> mDatas;

    public static CustomMenuFragment newInstance() {
        return new CustomMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_custom_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.tool_bar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HashMap<FloatWindowActionModel, IFloatWindowAction> currentActions = FloatWindowSetting.getInstance().getCurrentActions();
        mDatas = new ArrayList<>();
        for (Map.Entry<FloatWindowActionModel, IFloatWindowAction> entry : currentActions.entrySet()) {
            mDatas.add(entry.getKey());
        }
        CustomMenuItemDragAdapter adapter = new CustomMenuItemDragAdapter(mDatas);
        ItemDragAndSwipeCallback itemDragCallback = new ItemDragAndSwipeCallback(adapter);
        //限制只能上下移动
        itemDragCallback.setDragMoveFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragCallback);
        //允许拽托
        adapter.enableDragItem(itemTouchHelper);
        //移动监听
        adapter.setOnItemDragListener(new OnItemDragListener() {

            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int position) {
                ViewCompat.setElevation(viewHolder.itemView, ScreenUtil.dip2px(viewHolder.itemView.getContext(), 10f));
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int position) {
                ViewCompat.setElevation(viewHolder.itemView, 0f);
                //将新数据保存
                FloatWindowSetting.getInstance().saveNewActions(mDatas);
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LinkedHashMap<Integer, IFloatWindowAction> actionMap = FloatWindowSetting.getInstance().getActionMap();
                FloatWindowActionModel model = mDatas.get(position);
                IFloatWindowAction action = actionMap.get(model.getActionId());
                //跳转到设置某个按钮的功能界面
            }
        });
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }
}