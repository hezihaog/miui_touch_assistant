package com.miui.touchassistant.settings;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
{
  private static String b(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("string_list:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(Base64.encodeToString(((String)paramList.next()).getBytes(), 2));
      localStringBuilder.append('|');
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  private static List b(String paramString)
  {
    if (paramString.startsWith("string_list:"))
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = paramString.substring("string_list:".length()).split("\\|");
      int j = arrayOfString.length;
      for (int i = 0;; i++)
      {
        paramString = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(new String(Base64.decode(arrayOfString[i], 2)));
      }
    }
    paramString = null;
    return paramString;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/settings/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */