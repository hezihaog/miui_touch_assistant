package com.miui.touchassistant.view;

import android.os.Handler;
import android.os.Message;
import com.miui.touchassistant.a.h;

class g
  extends Handler
{
  private g(e parame) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      e.a(this.a, true);
      e.b(this.a, false);
      if (e.a(this.a) != null)
      {
        e.a(this.a).e(true);
        e.a(this.a).f();
      }
      e.a(this.a, 3);
      continue;
      if (e.b(this.a))
      {
        e.a(this.a, 1);
        removeMessages(1);
        e.a(this.a).e();
        this.a.invalidate();
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */