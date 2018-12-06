package com.zh.touchassistant.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zh.touchassistant.R;

public class ForegroundImageView extends ImageView {
    private Drawable mDrawable;

    public ForegroundImageView(Context context) {
        super(context);
    }

    public ForegroundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ForegroundImageView);
        this.mDrawable = typedArray.getDrawable(R.styleable.ForegroundImageView_ForegroundImageView);
        typedArray.recycle();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mDrawable != null) {
            this.mDrawable.setState(getDrawableState());
        }
        postInvalidateOnAnimation();
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.mDrawable.draw(paramCanvas);
        }
    }
}