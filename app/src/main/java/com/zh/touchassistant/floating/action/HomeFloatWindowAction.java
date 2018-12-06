package com.zh.touchassistant.floating.action;

import android.widget.Toast;

import com.zh.touchassistant.ContextProvider;

/**
 * <b>Package:</b> com.zh.touchassistant.floating.action <br>
 * <b>FileName:</b> HomeFloatWindowAction <br>
 * <b>Create Date:</b> 2018/12/6  下午12:12 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class HomeFloatWindowAction implements IFloatWindowAction {

    @Override
    public void onAction() {
        Toast.makeText(ContextProvider.get().getContext(), "Home", Toast.LENGTH_SHORT).show();
    }
}