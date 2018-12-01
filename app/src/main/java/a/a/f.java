package a.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class f
  extends Activity
  implements c
{
  private String a;
  private DialogInterface.OnClickListener b = new g(this);
  private DialogInterface.OnClickListener c = new h(this);
  
  private Dialog a()
  {
    String str2;
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str2 = "MIUI SDK发生错误";
    }
    for (String str1 = "请重新安装MIUI SDK再运行本程序。";; str1 = "Please re-install MIUI SDK and then re-run this application.")
    {
      return a(str2, str1, this.b);
      str2 = "MIUI SDK encounter errors";
    }
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return new AlertDialog.Builder(this).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, paramOnClickListener).setIcon(17301543).setCancelable(false).create();
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return new AlertDialog.Builder(this).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, paramOnClickListener1).setNegativeButton(17039360, paramOnClickListener2).setIcon(17301543).setCancelable(false).create();
  }
  
  private Dialog b()
  {
    String str1;
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str1 = "没有找到MIUI SDK";
    }
    for (String str2 = "请先安装MIUI SDK再运行本程序。";; str2 = "Please install MIUI SDK and then re-run this application.")
    {
      return a(str1, str2, this.b);
      str1 = "MIUI SDK not found";
    }
  }
  
  private Dialog c()
  {
    String str;
    if (!g())
    {
      if (Locale.CHINESE.getLanguage().equals(this.a)) {
        localObject = "MIUI SDK版本过低";
      }
      for (str = "请先升级MIUI SDK再运行本程序。";; str = "Please upgrade MIUI SDK and then re-run this application.")
      {
        localObject = a((String)localObject, str, this.b);
        return (Dialog)localObject;
        localObject = "MIUI SDK too old";
      }
    }
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str = "MIUI SDK版本过低";
    }
    for (Object localObject = "请先升级MIUI SDK再运行本程序。是否现在升级？";; localObject = "Please upgrade MIUI SDK and then re-run this application. Upgrade now?")
    {
      localObject = a(str, (String)localObject, this.c, this.b);
      break;
      str = "MIUI SDK too old";
    }
  }
  
  private Dialog d()
  {
    String str2;
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str2 = "MIUI SDK正在更新";
    }
    for (String str1 = "请稍候...";; str1 = "Please wait...")
    {
      return ProgressDialog.show(this, str2, str1, true, false);
      str2 = "MIUI SDK updating";
    }
  }
  
  private Dialog e()
  {
    String str1;
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str1 = "MIUI SDK更新完成";
    }
    for (String str2 = "请重新运行本程序。";; str2 = "Please re-run this application.")
    {
      return a(str1, str2, this.b);
      str1 = "MIUI SDK updated";
    }
  }
  
  private Dialog f()
  {
    String str1;
    if (Locale.CHINESE.getLanguage().equals(this.a)) {
      str1 = "MIUI SDK更新失败";
    }
    for (String str2 = "请稍后重试。";; str2 = "Please try it later.")
    {
      return a(str1, str2, this.b);
      str1 = "MIUI SDK update failed";
    }
  }
  
  private boolean g()
  {
    try
    {
      bool = ((Boolean)e.a().getMethod("supportUpdate", new Class[] { Map.class }).invoke(null, new Object[] { null })).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  private boolean h()
  {
    try
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      bool = ((Boolean)e.a().getMethod("update", new Class[] { Map.class }).invoke(null, new Object[] { localHashMap })).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973909);
    super.onCreate(paramBundle);
    this.a = Locale.getDefault().getLanguage();
    paramBundle = null;
    Object localObject = getIntent();
    if (localObject != null) {
      paramBundle = (d)((Intent)localObject).getSerializableExtra("com.miui.sdk.error");
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = d.a;
    }
    switch (j.a[localObject.ordinal()])
    {
    default: 
      paramBundle = a();
    }
    for (;;)
    {
      new k(this, paramBundle).show(getFragmentManager(), "SdkErrorPromptDialog");
      return;
      paramBundle = b();
      continue;
      paramBundle = c();
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */