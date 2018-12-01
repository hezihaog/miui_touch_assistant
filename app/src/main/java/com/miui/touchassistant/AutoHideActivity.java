package com.miui.touchassistant;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.os.Bundle;
import android.widget.ListView;
import com.miui.touchassistant.c.g;
import com.miui.touchassistant.c.k;
import com.miui.touchassistant.settings.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import miui.app.ListActivity;

public class AutoHideActivity
  extends ListActivity
  implements g
{
  private e a;
  
  private void b(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ("com.miui.touchassistant".equals(localResolveInfo.activityInfo.packageName)) {
        paramList.remove(localResolveInfo);
      }
    }
  }
  
  public void a(List paramList)
  {
    b(paramList);
    Collections.sort(paramList, new DisplayNameComparator(getPackageManager()));
    this.a = new e(this, paramList);
    this.a.a(b.e(this));
    getListView().setAdapter(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    k.a(this, this);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/AutoHideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */