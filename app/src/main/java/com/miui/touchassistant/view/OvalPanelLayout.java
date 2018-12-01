package com.miui.touchassistant.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;

public class OvalPanelLayout
  extends h
{
  private boolean b;
  private int c;
  private double d = 0.18D;
  
  public OvalPanelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public OvalPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected static double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.sqrt(1.0D / (Math.pow(paramDouble1 / paramDouble3, 2.0D) + Math.pow(1.0D / paramDouble2, 2.0D)));
  }
  
  private Point a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2)
  {
    Point localPoint = new Point();
    double d1 = Math.tan(Math.toRadians(180.0D / paramInt2 * (paramInt1 + 0.5D + this.d * (paramInt1 - getChildCount() / 2)) + 90.0D));
    paramDouble2 = -a(d1, paramDouble1, paramDouble2);
    paramDouble1 = paramInt3;
    double d2 = paramInt4;
    localPoint.x = ((int)(paramDouble2 + paramDouble1));
    localPoint.y = ((int)(d2 - d1 * paramDouble2));
    if (paramBoolean) {
      localPoint.x = (getWidth() - localPoint.x);
    }
    return localPoint;
  }
  
  protected Point a(int paramInt)
  {
    int j = getWidth();
    int i = getHeight();
    return a(this.b, paramInt, getChildCount(), j - this.c, i / 2, i / 2 * 0.635D, 0.635D * (i / 2));
  }
  
  protected Point getStartPoint()
  {
    if (this.b) {}
    for (int i = this.c;; i = getWidth() - this.c) {
      return new Point(i, getHeight() / 2);
    }
  }
  
  public void setIsLeft(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setX(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/OvalPanelLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */