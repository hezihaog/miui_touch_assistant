package com.zh.touchassistant.util.logger;

import android.content.Context;

import timber.log.Timber;

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
        if (mDebugAble) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {

        }
    }

    @Override
    public void e(String msg, Object... obj) {
        Timber.e(msg, obj);
    }

    @Override
    public void w(String msg, Object... obj) {
        Timber.w(msg, obj);
    }

    @Override
    public void i(String msg, Object... obj) {
        Timber.i(msg, obj);
    }

    @Override
    public void d(String msg, Object... obj) {
        Timber.d(msg, obj);
    }
}