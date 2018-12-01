package com.miui.touchassistant.settings;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.view.Display;
import android.view.WindowManager;
import com.miui.touchassistant.c.h;
import com.miui.touchassistant.entries.g;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static SharedPreferences a;
  private static int b;
  
  public static int a()
  {
    return a.getInt("position_y", b);
  }
  
  private static ArrayList a(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    paramUri = paramContext.getContentResolver().query(paramUri, null, null, null, null);
    paramContext = (Context)localObject;
    if (paramUri != null) {
      try
      {
        paramContext = new java/util/ArrayList;
        paramContext.<init>();
        paramUri.moveToPosition(-1);
        while (paramUri.moveToNext()) {
          paramContext.add(paramUri.getString(0));
        }
      }
      finally
      {
        paramUri.close();
      }
    }
    return paramContext;
  }
  
  public static void a(int paramInt)
  {
    a.edit().putInt("position_y", paramInt).apply();
  }
  
  public static void a(Context paramContext)
  {
    a = PreferenceManager.getDefaultSharedPreferences(paramContext);
    b = (int)paramContext.getResources().getDimension(2131165186);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("package_name", paramString);
    paramContext.getContentResolver().insert(AssistantProvider.c, localContentValues);
  }
  
  public static void a(Context paramContext, List paramList)
  {
    String str = AssistantProvider.a(paramList);
    paramList = new ContentValues(1);
    paramList.put("entries", str);
    paramContext.getContentResolver().insert(AssistantProvider.b, paramList);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getContentResolver();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Settings.System.putInt(paramContext, "touch_assistant_enabled", i);
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a.edit().putBoolean("left_hand", paramBoolean).apply();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramString = Uri.withAppendedPath(AssistantProvider.c, paramString);
    paramContext.getContentResolver().delete(paramString, null, null);
  }
  
  public static boolean b()
  {
    return a.getBoolean("left_hand", false);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "touch_assistant_enabled", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static Point c(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    paramContext.getDefaultDisplay().getSize(localPoint);
    return localPoint;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("package_name", paramString);
    paramContext.getContentResolver().insert(AssistantProvider.d, localContentValues);
  }
  
  public static ArrayList d(Context paramContext)
  {
    ArrayList localArrayList = a(paramContext, AssistantProvider.b);
    paramContext = localArrayList;
    if (localArrayList == null)
    {
      h.b("failed to get floating entries, returns default");
      paramContext = g.d();
    }
    return paramContext;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    paramString = Uri.withAppendedPath(AssistantProvider.d, paramString);
    paramContext.getContentResolver().delete(paramString, null, null);
  }
  
  public static ArrayList e(Context paramContext)
  {
    ArrayList localArrayList = a(paramContext, AssistantProvider.c);
    paramContext = localArrayList;
    if (localArrayList == null)
    {
      h.b("failed to get auto hide apps, returns empty");
      paramContext = new ArrayList();
    }
    return paramContext;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("package_name", paramString);
    paramContext.getContentResolver().insert(AssistantProvider.e, localContentValues);
  }
  
  public static ArrayList f(Context paramContext)
  {
    ArrayList localArrayList = a(paramContext, AssistantProvider.d);
    paramContext = localArrayList;
    if (localArrayList == null)
    {
      h.b("failed to get scan-to-pay apps, returns empty");
      paramContext = new ArrayList();
    }
    return paramContext;
  }
  
  public static void f(Context paramContext, String paramString)
  {
    paramString = Uri.withAppendedPath(AssistantProvider.e, paramString);
    paramContext.getContentResolver().delete(paramString, null, null);
  }
  
  public static ArrayList g(Context paramContext)
  {
    ArrayList localArrayList = a(paramContext, AssistantProvider.e);
    paramContext = localArrayList;
    if (localArrayList == null)
    {
      h.b("failed to get payment-code apps, returns empty");
      paramContext = new ArrayList();
    }
    return paramContext;
  }
  
  public static void h(Context paramContext)
  {
    a.edit().clear().apply();
    paramContext.getContentResolver().delete(AssistantProvider.b, null, null);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/settings/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */