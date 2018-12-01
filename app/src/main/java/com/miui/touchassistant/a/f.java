package com.miui.touchassistant.a;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.miui.touchassistant.view.FloatPanelView;

class f
  implements OnLayoutChangeListener
{
  f(b paramb) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    b.e(this.a).removeOnLayoutChangeListener(this);
    paramInt1 = b.f(this.a) / 2 + b.g(this.a);
    paramView = b.b(this.a);
    if (b.h(this.a)) {}
    for (;;)
    {
      paramView.a(paramInt1, b.i(this.a) / 2);
      b.e(this.a).d();
      return;
      paramInt1 = b.i(this.a) / 2 - paramInt1;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */