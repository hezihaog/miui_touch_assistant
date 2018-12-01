package com.miui.touchassistant.entries;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import com.miui.touchassistant.c.h;

public class a
  extends f
{
  private ComponentName a;
  private String b;
  private Drawable c;
  
  public a(String paramString)
  {
    super(paramString);
    this.a = b.c(paramString);
  }
  
  public Drawable a(Context paramContext)
  {
    if (this.c == null) {}
    try
    {
      this.c = paramContext.getPackageManager().getActivityIcon(this.a);
      return this.c;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        h.a("error get app icons ", localNameNotFoundException);
        this.c = android.support.b.a.a.a(paramContext, 2130837517);
      }
    }
  }
  
  public Drawable b(Context paramContext)
  {
    return a(paramContext);
  }
  
  public String c(Context paramContext)
  {
    if (this.b == null) {}
    try
    {
      this.b = paramContext.getPackageManager().getActivityInfo(this.a, 0).loadLabel(paramContext.getPackageManager()).toString();
      return this.b;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        h.a("error get app icons ", localNameNotFoundException);
        this.b = paramContext.getString(2131296258);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */