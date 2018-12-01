package com.miui.touchassistant.c;

import miui.util.Log.Facade;

public class h
{
  public static void a(String paramString)
  {
    android.util.Log.d("TouchAssistant", paramString);
  }
  
  public static void a(String paramString, Exception paramException)
  {
    miui.util.Log.getFullLogger().error("TouchAssistant", paramString, paramException);
  }
  
  public static void b(String paramString)
  {
    miui.util.Log.getFullLogger().error("TouchAssistant", paramString);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */