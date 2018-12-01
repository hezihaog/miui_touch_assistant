package a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h
  implements OnClickListener
{
  h(f paramf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = f.a(this.a);
    new k(this.a, paramDialogInterface).show(this.a.getFragmentManager(), "SdkUpdatePromptDialog");
    new i(this, paramDialogInterface).execute(new Void[0]);
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */