package com.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

class g
  implements t
{
  g(e parame, Context paramContext, String paramString1, String paramString2) {}
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = al.a(this.a.getApplicationContext(), "session_begin", 0L);
    long l3 = al.a(this.a.getApplicationContext(), "last_deactivate", 0L);
    Object localObject2 = al.a(this.a.getApplicationContext(), "pv_path", "");
    Object localObject1;
    if (l2 <= 0L)
    {
      al.b(this.a.getApplicationContext(), "session_begin", l1);
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (l3 > 0L)
      {
        localObject2 = localObject1;
        if (l1 - l3 > e.b())
        {
          e.a(this.d, this.a, l2, l3);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label338;
          }
          e.a(this.d, this.a, (String)localObject1);
          localObject1 = "";
        }
      }
    }
    label338:
    for (;;)
    {
      al.b(this.a.getApplicationContext(), "session_begin", l1);
      localObject2 = localObject1;
      localObject1 = e.b(this.d, this.a, this.b);
      if ((!((String)localObject2).endsWith((String)localObject1)) || (!TextUtils.isEmpty(this.c)))
      {
        localObject2 = e.a(this.d, (String)localObject2, (String)localObject1);
        al.b(this.a.getApplicationContext(), "pv_path", (String)localObject2);
        localObject2 = al.a(b.a(), "source_path", "");
        localObject2 = e.a(this.d, (String)localObject2, this.c);
        al.b(b.a(), "source_path", (String)localObject2);
      }
      localObject1 = new com.a.a.a.b.g((String)localObject1, Long.valueOf(l1));
      e.c().add(localObject1);
      return;
      localObject1 = localObject2;
      if (l3 > 0L) {
        break;
      }
      al.b(this.a.getApplicationContext(), "session_begin", l1);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      e.a(this.d, this.a, (String)localObject2);
      localObject1 = "";
      break;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */