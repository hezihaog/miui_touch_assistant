package com.miui.touchassistant;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.miui.touchassistant.entries.PayEntriesDialog;
import com.miui.touchassistant.entries.f;
import com.miui.touchassistant.entries.g;
import java.util.Iterator;
import java.util.List;
import miui.os.Build;
import miui.preference.PreferenceActivity;

public class EntryPickerActivity
  extends PreferenceActivity
{
  private String a;
  private List b;
  private int c;
  private String d;
  
  private q a(List paramList, f paramf)
  {
    q localq = new q(this, this);
    localq.setKey(paramf.a());
    localq.setTitle(paramf.c(this));
    if ((paramList.contains(paramf.a())) && (!a(paramf.a()))) {
      localq.setEnabled(false);
    }
    return localq;
  }
  
  private boolean a(String paramString)
  {
    if ((com.miui.touchassistant.entries.b.a(paramString)) && (paramString.equals(this.a))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(String paramString)
  {
    this.b.remove(this.c);
    this.b.add(this.c, paramString);
    com.miui.touchassistant.settings.b.a(this, this.b);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 0) {
        break label25;
      }
      b(this.d);
    }
    for (;;)
    {
      return;
      label25:
      if (paramInt1 == 1) {
        b(com.miui.touchassistant.entries.b.a(paramIntent.getComponent()));
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getIntent().getIntExtra("index", 0);
    this.b = com.miui.touchassistant.settings.b.d(this);
    this.a = ((String)this.b.get(this.c));
    addPreferencesFromResource(2131034112);
    PreferenceCategory localPreferenceCategory = (PreferenceCategory)findPreference("system_settings");
    Object localObject1 = (PreferenceCategory)findPreference("quick_settings");
    paramBundle = (PreferenceCategory)findPreference("quick_pay");
    Object localObject2 = g.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f)((Iterator)localObject2).next();
      localPreferenceCategory.addPreference(a(this.b, (f)localObject3));
    }
    Object localObject3 = g.b().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (f)((Iterator)localObject3).next();
      ((PreferenceCategory)localObject1).addPreference(a(this.b, (f)localObject2));
    }
    if (Build.IS_INTERNATIONAL_BUILD) {
      getPreferenceScreen().removePreference(paramBundle);
    }
    for (;;)
    {
      return;
      localObject1 = g.c().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        paramBundle.addPreference(a(this.b, (f)localObject2));
      }
    }
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    boolean bool = true;
    if (((paramPreference instanceof q)) && (paramPreference.isEnabled()))
    {
      paramPreferenceScreen = paramPreference.getKey();
      if (com.miui.touchassistant.entries.b.a(paramPreferenceScreen))
      {
        this.d = paramPreferenceScreen;
        PayEntriesDialog.a(this, true, "scan_to_pay".equals(paramPreferenceScreen));
      }
    }
    for (;;)
    {
      return bool;
      b(paramPreferenceScreen);
      continue;
      if (paramPreference.getKey().equals("applications")) {
        startActivityForResult(new Intent(this, AppPickerActivity.class), 1);
      } else {
        bool = super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/EntryPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */