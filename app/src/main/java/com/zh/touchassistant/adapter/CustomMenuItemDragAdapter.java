package com.zh.touchassistant.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.adapter <br>
 * <b>FileName:</b> CustomMenuItemDragAdapter <br>
 * <b>Create Date:</b> 2018/12/7  下午4:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuItemDragAdapter extends BaseItemDraggableAdapter<FloatWindowActionModel, BaseViewHolder> {
    private final LinkedHashMap<Integer, IFloatWindowAction> mActionMap;

    public CustomMenuItemDragAdapter(List<FloatWindowActionModel> data, LinkedHashMap<Integer, IFloatWindowAction> actionMap) {
        super(R.layout.item_custom_menu, data);
        this.mActionMap = actionMap;
    }

    @Override
    protected void convert(BaseViewHolder helper, FloatWindowActionModel item) {
        int actionId = item.getActionId();
        IFloatWindowAction action = mActionMap.get(actionId);
        helper.setImageDrawable(R.id.action_icon_iv, action.getActionIconDrawable());
        helper.setText(R.id.action_name_tv, action.getActionName());
    }
}