package com.zh.touchassistant.itembinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zh.touchassistant.R;
import com.zh.touchassistant.database.biz.IAutoHideFloatBiz;
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz;
import com.zh.touchassistant.database.model.dto.AutoHideFloatDTO;
import com.zh.touchassistant.model.AutoHideModel;
import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.util.singleton.ISingletonStorage;
import com.zh.touchassistant.widget.SwitchButton;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <b>Package:</b> com.zh.touchassistant.itembinder <br>
 * <b>FileName:</b> AutoHideViewBinder <br>
 * <b>Create Date:</b> 2018/12/21  下午8:47 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideViewBinder extends ItemViewBinder<AutoHideModel, AutoHideViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_local_install_app, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull final AutoHideModel model) {
        holder.mAppIconIv.setImageDrawable(model.getAppIcon());
        holder.mAppNameTv.setText(model.getAppName());
        SwitchButton switchButton = holder.mSwitchButton;
        switchButton.setChecked(model.isAutoHide());
        if (switchButton.getCheckedChangeListener() == null) {
            switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(SwitchButton button, boolean isChecked) {
                    ISingletonStorage storage = (ISingletonStorage) ContextProvider.get().getApplication();
                    final AutoHideFloatBiz biz = storage.getInstance(IAutoHideFloatBiz.class, AutoHideFloatBiz.class);
                    //取消自动隐藏
                    AutoHideFloatDTO dto = new AutoHideFloatDTO();
                    dto.setAppPackageName(model.getPackageName());
                    if (isChecked) {
                        biz.addAutoHide(dto);
                    } else {
                        biz.removeAutoHide(dto);
                    }
                }
            });
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mAppIconIv;
        private final TextView mAppNameTv;
        private final SwitchButton mSwitchButton;

        ViewHolder(View itemView) {
            super(itemView);
            mAppIconIv = itemView.findViewById(R.id.app_icon_iv);
            mAppNameTv = itemView.findViewById(R.id.app_name_tv);
            mSwitchButton = itemView.findViewById(R.id.auto_hide_switch);
        }
    }
}
