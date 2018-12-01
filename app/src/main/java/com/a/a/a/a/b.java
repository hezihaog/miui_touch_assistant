package com.a.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public abstract class b
{
  private static Context a;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  
  public static Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a = paramContext.getApplicationContext();
    b = paramString1;
    c = paramString2;
    d = paramString3;
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String c()
  {
    return c;
  }
  
  public static String d()
  {
    return d;
  }
  
  public static String e()
  {
    if (!TextUtils.isEmpty(e)) {}
    for (Object localObject = e;; localObject = e)
    {
      return (String)localObject;
      localObject = a.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(a.getPackageName(), 16384);
        if (localObject != null) {
          e = ((PackageInfo)localObject).versionName;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static String f()
  {
    if (!TextUtils.isEmpty(f)) {}
    for (String str = f;; str = f)
    {
      return str;
      f = a.getPackageName();
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */