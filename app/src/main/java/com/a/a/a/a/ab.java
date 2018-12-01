package com.a.a.a.a;

import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

class ab
  implements t
{
  ab(aa paramaa) {}
  
  public void a()
  {
    if (this.a.a.c()) {}
    for (;;)
    {
      try
      {
        List localList2 = this.a.a.b();
        int j = localList2.size();
        int i = 0;
        if (i < j)
        {
          List localList1;
          if (i + 30 >= j)
          {
            localList1 = localList2.subList(i, j);
            if (!y.a(this.a.a, localList1)) {}
          }
          synchronized (y.a(this.a.a))
          {
            y.a(this.a.a).removeAll(localList1);
            i += 30;
            continue;
            localList1 = localList2.subList(i, i + 30);
          }
        }
        if (!this.a.a.d()) {
          continue;
        }
      }
      catch (IOException localIOException1)
      {
        new ae().a("", localIOException1);
        return;
      }
      catch (JSONException localJSONException1)
      {
        new ae().a("", localJSONException1);
        continue;
      }
      JSONArray localJSONArray = new JSONArray();
      try
      {
        this.a.a.a(localJSONArray.toString());
      }
      catch (IOException localIOException2)
      {
        new ae().a("", localIOException2);
      }
      catch (JSONException localJSONException2)
      {
        new ae().a("", localJSONException2);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */