package com.a.a.a.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.a.a.a.a.ag;
import com.a.a.a.a.b;
import org.json.JSONObject;

public class a
{
  private long a;
  private long b;
  private int c;
  private String d;
  private String e;
  private long f = System.currentTimeMillis();
  private String g;
  private long h = 0L;
  private String i;
  private String j;
  private String k;
  private int l = 0;
  
  public a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    this(paramString1, paramLong, 0L, paramInt, paramString2);
  }
  
  public a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this(paramString, paramLong1, paramLong2, paramInt, null);
  }
  
  public a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    this.g = paramString1;
    this.a = paramLong1;
    this.c = paramInt;
    this.d = paramString2;
    this.h = paramLong2;
    b();
  }
  
  public a(String paramString1, String paramString2)
  {
    this(paramString1, -1L, -1, paramString2);
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void b()
  {
    if (b.a() == null) {
      this.e = "NULL";
    }
    for (;;)
    {
      return;
      String str = ag.b(b.a());
      if (TextUtils.isEmpty(str))
      {
        this.e = "NULL";
      }
      else
      {
        this.e = str;
        if (!"WIFI".equalsIgnoreCase(str)) {
          this.i = ((TelephonyManager)b.a().getSystemService("phone")).getSimOperator();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("net", this.e);
    if (this.a > 0L) {
      localJSONObject.put("cost", this.a);
    }
    if (this.b > 0L) {
      localJSONObject.put("first_byte_t", this.b);
    }
    if (this.c != -1) {
      localJSONObject.put("code", this.c);
    }
    if (!TextUtils.isEmpty(this.d)) {
      localJSONObject.put("exception", this.d);
    }
    if (!TextUtils.isEmpty(this.i)) {
      localJSONObject.put("op", this.i);
    }
    if (this.h > 0L) {
      localJSONObject.put("flow", this.h);
    }
    if ((this.l == 1) || (this.l == 2)) {
      localJSONObject.put("flow_status", this.l);
    }
    if (!TextUtils.isEmpty(this.j)) {
      localJSONObject.put("rid", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      localJSONObject.put("dns", this.k);
    }
    localJSONObject.put("t", this.f);
    return localJSONObject;
  }
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramObject instanceof a)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(this.g, ((a)paramObject).g))
      {
        bool1 = bool2;
        if (TextUtils.equals(this.e, ((a)paramObject).e))
        {
          bool1 = bool2;
          if (TextUtils.equals(this.d, ((a)paramObject).d))
          {
            bool1 = bool2;
            if (TextUtils.equals(this.k, ((a)paramObject).k))
            {
              bool1 = bool2;
              if (this.c == ((a)paramObject).c)
              {
                bool1 = bool2;
                if (this.a == ((a)paramObject).a)
                {
                  bool1 = bool2;
                  if (this.f == ((a)paramObject).f)
                  {
                    bool1 = bool2;
                    if (this.h == ((a)paramObject).h)
                    {
                      bool1 = bool2;
                      if (this.l == ((a)paramObject).l)
                      {
                        bool1 = bool2;
                        if (TextUtils.equals(this.j, ((a)paramObject).j))
                        {
                          bool1 = bool2;
                          if (this.b == ((a)paramObject).b) {
                            bool1 = true;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */