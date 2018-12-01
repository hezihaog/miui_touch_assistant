package com.miui.touchassistant.entries;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import miui.app.AlertActivity;

public class PayEntriesDialog
  extends AlertActivity
  implements OnClickListener, OnCheckedChangeListener
{
  private static final HashMap b = new HashMap();
  ArrayList a;
  private int c;
  private int d;
  private Button e;
  private PayEntriesDialog.AppSelectionIcon f;
  private PayEntriesDialog.AppSelectionIcon g;
  
  static
  {
    b.put("com.eg.android.AlipayGphone", new String[] { "alipay_scan", "alipay_payment_code" });
    b.put("com.tencent.mm", new String[] { "wechat_scan", "wechat_payment_code" });
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    Intent localIntent = new Intent(paramContext, PayEntriesDialog.class);
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localIntent.putExtra("mode", i);
      i = j;
      if (paramBoolean2) {
        i = 0;
      }
      localIntent.putExtra("type", i);
      if ((!paramBoolean1) || (!(paramContext instanceof Activity))) {
        break label75;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, 0);
    }
    for (;;)
    {
      return;
      i = 1;
      break;
      label75:
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    return ((String[])b.get(paramString))[paramInt];
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.e;
    if ((PayEntriesDialog.AppSelectionIcon.a(this.f)) || (PayEntriesDialog.AppSelectionIcon.a(this.g))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      setResult(-1);
      this.f.b();
      this.g.b();
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(524288);
    KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
    if ((localKeyguardManager.isKeyguardSecure()) && (localKeyguardManager.isKeyguardLocked())) {
      setTheme(2131361796);
    }
    super.onCreate(paramBundle);
    this.c = getIntent().getIntExtra("mode", 0);
    this.d = getIntent().getIntExtra("type", 0);
    if (this.d == 0) {}
    for (paramBundle = com.miui.touchassistant.settings.b.f(this);; paramBundle = com.miui.touchassistant.settings.b.g(this))
    {
      this.a = paramBundle;
      if (this.c != 1) {
        break label200;
      }
      if (this.a.size() != 1) {
        break;
      }
      b.a(this, b((String)this.a.get(0), this.d), new Handler());
      finish();
      return;
    }
    this.mAlertParams.mTitle = getString(2131296283);
    this.mAlertParams.mNegativeButtonText = getString(17039360);
    for (;;)
    {
      this.mAlertParams.mView = getLayoutInflater().inflate(2130903043, null);
      setupAlert();
      break;
      label200:
      if (this.c == 0)
      {
        this.mAlertParams.mTitle = getString(2131296284);
        this.mAlertParams.mPositiveButtonText = getString(17039370);
        this.mAlertParams.mPositiveButtonListener = this;
      }
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.e = ((Button)findViewById(16908313));
    this.e.setEnabled(false);
    this.f = ((PayEntriesDialog.AppSelectionIcon)findViewById(2131427328));
    this.g = ((PayEntriesDialog.AppSelectionIcon)findViewById(2131427330));
    this.f.setTitleView((TextView)findViewById(2131427329));
    this.g.setTitleView((TextView)findViewById(2131427331));
    paramBundle = this.f;
    if (this.d == 0)
    {
      i = 2131296268;
      paramBundle.setTitle(i);
      paramBundle = this.g;
      if (this.d != 0) {
        break label187;
      }
    }
    label187:
    for (int i = 2131296282;; i = 2131296281)
    {
      paramBundle.setTitle(i);
      PayEntriesDialog.AppSelectionIcon.a(this.f, PayEntriesDialog.AppSelectionIcon.a(this.g, this));
      this.f.a(this.c, this.d, this.a);
      this.g.a(this.c, this.d, this.a);
      return;
      i = 2131296267;
      break;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/PayEntriesDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */