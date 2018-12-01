package com.miui.touchassistant;

import android.app.Notification;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings.System;
import com.miui.touchassistant.a.g;
import com.miui.touchassistant.b.a;
import com.miui.touchassistant.c.d;
import com.miui.touchassistant.c.f;
import com.miui.touchassistant.settings.AssistantProvider;
import java.util.ArrayList;
import miui.app.ToggleManager;
import miui.app.ToggleManager.OnToggleChangedListener;

public class CoreService
  extends Service
  implements f, ToggleManager.OnToggleChangedListener
{
  private com.miui.touchassistant.a.b a;
  private Handler b;
  private l c;
  private ContentObserver d;
  private ContentObserver e;
  private ContentObserver f;
  private ToggleManager g;
  private d h;
  private ArrayList i;
  private boolean j = false;
  
  private void a()
  {
    com.miui.touchassistant.c.h.a("floating windows showing");
    if (this.a == null) {
      this.a = new com.miui.touchassistant.a.b(this, new g());
    }
    this.a.a(false);
    this.j = true;
    this.h.start();
    startForeground(0, new Notification());
  }
  
  private void b()
  {
    if (this.a != null)
    {
      com.miui.touchassistant.c.h.a("floating windows hiding");
      this.a.b(false);
    }
    this.j = false;
    this.h.stop();
    stopForeground(true);
    startService(new Intent(this, CoreService.class).setAction("com.miui.touchassistant.HIDE_FLOATING_WINDOW"));
  }
  
  private void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void OnToggleChanged(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.a != null) && (this.a.b())) {
      this.a.b(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null)
    {
      if (!this.i.contains(paramString)) {
        break label32;
      }
      this.a.b(false);
      a.a("hide_for_app");
    }
    for (;;)
    {
      return;
      label32:
      if (!this.a.b()) {
        this.a.a(false);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.g = ToggleManager.createInstance(this);
    this.b = new Handler();
    this.c = new l(this, this);
    this.c.a();
    this.d = new h(this, this.b);
    this.e = new i(this, this.b);
    this.f = new j(this, this.b);
    getContentResolver().registerContentObserver(AssistantProvider.b, false, this.d);
    getContentResolver().registerContentObserver(AssistantProvider.c, false, this.e);
    getContentResolver().registerContentObserver(Settings.System.getUriFor("touch_assistant_enabled"), false, this.f);
    this.g.setOnToggleChangedListener(this);
    this.h = new d(this, this.b, this);
    this.h.start();
    this.i = com.miui.touchassistant.settings.b.e(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.b();
    getContentResolver().unregisterContentObserver(this.d);
    getContentResolver().unregisterContentObserver(this.e);
    getContentResolver().unregisterContentObserver(this.f);
    this.g.onDestroy();
    this.h.stop();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (!this.j)
    {
      com.miui.touchassistant.c.h.a("low memory and touchassistant not enabled, good bye.");
      stopSelf();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    if (paramIntent == null)
    {
      com.miui.touchassistant.c.h.b("start command intent is null, may be a restart");
      paramInt1 = paramInt2;
      if (com.miui.touchassistant.settings.b.b(this))
      {
        a();
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      return paramInt1;
      if ("com.miui.touchassistant.SHOW_FLOATING_WINDOW".equals(paramIntent.getAction()))
      {
        a();
        paramInt1 = paramInt2;
      }
      else if ("com.miui.touchassistant.HIDE_FLOATING_WINDOW".equals(paramIntent.getAction()))
      {
        paramInt1 = 2;
      }
      else if ("com.miui.touchassistant.HIDE_FOR_SCREENSHOT".equals(paramIntent.getAction()))
      {
        paramInt1 = paramInt2;
        if (this.a != null)
        {
          com.miui.touchassistant.c.h.a("floating window hiding for screenshot");
          this.a.b(true);
          this.b.postDelayed(new k(this), 1000L);
          paramInt1 = paramInt2;
        }
      }
      else if ("com.miui.touchassistant.RELOAD".equals(paramIntent.getAction()))
      {
        com.miui.touchassistant.settings.b.h(getApplicationContext());
        if (this.a != null)
        {
          this.a.a();
          this.a.c();
          paramInt1 = paramInt2;
        }
        else
        {
          paramInt1 = 2;
        }
      }
      else
      {
        com.miui.touchassistant.c.h.b("unknown action : " + paramIntent.getAction());
        paramInt1 = 2;
      }
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (!this.j)
    {
      com.miui.touchassistant.c.h.a("on trim memory and touchassistant not enabled, good bye.");
      stopSelf();
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/CoreService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */