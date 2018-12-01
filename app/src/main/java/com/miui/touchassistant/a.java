package com.miui.touchassistant;

import android.content.pm.ResolveInfo;
import com.miui.touchassistant.c.g;

class a
  implements g
{
  a(AppPickerActivity paramAppPickerActivity) {}
  
  public void a(ResolveInfo paramResolveInfo)
  {
    this.a.setResult(-1, AppPickerActivity.a(this.a, paramResolveInfo));
    this.a.finish();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */