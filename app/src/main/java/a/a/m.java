package a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;

class m
{
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (paramContext == null) {
      paramContext = c(paramString);
    }
    for (;;)
    {
      return paramContext;
      paramString = b(paramContext, paramString);
      paramContext = (Context)localObject;
      if (paramString != null) {
        paramContext = paramString.applicationInfo.nativeLibraryDir;
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (paramContext == null) {
      paramContext = a(paramString1, paramString2);
    }
    for (;;)
    {
      return paramContext;
      paramString1 = b(paramContext, paramString1);
      paramContext = (Context)localObject;
      if (paramString1 != null) {
        paramContext = paramString1.applicationInfo.publicSourceDir;
      }
    }
  }
  
  private static String a(String paramString)
  {
    return a(new String[] { "/data/app/" + paramString + "-1.apk", "/data/app/" + paramString + "-2.apk", "/data/app/" + paramString + "-1/base.apk", "/data/app/" + paramString + "-2/base.apk" });
  }
  
  private static String a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    paramString1 = str;
    if (str == null) {
      paramString1 = b(paramString2);
    }
    return paramString1;
  }
  
  private static String a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramArrayOfString[i];
      if (!new File(str).exists()) {}
    }
    for (paramArrayOfString = str;; paramArrayOfString = null)
    {
      return paramArrayOfString;
      i++;
      break;
    }
  }
  
  public static boolean a()
  {
    if (b("miui") != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static PackageInfo b(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
  }
  
  private static String b(String paramString)
  {
    return a(new String[] { "/system/app/" + paramString + ".apk", "/system/priv-app/" + paramString + ".apk", "/system/app/" + paramString + "/" + paramString + ".apk", "/system/priv-app/" + paramString + "/" + paramString + ".apk" });
  }
  
  private static String c(String paramString)
  {
    return "/data/data/" + paramString + "/lib/";
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */