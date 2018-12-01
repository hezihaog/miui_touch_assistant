package a.a;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class a
  extends Application
  implements c
{
  private boolean a;
  private boolean b;
  private b c;
  
  public a()
  {
    if (!e()) {}
    for (;;)
    {
      return;
      if (f()) {
        this.a = true;
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Log.e("miuisdk", "MIUI SDK encounter errors, please contact miuisdk@xiaomi.com for support. phase: " + paramString + " code: " + paramInt);
    l.a(d.a);
  }
  
  private void a(Throwable paramThrowable)
  {
    for (;;)
    {
      if ((paramThrowable == null) || (paramThrowable.getCause() == null)) {}
      do
      {
        Log.e("miuisdk", "MIUI SDK encounter errors, please contact miuisdk@xiaomi.com for support.", paramThrowable);
        l.a(d.a);
        return;
        if ((paramThrowable instanceof InvocationTargetException))
        {
          paramThrowable = paramThrowable.getCause();
          break;
        }
      } while (!(paramThrowable instanceof ExceptionInInitializerError));
      paramThrowable = paramThrowable.getCause();
    }
  }
  
  private boolean e()
  {
    boolean bool = false;
    try
    {
      if ((!m.a()) && (!n.a(m.a(null, "com.miui.core", "miui"), null, m.a(null, "com.miui.core"), a.class.getClassLoader())))
      {
        l.a(d.b);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
        continue;
        bool = true;
      }
    }
  }
  
  private boolean f()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      int i = ((Integer)e.a().getMethod("initialize", new Class[] { Application.class, Map.class }).invoke(null, new Object[] { this, localHashMap })).intValue();
      if (i == 0) {
        break label79;
      }
      a("initialize", i);
      bool = false;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
        boolean bool = false;
        continue;
        label79:
        bool = true;
      }
    }
    return bool;
  }
  
  private boolean g()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        i = ((Integer)e.a().getMethod("start", new Class[] { Map.class }).invoke(null, new Object[] { localHashMap })).intValue();
        if (i != 1) {
          continue;
        }
        l.a(d.c);
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        int i;
        a(localThrowable);
        boolean bool = false;
        continue;
        bool = true;
        continue;
      }
      return bool;
      if (i == 0) {
        continue;
      }
      a("start", i);
      bool = false;
    }
  }
  
  public b a()
  {
    return null;
  }
  
  final void a(int paramInt)
  {
    super.onTrimMemory(paramInt);
  }
  
  final void a(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    if (!this.a) {}
    for (;;)
    {
      return;
      if (g())
      {
        this.c = a();
        if (this.c != null) {
          this.c.a(this);
        }
        this.b = true;
      }
    }
  }
  
  final void b()
  {
    super.onCreate();
  }
  
  final void c()
  {
    super.onTerminate();
  }
  
  final void d()
  {
    super.onLowMemory();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.c != null) {
      this.c.onConfigurationChanged(paramConfiguration);
    }
    for (;;)
    {
      return;
      a(paramConfiguration);
    }
  }
  
  public final void onCreate()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if (this.c != null) {
        this.c.a();
      } else {
        b();
      }
    }
  }
  
  public final void onLowMemory()
  {
    if (this.c != null) {
      this.c.onLowMemory();
    }
    for (;;)
    {
      return;
      d();
    }
  }
  
  public final void onTerminate()
  {
    if (this.c != null) {
      this.c.b();
    }
    for (;;)
    {
      return;
      c();
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    if (this.c != null) {
      this.c.onTrimMemory(paramInt);
    }
    for (;;)
    {
      return;
      a(paramInt);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */