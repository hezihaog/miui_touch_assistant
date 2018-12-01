package com.miui.touchassistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;

public class e
  extends ImageView
{
  private int a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private com.miui.touchassistant.a.h b;
  private g c = new g(this, null);
  private boolean d;
  private boolean e;
  private float f;
  private float g;
  private int h;
  
  public e(Context paramContext)
  {
    super(paramContext);
    setImageLevel(1);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.h == 0) {
      performHapticFeedback(0);
    }
    this.c.sendEmptyMessageDelayed(0, 600L);
    if (this.h == 1) {
      this.h = 2;
    }
    for (;;)
    {
      this.f = paramMotionEvent.getRawX();
      this.g = paramMotionEvent.getRawY();
      this.d = true;
      invalidate();
      return;
      this.h = 0;
      this.c.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  public void a()
  {
    if (this.d) {
      com.miui.touchassistant.c.h.b("FloatTouchView.closePanel error, why called when mTouching=true");
    }
    for (;;)
    {
      return;
      this.h = 0;
      this.b.e(true);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        a(paramMotionEvent);
        continue;
        if (!this.e)
        {
          float f3 = paramMotionEvent.getRawX();
          float f4 = paramMotionEvent.getRawY();
          float f5 = Math.abs(f3 - this.f);
          float f6 = Math.abs(f4 - this.g);
          if ((this.h == 2) || (this.h == 0))
          {
            float f1 = this.f;
            float f7 = this.f;
            float f2 = this.g;
            if ((f7 - f3) * (f1 - f3) + (this.g - f4) * (f2 - f4) > 400.0F) {
              this.c.removeMessages(0);
            }
          }
          if ((this.h == 0) || (this.h == 1))
          {
            if (f5 * f6 > this.a * this.a)
            {
              if (this.h == 0)
              {
                this.c.removeMessages(1);
                this.c.sendMessageAtFrontOfQueue(this.c.obtainMessage(1));
              }
              this.h = 2;
            }
          }
          else if (this.h == 2) {
            this.b.a(paramMotionEvent);
          }
        }
        else
        {
          this.b.b(paramMotionEvent);
        }
      }
    case 1: 
      if ((this.e) && (this.b != null)) {
        this.b.c(paramMotionEvent);
      }
      break;
    }
    boolean bool;
    if (paramMotionEvent.getAction() == 3)
    {
      bool = true;
      label299:
      switch (this.h)
      {
      }
    }
    for (;;)
    {
      if (this.h != 1) {
        this.h = 0;
      }
      this.c.removeMessages(1);
      this.c.removeMessages(0);
      invalidate();
      if ((this.e) && (bool)) {
        this.b.g();
      }
      this.e = false;
      this.d = false;
      break;
      bool = false;
      break label299;
      this.b.h();
      continue;
      this.b.e(bool);
    }
  }
  
  public void setTouchViewCallback(com.miui.touchassistant.a.h paramh)
  {
    this.b = paramh;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */