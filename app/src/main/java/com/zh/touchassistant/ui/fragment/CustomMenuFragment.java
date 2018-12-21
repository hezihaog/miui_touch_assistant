package com.zh.touchassistant.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.zh.touchassistant.CustomMenuItemTouchCallback;
import com.zh.touchassistant.R;
import com.zh.touchassistant.base.BaseTouchAssistantFragment;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.itembinder.FloatWindowActionViewBinder;
import com.zh.touchassistant.listener.DelayOnClickListener;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.setting.FloatWindowSetting;
import com.zh.touchassistant.widget.TopBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> CustomMenuFragment <br>
 * <b>Create Date:</b> 2018/12/7  下午3:54 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuFragment extends BaseTouchAssistantFragment {
    private RecyclerView mRecyclerView;
    private ArrayList<FloatWindowActionModel> mDatas;

    public static CustomMenuFragment newInstance() {
        return new CustomMenuFragment();
    }

    @Override
    public int onLayoutId() {
        return R.layout.fragment_custom_menu;
    }

    @Override
    public void onLayoutAfter() {
        super.onLayoutAfter();
        View view = getView();
        TopBar topBar = view.findViewById(R.id.top_bar);
        topBar.setTitle("自定义菜单");
        topBar.addLeftBackImageButton().setOnClickListener(new DelayOnClickListener() {
            @Override
            public void onDelayClick(View view) {
                getActivity().finish();
            }
        });
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HashMap<FloatWindowActionModel, IFloatWindowAction> currentActions = FloatWindowSetting.getInstance().getCurrentActions();
        mDatas = new ArrayList<>();
        for (Map.Entry<FloatWindowActionModel, IFloatWindowAction> entry : currentActions.entrySet()) {
            mDatas.add(entry.getKey());
        }
        final MultiTypeAdapter adapter = new MultiTypeAdapter(mDatas);
        adapter.register(FloatWindowActionModel.class, new FloatWindowActionViewBinder(FloatWindowSetting.getInstance().getActionMap()));
        CustomMenuItemTouchCallback touchCallback = new CustomMenuItemTouchCallback(new CustomMenuItemTouchCallback.OnItemMoveCallback() {
            @Override
            public boolean isCanMove(RecyclerView.ViewHolder current, @NonNull RecyclerView.ViewHolder target) {
                return current.getItemViewType() == target.getItemViewType();
            }

            @Override
            public void onItemMove(int fromPosition, int toPosition) {
                //交换数据
                Collections.swap(mDatas, fromPosition, toPosition);
                adapter.notifyItemMoved(fromPosition, toPosition);
                //将新数据保存
                FloatWindowSetting.getInstance().saveNewActions(mDatas);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchCallback);
//        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                LinkedHashMap<Integer, IFloatWindowAction> actionMap = FloatWindowSetting.getInstance().getActionMap();
//                FloatWindowActionModel model = mDatas.get(position);
//                IFloatWindowAction action = actionMap.get(model.getActionId());
//                //跳转到设置某个按钮的功能界面
//            }
//        });
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }
}