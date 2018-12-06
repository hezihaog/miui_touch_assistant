package com.zh.touchassistant.model;

import java.util.Objects;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> FloatWindowActionModel <br>
 * <b>Create Date:</b> 2018/12/6  上午11:52 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowActionModel {
    private String actionName;
    private int actionIcon;

    public FloatWindowActionModel() {
    }

    public FloatWindowActionModel(String actionName, int actionIcon) {
        this.actionName = actionName;
        this.actionIcon = actionIcon;
    }

    public String getActionName() {
        return actionName;
    }

    public int getActionIcon() {
        return actionIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatWindowActionModel that = (FloatWindowActionModel) o;
        return actionIcon == that.actionIcon &&
                Objects.equals(actionName, that.actionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionName, actionIcon);
    }

    @Override
    public String toString() {
        return "FloatWindowActionModel{" +
                "actionName='" + actionName + '\'' +
                ", actionIcon=" + actionIcon +
                '}';
    }
}