package com.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class y
{
  private static y a = new y();
  private a b = new z(this);
  private List c = new LinkedList();
  private Handler d = new aa(this, Looper.getMainLooper());
  
  public static y a()
  {
    return a;
  }
  
  private boolean a(List paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    Object localObject1;
    String str;
    while (paramList.hasNext())
    {
      localObject1 = (com.a.a.a.b.a)paramList.next();
      str = ((com.a.a.a.b.a)localObject1).a();
      if (!TextUtils.isEmpty(str)) {
        if (localHashMap.containsKey(str))
        {
          ((List)localHashMap.get(str)).add(localObject1);
        }
        else
        {
          localHashMap.put(str, new ArrayList());
          ((List)localHashMap.get(str)).add(localObject1);
        }
      }
    }
    if (!localHashMap.isEmpty())
    {
      localObject1 = new JSONArray();
      paramList = localHashMap.keySet().iterator();
      while (paramList.hasNext())
      {
        str = (String)paramList.next();
        JSONArray localJSONArray = new JSONArray();
        Object localObject2 = ((List)localHashMap.get(str)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localJSONArray.put(((com.a.a.a.b.a)((Iterator)localObject2).next()).c());
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("url", str);
        ((JSONObject)localObject2).put("data", localJSONArray);
        ((JSONArray)localObject1).put(localObject2);
      }
    }
    for (boolean bool = a(((JSONArray)localObject1).toString());; bool = false) {
      return bool;
    }
  }
  
  private String f()
  {
    if (com.a.a.a.a.a()) {}
    for (String str = "http://10.99.168.145:8097/realtime_network";; str = "https://data.mistat.xiaomi.com/realtime_network") {
      return str;
    }
  }
  
  public void a(com.a.a.a.b.a arg1)
  {
    Object localObject1 = b.a();
    if (localObject1 == null) {
      new ae().a("add http event without initialization.");
    }
    for (;;)
    {
      return;
      if (com.a.a.a.a.a((Context)localObject1))
      {
        new ae().a("disabled the http event upload");
        continue;
      }
      if ((???.a().equals(f())) && (!com.a.a.a.a.b())) {
        continue;
      }
      localObject1 = ???;
      if (this.b != null)
      {
        localObject1 = ???;
        if (!???.a().equals(f())) {
          localObject1 = this.b.a(???);
        }
      }
      if ((localObject1 == null) || (TextUtils.isEmpty(((com.a.a.a.b.a)localObject1).a()))) {
        continue;
      }
      synchronized (this.c)
      {
        this.c.add(localObject1);
        if (this.c.size() > 100) {
          this.c.remove(0);
        }
        if ((this.d.hasMessages(1023)) || (((com.a.a.a.b.a)localObject1).a().equals(f()))) {
          continue;
        }
        this.d.sendEmptyMessageDelayed(1023, e());
      }
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("data"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      int i = paramJSONObject.optInt("sample_rate", 10000);
      int j = paramJSONObject.optInt("delay", 300000);
      long l = paramJSONObject.optLong("ban_time", 0L);
      al.b(b.a(), "rt_upload_rate", i);
      al.b(b.a(), "rt_upload_delay", j);
      al.b(b.a(), "rt_ban_time", l);
      al.b(b.a(), "rt_update_time", System.currentTimeMillis());
    }
  }
  
  public boolean a(String paramString)
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("app_id", b.b());
    localTreeMap.put("app_package", b.f());
    localTreeMap.put("device_uuid", v.a(b.a()));
    localTreeMap.put("device_os", "android" + VERSION.SDK_INT);
    localTreeMap.put("device_model", Build.MODEL);
    localTreeMap.put("app_version", b.e());
    localTreeMap.put("app_channel", b.d());
    localTreeMap.put("time", String.valueOf(System.currentTimeMillis()));
    localTreeMap.put("net_value", paramString);
    paramString = ag.b(b.a(), f(), localTreeMap);
    new ae().a("http data complete, result=" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject(paramString);
      if ("ok".equals(paramString.getString("status"))) {
        a(paramString);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public List b()
  {
    synchronized (this.c)
    {
      LinkedList localLinkedList = new java/util/LinkedList;
      localLinkedList.<init>(this.c);
      return localLinkedList;
    }
  }
  
  boolean c()
  {
    if ((System.currentTimeMillis() > al.a(b.a(), "rt_ban_time", 0L)) && (Math.random() * 10000.0D <= al.a(b.a(), "rt_upload_rate", 10000))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean d()
  {
    if (System.currentTimeMillis() - al.a(b.a(), "rt_update_time", 0L) > 86400000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long e()
  {
    return al.a(b.a(), "rt_upload_delay", 300000L);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */