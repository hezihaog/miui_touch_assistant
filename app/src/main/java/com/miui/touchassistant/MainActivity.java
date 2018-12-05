package com.miui.touchassistant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.miui.touchassistant.util.RxPreventJitter;
import com.miui.touchassistant.view.ControlPanelView;
import com.miui.touchassistant.view.ForegroundImageView;
import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.IFloatWindow;
import com.yhao.floatwindow.MoveType;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.ViewStateListenerAdapter;
import com.zh.touchassistant.R;

import io.reactivex.functions.Consumer;

/**
 * <b>Package:</b> com.miui.touchassistant <br>
 * <b>FileName:</b> MainActivity <br>
 * <b>Create Date:</b> 2018/12/2  下午4:43 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class MainActivity extends AppCompatActivity {
    private static final String BUTTON_TAG = "button_tag";
    private static final String PANEL_TAG = "panel_tag";

    //布局文件中 含有 vector矢量图 的 Activity 还需要添加一句以下代码
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //填充浮动按钮和浮动面板
        View floatButtonView = getLayoutInflater().inflate(R.layout.float_button, null);
        final View floatPanelLayout = getLayoutInflater().inflate(R.layout.view_float_control_panel, null);
        final ControlPanelView floatControlPanelView = floatPanelLayout.findViewById(R.id.control_panel_view);
        final ForegroundImageView floatButton = floatButtonView.findViewById(R.id.foreground_iv);
        //面板区域
        FloatWindow
                .with(getApplicationContext())
                .setTag(PANEL_TAG)
                .setView(floatPanelLayout)
                .setDesktopShow(true)
                .setMoveType(MoveType.inactive)
                .build();
        //悬浮球
        FloatWindow
                .with(getApplicationContext())
                .setTag(BUTTON_TAG)
                .setView(floatButtonView)
                .setDesktopShow(true)
                .setMoveType(MoveType.active)
                .setViewStateListener(new ViewStateListenerAdapter() {
                    private ControlPanelView getPanelView() {
                        IFloatWindow floatPanelWindow = FloatWindow
                                .get(PANEL_TAG);
                        ViewGroup layout = (ViewGroup) floatPanelWindow.getView();
                        return layout.findViewById(R.id.control_panel_view);
                    }

                    private IFloatWindow getButtonFloatWindow() {
                        return FloatWindow
                                .get(PANEL_TAG);
                    }

                    @Override
                    public void onPositionUpdate(int x, int y) {
                        super.onPositionUpdate(x, y);
                        ControlPanelView panelView = getPanelView();
                        IFloatWindow floatPanelWindow = FloatWindow
                                .get(PANEL_TAG);
                        //如果正在打开，先关闭
                        boolean isOpen = panelView.isOpen();
                        if (isOpen) {
                            panelView.toggleControlPanel();
                        }
                        //判断在屏幕左边还是右边，切换位置
                        int halfScreenWidth = getScreenWidth(MainActivity.this) / 2;
                        if (x < halfScreenWidth) {
                            //左边
                            panelView.setOrientation(true);
                        } else {
                            //右边
                            panelView.setOrientation(false);
                        }
                        //跟随
                        int[] result = panelView.fixFollowPosition(x, y);
                        floatPanelWindow.updateX(result[0]);
                        floatPanelWindow.updateY(result[1]);
                    }
                })    //监听悬浮控件状态改变
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onFail() {
                    }
                })  //监听权限申请结果
                .build();
        RxPreventJitter
                .preventJitter(floatButton)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        boolean isOpen = floatControlPanelView.isOpen();
                        if (isOpen) {
                            floatButton.setSelected(false);
                        } else {
                            floatButton.setSelected(true);
                        }
                        floatControlPanelView.toggleControlPanel();
                    }
                });
        floatControlPanelView.setOnTogglePanelListener(new ControlPanelView.OnTogglePanelListener() {
            @Override
            public void onToggleChange(boolean isOpen) {
                //最新为打开
                if (isOpen) {
                    floatButton.setSelected(true);
                    floatButton
                            .animate()
                            .scaleX(0.8f)
                            .scaleY(0.8f)
                            .alpha(1.0f)
                            .start();
                    FloatWindow
                            .get(PANEL_TAG)
                            .show();
                } else {
                    floatButton.setSelected(false);
                    floatButton
                            .animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(0.2f)
                            .start();
                    FloatWindow
                            .get(PANEL_TAG)
                            .hide();
                }
            }
        });
        new Handler(getMainLooper())
                .post(new Runnable() {
                    @Override
                    public void run() {
                        //一开始先隐藏
                        FloatWindow
                                .get(PANEL_TAG)
                                .hide();
                    }
                });
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    private int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    public static int spToPixel(Context context, float spValue) {
        final float fontScale = getDisplayMetrics(context).scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
    }
}