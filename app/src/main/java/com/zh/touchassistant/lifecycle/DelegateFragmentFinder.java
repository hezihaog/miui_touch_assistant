package com.zh.touchassistant.lifecycle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;

import com.zh.touchassistant.util.logger.FSLogger;

import java.lang.reflect.Constructor;


/**
 * Package: com.hzh.lifecycle.dispatch
 * FileName: DelegateFinder
 * Date: on 2018/2/17  下午3:42
 * Auther: zihe
 * Descirbe:代理查找者
 * Email: hezihao@linghit.com
 */

public class DelegateFragmentFinder implements Handler.Callback {
    private static final String DELEGATE_FRAGMENT_TAG_PREFIX = "DelegateFragmentTag：";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;

    private final Handler handler;
    private final ArrayMap<String, BaseDelegateFragment> pendingFragments = new ArrayMap<>();

    private DelegateFragmentFinder() {
        handler = new Handler(Looper.getMainLooper(), this);
    }

    private static class Singleton {
        private static final DelegateFragmentFinder INSTANCE = new DelegateFragmentFinder();
    }

    public static DelegateFragmentFinder getInstance() {
        return Singleton.INSTANCE;
    }

    private String buildFragmentTag(Class fragmentClazz) {
        return DELEGATE_FRAGMENT_TAG_PREFIX + fragmentClazz.getName();
    }

    /**
     * 添加代理fragment
     */
    public <T extends BaseDelegateFragment> T find(FragmentActivity activity, Class<T> delegateClass) {
        String fragmentTag = buildFragmentTag(delegateClass);
        FragmentManager fm = activity.getSupportFragmentManager();
        BaseDelegateFragment current = (BaseDelegateFragment) fm.findFragmentByTag(fragmentTag);
        if (current == null) {
            //这里的缓存Fragment是由于fragment的事务机制，和Looper机制，
            // 当2次执行到该代码段时，beginTransaction可能还在执行完，findFragmentByTag时找不到的，
            // 这就有可能创建了多个frag的实例，所以加多一个缓存实例，当真正执行完beginTransaction，再将缓存移除。
            current = pendingFragments.get(fm);
            if (current == null) {
                current = buildDelegate(delegateClass);
                pendingFragments.put(fragmentTag, current);
                fm.beginTransaction().add(current, DELEGATE_FRAGMENT_TAG_PREFIX).commitAllowingStateLoss();
                handler.obtainMessage(ID_REMOVE_FRAGMENT_MANAGER, fragmentTag).sendToTarget();
            }
        }
        return (T) current;
    }

    /**
     * 构造代理fragment
     *
     * @param delegateClass 代理fragment的class
     */
    private BaseDelegateFragment buildDelegate(Class<? extends BaseDelegateFragment> delegateClass) {
        if (delegateClass == null) {
            throw new NullPointerException("delegateClass must be not null");
        }
        BaseDelegateFragment delegateFragment = null;
        try {
            Constructor<? extends BaseDelegateFragment> constructor = delegateClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            delegateFragment = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delegateFragment;
    }

    @Override
    public boolean handleMessage(Message message) {
        boolean handled = true;
        Object removed = null;
        Object key = null;
        switch (message.what) {
            case ID_REMOVE_FRAGMENT_MANAGER:
                String fragmentTag = (String) message.obj;
                key = fragmentTag;
                removed = pendingFragments.remove(fragmentTag);
                break;
            default:
                handled = false;
        }
        if (handled && removed == null) {
            FSLogger.d("移除permission delegate fragment 失败 ::: " + key);
        }
        return false;
    }
}