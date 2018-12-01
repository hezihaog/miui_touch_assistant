package com.miui.touchassistant.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.text.TextUtils;
import java.util.List;

class e
  implements Runnable
{
  e(d paramd) {}
  
  public void run()
  {
    String str = ((RunningTaskInfo)d.a(this.a).getRunningTasks(1).get(0)).topActivity.getPackageName();
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(d.b(this.a))) && (d.c(this.a) != null)) {
      d.c(this.a).a(str);
    }
    d.a(this.a, str);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */