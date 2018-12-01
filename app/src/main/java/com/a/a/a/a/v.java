package com.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class v
{
  private static String a;
  
  public static String a(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str;
    if (0 == 0) {
      str = b(paramContext);
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      localObject1 = localObject2;
      if (VERSION.SDK_INT > 8) {
        localObject1 = Build.SERIAL;
      }
      localObject1 = a(str + paramContext + (String)localObject1);
      return (String)localObject1;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  static String a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        Object localObject = MessageDigest.getInstance("SHA1");
        ((MessageDigest)localObject).update(c(paramString));
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
  
  public static String b(Context paramContext)
  {
    try
    {
      localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = localTelephonyManager.getDeviceId();
      i = 10;
    }
    catch (Throwable paramContext)
    {
      try
      {
        for (;;)
        {
          TelephonyManager localTelephonyManager;
          int i;
          Thread.sleep(500L);
          paramContext = localTelephonyManager.getDeviceId();
          i--;
        }
        for (;;)
        {
          return paramContext;
          paramContext = paramContext;
          paramContext = null;
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;) {}
      }
    }
    if ((paramContext != null) || (i <= 0)) {}
  }
  
  private static byte[] c(String paramString)
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
  
  public String a()
  {
    if (a != null) {}
    for (String str = a;; str = null)
    {
      return str;
      q.a().a(new w(b.a()));
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */