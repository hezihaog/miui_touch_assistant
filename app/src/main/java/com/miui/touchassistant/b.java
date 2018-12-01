package com.miui.touchassistant;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.touchassistant.c.g;
import com.miui.touchassistant.c.j;
import java.util.List;
import miui.util.async.TaskManager;

class b
  extends BaseAdapter
{
  private Context a;
  private List b;
  private g c;
  
  public b(Context paramContext, List paramList, g paramg)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramg;
  }
  
  public ResolveInfo a(int paramInt)
  {
    return (ResolveInfo)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt).activityInfo.packageName;
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903044, paramViewGroup, false);
    }
    ((TextView)localView.findViewById(2131427333)).setText(a(paramInt).loadLabel(this.a.getPackageManager()));
    localView.setOnClickListener(new c(this, paramInt));
    paramView = (ImageView)localView.findViewById(2131427332);
    paramView.setImageDrawable(null);
    TaskManager.getDefault().add(new j(str, this.a.getPackageManager(), a(paramInt), paramView));
    return localView;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */