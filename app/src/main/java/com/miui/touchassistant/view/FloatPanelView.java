package com.miui.touchassistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zh.touchassistant.R;

public class FloatPanelView
        extends RelativeLayout {
    protected OvalPanelLayout mOvalPanelLayout;
    private boolean isLeft;

    public FloatPanelView(Context paramContext) {
        super(paramContext);
        init();
    }

    public FloatPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.oval_panel_window, this);
        this.mOvalPanelLayout = ((OvalPanelLayout) findViewById(R.id.oval_panel_layout));
        //this.a.setOnChildStateChangedListener(this);
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        //setOnKeyListener(new b(this));
        setFocusable(true);
        setFocusableInTouchMode(true);
        addChild();
    }

    //    private void a(ImageView paramImageView, f paramf) {
//        paramImageView.setImageDrawable(paramf.a(getContext()));
//        paramImageView.setActivated(paramf.b());
//    }

//    public int a(MotionEvent paramMotionEvent) {
//        return this.mOvalPanelLayout.a(paramMotionEvent);
//    }

    public void addChild() {
        this.mOvalPanelLayout.removeAllViews();
        //ArrayList localArrayList = com.miui.touchassistant.settings.b.d(getContext());
//        for (int i = 0; i < localArrayList.size(); i++) {
//            
//        }

        for (int i = 0; i < 1; i++) {
            ImageView childImage = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.float_icon, this.mOvalPanelLayout, false);
            int padding = getContext().getResources().getDimensionPixelSize(R.dimen.float_icon_padding);
            childImage.setPadding(padding, padding, padding, padding);
            childImage.setImageResource(R.drawable.ic_key_back);
            //a(localImageView, localf);
            //localImageView.setOnClickListener(new isLeft(this, localImageView, i));
            this.mOvalPanelLayout.addView(childImage);
        }
    }

//    public void a(View paramView, int paramInt) {
//        this.b.c(paramView, paramInt);
//    }

//    public void b() {
//        ArrayList localArrayList = com.miui.touchassistant.settings.b.d(getContext());
//        for (int i = 0; i < localArrayList.size(); i++) {
//            f localf = g.a((String) localArrayList.get(i));
//            //a((ImageView) this.mOvalPanelLayout.getChildAt(i), localf);
//        }
//    }

//    public void b(View paramView, int paramInt) {
//        this.b.d(paramView, paramInt);
//    }

//    public void c() {
//        this.b.a(this.mOvalPanelLayout);
//        for (int i = 0; i < this.mOvalPanelLayout.getChildCount(); i++) {
//            this.b.a(this.mOvalPanelLayout.getChildAt(i), i);
//        }
//    }

//    public void d() {
//        this.b.b(this.mOvalPanelLayout);
//        for (int i = 0; i < this.mOvalPanelLayout.getChildCount(); i++) {
//            this.b.b(this.mOvalPanelLayout.getChildAt(i), i);
//            this.b.d(this.mOvalPanelLayout.getChildAt(i), i);
//        }
//    }

//    public void setFloatPanelCallback(d paramd) {
//        this.b = paramd;
//    }

    public void setIsLeft(boolean paramBoolean) {
        int i = ALIGN_PARENT_LEFT;
        this.isLeft = true;
        this.mOvalPanelLayout.setIsLeft(paramBoolean);
        LayoutParams localLayoutParams = (LayoutParams) this.mOvalPanelLayout.getLayoutParams();
        localLayoutParams.removeRule(ALIGN_PARENT_RIGHT);
        localLayoutParams.removeRule(ALIGN_PARENT_LEFT);
        if (paramBoolean) {
        }
        localLayoutParams.addRule(i);
        this.mOvalPanelLayout.requestLayout();
        i = ALIGN_PARENT_RIGHT;
    }

    public void setPositionX(int paramInt) {
        this.mOvalPanelLayout.setX(paramInt);
    }

    public void setPositionY(int paramInt) {
        LayoutParams localLayoutParams = (LayoutParams) this.mOvalPanelLayout.getLayoutParams();
        localLayoutParams.bottomMargin = (paramInt - localLayoutParams.height / 2);
        this.mOvalPanelLayout.requestLayout();
    }
}