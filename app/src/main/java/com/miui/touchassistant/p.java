package com.miui.touchassistant;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.touchassistant.entries.a;
import com.miui.touchassistant.entries.f;
import com.miui.touchassistant.entries.g;
import java.util.List;
import miui.widget.DynamicListView;

class p
  implements OnTouchListener
{
  final TextView a;
  final ImageView b;
  final View c;
  private int e;
  
  public p(o paramo, View paramView)
  {
    this.b = ((ImageView)paramView.findViewById(2131427332));
    this.a = ((TextView)paramView.findViewById(2131427336));
    this.c = paramView.findViewById(2131427335);
    this.c.setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    f localf = g.a((String)o.a(this.d).get(paramInt));
    this.b.setImageDrawable(localf.b(this.b.getContext()));
    if (!(localf instanceof a)) {
      this.b.setColorFilter(-16777216);
    }
    for (;;)
    {
      this.a.setText(localf.c(this.a.getContext()));
      this.e = paramInt;
      return;
      this.b.clearColorFilter();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0) {
      o.b(this.d).startDragging(this.e);
    }
    return false;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */