package com.zh.touchassistant.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by Hezihao on 2017/7/10.
 */

public class LifecycleFragment extends Fragment {
    private FragmentLifecycle lifecycle;

    public LifecycleFragment() {
        this(new FragmentLifecycle());
    }

    @SuppressLint("ValidFragment")
    public LifecycleFragment(FragmentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
        //设置屏幕旋转保持实例
        setRetainInstance(true);
    }

    public FragmentLifecycle getProxyLifecycle() {
        if (lifecycle == null) {
            lifecycle = new FragmentLifecycle();
        }
        return lifecycle;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (lifecycle != null) {
            lifecycle.onAttach();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (lifecycle != null) {
            lifecycle.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (lifecycle != null) {
            lifecycle.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (lifecycle != null) {
            lifecycle.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (lifecycle != null) {
            lifecycle.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (lifecycle != null) {
            lifecycle.onDestroy();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (lifecycle != null) {
            lifecycle.onDetach();
        }
    }
}
