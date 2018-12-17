package com.zh.touchassistant.model;

import android.graphics.drawable.Drawable;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> AutoHideModel <br>
 * <b>Create Date:</b> 2018/12/17  下午4:59 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideModel extends BaseDataModel {
    private boolean isAutoHide;
    private String appName;
    private String packageName;
    private Drawable appIcon;

    public boolean isAutoHide() {
        return isAutoHide;
    }

    public void setAutoHide(boolean autoHide) {
        isAutoHide = autoHide;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    @Override
    public String toString() {
        return "AutoHideModel{" +
                "isAutoHide=" + isAutoHide +
                ", appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", appIcon=" + appIcon +
                '}';
    }
}