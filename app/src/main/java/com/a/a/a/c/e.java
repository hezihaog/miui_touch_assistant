package com.a.a.a.c;

import android.os.SystemClock;
import com.a.a.a.a.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class e
  extends HttpsURLConnection
{
  private String a = null;
  private long b;
  private long c;
  private long d;
  private int e = -1;
  private boolean f = false;
  private String g = null;
  private HttpsURLConnection h;
  
  public e(HttpsURLConnection paramHttpsURLConnection)
  {
    super(paramHttpsURLConnection.getURL());
    this.h = paramHttpsURLConnection;
    this.b = SystemClock.elapsedRealtime();
  }
  
  private boolean a(String paramString)
  {
    if ((b.a(paramString)) || (b.d(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    String str = this.url.getHost();
    if ((this.g == null) && (str != null) && (!a(str))) {
      a.a().execute(new f(this));
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/a/a/a/c/e:g	Ljava/lang/String;
    //   6: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +12 -> 21
    //   12: aload_0
    //   13: getfield 32	com/a/a/a/c/e:f	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 60	com/a/a/a/c/e:url	Ljava/net/URL;
    //   28: invokevirtual 66	java/net/URL:getHost	()Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 34	com/a/a/a/c/e:g	Ljava/lang/String;
    //   36: ifnonnull -15 -> 21
    //   39: aload_2
    //   40: ifnull -19 -> 21
    //   43: aload_0
    //   44: aload_2
    //   45: invokespecial 67	com/a/a/a/c/e:a	(Ljava/lang/String;)Z
    //   48: istore_1
    //   49: iload_1
    //   50: ifne -29 -> 21
    //   53: aload_0
    //   54: aload_2
    //   55: invokestatic 96	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   58: invokevirtual 99	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   61: putfield 34	com/a/a/a/c/e:g	Ljava/lang/String;
    //   64: goto -43 -> 21
    //   67: astore_3
    //   68: new 101	com/a/a/a/a/ae
    //   71: astore_2
    //   72: aload_2
    //   73: invokespecial 103	com/a/a/a/a/ae:<init>	()V
    //   76: aload_2
    //   77: ldc 105
    //   79: aload_3
    //   80: invokevirtual 108	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: goto -62 -> 21
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	e
    //   16	34	1	bool	boolean
    //   31	46	2	localObject1	Object
    //   86	4	2	localObject2	Object
    //   67	13	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   53	64	67	java/lang/Exception
    //   2	17	86	finally
    //   24	39	86	finally
    //   43	49	86	finally
    //   53	64	86	finally
    //   68	83	86	finally
  }
  
  private int e()
  {
    int j = -1;
    int i;
    if (this.e != -1) {
      i = this.e;
    }
    for (;;)
    {
      return i;
      try
      {
        i = this.h.getResponseCode();
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
  }
  
  private void f()
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
  
  private void g()
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
      paramException = new com.a.a.a.b.a(getURL().toString(), -1L, e(), paramException.getClass().getSimpleName());
      paramException.c(this.g);
      paramException.b(this.a);
      y.a().a(paramException);
    }
  }
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.h.addRequestProperty(paramString1, paramString2);
  }
  
  public void b()
  {
    if (!this.f)
    {
      this.f = true;
      com.a.a.a.b.a locala = new com.a.a.a.b.a(getURL().toString(), SystemClock.elapsedRealtime() - this.b, 0L, e());
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
      this.h.connect();
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
    this.h.disconnect();
    b();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.h.getAllowUserInteraction();
  }
  
  public String getCipherSuite()
  {
    return this.h.getCipherSuite();
  }
  
  public int getConnectTimeout()
  {
    return this.h.getConnectTimeout();
  }
  
  public Object getContent()
  {
    return this.h.getContent();
  }
  
  public Object getContent(Class[] paramArrayOfClass)
  {
    try
    {
      paramArrayOfClass = this.h.getContent(paramArrayOfClass);
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
    return this.h.getContentEncoding();
  }
  
  public int getContentLength()
  {
    return this.h.getContentLength();
  }
  
  public String getContentType()
  {
    return this.h.getContentType();
  }
  
  public long getDate()
  {
    return this.h.getDate();
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.h.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.h.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.h.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    return this.h.getErrorStream();
  }
  
  public long getExpiration()
  {
    return this.h.getExpiration();
  }
  
  public String getHeaderField(int paramInt)
  {
    return this.h.getHeaderField(paramInt);
  }
  
  public String getHeaderField(String paramString)
  {
    return this.h.getHeaderField(paramString);
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    return this.h.getHeaderFieldDate(paramString, paramLong);
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    return this.h.getHeaderFieldInt(paramString, paramInt);
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    return this.h.getHeaderFieldKey(paramInt);
  }
  
  public Map getHeaderFields()
  {
    return this.h.getHeaderFields();
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.h.getHostnameVerifier();
  }
  
  public long getIfModifiedSince()
  {
    return this.h.getIfModifiedSince();
  }
  
  public InputStream getInputStream()
  {
    try
    {
      f();
      g localg = new com/a/a/a/c/g;
      localg.<init>(this, this.h.getInputStream());
      g();
      c();
      return localg;
    }
    catch (IOException localIOException)
    {
      d();
      a(localIOException);
      throw localIOException;
    }
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.h.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    return this.h.getLastModified();
  }
  
  public Certificate[] getLocalCertificates()
  {
    return this.h.getLocalCertificates();
  }
  
  public Principal getLocalPrincipal()
  {
    return this.h.getLocalPrincipal();
  }
  
  public OutputStream getOutputStream()
  {
    try
    {
      f();
      h localh = new com/a/a/a/c/h;
      localh.<init>(this, this.h.getOutputStream());
      g();
      c();
      return localh;
    }
    catch (IOException localIOException)
    {
      d();
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Principal getPeerPrincipal()
  {
    try
    {
      Principal localPrincipal = this.h.getPeerPrincipal();
      return localPrincipal;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      a(localSSLPeerUnverifiedException);
      throw localSSLPeerUnverifiedException;
    }
  }
  
  public Permission getPermission()
  {
    try
    {
      Permission localPermission = this.h.getPermission();
      return localPermission;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public int getReadTimeout()
  {
    return this.h.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    return this.h.getRequestMethod();
  }
  
  public Map getRequestProperties()
  {
    return this.h.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.h.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
  {
    try
    {
      f();
      this.e = this.h.getResponseCode();
      g();
      int i = this.e;
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public String getResponseMessage()
  {
    try
    {
      String str = this.h.getResponseMessage();
      return str;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.h.getSSLSocketFactory();
  }
  
  public Certificate[] getServerCertificates()
  {
    try
    {
      Certificate[] arrayOfCertificate = this.h.getServerCertificates();
      return arrayOfCertificate;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      a(localSSLPeerUnverifiedException);
      throw localSSLPeerUnverifiedException;
    }
  }
  
  public URL getURL()
  {
    return this.h.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.h.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.h.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.h.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.h.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.h.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.h.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.h.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.h.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setFixedLengthStreamingMode(long paramLong)
  {
    try
    {
      this.h.getClass().getMethod("setFixedLengthStreamingMode", new Class[] { Long.TYPE }).invoke(this.h, new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Exception localException)
    {
      throw new UnsupportedOperationException(localException);
    }
  }
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.h.setHostnameVerifier(paramHostnameVerifier);
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.h.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.h.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.h.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    try
    {
      this.h.setRequestMethod(paramString);
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
    this.h.setRequestProperty(paramString1, paramString2);
  }
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.h.setSSLSocketFactory(paramSSLSocketFactory);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.h.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.h.toString();
  }
  
  public boolean usingProxy()
  {
    return this.h.usingProxy();
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */