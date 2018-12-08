package com.zh.touchassistant.setting;

import android.text.TextUtils;

import com.zh.touchassistant.Const;
import com.zh.touchassistant.R;
import com.zh.touchassistant.floating.action.BackFloatWindowAction;
import com.zh.touchassistant.floating.action.HomeFloatWindowAction;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.floating.action.LockFloatWindowAction;
import com.zh.touchassistant.floating.action.MenuFloatWindowAction;
import com.zh.touchassistant.floating.action.ScreenshotFloatWindowAction;
import com.zh.touchassistant.model.FloatWindowActionListModel;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.util.GsonUtils;
import com.zh.touchassistant.util.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.setting <br>
 * <b>FileName:</b> FloatWindowSetting <br>
 * <b>Create Date:</b> 2018/12/6  上午11:51 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowSetting {
    /**
     * ActionId和Action的映射
     */
    private static LinkedHashMap<Integer, IFloatWindowAction> actionMap;
    /**
     * ActionModel和ActionId的映射
     */
    private ArrayList<FloatWindowActionModel> mActionModels;

    static {
        //添加ActionId和Action的映射
        actionMap = new LinkedHashMap();
        BackFloatWindowAction backAction = new BackFloatWindowAction();
        ScreenshotFloatWindowAction screenshotAction = new ScreenshotFloatWindowAction();
        LockFloatWindowAction lockAction = new LockFloatWindowAction();
        MenuFloatWindowAction menuAction = new MenuFloatWindowAction();
        HomeFloatWindowAction homeAction = new HomeFloatWindowAction();
        actionMap.put(backAction.getActionId(), backAction);
        actionMap.put(screenshotAction.getActionId(), screenshotAction);
        actionMap.put(lockAction.getActionId(), lockAction);
        actionMap.put(menuAction.getActionId(), menuAction);
        actionMap.put(homeAction.getActionId(), homeAction);
    }

    private static final class SingleHolder {
        private static final FloatWindowSetting INSTANCE = new FloatWindowSetting();
    }

    private ArrayList<FloatWindowActionModel> getActionModels() {
        if (mActionModels == null) {
            mActionModels = new ArrayList<>(5);
        }
        return mActionModels;
    }

    public static FloatWindowSetting getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void initFloatWindowActions() {
        String actionDatas = Property.getDefault().getProperty(Const.Config.KEY_CUSTOM_MENU_DATA, "");
        if (TextUtils.isEmpty(actionDatas)) {
            initActionFromDefault();
        } else {
            initActionFromCustom(GsonUtils.fromJson(actionDatas, FloatWindowActionListModel.class));
        }
    }

    private void initActionFromDefault() {
        ArrayList<FloatWindowActionModel> actions = getActionModels();
        actions.add(new FloatWindowActionModel("Home", R.drawable.ic_key_home, new HomeFloatWindowAction().getActionId()));
        actions.add(new FloatWindowActionModel("Menu", R.drawable.ic_key_menu, new MenuFloatWindowAction().getActionId()));
        actions.add(new FloatWindowActionModel("Lock", R.drawable.ic_toggle_lock, new LockFloatWindowAction().getActionId()));
        actions.add(new FloatWindowActionModel("Screenshot", R.drawable.ic_toggle_screenshot, new ScreenshotFloatWindowAction().getActionId()));
        actions.add(new FloatWindowActionModel("Back", R.drawable.ic_key_back, new BackFloatWindowAction().getActionId()));
        //第一次初始化完后，保存到Sp
        FloatWindowActionListModel listModel = new FloatWindowActionListModel();
        listModel.setModels(actions);
        String json = GsonUtils.toJson(listModel);
        Property.getDefault().setProperty(Const.Config.KEY_CUSTOM_MENU_DATA, json);
    }

    private void initActionFromCustom(FloatWindowActionListModel customActions) {
        List<FloatWindowActionModel> customActionsModels = customActions.getModels();
        ArrayList<FloatWindowActionModel> actions = getActionModels();
        actions.addAll(customActionsModels);
    }

    public void saveNewActions(ArrayList<FloatWindowActionModel> newActions) {
        FloatWindowActionListModel listModel = new FloatWindowActionListModel();
        listModel.setModels(newActions);
        String json = GsonUtils.toJson(listModel);
        Property.getDefault().setProperty(Const.Config.KEY_CUSTOM_MENU_DATA, json);
    }

    public LinkedHashMap<Integer, IFloatWindowAction> getActionMap() {
        return actionMap;
    }

    public HashMap<FloatWindowActionModel, IFloatWindowAction> getCurrentActions() {
        LinkedHashMap<FloatWindowActionModel, IFloatWindowAction> map = new LinkedHashMap<>(5);
        for (FloatWindowActionModel model : getActionModels()) {
            map.put(model, actionMap.get(model.getActionId()));
        }
        return map;
    }
}