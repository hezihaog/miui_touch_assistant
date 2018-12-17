package com.zh.touchassistant.constant;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> Const <br>
 * <b>Create Date:</b> 2018/12/7  下午2:57 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class Const {
    public static final class Config {
        /**
         * SP文件名
         */
        public static final String APP_SP_FILE_NAME = "float_window_setting";
        /**
         * 悬浮窗坐标
         */
        public static final String KEY_FLOAT_BUTTON_X = "float_button_x";
        public static final String KEY_FLOAT_BUTTON_Y = "float_button_y";
        public static final String KEY_FLOAT_PANEL_X = "float_panel_x";
        public static final String KEY_FLOAT_PANEL_Y = "float_panel_y";
        /**
         * 上一次移动时，悬浮面板是否在左边
         */
        public static final String KEY_FLOAT_WINDOW_IS_LEFT = "float_window_is_left";
        /**
         * 自定义菜单Json数据
         */
        public static final String KEY_CUSTOM_MENU_DATA = "custom_menu_data";
        /**
         * 是否开启悬浮窗
         */
        public static final String KEY_ENABLE = "enabled";
        /**
         * 显示的Alpha值
         */
        public static final float ALPHA_SHOW = 1.0f;
        /**
         * 隐藏的Alpha值
         */
        public static final float ALPHA_HIDDEN = 0.2f;
    }

    public static class Action {
        /**
         * Action操作图标位置改变
         */
        public static final String ACTION_UPDATE_PANEL_ACTIONS = "action_update_panel_actions";
        /**
         * 前台Activity改变
         */
        public static final String ACTION_FOREGROUND_APP_CHANGE = "action_foreground_app_change";
        /**
         * 当悬浮球打开时
         */
        public static final String ACTION_FLOAT_BUTTON_OPEN = "action_float_button_open";
        /**
         * 当悬浮球关闭
         */
        public static final String ACTION_FLOAT_BUTTON_CLOSE = "action_float_button_close";
    }

    /**
     * Bundle数据Key
     */
    public static class Extras {
        /**
         * 前台App信息
         */
        public static final String EXTRAS_FOREGROUND_APP_DATA = "extras_foreground_app_data";
    }
}