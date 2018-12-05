package com.miui.touchassistant.floating;

import android.content.Context;
import android.view.View;

import java.util.HashMap;

/**
 * <b>Package:</b> com.miui.touchassistant <br>
 * <b>FileName:</b> FloatWindowController <br>
 * <b>Create Date:</b> 2018/12/5  下午6:24 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class FloatWindowController {
    private HashMap<String, IFloatWindowAgent> mWindowAgents;

    public FloatWindowController() {
        mWindowAgents = new HashMap<>(5);
    }

    /**
     * 创建悬浮窗
     */
    public void makeFloatWindow(Context context, View view, String tag, FloatWindowOption option) {
        if (option == null) {
            option = FloatWindowOption.create(new FloatWindowOption.Builder());
        }
        IFloatWindowAgent agent = new FloatWindowAgentImpl();
        agent.setContext(context);
        agent.makeFloatWindow(view, tag, option);
        mWindowAgents.put(tag, agent);
    }

    private void assertNotNull(IFloatWindowAgent agent) {
        if (agent == null) {
            throw new NullPointerException("IFloatWindowAgent must be not null");
        }
    }

    public IFloatWindowAgent getFloatWindowAgent(String tag) {
        return this.mWindowAgents.get(tag);
    }

    /**
     * 展示悬浮窗
     */
    public void show(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        agent.show();
    }

    /**
     * 隐藏悬浮窗
     */
    public void hide(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        agent.hide();
    }

    /**
     * 悬浮窗当前是否展示
     */
    public boolean isShowing(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        return agent.isShowing();
    }

    /**
     * 获取悬浮床当前的X坐标
     */
    public int getX(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        return agent.getX();
    }

    /**
     * 获取悬浮窗当前的Y坐标
     */
    public int getY(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        return agent.getY();
    }

    /**
     * 更新悬浮窗的X坐标
     */
    public void updateX(String tag, int newX) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        agent.updateX(newX);
    }

    /**
     * 更新悬浮窗的Y坐标
     */
    public void updateY(String tag, int newY) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        agent.updateY(newY);
    }

    /**
     * 获取悬浮窗View
     */
    public View getView(String tag) {
        IFloatWindowAgent agent = mWindowAgents.get(tag);
        assertNotNull(agent);
        return agent.getView();
    }
}