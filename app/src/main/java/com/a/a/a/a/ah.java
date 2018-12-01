package com.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Map;

final class ah
  implements ServiceConnection
{
  ah(ae paramae, Object paramObject, ak paramak, String paramString, Map paramMap, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    q.a().a(new ai(this, paramIBinder, this));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.a("error while perform IPC connection.", null);
    ag.a(this.b);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */