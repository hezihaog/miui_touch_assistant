package com.zh.touchassistant.setting;

import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.action.BackFloatWindowAction;
import com.zh.touchassistant.floating.action.HomeFloatWindowAction;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.floating.action.LockFloatWindowAction;
import com.zh.touchassistant.floating.action.MenuFloatWindowAction;
import com.zh.touchassistant.floating.action.ScreenshotFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionModel;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * <b>Package:</b> com.zh.touchassistant.setting <br>
 * <b>FileName:</b> FloatWindowSetting <br>
 * <b>Create Date:</b> 2018/12/6  上午11:51 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowSetting {
    private LinkedHashMap<FloatWindowActionModel, IFloatWindowAction> mActionModels;

    private static final class SingleHolder {
        private static final FloatWindowSetting INSTANCE = new FloatWindowSetting();
    }

    public static FloatWindowSetting getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void initDefaultFloatWindowAction() {
        mActionModels = new LinkedHashMap<>(5);
        //注意要反着来添加
        mActionModels.put(new FloatWindowActionModel("Back", R.drawable.ic_key_back), new BackFloatWindowAction());
        mActionModels.put(new FloatWindowActionModel("Screenshot", R.drawable.ic_toggle_screenshot), new ScreenshotFloatWindowAction());
        mActionModels.put(new FloatWindowActionModel("Lock", R.drawable.ic_toggle_lock), new LockFloatWindowAction());
        mActionModels.put(new FloatWindowActionModel("Menu", R.drawable.ic_key_menu), new MenuFloatWindowAction());
        mActionModels.put(new FloatWindowActionModel("Home", R.drawable.ic_key_home), new HomeFloatWindowAction());
    }

    public HashMap<FloatWindowActionModel, IFloatWindowAction> getFloatWindowActions() {
        return mActionModels;
    }
}