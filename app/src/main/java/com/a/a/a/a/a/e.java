package com.a.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.a.a;
import com.a.a.a.a.ae;
import com.a.a.a.a.ag;
import com.a.a.a.a.am;
import com.a.a.a.a.b;
import com.a.a.a.a.t;
import com.a.a.a.a.v;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class e
  implements t
{
  private f a;
  private String b;
  
  public e(String paramString, f paramf)
  {
    this.a = paramf;
    this.b = paramString;
  }
  
  private boolean a(ae paramae, String paramString)
  {
    paramae.a("Upload MiStat data complete, result=" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramae = new JSONObject(paramString);
      if ("ok".equals(paramae.getString("status"))) {
        if (paramae.has("data"))
        {
          paramae = paramae.getJSONObject("data");
          if (paramae.has("delay")) {
            am.a(paramae.getLong("delay"));
          }
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    bool2 = false;
    localae = new ae();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("app_id", b.b());
    localTreeMap.put("app_key", b.c());
    localTreeMap.put("device_id", new v().a());
    localTreeMap.put("channel", b.d());
    String str = b.e();
    if (!TextUtils.isEmpty(str)) {
      localTreeMap.put("version", str);
    }
    localTreeMap.put("stat_value", this.b);
    for (;;)
    {
      try
      {
        Context localContext = b.a();
        if (!a.a()) {
          continue;
        }
        str = "http://10.235.124.13:8097/mistats";
        bool1 = a(localae, ag.b(localContext, str, localTreeMap));
      }
      catch (Exception localException)
      {
        localae.a("Upload MiStat data failed", localException);
        boolean bool1 = bool2;
        continue;
      }
      this.a.a(bool1);
      return;
      str = "https://data.mistat.xiaomi.com/mistats";
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */