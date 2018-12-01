package com.miui.touchassistant.a;

import android.graphics.Point;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import miui.view.animation.BackEaseInInterpolator;

public abstract class a
{
  protected static final DecelerateInterpolator a = new DecelerateInterpolator();
  protected static final AccelerateInterpolator b = new AccelerateInterpolator();
  protected static final OvershootInterpolator c = new OvershootInterpolator();
  protected static final BackEaseInInterpolator d = new BackEaseInInterpolator();
  protected boolean e;
  protected Point f = new Point();
  
  public static ViewPropertyAnimator q(View paramView)
  {
    return paramView.animate().alpha(1.0F).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setStartDelay(0L).setListener(null);
  }
  
  public static ViewPropertyAnimator r(View paramView)
  {
    return paramView.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setStartDelay(0L).setListener(null);
  }
  
  public final ViewPropertyAnimator a(View paramView)
  {
    paramView.animate().cancel();
    return i(paramView);
  }
  
  public final ViewPropertyAnimator a(View paramView, int paramInt)
  {
    paramView.animate().cancel();
    return e(paramView, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f.set(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final ViewPropertyAnimator b(View paramView)
  {
    paramView.animate().cancel();
    return j(paramView);
  }
  
  public final ViewPropertyAnimator b(View paramView, int paramInt)
  {
    paramView.animate().cancel();
    return f(paramView, paramInt);
  }
  
  public final ViewPropertyAnimator c(View paramView)
  {
    return k(paramView);
  }
  
  public final ViewPropertyAnimator c(View paramView, int paramInt)
  {
    return g(paramView, paramInt);
  }
  
  public final ViewPropertyAnimator d(View paramView)
  {
    return l(paramView);
  }
  
  public final ViewPropertyAnimator d(View paramView, int paramInt)
  {
    return h(paramView, paramInt);
  }
  
  public final ViewPropertyAnimator e(View paramView)
  {
    paramView.animate().cancel();
    return m(paramView);
  }
  
  protected abstract ViewPropertyAnimator e(View paramView, int paramInt);
  
  public final ViewPropertyAnimator f(View paramView)
  {
    paramView.animate().cancel();
    return n(paramView);
  }
  
  protected abstract ViewPropertyAnimator f(View paramView, int paramInt);
  
  public final ViewPropertyAnimator g(View paramView)
  {
    paramView.animate().cancel();
    return o(paramView);
  }
  
  protected abstract ViewPropertyAnimator g(View paramView, int paramInt);
  
  public final ViewPropertyAnimator h(View paramView)
  {
    paramView.animate().cancel();
    return p(paramView);
  }
  
  protected abstract ViewPropertyAnimator h(View paramView, int paramInt);
  
  protected abstract ViewPropertyAnimator i(View paramView);
  
  protected abstract ViewPropertyAnimator j(View paramView);
  
  protected abstract ViewPropertyAnimator k(View paramView);
  
  protected abstract ViewPropertyAnimator l(View paramView);
  
  protected abstract ViewPropertyAnimator m(View paramView);
  
  protected abstract ViewPropertyAnimator n(View paramView);
  
  protected abstract ViewPropertyAnimator o(View paramView);
  
  protected abstract ViewPropertyAnimator p(View paramView);
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */