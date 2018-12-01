package com.a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

class f
  extends Handler
{
  f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      long l2 = al.a(b.a(), "session_begin", 0L);
      long l1 = al.a(b.a(), "last_deactivate", 0L);
      paramMessage = al.a(b.a(), "pv_path", "");
      if ((l2 > 0L) && (l1 > l2)) {
        e.a(this.a, b.a(), l2, l1);
      }
      if (!TextUtils.isEmpty(paramMessage)) {
        e.a(this.a, b.a(), paramMessage);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */