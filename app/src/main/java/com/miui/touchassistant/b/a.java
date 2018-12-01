package com.miui.touchassistant.b;

import android.app.Application.ActivityLifecycleCallbacks;
import com.a.a.a.c;
import com.google.android.collect.Maps;
import java.util.HashMap;
import miui.os.Build;

public class a
{
  public static final boolean a;
  private static final Application.ActivityLifecycleCallbacks b;
  
  static
  {
    if ((Build.checkRegion("CN")) && (!Build.IS_CTA_BUILD)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new b();
      return;
    }
  }
  
  public static void a(a.a.b paramb)
  {
    c.a(paramb, "2882303761517441193", "5661744169193", "miui");
    c.a(1, 0L);
    com.a.a.a.b.a(true);
    paramb.a(b);
  }
  
  public static void a(String paramString)
  {
    if (!a) {}
    for (;;)
    {
      return;
      c.a("floating", paramString);
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!a) {}
    for (;;)
    {
      return;
      c.a("floating", "entry_triggered", b(paramString, paramInt, paramBoolean));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a) {}
    for (;;)
    {
      return;
      c.a("floating", paramString1, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "left";; str = "right")
    {
      a("ball_position", str);
      return;
    }
  }
  
  private static HashMap b(String paramString, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = Maps.newHashMap();
    String str = paramString;
    if (com.miui.touchassistant.entries.b.b(paramString)) {
      str = "application";
    }
    localHashMap.put("entry", str);
    localHashMap.put("entry_index", Integer.valueOf(paramInt));
    if (paramBoolean) {}
    for (paramString = "click";; paramString = "slide")
    {
      localHashMap.put("trigger_mode", paramString);
      return localHashMap;
    }
  }
  
  public static void b(a.a.b paramb)
  {
    paramb.b(b);
  }
  
  public static void b(String paramString)
  {
    if (!a) {}
    for (;;)
    {
      return;
      c.a("settings", paramString);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */