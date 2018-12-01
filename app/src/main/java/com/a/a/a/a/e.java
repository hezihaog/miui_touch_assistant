package com.a.a.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.a.a.a.b.i;
import java.util.ArrayList;
import java.util.List;

public class e
{
  private static e a;
  private static long c = 30000L;
  private static final List d = new ArrayList();
  private Handler b = new f(this, Looper.getMainLooper());
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return paramString2;
      paramString2 = paramString1 + "," + paramString2;
    }
  }
  
  private void a(Context paramContext, long paramLong1, long paramLong2)
  {
    String str2 = ag.b(paramContext.getApplicationContext());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "NULL";
    }
    ac.a(new i(paramLong1, paramLong2, str1));
    al.b(paramContext.getApplicationContext(), "session_begin", 0L);
    al.b(b.a(), "last_deactivate", 0L);
  }
  
  private String b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return paramString;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramContext.getClass().getName();
      }
      paramContext = paramContext.getPackageName();
      paramString = str;
      if (str.startsWith(paramContext)) {
        paramString = str.replace(paramContext, "");
      }
    }
  }
  
  private void c(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ac.a(new com.a.a.a.b.h(paramString, al.a(paramContext, "source_path", "")));
      al.b(paramContext, "source_path", "");
      al.b(paramContext, "pv_path", "");
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    q.a().a(new h(this, paramString, paramContext));
    this.b.sendEmptyMessageDelayed(31415927, c);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      new ae().a("record pageStart without context.", null);
    }
    for (;;)
    {
      return;
      this.b.removeMessages(31415927);
      q.a().a(new g(this, paramContext, paramString1, paramString2));
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */