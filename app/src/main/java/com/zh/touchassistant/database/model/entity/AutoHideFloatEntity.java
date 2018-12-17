package com.zh.touchassistant.database.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * <b>Package:</b> com.zh.touchassistant.database.entity <br>
 * <b>FileName:</b> AutoHideFloatEntity <br>
 * <b>Create Date:</b> 2018/12/17  下午3:20 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b> 自动隐藏悬浮球的App <br>
 *
 * @author wally
 */
@Entity(nameInDb = "auto_hide_float")
public class AutoHideFloatEntity {
    @Id
    private String id;

    @Property(nameInDb = "create_time")
    @NotNull
    private Date createTime = new Date();

    @Property(nameInDb = "update_time")
    @NotNull
    private Date updateTime = new Date();

    /**
     * 删除标识，0：未删除，1：删除
     */
    @Property(nameInDb = "delete_flag")
    @NotNull
    private Integer deleteFlag = 0;

    /**
     * 版本号，默认1
     */
    @Property(nameInDb = "version")
    @NotNull
    private Integer version = 1;

    //-------------------- 自定义属性 --------------------

    /**
     * App包名
     */
    @Property(nameInDb = "app_package_name")
    @NotNull
    private String appPackageName;

    @Generated(hash = 827313676)
    public AutoHideFloatEntity(String id, @NotNull Date createTime,
            @NotNull Date updateTime, @NotNull Integer deleteFlag,
            @NotNull Integer version, @NotNull String appPackageName) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
        this.version = version;
        this.appPackageName = appPackageName;
    }

    @Generated(hash = 1764893704)
    public AutoHideFloatEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }
}