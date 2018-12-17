package com.zh.touchassistant.model;

import android.graphics.drawable.Drawable;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> InstallAppInfoModel <br>
 * <b>Create Date:</b> 2018/12/17  下午4:07 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class InstallAppInfoModel {
    private String appName;
    private String packageName;
    private String versionName;
    private int versionCode;
    private Drawable appIcon;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    @Override
    public String toString() {
        return "InstallAppInfoModel{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionCode=" + versionCode +
                ", appIcon=" + appIcon +
                '}';
    }
}