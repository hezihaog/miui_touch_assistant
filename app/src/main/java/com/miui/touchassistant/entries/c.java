package com.miui.touchassistant.entries;

import android.content.Context;
import miui.app.ToggleManager;

final class c
  implements Runnable
{
  c(Context paramContext, int paramInt) {}
  
  public void run()
  {
    ToggleManager.createInstance(this.a).performToggle(this.b);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */