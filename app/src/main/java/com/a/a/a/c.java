package com.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.a.a.a.a.ac;
import com.a.a.a.a.al;
import com.a.a.a.a.am;
import com.a.a.a.a.b;
import com.a.a.a.a.i;
import com.a.a.a.a.q;
import com.a.a.a.a.v;
import com.a.a.a.a.x;
import com.a.a.a.b.f;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public abstract class c
{
  private static boolean a = false;
  
  private static final String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (paramString.contains(",")) {
        str = paramString.replace(",", "");
      }
    }
  }
  
  public static final void a(int paramInt, long paramLong)
  {
    
    if ((paramInt == 4) && ((paramLong < 60000L) || (paramLong > 86400000L))) {
      throw new IllegalArgumentException("interval should be set between 5 minutes and 1 day");
    }
    i.a().a(paramInt, paramLong);
  }
  
  public static final void a(Activity paramActivity, String paramString)
  {
    d();
    com.a.a.a.a.e.a().a(paramActivity, a(paramString), "");
    q.a().a(new com.a.a.a.a.a.a());
    c();
  }
  
  private static void a(Context paramContext)
  {
    if (al.a(b.a(), "uep_property", 0) != 0) {
      return;
    }
    if (a.c(paramContext)) {
      if (a.b(paramContext)) {
        paramContext = new f("mistat_basic", "UEP", "yes");
      }
    }
    for (;;)
    {
      ac.a(paramContext);
      al.b(b.a(), "uep_property", 1);
      break;
      paramContext = new f("mistat_basic", "UEP", "no");
      continue;
      paramContext = new f("mistat_basic", "UEP", "not_miui");
    }
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    d();
    com.a.a.a.a.e.a().a(paramContext, paramString);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, false);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("appID or appKey is empty.");
    }
    Context localContext = paramContext.getApplicationContext();
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "mistats_default";
    }
    b.a(localContext, paramString1, paramString2, str);
    x.a();
    new v().a();
    i.a().b();
    a = true;
    if (paramBoolean) {
      d.a();
    }
    a(paramContext);
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3)
  {
    d();
    b(paramString1, paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "default_category";
    }
    ac.a(new f(str, paramString2, paramString3));
  }
  
  public static final void a(String paramString1, String paramString2, Map paramMap)
  {
    d();
    b(paramString1, paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "default_category";
    }
    ac.a(new com.a.a.a.b.c(str, paramString2, paramMap));
  }
  
  public static boolean a()
  {
    boolean bool = true;
    if (e.d() != 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("mistat_"))) {
      throw new IllegalArgumentException("category cannot start with mistat_");
    }
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("mistat_"))) {
      throw new IllegalArgumentException("key cannot start with mistat_");
    }
  }
  
  public static boolean b()
  {
    if (e.d() == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void c()
  {
    int i = new GregorianCalendar().get(6);
    if (i == al.a(b.a(), "last_day", 0)) {}
    for (;;)
    {
      return;
      al.b(b.a(), "last_day", i);
      ac.a(new com.a.a.a.b.c("mistat_basic", "mistat_dau"));
      new am().a();
    }
  }
  
  private static void d()
  {
    if (!a) {
      throw new IllegalStateException("not initialized, do you forget to call initialize when application started?");
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */