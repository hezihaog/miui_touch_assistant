package com.a.a.a.a;

import android.os.Handler;
import android.os.Looper;

public class i
{
  private static i a = null;
  private int b = 3;
  private long c;
  private long d;
  private Handler e = new j(this, Looper.getMainLooper());
  
  public static i a()
  {
    try
    {
      if (a == null)
      {
        locali = new com/a/a/a/a/i;
        locali.<init>();
        a = locali;
      }
      i locali = a;
      return locali;
    }
    finally {}
  }
  
  public void a(int paramInt, long paramLong)
  {
    q.a().a(new n(this, paramInt, paramLong));
  }
  
  public void b()
  {
    q.a().a(new m(this));
    this.e.sendEmptyMessageDelayed(2, 5000L);
  }
  
  public void c()
  {
    if (this.b == 4) {
      if (!this.e.hasMessages(1)) {
        this.e.sendEmptyMessageDelayed(1, this.c);
      }
    }
    for (;;)
    {
      return;
      if (!this.e.hasMessages(1)) {
        if ((this.b == 0) || (this.b == 1)) {
          this.e.sendEmptyMessageDelayed(1, 5000L);
        } else {
          this.e.sendEmptyMessage(1);
        }
      }
    }
  }
  
  public void d()
  {
    this.d = System.currentTimeMillis();
    q.b().a(new p(this));
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (am.b()) {}
    for (;;)
    {
      return bool;
      switch (this.b)
      {
      case 3: 
      default: 
        break;
      case 0: 
        bool = true;
        break;
      case 1: 
        if (ag.a(b.a())) {
          bool = true;
        }
        break;
      case 2: 
        if (new x().c() >= 50) {
          bool = true;
        }
        break;
      case 4: 
        if (System.currentTimeMillis() - this.d > this.c) {
          bool = true;
        }
        break;
      }
    }
  }
  
  public long f()
  {
    return this.c;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */