package com.a.a.a.b;

import com.a.a.a.a.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
  extends b
{
  protected long b;
  private String c;
  private String d;
  private Map e;
  
  public d(String paramString1, String paramString2, long paramLong, Map paramMap)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.b = paramLong;
    if (paramMap == null) {}
    for (this.e = null;; this.e = new HashMap(paramMap)) {
      return;
    }
  }
  
  private String a(Map paramMap)
  {
    JSONObject localJSONObject;
    if (paramMap != null) {
      try
      {
        if (!paramMap.isEmpty())
        {
          localJSONObject = new org/json/JSONObject;
          localJSONObject.<init>();
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, paramMap.get(str));
          }
        }
        paramMap = null;
      }
      catch (JSONException paramMap)
      {
        new ae().a("json error", paramMap);
      }
    }
    for (;;)
    {
      return paramMap;
      paramMap = localJSONObject.toString();
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public j b()
  {
    j localj = new j();
    localj.a = this.c;
    localj.c = this.d;
    localj.b = this.a;
    localj.d = c();
    localj.e = String.valueOf(this.b);
    localj.f = a(this.e);
    return localj;
  }
  
  public abstract String c();
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */