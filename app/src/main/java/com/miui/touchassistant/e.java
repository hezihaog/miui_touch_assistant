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
import com.miui.touchassistant.c.j;
import com.miui.touchassistant.settings.b;
import java.util.ArrayList;
import java.util.List;
import miui.util.async.TaskManager;
import miui.widget.SlidingButton;

class e
  extends BaseAdapter
{
  private Context a;
  private List b;
  private ArrayList c;
  
  public e(Context paramContext, List paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      b.a(this.a, paramString);
      this.c.add(paramString);
    }
    for (;;)
    {
      return;
      b.b(this.a, paramString);
      this.c.remove(paramString);
    }
  }
  
  public ResolveInfo a(int paramInt)
  {
    return (ResolveInfo)this.b.get(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.c = paramArrayList;
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903045, paramViewGroup, false);
    }
    ((TextView)localView.findViewById(2131427333)).setText(a(paramInt).loadLabel(this.a.getPackageManager()));
    paramView = (SlidingButton)localView.findViewById(2131427334);
    paramView.setOnPerformCheckedChangeListener(null);
    paramView.setChecked(this.c.contains(str));
    paramView.setOnPerformCheckedChangeListener(new f(this, str));
    localView.setOnClickListener(new g(this, paramView, str));
    paramView = (ImageView)localView.findViewById(2131427332);
    paramView.setImageDrawable(null);
    TaskManager.getDefault().add(new j(str, this.a.getPackageManager(), a(paramInt), paramView));
    return localView;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */