package com.zh.touchassistant.widget;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
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
import android.view.animation.AccelerateInterpolator;

import com.zh.touchassistant.R;

public class SwitchButton extends View {
    private static final int BG_ANIMATOR_DURATION = 200;

    /**
     * 选中的背景颜色
     */
    private int mCheckedBg;
    /**
     * 未选中的背景颜色
     */
    private int mUncheckedBg;
    /**
     * 当前边界背景
     */
    private int mCurrentBoundBg;
    /**
     * 小圆与背景的间距
     */
    private int mSmallCircleMargin;
    /**
     * 内容画笔
     */
    private Paint mContentPaint;
    /**
     * 描边画笔
     */
    private Paint mOutlinePaint;
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
    private int mSmallCircleRadius;
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
     * 边界区域
     */
    private RectF mBoundRect;
    /**
     * 小圆中心位置的X坐标，开和关会改变该值来移动小圆
     */
    private int mSmallCircleCenterX;
    /**
     * 小圆中心位置的Y坐标，一直在高度的一半
     */
    private int mSmallCircleCenterY;
    /**
     * 是否打开
     */
    private boolean isChecked = false;
    /**
     * 状态监听
     */
    private OnCheckedChangeListener mCheckedChangeListener;
    /**
     * 小圆的起点X和终点x坐标
     */
    private int mSmallCircleStartX;
    private int mSmallCircleEndX;
    /**
     * 背景颜色估值器
     */
    final ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();
    private AnimatorSet mOffAnimatorSet;
    private AnimatorSet mOpenAnimatorSet;

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SwitchButton);
        this.mCheckedBg = typedArray.getColor(R.styleable.SwitchButton_sb_checked_bg, Color.BLUE);
        this.mUncheckedBg = typedArray.getColor(R.styleable.SwitchButton_sb_unchecked_bg, Color.GRAY);
        this.isChecked = typedArray.getBoolean(R.styleable.SwitchButton_sb_checked, false);
        this.mSmallCircleMargin = (int) typedArray.getDimension(R.styleable.SwitchButton_sb_circle_bg_margin, dip2px(getContext(), 3f));
        typedArray.recycle();
        if (isChecked) {
            this.mCurrentBoundBg = mCheckedBg;
        } else {
            this.mCurrentBoundBg = mUncheckedBg;
        }
        this.mDefaultWidth = dip2px(getContext(), 50f);
        this.mDefaultHeight = dip2px(getContext(), 30f);
        init();
    }

    private void init() {
        //内容画笔
        mContentPaint = new Paint();
        mContentPaint.setAntiAlias(true);
        mContentPaint.setStyle(Paint.Style.FILL);
        //描边画笔
        mOutlinePaint = new Paint();
        mOutlinePaint.setAntiAlias(true);
        mOutlinePaint.setStyle(Paint.Style.STROKE);
        mOutlinePaint.setColor(getResources().getColor(android.R.color.darker_gray));
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    //已打开，则关闭
                    if (mOffAnimatorSet != null && mOffAnimatorSet.isRunning()) {
                        return;
                    }
                    off();
                } else {
                    //已关闭，则打开
                    if (mOpenAnimatorSet != null && mOpenAnimatorSet.isRunning()) {
                        return;
                    }
                    open();
                }
                isChecked = !isChecked;
                if (mCheckedChangeListener != null) {
                    mCheckedChangeListener.onCheckedChanged(SwitchButton.this, isChecked);
                }
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
        this.mSmallCircleRadius = (mHeight - (mSmallCircleMargin * 2)) / 2;
        this.mBoundRadius = mHeight / 2;
        this.mSmallCircleCenterY = mHeight / 2;
        //小圆的起点X和终点x坐标
        mSmallCircleStartX = mWidth / 4;
        mSmallCircleEndX = (mWidth / 4) * 3;
        //因为一开始外部调用setChecked()会比onSizeChanged方法快，所以回显状态时，马上就得改变当前状态的相关配置
        if (isChecked) {
            this.mSmallCircleCenterX = mSmallCircleEndX;
            this.mCurrentBoundBg = mCheckedBg;
        } else {
            this.mSmallCircleCenterX = mSmallCircleStartX;
            this.mCurrentBoundBg = mUncheckedBg;
        }
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
        //关闭状态下，要描边
//        if (!isChecked) {
//            //更新当前背景颜色
//            drawBg(canvas, mOutlinePaint);
//            drawCircle(canvas, mOutlinePaint);
//        }
        //画内容
        mContentPaint.setColor(mCurrentBoundBg);
        drawBg(canvas, mContentPaint);
        //小圆为白色
        mContentPaint.setColor(Color.WHITE);
        drawCircle(canvas, mContentPaint);
    }

    /**
     * 画背景
     */
    private void drawBg(Canvas canvas, Paint paint) {
        //画边界背景
        if (mBoundRect == null) {
            mBoundRect = new RectF(0, 0, mWidth, mHeight);
        }
        canvas.drawRoundRect(mBoundRect, mBoundRadius, mBoundRadius, paint);
    }

    /**
     * 画小圆
     */
    private void drawCircle(Canvas canvas, Paint paint) {
        //画小圆
        canvas.drawCircle(mSmallCircleCenterX, mSmallCircleCenterY, mSmallCircleRadius, paint);
    }

    private void open() {
        //从左到右
        final int startX = mSmallCircleStartX;
        final int endX = mSmallCircleEndX;
        mOpenAnimatorSet = new AnimatorSet();
        ValueAnimator openAnimator = ValueAnimator.ofInt(startX, endX);
        openAnimator.setDuration(300);
        openAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mSmallCircleCenterX = (Integer) animation.getAnimatedValue();
                invalidate();
            }
        });
        ValueAnimator bgAnimator = ValueAnimator.ofFloat(0, 1f);
        //开关切换完后，再切换背景
        bgAnimator.setStartDelay(200);
        bgAnimator.setDuration(BG_ANIMATOR_DURATION);
        bgAnimator.setInterpolator(new AccelerateInterpolator());
        bgAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float fraction = (Float) animation.getAnimatedValue();
                mCurrentBoundBg = (int) mArgbEvaluator.evaluate(fraction, mUncheckedBg, mCheckedBg);
                invalidate();
            }
        });
        mOpenAnimatorSet
                .play(openAnimator)
                .before(bgAnimator);
        mOpenAnimatorSet.start();
    }

    private void off() {
        //从右到左
        final int startX = mSmallCircleEndX;
        final int endX = mSmallCircleStartX;
        mOffAnimatorSet = new AnimatorSet();
        ValueAnimator offAnimator = ValueAnimator.ofInt(startX, endX);
        offAnimator.setDuration(200);
        offAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //小圆位置
                mSmallCircleCenterX = (Integer) animation.getAnimatedValue();
                invalidate();
            }
        });
        ValueAnimator bgAnimator = ValueAnimator.ofFloat(0, 1f);
        bgAnimator.setStartDelay(200);
        bgAnimator.setDuration(BG_ANIMATOR_DURATION);
        bgAnimator.setInterpolator(new AccelerateInterpolator());
        bgAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float fraction = (Float) animation.getAnimatedValue();
                mCurrentBoundBg = (int) mArgbEvaluator.evaluate(fraction, mCheckedBg, mUncheckedBg);
                invalidate();
            }
        });
        mOffAnimatorSet
                .play(offAnimator)
                .before(bgAnimator);
        mOffAnimatorSet.start();
    }

    public void setChecked(final boolean checked) {
        this.isChecked = checked;
        postInvalidate();
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

    public OnCheckedChangeListener getCheckedChangeListener() {
        return mCheckedChangeListener;
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