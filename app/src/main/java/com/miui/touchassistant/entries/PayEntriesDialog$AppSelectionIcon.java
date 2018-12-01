package com.miui.touchassistant.entries;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.touchassistant.c.h;
import com.miui.touchassistant.c.k;
import com.miui.touchassistant.t;
import java.util.List;

public class PayEntriesDialog$AppSelectionIcon
  extends ImageView
  implements OnClickListener
{
  private static final int[] a = { 16842912 };
  private int b;
  private int c;
  private String d;
  private TextView e;
  private Drawable f;
  private int g;
  private String h;
  private boolean i;
  private boolean j = true;
  private CompoundButton.OnCheckedChangeListener k;
  
  public PayEntriesDialog$AppSelectionIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, t.AppSelectionIcon);
    this.h = paramContext.getString(0);
    this.f = paramContext.getDrawable(1);
    this.g = ((int)paramContext.getDimension(2, 0.0F));
    paramContext.recycle();
  }
  
  public void a()
  {
    try
    {
      setImageDrawable(getContext().getPackageManager().getApplicationIcon(this.h));
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        h.a("app not installed : " + this.h);
        this.j = false;
        setChecked(false);
        setTitle(2131296258);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, List paramList)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = PayEntriesDialog.a(this.h, paramInt2);
    if ((this.b == 0) && (paramList.contains(this.h))) {
      setChecked(true);
    }
    a();
  }
  
  public void b()
  {
    switch (this.c)
    {
    }
    for (;;)
    {
      return;
      if (this.i)
      {
        com.miui.touchassistant.settings.b.c(getContext(), this.h);
      }
      else
      {
        com.miui.touchassistant.settings.b.d(getContext(), this.h);
        continue;
        if (this.i) {
          com.miui.touchassistant.settings.b.e(getContext(), this.h);
        } else {
          com.miui.touchassistant.settings.b.f(getContext(), this.h);
        }
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.f != null) {
      this.f.setState(getDrawableState());
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (!this.j)
    {
      k.a(getContext(), this.h);
      ((Activity)getContext()).finish();
    }
    for (;;)
    {
      return;
      if (this.b == 0)
      {
        if (!this.i) {}
        for (;;)
        {
          setChecked(bool);
          break;
          bool = false;
        }
      }
      if (this.b == 1)
      {
        b.a(getContext(), this.d, getHandler());
        ((Activity)getContext()).finish();
      }
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (this.i) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.b == 0) && (this.f != null))
    {
      this.f.setBounds(getWidth() - this.f.getIntrinsicWidth(), getHeight() - this.f.getIntrinsicHeight(), getWidth(), getHeight());
      paramCanvas.save();
      paramCanvas.translate(this.g, this.g);
      this.f.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.i = paramBoolean;
    refreshDrawableState();
    invalidate();
    this.k.onCheckedChanged(null, this.i);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (paramBoolean) {
      setColorFilter(855638016);
    }
    for (;;)
    {
      super.setPressed(paramBoolean);
      return;
      clearColorFilter();
    }
  }
  
  public void setTitle(int paramInt)
  {
    this.e.setText(paramInt);
  }
  
  public void setTitleView(TextView paramTextView)
  {
    this.e = paramTextView;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/PayEntriesDialog$AppSelectionIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */