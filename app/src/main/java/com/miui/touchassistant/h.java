package com.miui.touchassistant;

import android.database.ContentObserver;
import android.os.Handler;
import com.miui.touchassistant.a.b;

class h
  extends ContentObserver
{
  h(CoreService paramCoreService, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (CoreService.a(this.a) != null) {
      CoreService.a(this.a).a();
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */