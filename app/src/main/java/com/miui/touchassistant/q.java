package com.miui.touchassistant;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.widget.CheckBox;

class q
  extends Preference
{
  CheckBox a;
  
  public q(EntryPickerActivity paramEntryPickerActivity, Context paramContext)
  {
    super(paramContext);
    setWidgetLayoutResource(2130903047);
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.a = ((CheckBox)paramView.findViewById(16908289));
    this.a.setChecked(EntryPickerActivity.a(this.b).equals(getKey()));
    paramView = this.a;
    if (this.a.isChecked()) {}
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      return;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */