package com.miui.touchassistant;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.os.Bundle;
import android.widget.ListView;
import com.miui.touchassistant.c.g;
import com.miui.touchassistant.c.k;
import java.util.Collections;
import java.util.List;
import miui.app.ListActivity;

public class AppPickerActivity
  extends ListActivity
  implements g
{
  private List a;
  private b b;
  
  private Intent a(ResolveInfo paramResolveInfo)
  {
    paramResolveInfo = new ComponentName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    return new Intent().setComponent(paramResolveInfo);
  }
  
  public void a(List paramList)
  {
    Collections.sort(paramList, new DisplayNameComparator(getPackageManager()));
    this.a = paramList;
    this.b = new b(this, paramList, new a(this));
    getListView().setAdapter(this.b);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    k.a(this, this);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/AppPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */