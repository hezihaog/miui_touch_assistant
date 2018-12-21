package com.zh.touchassistant.itembinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;

import java.util.LinkedHashMap;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <b>Package:</b> com.zh.touchassistant.itemprovider <br>
 * <b>FileName:</b> FloatWindowActionViewBinder <br>
 * <b>Create Date:</b> 2018/12/21  下午8:37 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowActionViewBinder extends ItemViewBinder<FloatWindowActionModel, FloatWindowActionViewBinder.ViewHolder> {
    private final LinkedHashMap<Integer, IFloatWindowAction> mActionMap;

    public FloatWindowActionViewBinder(LinkedHashMap<Integer, IFloatWindowAction> actionMap) {
        this.mActionMap = actionMap;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_custom_menu, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull FloatWindowActionModel model) {
        int actionId = model.getActionId();
        IFloatWindowAction action = mActionMap.get(actionId);
        holder.mIconIv.setImageDrawable(action.getActionIconDrawable());
        holder.mNameTv.setText(action.getActionName());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIconIv;
        private final TextView mNameTv;

        ViewHolder(View itemView) {
            super(itemView);
            mIconIv = itemView.findViewById(R.id.action_icon_iv);
            mNameTv = itemView.findViewById(R.id.action_name_tv);
        }
    }
}
