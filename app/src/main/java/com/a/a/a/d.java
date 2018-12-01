package com.a.a.a;

import com.a.a.a.a.ae;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
{
  private static final Map a = new HashMap();
  private static final List b = new ArrayList();
  private static final List c = new ArrayList();
  private static final List d = new ArrayList();
  private static final List e = new ArrayList();
  private static Boolean f = null;
  
  static
  {
    b.add("file");
    b.add("ftp");
    b.add("http");
    b.add("https");
    b.add("jar");
    c.add("http");
  }
  
  public static boolean a()
  {
    boolean bool;
    if (f != null)
    {
      bool = f.booleanValue();
      return bool;
    }
    try
    {
      Iterator localIterator1 = b.iterator();
      while (localIterator1.hasNext())
      {
        new URL((String)localIterator1.next(), "www.xiaomi.com", "");
        continue;
        f = Boolean.valueOf(false);
      }
    }
    catch (Throwable localThrowable)
    {
      new ae().a("failed to enable url interceptor", localThrowable);
    }
    for (;;)
    {
      bool = f.booleanValue();
      break;
      Object localObject = URL.class.getDeclaredField("streamHandlers");
      ((Field)localObject).setAccessible(true);
      Hashtable localHashtable = (Hashtable)((Field)localObject).get(null);
      Iterator localIterator2 = b.iterator();
      while (localIterator2.hasNext())
      {
        localObject = (String)localIterator2.next();
        URLStreamHandler localURLStreamHandler = (URLStreamHandler)localHashtable.get(localObject);
        a.put(localObject, localURLStreamHandler);
      }
      localObject = new com/a/a/a/f;
      ((f)localObject).<init>();
      URL.setURLStreamHandlerFactory((URLStreamHandlerFactory)localObject);
      f = Boolean.valueOf(true);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */