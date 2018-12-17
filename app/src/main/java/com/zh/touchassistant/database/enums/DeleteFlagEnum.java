package com.zh.touchassistant.database.enums;

/**
 * <b>Package:</b> com.zh.touchassistant.database.enums <br>
 * <b>FileName:</b> DeleteFlagEnum <br>
 * <b>Create Date:</b> 2018/12/17  下午4:49 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public enum DeleteFlagEnum {
    /**
     * 未删除
     */
    NO_DELETE(0),
    /**
     * 已删除
     */
    DELETED(1);

    private int mFlag;

    DeleteFlagEnum(int flag) {
        this.mFlag = flag;
    }

    public int getFlag() {
        return mFlag;
    }

    @Override
    public String toString() {
        return String.valueOf(mFlag);
    }
}