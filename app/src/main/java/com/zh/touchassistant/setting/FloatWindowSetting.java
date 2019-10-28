package com.zh.touchassistant.setting;

import android.text.TextUtils;

import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.floating.action.BackAction;
import com.zh.touchassistant.floating.action.HomeAction;
import com.zh.touchassistant.floating.action.IFloatWindowAction;
import com.zh.touchassistant.floating.action.LockAction;
import com.zh.touchassistant.floating.action.MenuAction;
import com.zh.touchassistant.floating.action.ScreenshotAction;
import com.zh.touchassistant.model.FloatWindowActionListModel;
import com.zh.touchassistant.model.FloatWindowActionModel;
import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.util.AppBroadcastManager;
import com.zh.touchassistant.util.Property;
import com.zh.touchassistant.util.json.JsonHandler;

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
        actionMap = new LinkedHashMap<>();
        BackAction backAction = new BackAction();
        ScreenshotAction screenshotAction = new ScreenshotAction();
        LockAction lockAction = new LockAction();
        MenuAction menuAction = new MenuAction();
        HomeAction homeAction = new HomeAction();
        actionMap.put(backAction.getActionId(), backAction);
        actionMap.put(screenshotAction.getActionId(), screenshotAction);
        actionMap.put(lockAction.getActionId(), lockAction);
        actionMap.put(menuAction.getActionId(), menuAction);
        actionMap.put(homeAction.getActionId(), homeAction);
    }

    private JsonHandler mJsonHandler;

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

    public void initFloatWindowActions(JsonHandler jsonHandler) {
        this.mJsonHandler = jsonHandler;
        String actionDatas = Property.getDefault().getProperty(AccessibilityConstant.Config.KEY_CUSTOM_MENU_DATA, "");
        if (TextUtils.isEmpty(actionDatas)) {
            initActionFromDefault();
        } else {
            initActionFromCustom(actionDatas);
        }
    }

    private void initActionFromDefault() {
        ArrayList<FloatWindowActionModel> actions = getActionModels();
        actions.add(new FloatWindowActionModel(new HomeAction().getActionId()));
        actions.add(new FloatWindowActionModel(new MenuAction().getActionId()));
        actions.add(new FloatWindowActionModel(new LockAction().getActionId()));
        actions.add(new FloatWindowActionModel(new ScreenshotAction().getActionId()));
        actions.add(new FloatWindowActionModel(new BackAction().getActionId()));
        //第一次初始化完后，保存到Sp
        FloatWindowActionListModel listModel = new FloatWindowActionListModel();
        listModel.setModels(actions);
        String json = mJsonHandler.toJson(listModel);
        Property.getDefault().setProperty(AccessibilityConstant.Config.KEY_CUSTOM_MENU_DATA, json);
    }

    private void initActionFromCustom(String actionDatas) {
        FloatWindowActionListModel customActions = mJsonHandler.parse(actionDatas, FloatWindowActionListModel.class);
        List<FloatWindowActionModel> customActionsModels = customActions.getModels();
        ArrayList<FloatWindowActionModel> actions = getActionModels();
        actions.addAll(customActionsModels);
    }

    public void saveNewActions(ArrayList<FloatWindowActionModel> newActions) {
        //更新内存
        ArrayList<FloatWindowActionModel> actionModels = getActionModels();
        actionModels.clear();
        actionModels.addAll(newActions);
        //更新本地
        FloatWindowActionListModel listModel = new FloatWindowActionListModel();
        listModel.setModels(newActions);
        String json = mJsonHandler.toJson(listModel);
        Property.getDefault().setProperty(AccessibilityConstant.Config.KEY_CUSTOM_MENU_DATA, json);
        //通知更新
        AppBroadcastManager.sendBroadcast(
                ContextProvider.get().getContext(), AccessibilityConstant.Action.ACTION_UPDATE_PANEL_ACTIONS);
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