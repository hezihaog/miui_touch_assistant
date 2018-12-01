package com.miui.touchassistant;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceScreen;
import com.miui.touchassistant.b.a;
import com.miui.touchassistant.settings.b;
import miui.preference.PreferenceActivity;
import miui.widget.SimpleDialogFragment;
import miui.widget.SimpleDialogFragment.AlertDialogFragmentBuilder;

public class MainActivity
  extends PreferenceActivity
  implements OnPreferenceChangeListener, OnPreferenceClickListener
{
  private CheckBoxPreference a;
  private Preference b;
  private Preference c;
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getPreferenceScreen().removePreference(this.b);
      getPreferenceScreen().removePreference(this.c);
    }
    for (;;)
    {
      return;
      getPreferenceScreen().addPreference(this.b);
      getPreferenceScreen().addPreference(this.c);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131034113);
    this.a = ((CheckBoxPreference)findPreference("enabled"));
    this.a.setChecked(b.b(this));
    this.a.setOnPreferenceChangeListener(this);
    findPreference("function_settings").setIntent(new Intent(this, EntriesActivity.class));
    findPreference("auto_hide").setIntent(new Intent(this, AutoHideActivity.class));
    findPreference("restore_to_default").setOnPreferenceClickListener(this);
    this.b = findPreference("category_setting");
    this.c = findPreference("category_others");
    if (!b.b(this)) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      if (b.b(this)) {
        startService(new Intent("com.miui.touchassistant.SHOW_FLOATING_WINDOW").setClass(this, CoreService.class));
      }
      return;
    }
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramPreference == this.a)
    {
      boolean bool3 = ((Boolean)paramObject).booleanValue();
      if (!bool3) {
        bool1 = true;
      }
      a(bool1);
      b.a(this, bool3);
      if (bool3)
      {
        paramPreference = new Intent(this, CoreService.class);
        paramPreference.setAction("com.miui.touchassistant.SHOW_FLOATING_WINDOW");
        startService(paramPreference);
        a.b("enable_touchassistant");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      a.b("disable_touchassistant");
      bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    boolean bool = true;
    if ("restore_to_default".equals(paramPreference.getKey()))
    {
      paramPreference = new SimpleDialogFragment.AlertDialogFragmentBuilder(1).setTitle(getString(2131296289)).setCancelable(true).setMessage(getString(2131296290)).create();
      paramPreference.setPositiveButton(17039370, new r(this));
      paramPreference.setNegativeButton(17039360, null);
      getFragmentManager().beginTransaction().add(paramPreference, "dialog").commit();
      a.b("click_restore");
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */