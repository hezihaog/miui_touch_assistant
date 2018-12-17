package com.zh.touchassistant.util.singleton;

/**
 * <b>Package:</b> com.zh.touchassistant.util.singleton <br>
 * <b>FileName:</b> ISingletonStorage <br>
 * <b>Create Date:</b> 2018/12/17  下午3:40 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b> 单例存储接口 <br>
 */
public interface ISingletonStorage {
    /**
     * 获取内存缓存实例
     *
     * @param key            单例缓存的Key
     * @param singletonClazz 单例对象的Class，用于反射创建实例
     */
    <T> T getInstance(Class<?> key, Class<?> singletonClazz);
}