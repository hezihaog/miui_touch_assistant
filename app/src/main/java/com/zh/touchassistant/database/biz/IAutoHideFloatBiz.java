package com.zh.touchassistant.database.biz;

import com.zh.touchassistant.database.model.dto.AutoHideFloatDTO;
import com.zh.touchassistant.database.model.vo.AutoHideFloatVO;

import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.database.biz <br>
 * <b>FileName:</b> IAutoHideFloatBiz <br>
 * <b>Create Date:</b> 2018/12/17  下午3:24 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface IAutoHideFloatBiz {
    /**
     * 获取所有需要自动隐藏悬浮球的App信息列表
     */
    List<AutoHideFloatVO> getAutoHideAppList();

    /**
     * 添加App到自定隐藏列表
     */
    void addAutoHide(AutoHideFloatDTO dto);

    /**
     * 取消App自动隐藏
     */
    void removeAutoHide(AutoHideFloatDTO dto);

    /**
     * 判断改App包名是否需要自动隐藏
     *
     * @param foregroundAppPackageName 当前前台的App包名
     */
    boolean isAutoHideApp(String foregroundAppPackageName);
}