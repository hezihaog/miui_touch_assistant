package com.a.a.a.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  private static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  
  public static boolean a(String paramString)
  {
    return a.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    return c.matcher(paramString).matches();
  }
  
  public static boolean d(String paramString)
  {
    if ((b(paramString)) || (c(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */