package com.miui.touchassistant.a;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.support.a.a.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.miui.touchassistant.c.k;
import com.miui.touchassistant.view.FloatPanelView;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class b
  implements h, com.miui.touchassistant.view.d
{
  private Context a;
  private WindowManager b;
  private FloatPanelView c;
  private com.miui.touchassistant.view.e d;
  private FrameLayout e;
  private android.support.a.a.b f;
  private android.support.a.a.b g;
  private a h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u = -1;
  private ArrayList v;
  private Animator.AnimatorListener w;
  private Animator.AnimatorListener x;
  private Handler y = new Handler();
  private Runnable z = new c(this);
  
  public b(@Nonnull Context paramContext, @Nonnull a parama)
  {
    this.a = paramContext;
    this.b = ((WindowManager)paramContext.getSystemService("window"));
    this.h = parama;
    k();
    j();
    a();
  }
  
  private float a(Point paramPoint, float paramFloat)
  {
    return Math.max(Math.min(paramFloat, paramPoint.y - this.s / 2), this.s / 2);
  }
  
  private LayoutParams a(int paramInt1, int paramInt2, int paramInt3)
  {
    LayoutParams localLayoutParams = d(paramInt1);
    localLayoutParams.gravity = 51;
    localLayoutParams.x = (paramInt2 - localLayoutParams.width / 2);
    localLayoutParams.y = (paramInt3 - localLayoutParams.height / 2);
    localLayoutParams.width = ((int)(localLayoutParams.width * 1.3F));
    localLayoutParams.height = ((int)(localLayoutParams.height * 1.3F));
    return localLayoutParams;
  }
  
  private int c(int paramInt)
  {
    return this.t + paramInt;
  }
  
  private LayoutParams d(int paramInt)
  {
    int i1 = paramInt;
    if (!this.l)
    {
      i1 = paramInt;
      if (this.o > 0) {
        i1 = (int)(paramInt * 0.99F);
      }
    }
    LayoutParams localLayoutParams = new LayoutParams();
    if (this.j)
    {
      paramInt = 2010;
      localLayoutParams.type = paramInt;
      localLayoutParams.flags = 296;
      localLayoutParams.format = -2;
      localLayoutParams.width = i1;
      localLayoutParams.height = localLayoutParams.width;
      if (!this.m) {
        break label138;
      }
    }
    label138:
    for (paramInt = 3;; paramInt = 5)
    {
      localLayoutParams.gravity = (paramInt | 0x50);
      localLayoutParams.x = this.r;
      localLayoutParams.y = ((int)(a(com.miui.touchassistant.settings.b.c(this.a), this.n) - localLayoutParams.height / 2));
      return localLayoutParams;
      paramInt = 2005;
      break;
    }
  }
  
  private void j()
  {
    this.m = com.miui.touchassistant.settings.b.b();
    this.n = com.miui.touchassistant.settings.b.a();
    if (this.o > 0) {
      this.n = Math.max(this.n, c(this.o));
    }
    this.q = ((int)this.a.getResources().getDimension(2131165189));
    this.r = ((int)this.a.getResources().getDimension(2131165188));
    this.s = ((int)this.a.getResources().getDimension(2131165192));
    this.t = ((int)this.a.getResources().getDimension(2131165194));
    this.c.setIsLeft(this.m);
    this.c.setPositionX(this.r + this.q / 2);
    this.c.setPositionY((int)a(com.miui.touchassistant.settings.b.c(this.a), this.n));
    this.h.a(this.m);
    o();
  }
  
  private void k()
  {
    if (this.c == null)
    {
      this.c = new FloatPanelView(this.a);
      this.c.setFloatPanelCallback(this);
    }
    if (this.d == null)
    {
      this.e = new FrameLayout(this.a);
      this.d = new com.miui.touchassistant.view.e(this.a);
      this.d.setTouchViewCallback(this);
      this.d.setBackgroundResource(2130837508);
      if (!k.a()) {
        break label141;
      }
      this.d.setImageResource(2130837513);
    }
    for (;;)
    {
      this.e.addView(this.d);
      this.w = new com.miui.touchassistant.c.b(this.c);
      this.x = new com.miui.touchassistant.c.c(this.c);
      return;
      label141:
      this.d.setImageDrawable(l.a(this.a.getResources(), 2130837529, null));
      this.f = android.support.a.a.b.a(this.a, 2130837504);
      this.g = android.support.a.a.b.a(this.a, 2130837505);
    }
  }
  
  private void l()
  {
    if (this.i)
    {
      this.i = false;
      this.b.removeView(this.c);
      this.b.removeView(this.e);
    }
  }
  
  private void m()
  {
    this.y.removeCallbacks(this.z);
  }
  
  private void n()
  {
    this.y.removeCallbacks(this.z);
    this.y.postDelayed(this.z, 1500L);
  }
  
  private void o()
  {
    this.c.addOnLayoutChangeListener(new f(this));
  }
  
  public void a()
  {
    this.v = com.miui.touchassistant.settings.b.d(this.a);
    this.c.a();
    o();
  }
  
  public void a(int paramInt)
  {
    this.c.b();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.u = this.c.a(paramMotionEvent);
  }
  
  public void a(View paramView)
  {
    c(true);
    this.h.g(paramView).setListener(this.x).start();
  }
  
  public void a(View paramView, int paramInt)
  {
    this.h.a(paramView, paramInt).start();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.i)
    {
      this.b.addView(this.c, f(false));
      this.b.addView(this.e, d(this.q));
      this.i = true;
      this.c.setVisibility(4);
      this.c.d();
      if (!paramBoolean)
      {
        this.h.a(this.d);
        this.h.d(this.d);
        n();
      }
    }
    if (this.k)
    {
      this.d.animate().cancel();
      this.h.a(this.d);
      this.h.d(this.d);
      n();
      this.k = false;
    }
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
    if ((!this.l) || (paramInt > 0)) {
      c();
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.b.updateViewLayout(this.e, a(this.q, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
  }
  
  public void b(View paramView)
  {
    c(false);
    this.h.h(paramView).setListener(this.w).start();
  }
  
  public void b(View paramView, int paramInt)
  {
    this.h.b(paramView, paramInt).start();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      l();
    }
    for (;;)
    {
      return;
      this.k = true;
      this.h.b(this.d).withEndAction(new d(this));
    }
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public void c()
  {
    j();
    if (this.i)
    {
      this.b.updateViewLayout(this.c, f(false));
      this.b.updateViewLayout(this.e, d(this.q));
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    Point localPoint = com.miui.touchassistant.settings.b.c(this.a);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    f2 = a(localPoint, localPoint.y - f2);
    if (f1 < localPoint.x / 2) {}
    for (boolean bool = true;; bool = false)
    {
      com.miui.touchassistant.settings.b.a((int)f2);
      com.miui.touchassistant.settings.b.a(bool);
      c();
      n();
      com.miui.touchassistant.b.a.a(bool);
      return;
    }
  }
  
  public void c(View paramView, int paramInt)
  {
    paramView.setSelected(true);
    this.h.c(paramView, paramInt).start();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.i) {
      this.b.updateViewLayout(this.c, f(paramBoolean));
    }
  }
  
  public void d()
  {
    this.d.a();
  }
  
  public void d(View paramView, int paramInt)
  {
    paramView.setSelected(false);
    this.h.d(paramView, paramInt).start();
  }
  
  public void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (this.i)
    {
      b(true);
      a(true);
    }
  }
  
  public void e()
  {
    boolean bool2 = this.p;
    if (this.o > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.p = (bool1 | bool2);
      this.l = true;
      m();
      this.c.c();
      this.d.setSelected(true);
      this.h.e(this.d).start();
      this.h.d(this.d).start();
      if (!k.a())
      {
        this.d.setImageDrawable(this.f);
        this.f.start();
      }
      return;
    }
  }
  
  public void e(View paramView, int paramInt)
  {
    this.d.a();
    paramView = (String)this.v.get(paramInt);
    com.miui.touchassistant.b.a.a(paramView, paramInt, true);
    com.miui.touchassistant.entries.b.a(this.a, paramView, this.y);
  }
  
  public void e(boolean paramBoolean)
  {
    this.l = false;
    n();
    this.c.d();
    this.d.setSelected(false);
    this.h.f(this.d).withEndAction(new e(this)).start();
    if ((!paramBoolean) && (this.u >= 0))
    {
      String str = (String)this.v.get(this.u);
      com.miui.touchassistant.b.a.a(str, this.u, false);
      com.miui.touchassistant.entries.b.a(this.a, str, this.y);
    }
    this.u = -1;
    if (!k.a())
    {
      this.d.setImageDrawable(this.g);
      this.g.start();
    }
  }
  
  public LayoutParams f(boolean paramBoolean)
  {
    LayoutParams localLayoutParams = new LayoutParams();
    if (this.j)
    {
      i1 = 2010;
      localLayoutParams.type = i1;
      if (paramBoolean) {
        break label63;
      }
    }
    label63:
    for (int i1 = 1336;; i1 = 1312)
    {
      localLayoutParams.flags = i1;
      localLayoutParams.format = -2;
      localLayoutParams.gravity = 53;
      localLayoutParams.alpha = 1.0F;
      return localLayoutParams;
      i1 = 2005;
      break;
    }
  }
  
  public void f()
  {
    this.d.performHapticFeedback(0);
    m();
  }
  
  public void g() {}
  
  public void h()
  {
    com.miui.touchassistant.c.h.b("single-tap not supported yet");
  }
  
  public void i()
  {
    this.d.a();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */