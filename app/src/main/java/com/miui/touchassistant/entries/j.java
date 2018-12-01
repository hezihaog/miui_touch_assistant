package com.miui.touchassistant.entries;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.b.a.a;
import miui.app.ToggleManager;

public class j
  extends f
{
  private int a;
  private int b;
  
  public j(String paramString, int paramInt)
  {
    super(paramString);
    this.a = g.b(paramString);
    this.b = paramInt;
  }
  
  public Drawable a(Context paramContext)
  {
    return a.a(paramContext, this.b);
  }
  
  public Drawable b(Context paramContext)
  {
    return a(paramContext);
  }
  
  public boolean b()
  {
    return ToggleManager.getStatus(this.a);
  }
  
  public String c(Context paramContext)
  {
    return paramContext.getString(ToggleManager.getName(this.a));
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */