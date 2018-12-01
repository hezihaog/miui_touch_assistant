package com.miui.touchassistant;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class m
  implements OnItemClickListener
{
  m(EntriesActivity paramEntriesActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.startActivity(new Intent(this.a.getApplicationContext(), EntryPickerActivity.class).putExtra("index", paramInt));
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */