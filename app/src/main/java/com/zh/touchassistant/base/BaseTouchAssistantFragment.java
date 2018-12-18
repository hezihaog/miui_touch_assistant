package com.zh.touchassistant.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <b>Package:</b> com.zh.touchassistant.base <br>
 * <b>FileName:</b> BaseFragment <br>
 * <b>Create Date:</b> 2018/12/18  上午9:59 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public abstract class BaseTouchAssistantFragment extends Fragment implements LayoutCallback {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLayoutBefore();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = onLayoutId();
        if (layoutId > 0) {
            return inflater.inflate(onLayoutId(), container, false);
        }
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onLayoutAfter();
    }

    @Override
    public void onLayoutBefore() {
    }

    @Override
    public void onLayoutAfter() {
    }
}