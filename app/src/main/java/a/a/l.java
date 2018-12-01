package a.a;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class l
  extends Instrumentation
  implements c
{
  private d a;
  
  private l(d paramd)
  {
    this.a = paramd;
  }
  
  private static Field a(Class paramClass1, Object paramObject1, Object paramObject2, String paramString, Class paramClass2)
  {
    Field[] arrayOfField = paramClass1.getDeclaredFields();
    int j;
    int i;
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      j = arrayOfField.length;
      i = 0;
      if (i < j)
      {
        paramClass1 = arrayOfField[i];
        paramClass1.setAccessible(true);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = paramClass1.get(paramObject1);
        if (localObject == paramObject2) {
          return paramClass1;
        }
      }
      catch (IllegalArgumentException paramClass1)
      {
        paramClass1.printStackTrace();
        i++;
      }
      catch (IllegalAccessException paramClass1)
      {
        paramClass1.printStackTrace();
        continue;
      }
      if (paramString != null)
      {
        j = arrayOfField.length;
        for (i = 0;; i++)
        {
          if (i >= j) {
            break label124;
          }
          paramClass1 = arrayOfField[i];
          if (paramClass1.getName().equals(paramString))
          {
            paramClass1.setAccessible(true);
            break;
          }
        }
      }
      label124:
      paramObject1 = null;
      paramClass1 = null;
      if (paramClass2 == null)
      {
        j = arrayOfField.length;
        i = 0;
        paramClass1 = (Class)paramObject1;
        while (i < j)
        {
          paramString = arrayOfField[i];
          if (paramString.getType() != paramClass2)
          {
            paramObject1 = paramClass1;
            if (!paramString.getType().isInstance(paramClass2)) {}
          }
          else
          {
            if (paramClass1 != null) {
              break label193;
            }
            paramObject1 = paramString;
          }
          i++;
          paramClass1 = (Class)paramObject1;
          continue;
          label193:
          throw new NoSuchFieldException("More than one matched field found: " + paramClass1.getName() + " and " + paramString.getName());
        }
        if (paramClass1 == null) {
          throw new NoSuchFieldException("No such field found of value " + paramObject2);
        }
        paramClass1.setAccessible(true);
      }
    }
  }
  
  static void a(d paramd)
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      Field localField1 = a((Class)localObject2, localObject1, (Instrumentation)((Class)localObject2).getMethod("getInstrumentation", new Class[0]).invoke(localObject1, new Object[0]), null, null);
      localObject2 = (Instrumentation)localField1.get(localObject1);
      l locall = new a/a/l;
      locall.<init>(paramd);
      for (paramd = Instrumentation.class; paramd != null; paramd = paramd.getSuperclass()) {
        for (Field localField2 : paramd.getDeclaredFields())
        {
          localField2.setAccessible(true);
          localField2.set(locall, localField2.get(localObject2));
        }
      }
      localField1.set(localObject1, locall);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        paramd.printStackTrace();
      }
    }
  }
  
  public Activity newActivity(Class paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    if (!paramClass.getSimpleName().startsWith("SdkError"))
    {
      Class localClass = f.class;
      paramClass = paramIntent;
      if (paramIntent == null) {
        paramClass = new Intent();
      }
      paramClass.putExtra("com.miui.sdk.error", this.a);
      paramIntent = paramClass;
      paramClass = localClass;
    }
    for (;;)
    {
      return super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
    }
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    String str = paramString;
    Object localObject = paramIntent;
    if (!paramString.startsWith("SdkError"))
    {
      str = f.class.getName();
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("com.miui.sdk.error", this.a);
      localObject = paramString;
    }
    return super.newActivity(paramClassLoader, str, (Intent)localObject);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */