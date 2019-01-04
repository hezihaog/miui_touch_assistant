package com.zh.touchassistant.util;

import android.content.Context;

import com.zh.touchassistant.constant.AccessibilityConstant;
import com.zh.touchassistant.util.logger.FSLogger;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 类名 CrashHandler.java</br>
 * 创建日期 2013-7-28</br>
 *
 * @author LiWenLong</               br>
 * Email lendylongli@gmail.com</br>
 * 更新时间 2013-7-28 下午5:02:05</br>
 * 最后更新者 LeOn</br>
 * <p/>
 * 说明 捕捉程序退出异常类
 */
public class CrashHandler implements UncaughtExceptionHandler {
    private static volatile CrashHandler mInstance;

    private static CrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (CrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new CrashHandler();
                }
            }
        }
        return mInstance;
    }

    private UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;

    private CrashHandler() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (!handleException(throwable) && mDefaultHandler != null) {
            // 如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, throwable);
        } else {
            if (AccessibilityConstant.isDebug) {
                if (mDefaultHandler != null) {
                    mDefaultHandler.uncaughtException(thread, throwable);
                }
                return;
            }
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        if (!AccessibilityConstant.isDebug) {
            ex.printStackTrace();
            FSLogger.e("程序异常退出", ex);
        } else {
            //将记录打印到控制台
            FSLogger.e("程序异常退出", ex);
        }
        return true;
    }

    public static void init(Context context) {
        getInstance().setContext(context);
    }
}
