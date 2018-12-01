package com.miui.touchassistant;

import android.database.ContentObserver;
import android.os.Handler;
import com.miui.touchassistant.settings.b;

class n
  extends ContentObserver
{
  n(EntriesActivity paramEntriesActivity, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    EntriesActivity.a(this.a, b.d(this.a));
    EntriesActivity.b(this.a).a(EntriesActivity.a(this.a));
    EntriesActivity.b(this.a).notifyDataSetChanged();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */