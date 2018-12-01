package com.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.a.b.g;
import java.util.List;

class h
  implements t
{
  h(e parame, String paramString, Context paramContext) {}
  
  public void a()
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    al.b(b.a(), "last_deactivate", localLong.longValue());
    int j;
    if (!e.c().isEmpty())
    {
      if (!TextUtils.isEmpty(this.a)) {
        break label140;
      }
      j = e.c().size() - 1;
    }
    for (;;)
    {
      if (j >= 0)
      {
        localObject = (g)e.c().get(j);
        String str = ((g)localObject).d();
        long l1 = ((g)localObject).c();
        long l2 = localLong.longValue() - l1;
        if ((!TextUtils.isEmpty(str)) && (l1 > 0L) && (l2 > 0L))
        {
          ((g)localObject).a(Long.valueOf(l2));
          ac.a((com.a.a.a.b.b)localObject);
          e.c().remove(j);
        }
      }
      return;
      label140:
      Object localObject = e.b(this.c, this.b, this.a);
      for (int i = e.c().size() - 1;; i--)
      {
        if (i < 0) {
          break label203;
        }
        j = i;
        if (TextUtils.equals(((g)e.c().get(i)).d(), (CharSequence)localObject)) {
          break;
        }
      }
      label203:
      j = -1;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */