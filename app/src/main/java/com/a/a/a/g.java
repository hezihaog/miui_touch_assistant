package com.a.a.a;

import java.net.URLStreamHandler;

class g
  extends URLStreamHandler
{
  private URLStreamHandler a;
  
  public g(URLStreamHandler paramURLStreamHandler)
  {
    this.a = paramURLStreamHandler;
  }
  
  /* Error */
  protected java.net.URLConnection openConnection(java.net.URL paramURL)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: ldc 4
    //   6: ldc 25
    //   8: iconst_1
    //   9: anewarray 27	java/lang/Class
    //   12: dup
    //   13: iconst_0
    //   14: ldc 29
    //   16: aastore
    //   17: invokevirtual 33	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   20: astore 4
    //   22: aload 4
    //   24: iconst_1
    //   25: invokevirtual 39	java/lang/reflect/Method:setAccessible	(Z)V
    //   28: aload 4
    //   30: aload_0
    //   31: getfield 13	com/a/a/a/g:a	Ljava/net/URLStreamHandler;
    //   34: iconst_1
    //   35: anewarray 41	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: invokevirtual 45	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 47	java/net/URLConnection
    //   48: astore 5
    //   50: aload 5
    //   52: instanceof 49
    //   55: ifeq +27 -> 82
    //   58: new 51	com/a/a/a/c/e
    //   61: astore 4
    //   63: aload 4
    //   65: aload 5
    //   67: checkcast 49	javax/net/ssl/HttpsURLConnection
    //   70: invokespecial 54	com/a/a/a/c/e:<init>	(Ljavax/net/ssl/HttpsURLConnection;)V
    //   73: aload 4
    //   75: lload_2
    //   76: invokevirtual 57	com/a/a/a/c/e:a	(J)V
    //   79: aload 4
    //   81: areturn
    //   82: aload 5
    //   84: astore 4
    //   86: aload 5
    //   88: instanceof 59
    //   91: ifeq -12 -> 79
    //   94: new 61	com/a/a/a/c/c
    //   97: astore 4
    //   99: aload 4
    //   101: aload 5
    //   103: checkcast 59	java/net/HttpURLConnection
    //   106: invokespecial 64	com/a/a/a/c/c:<init>	(Ljava/net/HttpURLConnection;)V
    //   109: aload 4
    //   111: lload_2
    //   112: invokevirtual 65	com/a/a/a/c/c:a	(J)V
    //   115: goto -36 -> 79
    //   118: astore 4
    //   120: invokestatic 70	com/a/a/a/a/y:a	()Lcom/a/a/a/a/y;
    //   123: new 72	com/a/a/a/b/a
    //   126: dup
    //   127: aload_1
    //   128: invokevirtual 76	java/net/URL:toString	()Ljava/lang/String;
    //   131: aload 4
    //   133: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: invokevirtual 83	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   139: invokespecial 86	com/a/a/a/b/a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: invokevirtual 89	com/a/a/a/a/y:a	(Lcom/a/a/a/b/a;)V
    //   145: new 91	java/io/IOException
    //   148: dup
    //   149: invokespecial 92	java/io/IOException:<init>	()V
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	g
    //   0	153	1	paramURL	java.net.URL
    //   3	109	2	l	long
    //   20	90	4	localObject	Object
    //   118	14	4	localException	Exception
    //   48	54	5	localURLConnection	java.net.URLConnection
    // Exception table:
    //   from	to	target	type
    //   0	79	118	java/lang/Exception
    //   86	115	118	java/lang/Exception
  }
  
  /* Error */
  protected java.net.URLConnection openConnection(java.net.URL paramURL, java.net.Proxy paramProxy)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: ldc 4
    //   6: ldc 25
    //   8: iconst_2
    //   9: anewarray 27	java/lang/Class
    //   12: dup
    //   13: iconst_0
    //   14: ldc 29
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: ldc 95
    //   21: aastore
    //   22: invokevirtual 33	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: astore 5
    //   27: aload 5
    //   29: iconst_1
    //   30: invokevirtual 39	java/lang/reflect/Method:setAccessible	(Z)V
    //   33: aload 5
    //   35: aload_0
    //   36: getfield 13	com/a/a/a/g:a	Ljava/net/URLStreamHandler;
    //   39: iconst_2
    //   40: anewarray 41	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_2
    //   50: aastore
    //   51: invokevirtual 45	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 47	java/net/URLConnection
    //   57: astore 5
    //   59: aload 5
    //   61: instanceof 49
    //   64: ifeq +23 -> 87
    //   67: new 51	com/a/a/a/c/e
    //   70: astore_2
    //   71: aload_2
    //   72: aload 5
    //   74: checkcast 49	javax/net/ssl/HttpsURLConnection
    //   77: invokespecial 54	com/a/a/a/c/e:<init>	(Ljavax/net/ssl/HttpsURLConnection;)V
    //   80: aload_2
    //   81: lload_3
    //   82: invokevirtual 57	com/a/a/a/c/e:a	(J)V
    //   85: aload_2
    //   86: areturn
    //   87: aload 5
    //   89: astore_2
    //   90: aload 5
    //   92: instanceof 59
    //   95: ifeq -10 -> 85
    //   98: new 61	com/a/a/a/c/c
    //   101: astore_2
    //   102: aload_2
    //   103: aload 5
    //   105: checkcast 59	java/net/HttpURLConnection
    //   108: invokespecial 64	com/a/a/a/c/c:<init>	(Ljava/net/HttpURLConnection;)V
    //   111: aload_2
    //   112: lload_3
    //   113: invokevirtual 65	com/a/a/a/c/c:a	(J)V
    //   116: goto -31 -> 85
    //   119: astore_2
    //   120: invokestatic 70	com/a/a/a/a/y:a	()Lcom/a/a/a/a/y;
    //   123: new 72	com/a/a/a/b/a
    //   126: dup
    //   127: aload_1
    //   128: invokevirtual 76	java/net/URL:toString	()Ljava/lang/String;
    //   131: aload_2
    //   132: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   135: invokevirtual 83	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   138: invokespecial 86	com/a/a/a/b/a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: invokevirtual 89	com/a/a/a/a/y:a	(Lcom/a/a/a/b/a;)V
    //   144: new 91	java/io/IOException
    //   147: dup
    //   148: invokespecial 92	java/io/IOException:<init>	()V
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	g
    //   0	152	1	paramURL	java.net.URL
    //   0	152	2	paramProxy	java.net.Proxy
    //   3	110	3	l	long
    //   25	79	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	85	119	java/lang/Exception
    //   90	116	119	java/lang/Exception
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */