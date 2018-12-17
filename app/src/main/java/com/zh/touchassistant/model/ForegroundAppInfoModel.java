package com.zh.touchassistant.model;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> CurrentActivityModel <br>
 * <b>Create Date:</b> 2018/12/17  下午3:06 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class ForegroundAppInfoModel extends BaseDataModel {
    private String foregroundAppPackageName;
    private String foregroundActivityClassName;

    public ForegroundAppInfoModel(String foregroundAppPackageName, String foregroundActivityClassName) {
        this.foregroundAppPackageName = foregroundAppPackageName;
        this.foregroundActivityClassName = foregroundActivityClassName;
    }

    public String getForegroundAppPackageName() {
        return foregroundAppPackageName;
    }

    public String getForegroundActivityClassName() {
        return foregroundActivityClassName;
    }

    @Override
    public String toString() {
        return "CurrentActivityModel{" +
                "foregroundAppPackageName='" + foregroundAppPackageName + '\'' +
                ", foregroundActivityClassName='" + foregroundActivityClassName + '\'' +
                '}';
    }
}