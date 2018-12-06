package com.zh.touchassistant.util;

import android.app.Activity;

import java.io.Closeable;
import java.io.IOException;

/**
 * Package: me.wally.arch.util
 * FileName: Util
 * Date: on 2018/11/12  下午12:20
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class FSUtil {
    private FSUtil() {
    }

    public static void assertActivityNotNull(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Activity must be not null");
        }
        if (activity.isFinishing()) {
            throw new IllegalStateException("Activity is finishing");
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}