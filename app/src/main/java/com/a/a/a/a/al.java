package com.a.a.a.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class al
{
  public static String a = null;
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences(a(paramContext), 0).getInt(paramString, paramInt);
  }
  
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences(a(paramContext), 0).getLong(paramString, paramLong);
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a))
    {
      paramContext = a;
      return paramContext;
    }
    String str = b(paramContext);
    if (TextUtils.equals(str, paramContext.getPackageName())) {}
    for (a = "mistat";; a = "mistat" + v.a(str))
    {
      paramContext = a;
      break;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(a(paramContext), 0).getString(paramString1, paramString2);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(a(paramContext), 0).contains(paramString);
  }
  
  private static String b(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!paramContext.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (RunningAppProcessInfo)paramContext.next();
    } while (localRunningAppProcessInfo.pid != Process.myPid());
    for (paramContext = localRunningAppProcessInfo.processName;; paramContext = "") {
      return paramContext;
    }
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(a(paramContext), 0).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(a(paramContext), 0).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(a(paramContext), 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */