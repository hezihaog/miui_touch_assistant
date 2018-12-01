package com.a.a.a.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.a.a.a.a.ae;
import com.a.a.a.a.am;
import com.a.a.a.a.t;
import com.a.a.a.a.x;
import com.a.a.a.b.j;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements t
{
  private static int h = 0;
  private long a;
  private HashMap b = new HashMap();
  private long c = System.currentTimeMillis();
  private JSONObject d = null;
  private ArrayList e = new ArrayList();
  private c f;
  private HashMap g = new HashMap();
  
  public b(long paramLong, c paramc)
  {
    this.a = paramLong;
    this.f = paramc;
  }
  
  private void a(j paramj)
  {
    Object localObject2 = (JSONObject)this.b.get("mistat_session");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new JSONArray();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("category", "mistat_session");
      ((JSONObject)localObject1).put("values", localObject2);
      this.b.put("mistat_session", localObject1);
      this.d.getJSONArray("content").put(localObject1);
    }
    localObject2 = new JSONObject();
    String[] arrayOfString = paramj.e.split(",");
    long l2 = Long.parseLong(arrayOfString[0]);
    long l1 = Long.parseLong(arrayOfString[1]);
    ((JSONObject)localObject2).put("start", l2);
    ((JSONObject)localObject2).put("end", l1);
    ((JSONObject)localObject2).put("env", paramj.f);
    ((JSONObject)localObject1).getJSONArray("values").put(localObject2);
  }
  
  private void b()
  {
    this.d = null;
    this.b.clear();
    this.e.clear();
    this.g.clear();
  }
  
  private void b(j paramj)
  {
    Object localObject2 = (JSONObject)this.b.get("mistat_pv");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      localObject3 = new JSONArray();
      ((JSONObject)localObject1).put("category", "mistat_pv");
      ((JSONObject)localObject1).put("values", localObject2);
      ((JSONObject)localObject1).put("source", localObject3);
      this.b.put("mistat_pv", localObject1);
      this.d.getJSONArray("content").put(localObject1);
    }
    Object localObject3 = paramj.e.trim().split(",");
    localObject2 = new String[localObject3.length];
    int i = 0;
    if (i < localObject3.length)
    {
      int j = this.e.indexOf(localObject3[i]);
      if (j >= 0) {
        localObject2[i] = String.valueOf(j + 1);
      }
      for (;;)
      {
        i++;
        break;
        localObject2[i] = String.valueOf(this.e.size() + 1);
        this.e.add(localObject3[i]);
      }
    }
    localObject2 = TextUtils.join(",", (Object[])localObject2);
    ((JSONObject)localObject1).getJSONArray("values").put(localObject2);
    ((JSONObject)localObject1).put("index", TextUtils.join(",", this.e));
    if (TextUtils.isEmpty(paramj.f)) {
      ((JSONObject)localObject1).getJSONArray("source").put("");
    }
    for (;;)
    {
      return;
      ((JSONObject)localObject1).getJSONArray("source").put(paramj.f);
    }
  }
  
  private void c(j paramj)
  {
    Object localObject2 = (JSONObject)this.b.get("mistat_pt");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      ((JSONObject)localObject1).put("category", "mistat_pt");
      ((JSONObject)localObject1).put("values", localObject2);
      this.b.put("mistat_pt", localObject1);
      this.d.getJSONArray("content").put(localObject1);
    }
    localObject2 = ((JSONObject)localObject1).getJSONArray("values");
    int i = 0;
    if (i < ((JSONArray)localObject2).length())
    {
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if (TextUtils.equals(localJSONObject.getString("key"), paramj.c)) {
        localJSONObject.put("value", localJSONObject.getString("value") + "," + paramj.e);
      }
    }
    for (;;)
    {
      return;
      i++;
      break;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("key", paramj.c);
      ((JSONObject)localObject2).put("value", paramj.e);
      ((JSONObject)localObject1).getJSONArray("values").put(localObject2);
    }
  }
  
  private void d(j paramj)
  {
    JSONObject localJSONObject = (JSONObject)this.b.get(paramj.a);
    Object localObject;
    if (localJSONObject == null)
    {
      localJSONObject = new JSONObject();
      localObject = new JSONArray();
      localJSONObject.put("category", paramj.a);
      localJSONObject.put("values", localObject);
      this.b.put(paramj.a, localJSONObject);
      this.d.getJSONArray("content").put(localJSONObject);
    }
    for (;;)
    {
      if (("event".equals(paramj.d)) && (TextUtils.isEmpty(paramj.f)))
      {
        localObject = (JSONObject)this.g.get(paramj.c);
        if (localObject != null) {
          ((JSONObject)localObject).put("value", ((JSONObject)localObject).getLong("value") + Long.parseLong(paramj.e));
        }
      }
      for (;;)
      {
        return;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("key", paramj.c);
        ((JSONObject)localObject).put("type", paramj.d);
        ((JSONObject)localObject).put("value", Long.parseLong(paramj.e));
        localJSONObject.getJSONArray("values").put(localObject);
        this.g.put(paramj.c, localObject);
        continue;
        if (!"mistat_extra".equals(paramj.a)) {
          break;
        }
        localJSONObject.getJSONArray("values").put(paramj.e);
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("key", paramj.c);
      ((JSONObject)localObject).put("type", paramj.d);
      if (("count".equals(paramj.d)) || ("numeric".equals(paramj.d))) {
        ((JSONObject)localObject).put("value", Long.parseLong(paramj.e));
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramj.f)) {
          ((JSONObject)localObject).put("params", new JSONObject(paramj.f));
        }
        localJSONObject.getJSONArray("values").put(localObject);
        break;
        ((JSONObject)localObject).put("value", paramj.e);
      }
    }
  }
  
  public d a(long paramLong)
  {
    Object localObject3 = new ae();
    Object localObject5 = new x();
    ((x)localObject5).b();
    long l3 = 0L;
    long l5 = 0L;
    int m = 0;
    int j = 0;
    JSONArray localJSONArray = new JSONArray();
    b();
    this.c = System.currentTimeMillis();
    localObject5 = ((x)localObject5).a(paramLong);
    ((ae)localObject3).a("Begin to packing data from local DB");
    int k = 0;
    long l1;
    Object localObject6;
    long l2;
    long l4;
    if (localObject5 != null)
    {
      l1 = l5;
      paramLong = l3;
      i = m;
      do
      {
        try
        {
          if (!((Cursor)localObject5).moveToFirst()) {
            break label913;
          }
          l1 = l5;
          paramLong = l3;
          i = m;
          j = ((Cursor)localObject5).getCount();
          m = k + 1;
          l1 = l5;
          paramLong = l3;
          i = j;
          localObject6 = x.a((Cursor)localObject5);
          l1 = l5;
          paramLong = l3;
          i = j;
          Object localObject7 = new java/lang/StringBuilder;
          l1 = l5;
          paramLong = l3;
          i = j;
          ((StringBuilder)localObject7).<init>();
          l1 = l5;
          paramLong = l3;
          i = j;
          ((ae)localObject3).a("Packing " + ((j)localObject6).toString());
          l2 = l3;
          if (l3 == 0L)
          {
            l1 = l5;
            paramLong = l3;
            i = j;
            l2 = ((j)localObject6).b;
            l1 = l5;
            paramLong = l2;
            i = j;
            this.c = l2;
          }
          l1 = l5;
          paramLong = l2;
          i = j;
          l4 = ((j)localObject6).b;
          l1 = l4;
          paramLong = l2;
          i = j;
          if (this.a > 0L)
          {
            l1 = l4;
            paramLong = l2;
            i = j;
            if (this.c - ((j)localObject6).b > this.a)
            {
              l1 = l4;
              paramLong = l2;
              i = j;
              if (this.d != null)
              {
                l1 = l4;
                paramLong = l2;
                i = j;
                b();
                l1 = l4;
                paramLong = l2;
                i = j;
                this.c = ((j)localObject6).b;
              }
            }
          }
          l1 = l4;
          paramLong = l2;
          i = j;
          if (this.d == null)
          {
            l1 = l4;
            paramLong = l2;
            i = j;
            localObject7 = new org/json/JSONObject;
            l1 = l4;
            paramLong = l2;
            i = j;
            ((JSONObject)localObject7).<init>();
            l1 = l4;
            paramLong = l2;
            i = j;
            this.d = ((JSONObject)localObject7);
            l1 = l4;
            paramLong = l2;
            i = j;
            this.d.put("endTS", ((j)localObject6).b);
            l1 = l4;
            paramLong = l2;
            i = j;
            localObject7 = new org/json/JSONArray;
            l1 = l4;
            paramLong = l2;
            i = j;
            ((JSONArray)localObject7).<init>();
            l1 = l4;
            paramLong = l2;
            i = j;
            this.d.put("content", localObject7);
            l1 = l4;
            paramLong = l2;
            i = j;
            localJSONArray.put(this.d);
          }
          l1 = l4;
          paramLong = l2;
          i = j;
          if (!"mistat_session".equals(((j)localObject6).a)) {
            break label748;
          }
          l1 = l4;
          paramLong = l2;
          i = j;
          a((j)localObject6);
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            localObject4 = localJSONArray;
            l5 = l1;
            l3 = paramLong;
            j = i;
            if (localObject5 != null)
            {
              ((Cursor)localObject5).close();
              localObject4 = localJSONArray;
              l5 = l1;
              l3 = paramLong;
              j = i;
              continue;
              l1 = l4;
              paramLong = l2;
              i = j;
              if (!"mistat_pt".equals(((j)localObject6).a)) {
                break;
              }
              l1 = l4;
              paramLong = l2;
              i = j;
              c((j)localObject6);
            }
          }
        }
        finally
        {
          if (localObject5 == null) {
            break label891;
          }
          ((Cursor)localObject5).close();
        }
        l1 = l4;
        paramLong = l2;
        i = j;
        this.d.put("startTS", ((j)localObject6).b);
        k = m;
        l5 = l4;
        l3 = l2;
        l1 = l4;
        paramLong = l2;
        i = j;
      } while (((Cursor)localObject5).moveToNext());
      l1 = l4;
      paramLong = l2;
      i = j;
      localObject6 = new java/lang/StringBuilder;
      l1 = l4;
      paramLong = l2;
      i = j;
      ((StringBuilder)localObject6).<init>();
      l1 = l4;
      paramLong = l2;
      i = j;
      ((ae)localObject3).a("Packing complete, total " + m + " records were packed and to be uploaded");
    }
    for (int i = j;; i = j)
    {
      localObject3 = localJSONArray;
      l5 = l4;
      l3 = l2;
      j = i;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        j = i;
        l3 = l2;
        l5 = l4;
        localObject3 = localJSONArray;
      }
      return new d(this, (JSONArray)localObject3, l5, l3, j);
      label748:
      l1 = l4;
      paramLong = l2;
      i = j;
      if ("mistat_pv".equals(((j)localObject6).a))
      {
        l1 = l4;
        paramLong = l2;
        i = j;
        b((j)localObject6);
        break;
      }
      Object localObject4;
      label891:
      l1 = l4;
      paramLong = l2;
      i = j;
      d((j)localObject6);
      break;
      label913:
      l1 = l5;
      paramLong = l3;
      i = m;
      ((ae)localObject4).a("No data available to be packed");
      Object localObject2 = null;
      l4 = l5;
      l2 = l3;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        localObject = a(Long.MAX_VALUE);
        if (d.a((d)localObject) != null)
        {
          this.f.a(d.a((d)localObject).toString(), d.b((d)localObject), d.c((d)localObject));
          if (((d)localObject).a < 200) {
            continue;
          }
          if (h < 50)
          {
            localObject = new com/a/a/a/a/am;
            ((am)localObject).<init>();
            ((am)localObject).a();
            h += 1;
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        this.f.a("", 0L, 0L);
        continue;
        h = 0;
        continue;
      }
      this.f.a("", d.b((d)localObject), d.c((d)localObject));
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */