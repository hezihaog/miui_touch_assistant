package com.miui.touchassistant.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;
import miui.util.async.Task;
import miui.util.async.TaskManager;

final class l
  extends Task
{
  l(Context paramContext, g paramg) {}
  
  public List a()
  {
    PackageManager localPackageManager = this.a.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    return localPackageManager.queryIntentActivities(localIntent, 0);
  }
  
  public void a(TaskManager paramTaskManager, List paramList)
  {
    super.onResult(paramTaskManager, paramList);
    this.b.a(paramList);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */