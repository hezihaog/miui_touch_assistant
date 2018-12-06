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
    private Drawable a;

    public ForegroundImageView(Context context) {
        super(context);
    }

    public ForegroundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ForegroundImageView);
        this.a = typedArray.getDrawable(R.styleable.ForegroundImageView_ForegroundImageView);
        typedArray.recycle();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.setState(getDrawableState());
        }
        postInvalidateOnAnimation();
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.a != null) {
            this.a.setBounds(0, 0, getWidth(), getHeight());
            this.a.draw(paramCanvas);
        }
    }
}