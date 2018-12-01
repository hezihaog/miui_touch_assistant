package com.a.a.a.a;

import android.os.Handler;
import java.util.ArrayList;

public class q
{
  private static q a = null;
  private static q b = null;
  private volatile Handler c;
  private ArrayList d = new ArrayList();
  
  private q(String paramString)
  {
    new u(this, paramString).start();
  }
  
  public static q a()
  {
    try
    {
      if (a == null)
      {
        localq = new com/a/a/a/a/q;
        localq.<init>("local_job_dispatcher");
        a = localq;
      }
      q localq = a;
      return localq;
    }
    finally {}
  }
  
  public static q b()
  {
    try
    {
      if (b == null)
      {
        localq = new com/a/a/a/a/q;
        localq.<init>("remote_job_dispatcher");
        b = localq;
      }
      q localq = b;
      return localq;
    }
    finally {}
  }
  
  public void a(t paramt)
  {
    synchronized (this.d)
    {
      if (this.c == null)
      {
        this.d.add(paramt);
        return;
      }
      Handler localHandler = this.c;
      r localr = new com/a/a/a/a/r;
      localr.<init>(this, paramt);
      localHandler.post(localr);
    }
  }
  
  public void a(t paramt, long paramLong)
  {
    if (this.c != null) {
      this.c.postDelayed(new s(this, paramt), paramLong);
    }
    for (;;)
    {
      return;
      new ae().a("drop the job as handler is not ready.", null);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */