package com.zh.touchassistant.model;

import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> FloatWindowActionListModel <br>
 * <b>Create Date:</b> 2018/12/7  下午4:04 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowActionListModel {
    private List<FloatWindowActionModel> models;

    public List<FloatWindowActionModel> getModels() {
        return models;
    }

    public void setModels(List<FloatWindowActionModel> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "FloatWindowActionListModel{" +
                "models=" + models +
                '}';
    }
}