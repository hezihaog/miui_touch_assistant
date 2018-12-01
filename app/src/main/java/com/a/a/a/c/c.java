package com.a.a.a.c;

import android.os.SystemClock;
import com.a.a.a.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class c
  extends HttpURLConnection
{
  private String a = null;
  private long b = SystemClock.elapsedRealtime();
  private long c;
  private long d;
  private int e = -1;
  private boolean f = false;
  private String g = null;
  private h h;
  private g i;
  private HttpURLConnection j;
  
  public c(HttpURLConnection paramHttpURLConnection)
  {
    super(paramHttpURLConnection.getURL());
    this.j = paramHttpURLConnection;
  }
  
  private boolean a(String paramString)
  {
    if ((b.a(paramString)) || (b.d(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int c()
  {
    int m = 0;
    if (this.i != null) {}
    for (int k = this.i.a();; k = 0)
    {
      if (this.h != null) {
        m = this.h.a();
      }
      return k + 1100 + m + getURL().toString().getBytes().length;
    }
  }
  
  private void d()
  {
    String str = this.url.getHost();
    if ((this.g == null) && (str != null) && (!a(str))) {
      a.a().execute(new d(this));
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/a/a/a/c/c:g	Ljava/lang/String;
    //   6: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +12 -> 21
    //   12: aload_0
    //   13: getfield 36	com/a/a/a/c/c:f	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 89	com/a/a/a/c/c:url	Ljava/net/URL;
    //   28: invokevirtual 92	java/net/URL:getHost	()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 38	com/a/a/a/c/c:g	Ljava/lang/String;
    //   36: ifnonnull -15 -> 21
    //   39: aload_2
    //   40: ifnull -19 -> 21
    //   43: aload_0
    //   44: aload_2
    //   45: invokespecial 93	com/a/a/a/c/c:a	(Ljava/lang/String;)Z
    //   48: istore_1
    //   49: iload_1
    //   50: ifne -29 -> 21
    //   53: aload_0
    //   54: aload_2
    //   55: invokestatic 122	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   58: invokevirtual 125	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   61: putfield 38	com/a/a/a/c/c:g	Ljava/lang/String;
    //   64: goto -43 -> 21
    //   67: astore_2
    //   68: new 127	com/a/a/a/a/ae
    //   71: astore_3
    //   72: aload_3
    //   73: invokespecial 129	com/a/a/a/a/ae:<init>	()V
    //   76: aload_3
    //   77: ldc -125
    //   79: aload_2
    //   80: invokevirtual 134	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: goto -62 -> 21
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	c
    //   16	34	1	bool	boolean
    //   31	24	2	str	String
    //   67	13	2	localException	Exception
    //   86	4	2	localObject	Object
    //   71	6	3	localae	com.a.a.a.a.ae
    // Exception table:
    //   from	to	target	type
    //   53	64	67	java/lang/Exception
    //   2	17	86	finally
    //   24	39	86	finally
    //   43	49	86	finally
    //   53	64	86	finally
    //   68	83	86	finally
  }
  
  private int f()
  {
    int m = -1;
    int k;
    if (this.e != -1) {
      k = this.e;
    }
    for (;;)
    {
      return k;
      try
      {
        k = this.j.getResponseCode();
      }
      catch (Exception localException)
      {
        k = m;
      }
    }
  }
  
  private void g()
  {
    try
    {
      if (this.c == 0L)
      {
        this.c = SystemClock.elapsedRealtime();
        this.b = this.c;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void h()
  {
    try
    {
      if ((this.d == 0L) && (this.c != 0L)) {
        this.d = (SystemClock.elapsedRealtime() - this.c);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  void a(Exception paramException)
  {
    if (!this.f)
    {
      this.f = true;
      paramException = new com.a.a.a.b.a(getURL().toString(), -1L, f(), paramException.getClass().getSimpleName());
      paramException.c(this.g);
      paramException.b(this.a);
      y.a().a(paramException);
    }
  }
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.j.addRequestProperty(paramString1, paramString2);
  }
  
  void b()
  {
    if (!this.f)
    {
      this.f = true;
      com.a.a.a.b.a locala = new com.a.a.a.b.a(getURL().toString(), SystemClock.elapsedRealtime() - this.b, c(), f());
      locala.c(this.g);
      locala.a(this.d);
      locala.b(this.a);
      y.a().a(locala);
    }
  }
  
  public void connect()
  {
    try
    {
      this.j.connect();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void disconnect()
  {
    this.j.disconnect();
    b();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.j.getAllowUserInteraction();
  }
  
  public int getConnectTimeout()
  {
    return this.j.getConnectTimeout();
  }
  
  public Object getContent()
  {
    try
    {
      Object localObject = this.j.getContent();
      return localObject;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Object getContent(Class[] paramArrayOfClass)
  {
    try
    {
      paramArrayOfClass = this.j.getContent(paramArrayOfClass);
      return paramArrayOfClass;
    }
    catch (IOException paramArrayOfClass)
    {
      a(paramArrayOfClass);
      throw paramArrayOfClass;
    }
  }
  
  public String getContentEncoding()
  {
    return this.j.getContentEncoding();
  }
  
  public int getContentLength()
  {
    return this.j.getContentLength();
  }
  
  public String getContentType()
  {
    return this.j.getContentType();
  }
  
  public long getDate()
  {
    return this.j.getDate();
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.j.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.j.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.j.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    return this.j.getErrorStream();
  }
  
  public long getExpiration()
  {
    return this.j.getExpiration();
  }
  
  public String getHeaderField(int paramInt)
  {
    return this.j.getHeaderField(paramInt);
  }
  
  public String getHeaderField(String paramString)
  {
    return this.j.getHeaderField(paramString);
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    return this.j.getHeaderFieldDate(paramString, paramLong);
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    return this.j.getHeaderFieldInt(paramString, paramInt);
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    return this.j.getHeaderFieldKey(paramInt);
  }
  
  public Map getHeaderFields()
  {
    return this.j.getHeaderFields();
  }
  
  public long getIfModifiedSince()
  {
    return this.j.getIfModifiedSince();
  }
  
  public InputStream getInputStream()
  {
    try
    {
      g();
      g localg = new com/a/a/a/c/g;
      localg.<init>(this, this.j.getInputStream());
      this.i = localg;
      h();
      d();
      localg = this.i;
      return localg;
    }
    catch (IOException localIOException)
    {
      e();
      a(localIOException);
      throw localIOException;
    }
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.j.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    return this.j.getLastModified();
  }
  
  public OutputStream getOutputStream()
  {
    try
    {
      g();
      h localh = new com/a/a/a/c/h;
      localh.<init>(this, this.j.getOutputStream());
      this.h = localh;
      h();
      d();
      localh = this.h;
      return localh;
    }
    catch (IOException localIOException)
    {
      e();
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Permission getPermission()
  {
    try
    {
      Permission localPermission = this.j.getPermission();
      return localPermission;
    }
    catch (ProtocolException localProtocolException)
    {
      a(localProtocolException);
      throw localProtocolException;
    }
  }
  
  public int getReadTimeout()
  {
    return this.j.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    return this.j.getRequestMethod();
  }
  
  public Map getRequestProperties()
  {
    return this.j.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.j.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
  {
    try
    {
      g();
      this.e = this.j.getResponseCode();
      h();
      int k = this.e;
      return k;
    }
    catch (ProtocolException localProtocolException)
    {
      a(localProtocolException);
      throw localProtocolException;
    }
  }
  
  public String getResponseMessage()
  {
    try
    {
      String str = this.j.getResponseMessage();
      return str;
    }
    catch (ProtocolException localProtocolException)
    {
      a(localProtocolException);
      throw localProtocolException;
    }
  }
  
  public URL getURL()
  {
    return this.j.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.j.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.j.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.j.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.j.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.j.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.j.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.j.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.j.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    try
    {
      this.j.getClass().getDeclaredMethod("setFixedLengthStreamingMode", new Class[] { Long.TYPE }).invoke(this.j, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Exception localException)
    {
      throw new UnsupportedOperationException(localException);
    }
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.j.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.j.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.j.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    try
    {
      this.j.setRequestMethod(paramString);
      return;
    }
    catch (ProtocolException paramString)
    {
      a(paramString);
      throw paramString;
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    if ("x-mistats-header".equals(paramString1)) {
      this.a = paramString2;
    }
    this.j.setRequestProperty(paramString1, paramString2);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.j.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.j.toString();
  }
  
  public boolean usingProxy()
  {
    return this.j.usingProxy();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */