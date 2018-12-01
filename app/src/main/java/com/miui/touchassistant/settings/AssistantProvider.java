package com.miui.touchassistant.settings;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.miui.touchassistant.entries.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AssistantProvider
  extends ContentProvider
{
  static final Uri a = Uri.parse("content://touchassistant");
  public static final Uri b = Uri.withAppendedPath(a, "float_entries");
  public static final Uri c = Uri.withAppendedPath(a, "auto_hide_apps");
  public static final Uri d = Uri.withAppendedPath(a, "scan_to_pay_apps");
  public static final Uri e = Uri.withAppendedPath(a, "payment_code_apps");
  private UriMatcher f;
  private SharedPreferences g;
  
  public static String a(List paramList)
  {
    return a.a(paramList);
  }
  
  private List a()
  {
    Object localObject = this.g.getString("key_float_entries", null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = g.d();; localObject = a.a((String)localObject)) {
      return (List)localObject;
    }
  }
  
  private Set b()
  {
    return new HashSet(this.g.getStringSet("key_auto_hide_apps", new HashSet()));
  }
  
  private Set c()
  {
    return new HashSet(this.g.getStringSet("key_scan_to_pay_apps", new HashSet()));
  }
  
  private Set d()
  {
    return new HashSet(this.g.getStringSet("key_payment_code_apps", new HashSet()));
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = 1;
    switch (this.f.match(paramUri))
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      paramUri = (String)paramUri.getPathSegments().get(1);
      paramString = a();
      if (paramString.remove(paramUri)) {}
      for (i = 1;; i = 0)
      {
        this.g.edit().putString("key_float_entries", a.a(paramString)).apply();
        getContext().getContentResolver().notifyChange(b, null);
        break;
      }
      this.g.edit().remove("key_float_entries").apply();
      getContext().getContentResolver().notifyChange(b, null);
      continue;
      paramString = (String)paramUri.getPathSegments().get(1);
      boolean bool;
      if (!TextUtils.isEmpty(paramString))
      {
        paramUri = b();
        bool = paramUri.remove(paramString);
        this.g.edit().putStringSet("key_auto_hide_apps", paramUri).apply();
        getContext().getContentResolver().notifyChange(c, null);
        if (!bool) {
          i = 0;
        }
      }
      else
      {
        paramString = (String)paramUri.getPathSegments().get(1);
        if (!TextUtils.isEmpty(paramString))
        {
          paramUri = c();
          bool = paramUri.remove(paramString);
          this.g.edit().putStringSet("key_scan_to_pay_apps", paramUri).apply();
          getContext().getContentResolver().notifyChange(d, null);
          if (!bool) {
            i = 0;
          }
        }
        else
        {
          paramString = (String)paramUri.getPathSegments().get(1);
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          paramUri = d();
          bool = paramUri.remove(paramString);
          this.g.edit().putStringSet("key_payment_code_apps", paramUri).apply();
          getContext().getContentResolver().notifyChange(e, null);
          if (!bool) {
            i = 0;
          }
        }
      }
    }
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (this.f.match(paramUri))
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (Uri)localObject1;
      paramUri = paramContentValues.getAsString("entries");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramUri))
      {
        this.g.edit().putString("key_float_entries", paramUri).apply();
        getContext().getContentResolver().notifyChange(b, null);
        localObject1 = b;
        continue;
        paramUri = paramContentValues.getAsString("package_name");
        if (!TextUtils.isEmpty(paramUri))
        {
          paramContentValues = b();
          paramContentValues.add(paramUri);
          this.g.edit().putStringSet("key_auto_hide_apps", paramContentValues).apply();
          getContext().getContentResolver().notifyChange(c, null);
          localObject1 = Uri.withAppendedPath(c, paramUri);
        }
        else
        {
          paramUri = paramContentValues.getAsString("package_name");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramUri))
          {
            paramContentValues = c();
            paramContentValues.add(paramUri);
            this.g.edit().putStringSet("key_scan_to_pay_apps", paramContentValues).apply();
            getContext().getContentResolver().notifyChange(d, null);
            localObject1 = b;
            continue;
            paramUri = paramContentValues.getAsString("package_name");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramUri))
            {
              paramContentValues = d();
              paramContentValues.add(paramUri);
              this.g.edit().putStringSet("key_payment_code_apps", paramContentValues).apply();
              getContext().getContentResolver().notifyChange(e, null);
              localObject1 = b;
            }
          }
        }
      }
    }
  }
  
  public boolean onCreate()
  {
    this.f = new UriMatcher(-1);
    this.f.addURI("touchassistant", "float_entries", 0);
    this.f.addURI("touchassistant", "float_entries/*", 1);
    this.f.addURI("touchassistant", "auto_hide_apps", 2);
    this.f.addURI("touchassistant", "auto_hide_apps/*", 3);
    this.f.addURI("touchassistant", "scan_to_pay_apps", 4);
    this.f.addURI("touchassistant", "scan_to_pay_apps/*", 5);
    this.f.addURI("touchassistant", "payment_code_apps", 6);
    this.f.addURI("touchassistant", "payment_code_apps/*", 7);
    this.g = PreferenceManager.getDefaultSharedPreferences(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = null;
    paramArrayOfString1 = paramString1;
    switch (this.f.match(paramUri))
    {
    default: 
      paramArrayOfString1 = paramString1;
    }
    for (;;)
    {
      return paramArrayOfString1;
      paramArrayOfString1 = new MatrixCursor(new String[] { "entry" });
      paramString1 = a().iterator();
      while (paramString1.hasNext())
      {
        paramUri = (String)paramString1.next();
        paramArrayOfString1.newRow().add(paramUri);
      }
      continue;
      paramArrayOfString1 = new MatrixCursor(new String[] { "package_name" });
      paramUri = b().iterator();
      while (paramUri.hasNext())
      {
        paramString1 = (String)paramUri.next();
        paramArrayOfString1.newRow().add(paramString1);
      }
      continue;
      paramArrayOfString1 = new MatrixCursor(new String[] { "package_name" });
      paramString1 = c().iterator();
      while (paramString1.hasNext())
      {
        paramUri = (String)paramString1.next();
        paramArrayOfString1.newRow().add(paramUri);
      }
      continue;
      paramArrayOfString1 = new MatrixCursor(new String[] { "package_name" });
      paramString1 = d().iterator();
      while (paramString1.hasNext())
      {
        paramUri = (String)paramString1.next();
        paramArrayOfString1.newRow().add(paramUri);
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    switch (this.f.match(paramUri))
    {
    }
    for (;;)
    {
      return i;
      i = paramContentValues.getAsInteger("index").intValue();
      paramContentValues = (String)paramUri.getPathSegments().get(0);
      paramUri = a();
      if (paramUri.contains(paramContentValues))
      {
        paramUri.remove(paramContentValues);
        paramUri.add(i, paramContentValues);
        this.g.edit().putString("key_float_entries", a.a(paramUri)).apply();
      }
      i = 1;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/settings/AssistantProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */