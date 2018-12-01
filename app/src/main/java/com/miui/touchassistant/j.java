package com.miui.touchassistant;

import android.database.ContentObserver;
import android.os.Handler;
import com.miui.touchassistant.settings.b;

class j
  extends ContentObserver
{
  j(CoreService paramCoreService, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (!b.b(this.a)) {
      CoreService.b(this.a);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */