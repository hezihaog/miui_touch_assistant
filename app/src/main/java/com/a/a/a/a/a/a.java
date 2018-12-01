package com.a.a.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.a.a.a.a.ac;
import com.a.a.a.a.ae;
import com.a.a.a.a.al;
import com.a.a.a.a.am;
import com.a.a.a.a.b;
import com.a.a.a.a.t;
import com.a.a.a.a.v;
import com.a.a.a.b.c;
import com.a.a.a.b.f;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class a
  implements t
{
  public static String a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(b(paramString));
        BigInteger localBigInteger = new java/math/BigInteger;
        localBigInteger.<init>(1, ((MessageDigest)localObject).digest());
        localObject = String.format("%1$032X", new Object[] { localBigInteger });
        paramString = (String)localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        continue;
      }
      return paramString;
      paramString = null;
    }
  }
  
  private static byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return paramString;
  }
  
  public void a()
  {
    Context localContext = b.a();
    if (!al.a(localContext, "basic_info_reported"))
    {
      a(localContext);
      al.b(localContext, "basic_info_reported", 1);
      new am().a();
    }
    String str1 = b.e();
    String str2 = al.a(localContext, "basic_info_version", "");
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
      ac.a(new c("mistat_basic", "upgrade"));
    }
    al.b(localContext, "basic_info_version", str1);
  }
  
  public void a(Context paramContext)
  {
    ac.a(new c("mistat_basic", "new"));
    ac.a(new f("mistat_basic", "model", Build.MODEL));
    ac.a(new f("mistat_basic", "OS", "android" + VERSION.SDK_INT));
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    if (!TextUtils.isEmpty(((TelephonyManager)localObject).getNetworkOperatorName())) {
      ac.a(new f("mistat_basic", "operator", ((TelephonyManager)localObject).getSimOperator()));
    }
    localObject = v.b(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ac.a(new f("mistat_basic", "imei_md5", a((String)localObject)));
    }
    try
    {
      localObject = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getMacAddress();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            f localf = new com/a/a/a/b/f;
            localf.<init>("mistat_basic", "mac_md5", a((String)localObject));
            ac.a(localf);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int j;
        int i;
        new ae().a("", localThrowable);
        continue;
        paramContext = i + "x" + j;
      }
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext != null)
    {
      j = paramContext.widthPixels;
      i = paramContext.heightPixels;
      if (j < i)
      {
        paramContext = j + "x" + i;
        ac.a(new f("mistat_basic", "resolution", paramContext));
      }
    }
    else
    {
      ac.a(new f("mistat_basic", "locale", Locale.getDefault().toString()));
      return;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */