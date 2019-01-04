package com.zh.touchassistant.base;

import java.util.List;

/**
 * Package: me.wally.arch.appdelegate
 * FileName: IUIApplication
 * Date: on 2018/11/12  下午9:50
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public interface IUIApplication {
    void onCreateUIApplicationHelperBefore();

    void onCreateUIApplicationHelperAfter();

    List<AppDelegate.IWorker> onInitWorkers();

    boolean isDebug();
}