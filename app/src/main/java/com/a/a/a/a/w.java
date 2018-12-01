package com.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;

class w
  implements t
{
  private Context a;
  
  public w(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a()
  {
    String str = al.a(this.a, "device_id", "");
    if (TextUtils.isEmpty(str))
    {
      v.b(v.a(this.a));
      al.b(this.a, "device_id", v.b());
    }
    for (;;)
    {
      return;
      v.b(str);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */