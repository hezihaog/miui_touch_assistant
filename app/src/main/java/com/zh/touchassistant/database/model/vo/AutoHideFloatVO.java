package com.zh.touchassistant.database.model.vo;

/**
 * <b>Package:</b> com.zh.touchassistant.database.model.vo <br>
 * <b>FileName:</b> AutoHideFloatVO <br>
 * <b>Create Date:</b> 2018/12/17  下午4:42 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideFloatVO {
    private Boolean isAutoHide;
    private String appPackageName;

    public Boolean getAutoHide() {
        return isAutoHide;
    }

    public void setAutoHide(Boolean autoHide) {
        isAutoHide = autoHide;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    @Override
    public String toString() {
        return "AutoHideFloatVO{" +
                "isAutoHide=" + isAutoHide +
                ", appPackageName='" + appPackageName + '\'' +
                '}';
    }
}