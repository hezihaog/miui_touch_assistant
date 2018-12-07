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
    private int actionId;

    public FloatWindowActionModel() {
    }

    public FloatWindowActionModel(String actionName, int actionIcon, int actionId) {
        this.actionName = actionName;
        this.actionIcon = actionIcon;
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getActionIcon() {
        return actionIcon;
    }

    public void setActionIcon(int actionIcon) {
        this.actionIcon = actionIcon;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatWindowActionModel model = (FloatWindowActionModel) o;
        return actionIcon == model.actionIcon &&
                actionId == model.actionId &&
                Objects.equals(actionName, model.actionName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(actionName, actionIcon, actionId);
    }

    @Override
    public String toString() {
        return "FloatWindowActionModel{" +
                "actionName='" + actionName + '\'' +
                ", actionIcon=" + actionIcon +
                ", actionId=" + actionId +
                '}';
    }
}