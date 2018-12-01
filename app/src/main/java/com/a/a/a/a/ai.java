package com.a.a.a.a;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.a.b.a.a.a;
import com.a.b.a.a.b;

class ai
  implements t
{
  ai(ah paramah, IBinder paramIBinder, ServiceConnection paramServiceConnection) {}
  
  public void a()
  {
    try
    {
      a locala = b.a(this.a);
      this.c.c.a = locala.a(this.c.d, this.c.e);
      this.c.f.unbindService(this.b);
      ag.a(this.c.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.c.a.a("error while uploading the logs by IPC.", localException);
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */