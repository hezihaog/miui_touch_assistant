package com.zh.touchassistant.model;

import java.util.Objects;

/**
 * <b>Package:</b> com.zh.touchassistant.model <br>
 * <b>FileName:</b> FloatWindowActionModel <br>
 * <b>Create Date:</b> 2018/12/6  上午11:52 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowActionModel extends BaseDataModel {
    private int actionId;

    public FloatWindowActionModel() {
    }

    public FloatWindowActionModel(int actionId) {
        this.actionId = actionId;
    }

    public int getActionId() {
        return actionId;
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
        return actionId == model.actionId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(actionId);
    }

    @Override
    public String toString() {
        return "FloatWindowActionModel{" +
                "actionId=" + actionId +
                '}';
    }
}