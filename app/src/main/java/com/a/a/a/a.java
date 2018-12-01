package com.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;

public class a
{
  private static boolean a = false;
  private static boolean b = false;
  private static Boolean c = null;
  private static boolean d = true;
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!d) {
      return bool1;
    }
    if (c == null)
    {
      if ((!c(paramContext)) || (!d(paramContext))) {
        break label60;
      }
      bool1 = bool2;
      if (!b(paramContext)) {
        bool1 = true;
      }
    }
    label60:
    for (c = Boolean.valueOf(bool1);; c = Boolean.valueOf(false))
    {
      bool1 = c.booleanValue();
      break;
    }
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    if (Settings.Secure.getInt(paramContext.getContentResolver(), "upload_log_pref", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo("com.xiaomi.xmsf", 0);
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return bool;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool2 = true;
    String str = paramContext.getPackageName();
    boolean bool1 = bool2;
    if (!str.contains("miui"))
    {
      if (!str.contains("xiaomi")) {
        break label31;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label31:
      bool1 = bool2;
      if ((paramContext.getApplicationInfo().flags & 0x1) == 0) {
        bool1 = false;
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */