package com.miui.touchassistant.c;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;
import android.widget.Toast;
import com.miui.touchassistant.b.a;
import javax.annotation.Nonnull;
import miui.util.async.TaskManager;

public class k
{
  public static void a(@Nonnull Context paramContext, ComponentName paramComponentName)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setComponent(paramComponentName);
    try
    {
      b();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a("failed to start " + paramComponentName.getPackageName(), localException);
        Toast.makeText(paramContext, 2131296258, 1).show();
        a(paramContext, paramComponentName.getPackageName());
      }
    }
  }
  
  public static void a(Context paramContext, g paramg)
  {
    TaskManager.getDefault().add(new l(paramContext, paramg));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?id=%s&ref=touchassistant&back=true", new Object[] { paramString }))).addFlags(268435456));
    a.a("open_mi_market");
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void b()
  {
    if (a()) {}
    for (;;)
    {
      try
      {
        WindowManagerGlobal.getWindowManagerService().dismissKeyguard();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        h.a("failed to dismiss keyguard ", localRemoteException1);
        continue;
      }
      try
      {
        ActivityManagerNative.getDefault().dismissKeyguardOnNextActivity();
      }
      catch (RemoteException localRemoteException2)
      {
        h.a("failed to dismiss keyguard ", localRemoteException2);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */