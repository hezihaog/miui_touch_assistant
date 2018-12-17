package com.zh.touchassistant.util.logger;

import android.content.Context;

import com.apkfuns.logutils.LogUtils;

/**
 * <b>Package:</b> com.zh.touchassistant.util.logger <br>
 * <b>FileName:</b> LoggerImpl <br>
 * <b>Create Date:</b> 2018/12/17  下午12:25 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class LoggerImpl implements FSLogger.FSLogDelegate {
    private boolean mDebugAble;

    public LoggerImpl(boolean debugAble) {
        this.mDebugAble = debugAble;
    }

    @Override
    public void init(Context context) {
        LogUtils.getLogConfig().configAllowLog(mDebugAble).configShowBorders(false);
    }

    @Override
    public void e(String msg, Object... obj) {
        LogUtils.e(msg, obj);
    }

    @Override
    public void w(String msg, Object... obj) {
        LogUtils.w(msg, obj);
    }

    @Override
    public void i(String msg, Object... obj) {
        LogUtils.i(msg, obj);
    }

    @Override
    public void d(String msg, Object... obj) {
        LogUtils.d(msg, obj);
    }

    @Override
    public void json(String json) {
        LogUtils.json(json);
    }

    @Override
    public void xml(String xml) {
        LogUtils.json(xml);
    }
}