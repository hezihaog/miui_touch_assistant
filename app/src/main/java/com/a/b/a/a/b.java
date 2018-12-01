package com.a.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b
  extends Binder
  implements a
{
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      paramIBinder = null;
    }
    for (;;)
    {
      return paramIBinder;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.xiaomi.xmsf.push.service.IHttpService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        paramIBinder = (a)localIInterface;
      } else {
        paramIBinder = new c(paramIBinder);
      }
    }
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      paramParcel2.writeString("com.xiaomi.xmsf.push.service.IHttpService");
      continue;
      paramParcel1.enforceInterface("com.xiaomi.xmsf.push.service.IHttpService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */