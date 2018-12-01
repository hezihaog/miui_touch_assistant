package a.a;

import android.util.Log;

class e
  implements c
{
  public static Class a()
  {
    try
    {
      Class localClass1 = Class.forName("miui.core.SdkManager");
      return localClass1;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        Class localClass2 = Class.forName("com.miui.internal.core.SdkManager");
        Log.w("miuisdk", "using legacy sdk");
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        Log.e("miuisdk", "no sdk found");
        throw localClassNotFoundException2;
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */