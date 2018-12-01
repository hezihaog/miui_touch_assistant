package com.miui.touchassistant.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.miui.touchassistant.t;

public class FloatPanelView$ForegroundImageView
  extends ImageView
{
  private Drawable a;
  
  public FloatPanelView$ForegroundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, t.ForegroundImageView);
    this.a = paramContext.getDrawable(0);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.a.setState(getDrawableState());
    postInvalidateOnAnimation();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.a.setBounds(0, 0, getWidth(), getHeight());
    this.a.draw(paramCanvas);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/FloatPanelView$ForegroundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */