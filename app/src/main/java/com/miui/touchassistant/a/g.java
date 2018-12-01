package com.miui.touchassistant.a;

import android.graphics.Point;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

public class g
  extends a
{
  private static final DecelerateInterpolator g = new DecelerateInterpolator(2.0F);
  
  protected ViewPropertyAnimator e(View paramView, int paramInt)
  {
    return paramView.animate().translationX(0.0F).translationY(0.0F).setDuration(300L).setInterpolator(g);
  }
  
  protected ViewPropertyAnimator f(View paramView, int paramInt)
  {
    paramInt = paramView.getLeft();
    int j = paramView.getWidth() / 2;
    int i = paramView.getTop();
    int k = paramView.getHeight() / 2;
    return paramView.animate().translationX(this.f.x - (paramInt + j)).translationY(this.f.y - (i + k)).setDuration(300L).setInterpolator(g);
  }
  
  protected ViewPropertyAnimator g(View paramView, int paramInt)
  {
    return q(paramView).scaleX(1.1F).scaleY(1.1F).setInterpolator(a).setDuration(200L).setStartDelay(0L);
  }
  
  protected ViewPropertyAnimator h(View paramView, int paramInt)
  {
    return r(paramView).setInterpolator(a).setDuration(200L).setStartDelay(0L);
  }
  
  protected ViewPropertyAnimator i(View paramView)
  {
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    return paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator(a);
  }
  
  protected ViewPropertyAnimator j(View paramView)
  {
    return paramView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(300L).setInterpolator(a);
  }
  
  protected ViewPropertyAnimator k(View paramView)
  {
    return paramView.animate().alpha(0.2F).setInterpolator(a);
  }
  
  protected ViewPropertyAnimator l(View paramView)
  {
    return paramView.animate().alpha(1.0F).setInterpolator(a);
  }
  
  protected ViewPropertyAnimator m(View paramView)
  {
    return paramView.animate().scaleX(0.88F).scaleY(0.88F).setInterpolator(a);
  }
  
  protected ViewPropertyAnimator n(View paramView)
  {
    return q(paramView);
  }
  
  protected ViewPropertyAnimator o(View paramView)
  {
    return paramView.animate().setDuration(100L).alpha(1.0F).setStartDelay(0L);
  }
  
  protected ViewPropertyAnimator p(View paramView)
  {
    return paramView.animate().setDuration(200L).alpha(0.0F).setStartDelay(100L);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */