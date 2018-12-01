package com.a.a.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

class u
  extends HandlerThread
{
  public u(q paramq, String paramString)
  {
    super(paramString);
  }
  
  protected void onLooperPrepared()
  {
    q.a(this.a, new Handler());
    Object localObject1 = null;
    synchronized (q.a(this.a))
    {
      if (!q.a(this.a).isEmpty())
      {
        localObject1 = (ArrayList)q.a(this.a).clone();
        q.a(this.a).clear();
      }
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((t)((Iterator)localObject1).next()).a();
        }
      }
    }
    super.onLooperPrepared();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */