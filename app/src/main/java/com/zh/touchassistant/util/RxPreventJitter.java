package com.zh.touchassistant.util;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Package: me.wally.rx.util
 * FileName: RxPreventJitter
 * Date: on 2018/11/9  上午11:13
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class RxPreventJitter {
    /**
     * 防止点击抖动
     */
    public static Observable<Object> preventJitter(View clickView) {
        return RxView
                .clicks(clickView)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}