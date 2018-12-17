package com.zh.touchassistant.database.model.dto;

/**
 * <b>Package:</b> com.zh.touchassistant.database.model.dto <br>
 * <b>FileName:</b> AutoHideFloatDTO <br>
 * <b>Create Date:</b> 2018/12/17  下午4:45 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideFloatDTO {
    private String appPackageName;

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    @Override
    public String toString() {
        return "AutoHideFloatDTO{" +
                "appPackageName='" + appPackageName + '\'' +
                '}';
    }
}