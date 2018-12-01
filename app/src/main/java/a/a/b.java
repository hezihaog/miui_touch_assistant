package a.a;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContextWrapper;
import android.content.res.Configuration;

public abstract class b
  extends ContextWrapper
  implements ComponentCallbacks2
{
  private a a;
  
  public b()
  {
    super(null);
  }
  
  public void a()
  {
    this.a.b();
  }
  
  void a(a parama)
  {
    this.a = parama;
    attachBaseContext(parama);
  }
  
  public void a(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.a.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void b()
  {
    this.a.c();
  }
  
  public void b(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.a.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.a.a(paramConfiguration);
  }
  
  public void onLowMemory()
  {
    this.a.d();
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.unregisterComponentCallbacks(paramComponentCallbacks);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */