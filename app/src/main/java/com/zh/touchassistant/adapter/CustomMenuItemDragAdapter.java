package com.zh.touchassistant.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zh.touchassistant.R;
import com.zh.touchassistant.model.FloatWindowActionModel;

import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.adapter <br>
 * <b>FileName:</b> CustomMenuItemDragAdapter <br>
 * <b>Create Date:</b> 2018/12/7  下午4:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuItemDragAdapter extends BaseItemDraggableAdapter<FloatWindowActionModel, BaseViewHolder> {
    public CustomMenuItemDragAdapter(List<FloatWindowActionModel> data) {
        super(R.layout.item_custom_menu, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FloatWindowActionModel item) {
        helper.setImageResource(R.id.action_icon_iv, item.getActionIcon());
        helper.setText(R.id.action_name_tv, item.getActionName());
    }
}