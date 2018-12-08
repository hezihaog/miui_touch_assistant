package com.zh.touchassistant.floating;

/**
 * <b>Package:</b> com.zh.touchassistant.floating <br>
 * <b>FileName:</b> FloatWindowPermissionCallback <br>
 * <b>Create Date:</b> 2018/12/5  下午6:57 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public interface FloatWindowPermissionCallback {
    /**
     * 权限允许时回调
     */
    void onPermissionAllow();

    /**
     * 权限拒绝时回调
     */
    void onPermissionReject();
}