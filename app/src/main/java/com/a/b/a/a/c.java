package com.a.b.a.a;

import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

class c
  implements a
{
  private IBinder a;
  
  c(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a(String paramString, Map paramMap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.xiaomi.xmsf.push.service.IHttpService");
      localParcel1.writeString(paramString);
      localParcel1.writeMap(paramMap);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/b/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */