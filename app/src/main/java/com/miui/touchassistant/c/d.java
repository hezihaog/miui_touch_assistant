package com.miui.touchassistant.c;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.IProcessObserver.Stub;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;

public class d
  extends IProcessObserver.Stub
{
  private String a;
  private Handler b;
  private ActivityManager c;
  private f d;
  private Runnable e = new e(this);
  
  public d(Context paramContext, Handler paramHandler, f paramf)
  {
    this.b = paramHandler;
    this.c = ((ActivityManager)paramContext.getSystemService("activity"));
    this.d = paramf;
  }
  
  public void onForegroundActivitiesChanged(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.post(this.e);
    }
  }
  
  public void onImportanceChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onProcessDied(int paramInt1, int paramInt2) {}
  
  public void onProcessStateChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void start()
  {
    h.a("watcher start");
    try
    {
      ActivityManagerNative.getDefault().registerProcessObserver(this);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        h.a("registerProcessObserver error", localRemoteException);
      }
    }
  }
  
  public void stop()
  {
    h.a("watcher stop");
    try
    {
      ActivityManagerNative.getDefault().unregisterProcessObserver(this);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        h.a("unregisterProcessObserver error", localRemoteException);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */