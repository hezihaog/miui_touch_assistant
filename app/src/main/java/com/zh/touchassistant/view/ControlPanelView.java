package com.zh.touchassistant.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.zh.touchassistant.R;

public class ControlPanelView extends FrameLayout {
    /**
     * 开关状态
     */
    private boolean isOpen = false;
    /**
     * 面板的当前半径，开关动画时会用到
     */
    private int mPanelRadius;
    /**
     * 半圆的原心位置到子控件之间的距离
     */
    int mRadius;
    /**
     * 子控件的半径
     */
    int mChildRadius;
    /**
     * 按钮的X,Y
     */
    int mButtonX;
    int mButtonY;
    /**
     * 打开的动画
     */
    private ValueAnimator mOpenAnimator;
    /**
     * 关闭的动画
     */
    private ValueAnimator mOffAnimator;

    //------------ 自定义属性 ------------
    /**
     * 第一个按钮的角度
     */
    int mStartAngle = -90;
    /**
     * 面板宽高
     */
    private int mWidth;
    private int mHeight;
    private boolean isLeft = false;
    /**
     * 左边或右边的偏移量
     */
    private int mOffset;
    private OnTogglePanelListener mTogglePanelListener;

    public ControlPanelView(Context context) {
        this(context, null);
    }

    public ControlPanelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ControlPanelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setWillNotDraw(false);
//        this.mOffset = dip2px(getContext(), 15f);
        this.mOffset = 0;
        setStartAngle();
    }

    private void setStartAngle() {
        if (isLeft) {
            mStartAngle = -90;
        } else {
            mStartAngle = 90;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int count = getChildCount();
        //最后一个作为中间的开关按钮
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            //计算子控件的半径。求法：子控件的宽高中最大的一半，暂时我们子空间宽高都是一致的
            mChildRadius = Math.max(childView.getMeasuredWidth(), childView.getMeasuredHeight()) / 2;
        }
        //计算出半圆的圆心心到子控件圆心的距离，就是我们半圆的半径
        //基本是高的一半减去子控件的2倍半径
        mRadius = Math.max(widthSize, heightSize) / 2 - (mChildRadius * 2);
        //计算按钮的位置
        mButtonX = -mWidth;
        mButtonY = heightSize / 2 - mChildRadius;
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        int childCount = getChildCount();
        //一开始，是关闭状态，子View全部隐藏
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int count = getChildCount();
        //每份子控件应该占用的角度
        int childAngle = 180 / count;
        //每个子View之间的间隔
        int interval = (180 / count) / 4;
        for (int i = 0; i < count; i++) {
            //计算出每个子控件的位置
            float[] point = getCoordinatePoint(mPanelRadius, mStartAngle + ((i * childAngle) + (i * interval)));
            View childView = getChildAt(i);
            int childViewWidth = childView.getMeasuredWidth();
            int childViewHeight = childView.getMeasuredHeight();
            int halfWidth = childViewWidth / 2;
            int halfHeight = childViewHeight / 2;
            //布局子控件
            int pointX = (int) point[0];
            int pointY = (int) point[1];
            if (isLeft) {
                childView.layout(pointX, pointY - halfHeight, pointX + childViewWidth, pointY + halfHeight);
            } else {
                childView.layout(pointX - childViewWidth, (pointY - halfHeight), (pointX), (pointY + halfHeight));
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将圆形平移到中间
        if (isLeft) {
            canvas.translate(mOffset, mWidth / 2);
        } else {
            canvas.translate(mWidth - mOffset, mWidth / 2);
        }
    }

    /**
     * 依圆心坐标，半径，扇形角度，计算出扇形终射线与圆弧交叉点的xy坐标
     *
     * @param angle 每个子控件和面板圆心的夹角
     */
    public float[] getCoordinatePoint(int panelRadius, float angle) {
        float[] point = new float[2];
        //Math类的三角函数是弧度制，所以要将角度转换为弧度才能进行计算
        double arcAngle = Math.toRadians(angle);
        //求子控件的X坐标，邻边 / 斜边，斜边的值刚好就是半径，cos值乘以斜边，就能求出邻边，而这个邻边的长度，就是点的x坐标
        point[0] = (float) (Math.cos(arcAngle) * panelRadius);
        //求子控件的Y坐标，对边 / 斜边，斜边的值刚好就是半径，sin值乘以斜边，就能求出对边，而这个对边的长度，就是点的y坐标
        point[1] = (float) ((getWidth() / 2) + Math.sin(arcAngle) * panelRadius);
        return point;
    }

    /**
     * 切换控件开关状态
     */
    public void toggleControlPanel() {
        if (isOpen) {
            if (mOffAnimator != null && mOffAnimator.isRunning()) {
                return;
            }
            off();
        } else {
            if (mOpenAnimator != null && mOpenAnimator.isRunning()) {
                return;
            }
            open();
        }
        isOpen = !isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    /**
     * 打开动画
     */
    private void open() {
        if (mOpenAnimator != null && mOpenAnimator.isRunning()) {
            return;
        }
        //不断放大开关到子控件圆心的距离，从而形成散开的效果
        mOpenAnimator = ValueAnimator.ofInt(0, mRadius);
        mOpenAnimator.setDuration(250);
        mOpenAnimator.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.decelerate_interpolator_more));
        mOpenAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPanelRadius = (int) valueAnimator.getAnimatedValue();
                invalidate();
                requestLayout();
            }
        });
        mOpenAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    getChildAt(i).setVisibility(View.VISIBLE);
                }
                if (mTogglePanelListener != null) {
                    mTogglePanelListener.onToggleChange(true);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mOpenAnimator = null;
            }
        });
        mOpenAnimator.start();
    }

    /**
     * 关闭动画
     */
    private void off() {
        if (mOffAnimator != null && mOffAnimator.isRunning()) {
            return;
        }
        //不断缩小开关到子控件圆心的距离，从而形成缩小的效果
        mOffAnimator = ValueAnimator.ofInt(mRadius, 0);
        mOffAnimator = ValueAnimator.ofInt(mRadius, 0);
        mOffAnimator.setDuration(200);
        mOffAnimator.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.decelerate_interpolator_more));
        mOffAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPanelRadius = (int) valueAnimator.getAnimatedValue();
                invalidate();
                requestLayout();
            }
        });
        mOffAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    getChildAt(i).setVisibility(View.GONE);
                }
                if (mTogglePanelListener != null) {
                    mTogglePanelListener.onToggleChange(false);
                }
                mOffAnimator = null;
            }
        });
        mOffAnimator.start();
    }

    public void setOrientation(boolean isLeft) {
        this.isLeft = isLeft;
        setStartAngle();
    }

    /**
     * 修正跟随位置
     */
    public int[] fixFollowPosition(int x, int y) {
        int[] result = new int[2];
        if (isLeft) {
            result[0] = x;
            result[1] = y - (mHeight / 2) + mChildRadius;
        } else {
            result[0] = x - mWidth + (mChildRadius * 2);
            result[1] = y - (mHeight / 2) + mChildRadius;
        }
        return result;
    }

    public interface OnTogglePanelListener {
        /**
         * 当切换开关状态时回调
         *
         * @param isOpen 当前是否是打开
         */
        void onToggleChange(boolean isOpen);
    }

    public void setOnTogglePanelListener(OnTogglePanelListener togglePanelListener) {
        this.mTogglePanelListener = togglePanelListener;
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
}