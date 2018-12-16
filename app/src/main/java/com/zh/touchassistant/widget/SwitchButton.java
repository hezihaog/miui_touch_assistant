package com.zh.touchassistant.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import com.zh.touchassistant.R;

public class SwitchButton extends View {
    /**
     * 选中的背景颜色
     */
    private int mCheckedBg;
    /**
     * 未选中的背景颜色
     */
    private int mUncheckedBg;
    /**
     * 圆圈与背景的间距
     */
    private int mCircleMargin;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 默认的宽度
     */
    private int mDefaultWidth;
    /**
     * 默认高度
     */
    private int mDefaultHeight;
    /**
     * 小圆半径
     */
    private int mSmallRadius;
    /**
     * View的宽
     */
    private int mWidth;
    /**
     * View的高
     */
    private int mHeight;
    /**
     * 边界的圆的半径
     */
    private float mBoundRadius;
    /**
     * 是否打开
     */
    private boolean isChecked = false;
    /**
     * 状态监听
     */
    private OnCheckedChangeListener mCheckedChangeListener;

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SwitchButton);
        this.mCheckedBg = typedArray.getColor(R.styleable.SwitchButton_sb_checked_bg, Color.BLUE);
        this.mUncheckedBg = typedArray.getColor(R.styleable.SwitchButton_sb_unchecked_bg, Color.GRAY);
        this.isChecked = typedArray.getBoolean(R.styleable.SwitchButton_sb_checked, false);
        this.mCircleMargin = (int) typedArray.getDimension(R.styleable.SwitchButton_sb_circle_bg_margin, dip2px(getContext(), 3f));
        typedArray.recycle();
        this.mDefaultWidth = dip2px(getContext(), 50f);
        this.mDefaultHeight = dip2px(getContext(), 30f);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = !isChecked;
                if (mCheckedChangeListener != null) {
                    mCheckedChangeListener.onCheckedChanged(SwitchButton.this, isChecked);
                }
                invalidate();
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mSmallRadius = (mHeight - (mCircleMargin * 2)) / 2;
        mBoundRadius = mHeight / 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int resultWidth;
        int resultHeight;
        if (widthMode == MeasureSpec.EXACTLY
                || heightMode == MeasureSpec.EXACTLY) {
            resultWidth = widthSize;
            resultHeight = heightSize;
        } else {
            resultWidth = mDefaultWidth;
            resultHeight = mDefaultHeight;
        }
        setMeasuredDimension(resultWidth, resultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isChecked) {
            drawOpen(canvas);
        } else {
            drawClose(canvas);
        }
    }

    /**
     * 画打开状态
     */
    private void drawOpen(Canvas canvas) {
        mPaint.setColor(mCheckedBg);
        //画背景
        RectF rectF = new RectF(0, 0, mWidth, mHeight);
        canvas.drawRoundRect(rectF, mBoundRadius, mBoundRadius, mPaint);
        //画圆
        mPaint.setColor(Color.WHITE);
        //移动小圆在宽度的3分之一位置
        canvas.drawCircle((mWidth / 4) * 3, mHeight / 2, mSmallRadius, mPaint);
    }

    /**
     * 画关闭状态
     */
    private void drawClose(Canvas canvas) {
        mPaint.setColor(mUncheckedBg);
        //画背景
        RectF rectF = new RectF(0, 0, mWidth, mHeight);
        canvas.drawRoundRect(rectF, mBoundRadius, mBoundRadius, mPaint);
        //画圆
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mWidth / 4, mHeight / 2, mSmallRadius, mPaint);
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
        invalidate();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton button, boolean isChecked);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener checkedChangeListener) {
        this.mCheckedChangeListener = checkedChangeListener;
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