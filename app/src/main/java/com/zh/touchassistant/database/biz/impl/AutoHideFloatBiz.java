package com.zh.touchassistant.database.biz.impl;

import com.zh.touchassistant.database.biz.IAutoHideFloatBiz;
import com.zh.touchassistant.database.enums.DeleteFlagEnum;
import com.zh.touchassistant.database.gen.AutoHideFloatEntityDao;
import com.zh.touchassistant.database.model.dto.AutoHideFloatDTO;
import com.zh.touchassistant.database.model.entity.AutoHideFloatEntity;
import com.zh.touchassistant.database.model.vo.AutoHideFloatVO;
import com.zh.touchassistant.database.util.GreenDaoManager;
import com.zh.touchassistant.database.util.UUIDUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.database.biz <br>
 * <b>FileName:</b> AutoHideFloatBiz <br>
 * <b>Create Date:</b> 2018/12/17  下午3:24 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideFloatBiz implements IAutoHideFloatBiz {
    private final AutoHideFloatEntityDao mEntityDao;

    public AutoHideFloatBiz() {
        mEntityDao = GreenDaoManager.getInstance().getDaoSession().getAutoHideFloatEntityDao();
    }

    @Override
    public List<AutoHideFloatVO> getAutoHideAppList() {
        ArrayList<AutoHideFloatVO> result = new ArrayList<>();
        List<AutoHideFloatEntity> list = mEntityDao
                .queryBuilder()
                .build()
                .list();
        for (AutoHideFloatEntity entity : list) {
            AutoHideFloatVO vo = new AutoHideFloatVO();
            vo.setAutoHide(true);
            vo.setAppPackageName(entity.getAppPackageName());
            result.add(vo);
        }
        return result;
    }

    @Override
    public void addAutoHide(AutoHideFloatDTO dto) {
        if (checkIsExist(dto.getAppPackageName())) {
            return;
        }
        AutoHideFloatEntity entity = new AutoHideFloatEntity();
        entity.setId(UUIDUtil.get32UUID());
        entity.setAppPackageName(dto.getAppPackageName());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setDeleteFlag(DeleteFlagEnum.NO_DELETE.getFlag());
        entity.setVersion(1);
        mEntityDao.insert(entity);
    }

    @Override
    public void removeAutoHide(AutoHideFloatDTO dto) {
        AutoHideFloatEntity entity = mEntityDao
                .queryBuilder()
                .where(AutoHideFloatEntityDao.Properties.AppPackageName.eq(dto.getAppPackageName()))
                .unique();
        if (entity != null) {
            mEntityDao.delete(entity);
        }
    }

    @Override
    public boolean isAutoHideApp(String foregroundAppPackageName) {
        return checkIsExist(foregroundAppPackageName);
    }

    /**
     * 按包名查询App是否存在
     */
    private boolean checkIsExist(String appPackageName) {
        AutoHideFloatEntity entity = mEntityDao
                .queryBuilder()
                .where(AutoHideFloatEntityDao.Properties.AppPackageName.eq(appPackageName))
                .build()
                .unique();
        return entity != null;
    }
}