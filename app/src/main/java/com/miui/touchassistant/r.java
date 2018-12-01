package com.miui.touchassistant;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.miui.touchassistant.b.a;

class r
  implements OnClickListener
{
  r(MainActivity paramMainActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startService(new Intent("com.miui.touchassistant.RELOAD").setClass(this.a.getApplicationContext(), CoreService.class));
    a.b("restored_settings");
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */