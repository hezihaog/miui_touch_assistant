package com.miui.touchassistant.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import javax.annotation.Nonnull;

public class c
  extends AnimatorListenerAdapter
{
  private View a;
  
  public c(@Nonnull View paramView)
  {
    this.a = paramView;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.a.setVisibility(0);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */