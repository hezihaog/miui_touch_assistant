package com.miui.touchassistant.entries;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.b.a.a;

public class i
  extends f
{
  private int a;
  private int b;
  
  public i(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public Drawable a(Context paramContext)
  {
    return a.a(paramContext, this.a);
  }
  
  public Drawable b(Context paramContext)
  {
    return a(paramContext);
  }
  
  public String c(Context paramContext)
  {
    return paramContext.getString(this.b);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */