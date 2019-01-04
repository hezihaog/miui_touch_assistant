package com.zh.touchassistant.base;

import android.content.Context;
import android.content.res.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: me.wally.arch.appdelegate
 * FileName: AppDelegate
 * Date: on 2018/11/12  下午9:27
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class AppDelegate {
    private HashMap<Integer, IWorker> mWorkerList;
    private Context mContext;

    public AppDelegate(Context context) {
        this.mContext = context.getApplicationContext();
        this.mWorkerList = new HashMap<>(16);
    }

    public Context getContext() {
        return mContext;
    }

    private void addWorker(AppDelegate.IWorker worker) {
        this.mWorkerList.put(worker.getId(), worker);
    }

    public void addWorkers(List<IWorker> workers) {
        LinkedHashMap<Integer, IWorker> map = new LinkedHashMap<>();
        for (IWorker worker : workers) {
            map.put(worker.getId(), worker);
        }
        this.mWorkerList.putAll(map);
    }

    private void removeWorker(AppDelegate.IWorker worker) {
        mWorkerList.remove(worker.getId());
    }

    public void dispatchCreate(Context context, Boolean isDebug) {
        //这里添加自定义的Worker类
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onCreate(context, isDebug);
        }
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onExecute();
        }
    }

    public void dispatchTerminate() {
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onTerminate();
        }
    }

    public void dispatchLowMemory() {
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onLowMemory();
        }
    }

    public void dispatchTrimMemory(int level) {
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onTrimMemory(level);
        }
    }

    public void dispatchConfigurationChanged(Configuration newConfig) {
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().onConfigurationChanged(newConfig);
        }
    }

    public void dispatchAttachBaseContext(Context base) {
        for (Map.Entry<Integer, IWorker> entry : mWorkerList.entrySet()) {
            entry.getValue().attachBaseContext(base);
        }
    }

    public interface IWorker {
        void attachBaseContext(Context base);

        void onCreate(Context context, Boolean isDebug);

        void onTerminate();

        void onExecute();

        Integer getId();

        void onLowMemory();

        void onTrimMemory(int level);

        void onConfigurationChanged(Configuration newConfig);
    }
}