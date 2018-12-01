package com.a.a.a.a;

import com.a.a.a.a.a.e;
import java.util.concurrent.atomic.AtomicBoolean;

public class am
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(long paramLong)
  {
    al.b(b.a(), "next_upload_ts", System.currentTimeMillis() + paramLong);
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    q.a().a(new c(this, paramLong1, paramLong2));
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    q.b().a(new e(paramString, new ao(this, paramLong1, paramLong2)));
  }
  
  public static boolean b()
  {
    return a.get();
  }
  
  public static boolean c()
  {
    if (System.currentTimeMillis() > al.a(b.a(), "next_upload_ts", 0L)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void e()
  {
    q.a().a(new a.b(i.a().f(), new an(this)));
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (a.compareAndSet(false, true)) {
      if (c())
      {
        e();
        i.a().d();
      }
    }
    for (;;)
    {
      return;
      a.set(false);
      new ae().a("upload is not allowed by the server.", null);
      continue;
      if (paramBoolean) {
        q.a().a(new d(this), 10000L);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */