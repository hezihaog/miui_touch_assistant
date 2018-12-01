package a.a;

import android.app.Dialog;
import android.os.AsyncTask;

class i
  extends AsyncTask
{
  i(h paramh, Dialog paramDialog) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      Thread.sleep(5000L);
      return Boolean.valueOf(f.b(this.b.a));
    }
    catch (InterruptedException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = f.c(this.b.a);; paramBoolean = f.d(this.b.a))
    {
      new k(this.b.a, paramBoolean).show(this.b.a.getFragmentManager(), "SdkUpdateFinishDialog");
      return;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */