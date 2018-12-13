package com.zh.touchassistant;

import android.os.Handler;
import android.os.Looper;

import com.zh.touchassistant.constant.Const;
import com.zh.touchassistant.controller.FloatButtonWindowController;
import com.zh.touchassistant.widget.FloatButton;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> FloatTimeTaskHolder <br>
 * <b>Create Date:</b> 2018/12/13  下午7:48 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatTimeTaskHolder {
    private final Handler mMainHandler;
    private FloatButtonWindowController mFloatButtonVC;

    private FloatTimeTaskHolder(FloatButtonWindowController floatButtonVC) {
        this.mFloatButtonVC = floatButtonVC;
        mMainHandler = new Handler(Looper.getMainLooper());
        //开始循环，2秒检查一次
        loopCheck();
    }

    private void loopCheck() {
        mMainHandler
                .postDelayed(mTask, 1200);
    }

    private Runnable mTask = new Runnable() {
        @Override
        public void run() {
            if (mFloatButtonVC != null) {
                //不在拽托时并且不能在打开，才减少透明图
                if (!mFloatButtonVC.getFloatWindow().isDragging()
                        && !mFloatButtonVC.isOpen()) {
                    FloatButton view = mFloatButtonVC
                            .getView();
                    if (view.getAlpha() != Const.Config.ALPHA_HIDDEN) {
                        view
                                .animate()
                                .alpha(Const.Config.ALPHA_HIDDEN)
                                .setDuration(400)
                                .start();
                    }
                }
            }
            loopCheck();
        }
    };

    public static FloatTimeTaskHolder create(FloatButtonWindowController floatButtonVC) {
        return new FloatTimeTaskHolder(floatButtonVC);
    }

    /**
     * 通知销毁
     */
    public void dispatchDestroy() {
        mMainHandler.removeCallbacksAndMessages(mTask);
    }
}