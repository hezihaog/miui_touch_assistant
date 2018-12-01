package com.miui.touchassistant.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.touchassistant.CoreService;
import com.miui.touchassistant.b.a;
import com.miui.touchassistant.c.h;
import com.miui.touchassistant.settings.b;

public class BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.BOOT_COMPLETED".equals(paramIntent.getAction())) && (b.b(paramContext)))
    {
      h.a("boot_completed, start touch assistant");
      a.a("wakeup_after_boot");
      paramContext.startService(new Intent("com.miui.touchassistant.SHOW_FLOATING_WINDOW").setClass(paramContext, CoreService.class));
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/receiver/BootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */