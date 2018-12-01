package com.miui.touchassistant.c;

import android.widget.ImageView;
import miui.util.async.Task;
import miui.util.async.TaskManager;
import miui.util.async.tasks.listeners.ImageViewBindingListener;

public class i
  extends ImageViewBindingListener
{
  private String a;
  
  public i(ImageView paramImageView, String paramString)
  {
    super(paramImageView);
    this.a = paramString;
    paramImageView.setTag(paramString);
  }
  
  public Object onResult(TaskManager paramTaskManager, Task paramTask, Object paramObject)
  {
    ImageView localImageView = getImageView();
    Object localObject = paramObject;
    if (localImageView != null)
    {
      localObject = paramObject;
      if (localImageView.getTag() != null)
      {
        localObject = paramObject;
        if (localImageView.getTag().equals(this.a)) {
          localObject = super.onResult(paramTaskManager, paramTask, paramObject);
        }
      }
    }
    return localObject;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */