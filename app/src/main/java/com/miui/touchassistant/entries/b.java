package com.miui.touchassistant.entries;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.miui.touchassistant.CoreService;
import com.miui.touchassistant.c.k;
import javax.annotation.Nonnull;

public class b
{
  public static String a(ComponentName paramComponentName)
  {
    return "component_name:" + paramComponentName.flattenToShortString();
  }
  
  public static void a(Context paramContext, String paramString, Handler paramHandler)
  {
    long l = 80L;
    if (paramContext == null) {
      com.miui.touchassistant.c.h.b("executing context cannot be null");
    }
    for (;;)
    {
      return;
      int i = g.b(paramString);
      if (i != -1)
      {
        if (i == 18)
        {
          paramContext.startService(new Intent(paramContext, CoreService.class).setAction("com.miui.touchassistant.HIDE_FOR_SCREENSHOT"));
          l = 200L;
        }
        paramHandler.postDelayed(new c(paramContext, i), l);
      }
      else if (b(paramString))
      {
        paramHandler.postDelayed(new d(paramContext, paramString), 80L);
      }
      else
      {
        paramHandler.postDelayed(new e(paramContext, paramString), 80L);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (("scan_to_pay".equals(paramString)) || ("payment_code".equals(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    return paramString.startsWith("component_name:");
  }
  
  public static ComponentName c(String paramString)
  {
    return ComponentName.unflattenFromString(paramString.substring("component_name:".length()));
  }
  
  private static void c(@Nonnull Context paramContext, String paramString)
  {
    k.a(paramContext, c(paramString));
  }
  
  private static void d(@Nonnull Context paramContext, String paramString)
  {
    if ("key_press_back".equals(paramString)) {
      h.a(4);
    }
    for (;;)
    {
      return;
      if ("key_press_home".equals(paramString)) {
        h.a(3);
      } else if ("key_press_menu".equals(paramString)) {
        h.a(82);
      } else if ("search".equals(paramString)) {
        h.a(paramContext);
      } else if (("alipay_scan".equals(paramString)) || ("alipay_payment_code".equals(paramString)) || ("wechat_scan".equals(paramString)) || ("wechat_payment_code".equals(paramString))) {
        h.a(paramContext, paramString);
      } else if (a(paramString)) {
        PayEntriesDialog.a(paramContext, false, "scan_to_pay".equals(paramString));
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */