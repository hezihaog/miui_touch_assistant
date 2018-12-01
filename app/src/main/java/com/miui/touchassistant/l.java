package com.miui.touchassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.miui.touchassistant.a.b;
import com.miui.touchassistant.c.d;
import com.miui.touchassistant.c.h;

class l
  extends BroadcastReceiver
{
  private Context b;
  
  public l(CoreService paramCoreService, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("miui.intent.action.INPUT_METHOD_VISIBLE_HEIGHT_CHANGED");
    this.b.registerReceiver(this, localIntentFilter, "miui.permission.USE_INTERNAL_GENERAL_API", null);
  }
  
  public void b()
  {
    this.b.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!CoreService.c(this.a)) {
      h.a("touchassistant not enabled, receiver ignored");
    }
    for (;;)
    {
      return;
      if ("android.intent.action.CONFIGURATION_CHANGED".equals(paramIntent.getAction()))
      {
        CoreService.d(this.a);
      }
      else if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        if (CoreService.a(this.a) != null)
        {
          CoreService.a(this.a).d();
          CoreService.a(this.a).d(true);
        }
        CoreService.e(this.a).stop();
      }
      else if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
      {
        CoreService.e(this.a).start();
      }
      else if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
      {
        if (CoreService.a(this.a) != null) {
          CoreService.a(this.a).d(false);
        }
      }
      else if ("miui.intent.action.INPUT_METHOD_VISIBLE_HEIGHT_CHANGED".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("miui.intent.extra.input_method_visible_height", 0);
        this.a.a(i);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */