package com.zh.touchassistant.util.singleton;

import com.zh.touchassistant.base.UIApplication;

import java.util.HashMap;

/**
 * <b>Package:</b> com.zh.touchassistant.util.singleton <br>
 * <b>FileName:</b> SingletonStorageApplication <br>
 * <b>Create Date:</b> 2018/12/17  下午3:41 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class SingletonStorageApplication extends UIApplication implements ISingletonStorage {
    private HashMap<Class<?>, Object> mInstanceMap;

    public SingletonStorageApplication() {
        this.mInstanceMap = new HashMap<>(16);
    }

    @Override
    public <T> T getInstance(Class<?> key, Class<?> singletonClazz) {
        T instance = (T) mInstanceMap.get(key);
        if (instance == null) {
            try {
                instance = (T) singletonClazz.newInstance();
                mInstanceMap.put(key, instance);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}