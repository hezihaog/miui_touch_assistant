package com.miui.touchassistant.c;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import miui.util.async.Cacheable;
import miui.util.async.Task;

public class j
  extends Task
  implements Cacheable
{
  String a;
  PackageManager b;
  ResolveInfo c;
  
  public j(String paramString, PackageManager paramPackageManager, ResolveInfo paramResolveInfo, ImageView paramImageView)
  {
    this.a = paramString;
    this.b = paramPackageManager;
    this.c = paramResolveInfo;
    addListener(new i(paramImageView, getCacheKey()));
  }
  
  public Drawable a()
  {
    return this.c.loadIcon(this.b);
  }
  
  public String getCacheKey()
  {
    return String.valueOf(System.identityHashCode(this.c));
  }
  
  public int sizeOf(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BitmapDrawable))) {}
    for (int i = ((BitmapDrawable)paramObject).getBitmap().getAllocationByteCount();; i = 0) {
      return i;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */