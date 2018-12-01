package com.miui.touchassistant.entries;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class g
{
  private static List a = new ArrayList();
  private static List b = new ArrayList();
  private static List c = new ArrayList();
  private static List d = new ArrayList();
  private static Map e = new HashMap();
  private static Map f = new HashMap();
  private static boolean g;
  
  public static f a(String paramString)
  {
    f localf = (f)e.get(paramString);
    Object localObject = localf;
    if (localf == null)
    {
      localObject = localf;
      if (b.b(paramString))
      {
        localObject = new a(paramString);
        e.put(paramString, localObject);
      }
    }
    return (f)localObject;
  }
  
  public static List a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    g = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    f.put("wifi_toggle", Integer.valueOf(15));
    f.put("network_toggle", Integer.valueOf(1));
    f.put("bluetooth_toggle", Integer.valueOf(2));
    f.put("ringer_mode_toggle", Integer.valueOf(5));
    f.put("lock_screen", Integer.valueOf(10));
    f.put("screenshot", Integer.valueOf(18));
    f.put("torch", Integer.valueOf(11));
    f.put("airplane_toggle", Integer.valueOf(9));
    f.put("orientation_locked", Integer.valueOf(3));
    a.add(new j("wifi_toggle", 2130837527));
    a.add(new j("network_toggle", 2130837521));
    a.add(new j("bluetooth_toggle", 2130837520));
    a.add(new j("ringer_mode_toggle", 2130837523));
    a.add(new j("orientation_locked", 2130837524));
    b.add(new j("lock_screen", 2130837522));
    b.add(new j("screenshot", 2130837525));
    if (g) {
      b.add(new j("torch", 2130837526));
    }
    b.add(new i("key_press_back", 2130837514, 2131296274));
    b.add(new i("key_press_home", 2130837515, 2131296275));
    b.add(new i("key_press_menu", 2130837516, 2131296276));
    c.add(new i("scan_to_pay", 2130837519, 2131296279));
    c.add(new i("payment_code", 2130837518, 2131296273));
    d.addAll(a);
    d.addAll(b);
    d.addAll(c);
    paramContext = d.iterator();
    while (paramContext.hasNext())
    {
      f localf = (f)paramContext.next();
      e.put(localf.a(), localf);
    }
  }
  
  public static int b(String paramString)
  {
    if (f.containsKey(paramString)) {}
    for (int i = ((Integer)f.get(paramString)).intValue();; i = -1) {
      return i;
    }
  }
  
  public static List b()
  {
    return b;
  }
  
  public static List c()
  {
    return c;
  }
  
  public static ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("key_press_home");
    localArrayList.add("key_press_menu");
    localArrayList.add("lock_screen");
    localArrayList.add("screenshot");
    localArrayList.add("key_press_back");
    return localArrayList;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */