package com.miui.touchassistant;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miui.widget.DynamicListView;

class o
  extends BaseAdapter
{
  private List a;
  private LayoutInflater b;
  private DynamicListView c;
  private Map d;
  
  public o(Context paramContext, List paramList, DynamicListView paramDynamicListView)
  {
    this.b = LayoutInflater.from(paramContext);
    this.a = paramList;
    this.c = paramDynamicListView;
    this.d = new HashMap();
    for (int i = 0; i < this.a.size(); i++) {
      this.d.put(this.a.get(i), Integer.valueOf(i));
    }
  }
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public void a(List paramList)
  {
    this.a = paramList;
    this.d.clear();
    for (int i = 0; i < this.a.size(); i++) {
      this.d.put(this.a.get(i), Integer.valueOf(i));
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {}
    for (long l = -1L;; l = ((Integer)this.d.get(this.a.get(paramInt))).intValue()) {
      return l;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903046, paramViewGroup, false);
      paramViewGroup = new p(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (p)paramView.getTag();
    }
  }
  
  public boolean hasStableIds()
  {
    if (Build.VERSION.SDK_INT < 20) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */