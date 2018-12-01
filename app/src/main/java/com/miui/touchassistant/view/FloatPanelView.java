package com.miui.touchassistant.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.miui.touchassistant.entries.f;
import com.miui.touchassistant.entries.g;
import java.util.ArrayList;
import java.util.List;

public class FloatPanelView
  extends RelativeLayout
  implements i
{
  protected OvalPanelLayout a;
  private d b;
  private boolean c;
  
  public FloatPanelView(Context paramContext)
  {
    super(paramContext);
    View.inflate(getContext(), 2130903049, this);
    this.a = ((OvalPanelLayout)findViewById(2131427337));
    this.a.setOnChildStateChangedListener(this);
    setOnClickListener(new a(this));
    setOnKeyListener(new b(this));
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(ImageView paramImageView, f paramf)
  {
    paramImageView.setImageDrawable(paramf.a(getContext()));
    paramImageView.setActivated(paramf.b());
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public void a()
  {
    this.a.removeAllViews();
    ArrayList localArrayList = com.miui.touchassistant.settings.b.d(getContext());
    for (int i = 0; i < localArrayList.size(); i++)
    {
      f localf = g.a((String)localArrayList.get(i));
      ImageView localImageView = (ImageView)LayoutInflater.from(getContext()).inflate(2130903048, this.a, false);
      a(localImageView, localf);
      localImageView.setOnClickListener(new c(this, localImageView, i));
      this.a.addView(localImageView);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    this.b.c(paramView, paramInt);
  }
  
  public void b()
  {
    ArrayList localArrayList = com.miui.touchassistant.settings.b.d(getContext());
    for (int i = 0; i < localArrayList.size(); i++)
    {
      f localf = g.a((String)localArrayList.get(i));
      a((ImageView)this.a.getChildAt(i), localf);
    }
  }
  
  public void b(View paramView, int paramInt)
  {
    this.b.d(paramView, paramInt);
  }
  
  public void c()
  {
    this.b.a(this.a);
    for (int i = 0; i < this.a.getChildCount(); i++) {
      this.b.a(this.a.getChildAt(i), i);
    }
  }
  
  public void d()
  {
    this.b.b(this.a);
    for (int i = 0; i < this.a.getChildCount(); i++)
    {
      this.b.b(this.a.getChildAt(i), i);
      this.b.d(this.a.getChildAt(i), i);
    }
  }
  
  public void setFloatPanelCallback(d paramd)
  {
    this.b = paramd;
  }
  
  public void setIsLeft(boolean paramBoolean)
  {
    int i = 9;
    this.c = true;
    this.a.setIsLeft(paramBoolean);
    LayoutParams localLayoutParams = (LayoutParams)this.a.getLayoutParams();
    localLayoutParams.removeRule(11);
    localLayoutParams.removeRule(9);
    if (paramBoolean) {}
    for (;;)
    {
      localLayoutParams.addRule(i);
      this.a.requestLayout();
      return;
      i = 11;
    }
  }
  
  public void setPositionX(int paramInt)
  {
    this.a.setX(paramInt);
  }
  
  public void setPositionY(int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)this.a.getLayoutParams();
    localLayoutParams.bottomMargin = (paramInt - localLayoutParams.height / 2);
    this.a.requestLayout();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/FloatPanelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */