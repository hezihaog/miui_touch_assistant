package com.miui.touchassistant.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import javax.annotation.Nonnull;

public class b
  extends AnimatorListenerAdapter
{
  private View a;
  private boolean b;
  
  public b(@Nonnull View paramView)
  {
    this.a = paramView;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.b = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!this.b) {
      this.a.setVisibility(8);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.b = false;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */