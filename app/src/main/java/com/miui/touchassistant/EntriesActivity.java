package com.miui.touchassistant;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import com.miui.touchassistant.settings.AssistantProvider;
import com.miui.touchassistant.settings.b;
import java.util.ArrayList;
import miui.app.Activity;
import miui.widget.DynamicListView;
import miui.widget.DynamicListView.RearrangeListener;

public class EntriesActivity
  extends Activity
  implements DynamicListView.RearrangeListener
{
  private DynamicListView a;
  private o b;
  private ArrayList c;
  private ContentObserver d;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    this.a = ((DynamicListView)findViewById(16908298));
    this.a.setRearrangeListener(this);
    this.c = b.d(this);
    this.b = new o(this, this.c, this.a);
    this.a.setAdapter(this.b);
    this.a.setOnItemClickListener(new m(this));
    this.d = new n(this, new Handler());
    getContentResolver().registerContentObserver(AssistantProvider.b, false, this.d);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    getContentResolver().unregisterContentObserver(this.d);
  }
  
  public void onDragEnd()
  {
    b.a(this, this.c);
  }
  
  public void onDragStart() {}
  
  public void onOrderChanged(int paramInt1, int paramInt2)
  {
    String str = (String)this.c.get(paramInt1);
    this.c.set(paramInt1, this.c.get(paramInt2));
    this.c.set(paramInt2, str);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/EntriesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */