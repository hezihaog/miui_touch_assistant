package com.a.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ag
{
  /* Error */
  public static String a(Context paramContext, String paramString, Map paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +13 -> 28
    //   18: new 18	java/lang/IllegalArgumentException
    //   21: dup
    //   22: ldc 20
    //   24: invokespecial 24	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: new 26	java/net/URL
    //   31: astore 7
    //   33: aload 7
    //   35: aload_1
    //   36: invokespecial 27	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: aload 7
    //   42: invokestatic 30	com/a/a/a/a/ag:a	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   45: astore 7
    //   47: aload 7
    //   49: sipush 10000
    //   52: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   55: aload 7
    //   57: sipush 15000
    //   60: invokevirtual 39	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   63: aload 7
    //   65: ldc 41
    //   67: invokevirtual 44	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: invokestatic 47	com/a/a/a/a/ag:a	(Ljava/util/Map;)Ljava/lang/String;
    //   74: astore_0
    //   75: aload_0
    //   76: ifnonnull +48 -> 124
    //   79: new 18	java/lang/IllegalArgumentException
    //   82: astore_0
    //   83: aload_0
    //   84: ldc 49
    //   86: invokespecial 24	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: athrow
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_1
    //   94: aload 4
    //   96: astore_0
    //   97: aload_1
    //   98: astore_2
    //   99: aload_3
    //   100: athrow
    //   101: astore_3
    //   102: aload_0
    //   103: astore_1
    //   104: aload_3
    //   105: astore_0
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 55	java/io/OutputStream:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 58	java/io/BufferedReader:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: aload 7
    //   126: iconst_1
    //   127: invokevirtual 62	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   130: aload_0
    //   131: invokevirtual 68	java/lang/String:getBytes	()[B
    //   134: astore 8
    //   136: aload 7
    //   138: invokevirtual 72	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   141: astore_1
    //   142: aload 6
    //   144: astore_0
    //   145: aload_1
    //   146: astore_2
    //   147: aload_1
    //   148: aload 8
    //   150: iconst_0
    //   151: aload 8
    //   153: arraylength
    //   154: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   157: aload 6
    //   159: astore_0
    //   160: aload_1
    //   161: astore_2
    //   162: aload_1
    //   163: invokevirtual 79	java/io/OutputStream:flush	()V
    //   166: aload 6
    //   168: astore_0
    //   169: aload_1
    //   170: astore_2
    //   171: aload_1
    //   172: invokevirtual 55	java/io/OutputStream:close	()V
    //   175: aload 7
    //   177: invokevirtual 83	java/net/HttpURLConnection:getResponseCode	()I
    //   180: pop
    //   181: new 85	java/io/InputStreamReader
    //   184: astore_0
    //   185: new 87	com/a/a/a/a/aj
    //   188: astore_1
    //   189: aload_1
    //   190: aload 7
    //   192: invokevirtual 91	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   195: invokespecial 94	com/a/a/a/a/aj:<init>	(Ljava/io/InputStream;)V
    //   198: aload_0
    //   199: aload_1
    //   200: invokespecial 95	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   203: new 57	java/io/BufferedReader
    //   206: dup
    //   207: aload_0
    //   208: invokespecial 98	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 102	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   216: astore_1
    //   217: new 104	java/lang/StringBuffer
    //   220: astore_3
    //   221: aload_3
    //   222: invokespecial 106	java/lang/StringBuffer:<init>	()V
    //   225: ldc 108
    //   227: invokestatic 114	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore_2
    //   231: aload_1
    //   232: ifnull +23 -> 255
    //   235: aload_3
    //   236: aload_1
    //   237: invokevirtual 118	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   240: pop
    //   241: aload_3
    //   242: aload_2
    //   243: invokevirtual 118	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   246: pop
    //   247: aload_0
    //   248: invokevirtual 102	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   251: astore_1
    //   252: goto -21 -> 231
    //   255: aload_3
    //   256: invokevirtual 121	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   259: astore_1
    //   260: aload_0
    //   261: invokevirtual 58	java/io/BufferedReader:close	()V
    //   264: iconst_0
    //   265: ifeq +11 -> 276
    //   268: new 123	java/lang/NullPointerException
    //   271: dup
    //   272: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   275: athrow
    //   276: iconst_0
    //   277: ifeq +11 -> 288
    //   280: new 123	java/lang/NullPointerException
    //   283: dup
    //   284: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   287: athrow
    //   288: aload_1
    //   289: areturn
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_1
    //   293: aload 5
    //   295: astore 4
    //   297: aload 4
    //   299: astore_0
    //   300: aload_1
    //   301: astore_2
    //   302: new 8	java/io/IOException
    //   305: astore 5
    //   307: aload 4
    //   309: astore_0
    //   310: aload_1
    //   311: astore_2
    //   312: aload 5
    //   314: aload_3
    //   315: invokevirtual 127	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   318: invokespecial 128	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   321: aload 4
    //   323: astore_0
    //   324: aload_1
    //   325: astore_2
    //   326: aload 5
    //   328: athrow
    //   329: astore_1
    //   330: goto -208 -> 122
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_2
    //   336: aload_3
    //   337: astore_1
    //   338: goto -232 -> 106
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_3
    //   344: aload_0
    //   345: astore_2
    //   346: aload_1
    //   347: astore_0
    //   348: aload_2
    //   349: astore_1
    //   350: aload_3
    //   351: astore_2
    //   352: goto -246 -> 106
    //   355: astore_3
    //   356: aload 5
    //   358: astore 4
    //   360: goto -63 -> 297
    //   363: astore_3
    //   364: aconst_null
    //   365: astore_1
    //   366: aload_0
    //   367: astore 4
    //   369: goto -72 -> 297
    //   372: astore_3
    //   373: aload 4
    //   375: astore_0
    //   376: goto -279 -> 97
    //   379: astore_3
    //   380: aconst_null
    //   381: astore_1
    //   382: goto -285 -> 97
    //   385: astore_0
    //   386: goto -98 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramContext	Context
    //   0	389	1	paramString	String
    //   0	389	2	paramMap	Map
    //   4	1	3	localObject1	Object
    //   91	9	3	localIOException1	IOException
    //   101	4	3	localObject2	Object
    //   220	36	3	localStringBuffer	StringBuffer
    //   290	47	3	localThrowable1	Throwable
    //   343	8	3	localObject3	Object
    //   355	1	3	localThrowable2	Throwable
    //   363	1	3	localThrowable3	Throwable
    //   372	1	3	localIOException2	IOException
    //   379	1	3	localIOException3	IOException
    //   9	365	4	localObject4	Object
    //   6	351	5	localIOException4	IOException
    //   1	166	6	localObject5	Object
    //   31	160	7	localObject6	Object
    //   134	18	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	75	91	java/io/IOException
    //   79	91	91	java/io/IOException
    //   124	142	91	java/io/IOException
    //   175	212	91	java/io/IOException
    //   99	101	101	finally
    //   147	157	101	finally
    //   162	166	101	finally
    //   171	175	101	finally
    //   302	307	101	finally
    //   312	321	101	finally
    //   326	329	101	finally
    //   28	75	290	java/lang/Throwable
    //   79	91	290	java/lang/Throwable
    //   124	142	290	java/lang/Throwable
    //   175	212	290	java/lang/Throwable
    //   110	114	329	java/io/IOException
    //   118	122	329	java/io/IOException
    //   28	75	333	finally
    //   79	91	333	finally
    //   124	142	333	finally
    //   175	212	333	finally
    //   212	231	341	finally
    //   235	252	341	finally
    //   255	264	341	finally
    //   147	157	355	java/lang/Throwable
    //   162	166	355	java/lang/Throwable
    //   171	175	355	java/lang/Throwable
    //   212	231	363	java/lang/Throwable
    //   235	252	363	java/lang/Throwable
    //   255	264	363	java/lang/Throwable
    //   147	157	372	java/io/IOException
    //   162	166	372	java/io/IOException
    //   171	175	372	java/io/IOException
    //   212	231	379	java/io/IOException
    //   235	252	379	java/io/IOException
    //   255	264	379	java/io/IOException
    //   268	276	385	java/io/IOException
    //   280	288	385	java/io/IOException
  }
  
  public static String a(URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol()).append("://").append("10.0.0.172").append(paramURL.getPath());
    if (!TextUtils.isEmpty(paramURL.getQuery())) {
      localStringBuilder.append("?").append(paramURL.getQuery());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Map paramMap)
  {
    StringBuffer localStringBuffer;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localStringBuffer = new StringBuffer();
      Iterator localIterator = paramMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label130;
        }
        paramMap = (Entry)localIterator.next();
        if ((paramMap.getKey() != null) && (paramMap.getValue() != null)) {
          try
          {
            localStringBuffer.append(URLEncoder.encode((String)paramMap.getKey(), "UTF-8"));
            localStringBuffer.append("=");
            localStringBuffer.append(URLEncoder.encode((String)paramMap.getValue(), "UTF-8"));
            localStringBuffer.append("&");
          }
          catch (UnsupportedEncodingException paramMap)
          {
            paramMap = null;
          }
        }
      }
      return paramMap;
      label130:
      if (localStringBuffer.length() <= 0) {
        break label161;
      }
    }
    label161:
    for (paramMap = localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);; paramMap = localStringBuffer)
    {
      paramMap = paramMap.toString();
      break;
      paramMap = null;
      break;
    }
  }
  
  public static HttpURLConnection a(Context paramContext, URL paramURL)
  {
    if (!"http".equals(paramURL.getProtocol())) {
      paramContext = (HttpURLConnection)paramURL.openConnection();
    }
    for (;;)
    {
      return paramContext;
      if (d(paramContext))
      {
        paramContext = (HttpURLConnection)paramURL.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
      }
      else if (!c(paramContext))
      {
        paramContext = (HttpURLConnection)paramURL.openConnection();
      }
      else
      {
        String str = paramURL.getHost();
        paramContext = (HttpURLConnection)new URL(a(paramURL)).openConnection();
        paramContext.addRequestProperty("X-Online-Host", str);
      }
    }
  }
  
  public static void a(Object paramObject)
  {
    try
    {
      paramObject.notifyAll();
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    boolean bool = true;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)b.a().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo != null) {
      if (localNetworkInfo.getType() != 1) {}
    }
    for (;;)
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (!localConnectivityManager.isActiveNetworkMetered()) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      bool = false;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return bool;
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        if (1 == paramContext.getType())
        {
          bool = true;
          continue;
        }
        bool = false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static String b(Context paramContext)
  {
    if (a(paramContext)) {
      paramContext = "WIFI";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null) {
          break label43;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        paramContext = "";
      }
      continue;
      try
      {
        label43:
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          break label67;
        }
        paramContext = "";
      }
      catch (Exception paramContext)
      {
        paramContext = "";
      }
      continue;
      label67:
      paramContext = (paramContext.getTypeName() + "-" + paramContext.getSubtypeName() + "-" + paramContext.getExtraInfo()).toLowerCase();
    }
  }
  
  public static String b(Context paramContext, String paramString, Map paramMap)
  {
    paramContext = null;
    if (com.a.a.a.b.a()) {
      if (!a()) {}
    }
    for (;;)
    {
      try
      {
        paramContext = c(b.a(), paramString, paramMap);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new IOException("exception thrown from IPC." + paramContext.getMessage());
      }
      paramContext = a(b.a(), paramString, paramMap);
    }
  }
  
  /* Error */
  private static void b(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc2_w 331
    //   6: invokevirtual 336	java/lang/Object:wait	(J)V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    //   17: astore_1
    //   18: goto -9 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	21	0	paramObject	Object
    //   12	4	1	localObject	Object
    //   17	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   9	11	12	finally
    //   13	15	12	finally
    //   2	9	17	java/lang/InterruptedException
  }
  
  public static String c(Context paramContext, String paramString, Map paramMap)
  {
    ae localae = new ae();
    Intent localIntent = new Intent();
    localIntent.setClassName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.HttpService");
    Object localObject = new Object();
    ak localak = new ak();
    if (paramContext.bindService(localIntent, new ah(localae, localObject, localak, paramString, paramMap, paramContext), 1)) {
      b(localObject);
    }
    return localak.a;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        bool1 = bool2;
        if (paramContext != null) {
          try
          {
            paramContext = paramContext.getActiveNetworkInfo();
            bool1 = bool2;
            if (paramContext != null)
            {
              paramContext = paramContext.getExtraInfo();
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramContext))
              {
                bool1 = bool2;
                if (paramContext.length() >= 3)
                {
                  bool1 = bool2;
                  if (!paramContext.contains("ctwap")) {
                    bool1 = paramContext.regionMatches(true, paramContext.length() - 3, "wap", 0, 3);
                  }
                }
              }
            }
          }
          catch (Exception paramContext)
          {
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramContext)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool;
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null) {
          break label52;
        }
        bool = false;
      }
      catch (Exception paramContext)
      {
        bool = false;
      }
      continue;
      try
      {
        label52:
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          break label72;
        }
        bool = false;
      }
      catch (Exception paramContext)
      {
        bool = false;
      }
      continue;
      label72:
      paramContext = paramContext.getExtraInfo();
      if ((TextUtils.isEmpty(paramContext)) || (paramContext.length() < 3)) {
        bool = false;
      } else if (paramContext.contains("ctwap")) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */