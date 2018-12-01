package com.miui.touchassistant.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

public abstract class h
  extends ViewGroup
{
  protected Point a = new Point();
  private int b = -1;
  private Point[] c;
  private i d;
  
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    for (int i = 0; i < getChildCount(); i++) {
      getChildAt(i).setSelected(false);
    }
    double d2 = Double.MAX_VALUE;
    int k = 0;
    i = j;
    j = k;
    while (i < this.c.length)
    {
      double d3 = (this.c[i].x - paramFloat1) * (this.c[i].x - paramFloat1) + (this.c[i].y - paramFloat2) * (this.c[i].y - paramFloat2);
      double d1 = d2;
      if (d3 < d2)
      {
        j = i;
        d1 = d3;
      }
      i++;
      d2 = d1;
    }
    if (j != this.c.length - 1) {
      getChildAt(j).setSelected(true);
    }
    for (;;)
    {
      if ((this.b > -1) && (this.b != j) && (this.d != null))
      {
        i = this.b;
        this.d.b(getChildAt(i), i);
      }
      if ((this.b != j) && (j != -1) && (this.d != null)) {
        this.d.a(getChildAt(j), j);
      }
      this.b = j;
      return j;
      j = -1;
    }
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
  }
  
  protected abstract Point a(int paramInt);
  
  protected abstract Point getStartPoint();
  
  protected int getTotalLeft()
  {
    int i = getLeft();
    ViewParent localViewParent = getParent();
    while ((localViewParent instanceof ViewGroup))
    {
      int j = ((ViewGroup)localViewParent).getLeft();
      localViewParent = localViewParent.getParent();
      i = j + i;
    }
    return i;
  }
  
  protected int getTotalTop()
  {
    int i = getTop();
    ViewParent localViewParent = getParent();
    while ((localViewParent instanceof ViewGroup))
    {
      int j = ((ViewGroup)localViewParent).getTop();
      localViewParent = localViewParent.getParent();
      i = j + i;
    }
    return i;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = new Point[getChildCount() + 1];
    for (paramInt1 = 0; paramInt1 < getChildCount(); paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      localPoint = a(paramInt1);
      int m = localView.getLayoutParams().width;
      paramInt2 = localView.getLayoutParams().height;
      paramInt3 = localPoint.x;
      int i = m / 2;
      paramInt4 = localPoint.y;
      int j = paramInt2 / 2;
      int k = localPoint.x;
      int n = m / 2;
      m = localPoint.y;
      localView.layout(paramInt3 - i, paramInt4 - j, n + k, paramInt2 / 2 + m);
      localView.invalidate();
      localPoint.x += getTotalLeft();
      localPoint.y += getTotalTop();
      this.c[paramInt1] = localPoint;
    }
    Point localPoint = getStartPoint();
    this.a.x = (localPoint.x + getTotalLeft());
    this.a.y = (localPoint.y + getTotalTop());
    this.c[getChildCount()] = this.a;
    this.a = localPoint;
  }
  
  public final void setOnChildStateChangedListener(i parami)
  {
    this.d = parami;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */