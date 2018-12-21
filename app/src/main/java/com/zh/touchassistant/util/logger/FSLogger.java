package com.zh.touchassistant.util.logger;

import android.content.Context;

import com.zh.touchassistant.provider.ContextProvider;

/**
 * Package: me.wally.arch.logger
 * FileName: FSLogger
 * Date: on 2018/11/12  下午12:37
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class FSLogger {
    public interface FSLogDelegate {
        void init(Context context);

        void e(final String msg, final Object... obj);

        void w(final String msg, final Object... obj);

        void i(final String msg, final Object... obj);

        void d(final String msg, final Object... obj);
    }

    private static FSLogDelegate sDelegate = null;

    public static void setDelegate(FSLogDelegate delegate) {
        sDelegate = delegate;
        sDelegate.init(ContextProvider.get().getContext());
    }

    public static void e(final String msg, final Object... obj) {
        if (sDelegate != null) {
            sDelegate.e(msg, obj);
        }
    }

    public static void w(final String msg, final Object... obj) {
        if (sDelegate != null) {
            sDelegate.w(msg, obj);
        }
    }

    public static void i(final String msg, final Object... obj) {
        if (sDelegate != null) {
            sDelegate.i(msg, obj);
        }
    }

    public static void d(final String msg, final Object... obj) {
        if (sDelegate != null) {
            sDelegate.d(msg, obj);
        }
    }
}