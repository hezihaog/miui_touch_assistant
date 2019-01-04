package com.zh.touchassistant.util;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> Singleton <br>
 * <b>Create Date:</b> 2019/1/4  10:17 PM <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b> 单例抽象 <br>
 */
public abstract class Singleton<T> {
    private volatile T mInstance;

    /**
     * 子类复写该类返回实例
     */
    protected abstract T onCreateInstance();

    public final T get() {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = onCreateInstance();
                }
            }
        }
        return mInstance;
    }
}