package com.miui.touchassistant.entries;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Binder;
import android.os.SystemClock;
import android.view.KeyEvent;
import com.miui.touchassistant.c.k;

public final class h
{
  static void a(int paramInt)
  {
    long l1 = Binder.clearCallingIdentity();
    long l2 = SystemClock.uptimeMillis();
    KeyEvent localKeyEvent = KeyEvent.obtain(l2, l2, 0, paramInt, 0, 0, -1, 0, 8, 257, null);
    InputManager.getInstance().injectInputEvent(localKeyEvent, 0);
    localKeyEvent.recycle();
    localKeyEvent = KeyEvent.obtain(l2, SystemClock.uptimeMillis(), 1, paramInt, 0, 0, -1, 0, 8, 257, null);
    InputManager.getInstance().injectInputEvent(localKeyEvent, 0);
    localKeyEvent.recycle();
    Binder.restoreCallingIdentity(l1);
  }
  
  static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent("android.search.action.GLOBAL_SEARCH").addFlags(268435456));
  }
  
  static void a(Context paramContext, String paramString)
  {
    ComponentName localComponentName = null;
    if ("wechat_scan".equals(paramString)) {
      localComponentName = new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
    }
    for (;;)
    {
      if (localComponentName != null) {
        k.a(paramContext, localComponentName);
      }
      return;
      if ("wechat_payment_code".equals(paramString)) {
        localComponentName = new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI");
      } else if ("alipay_scan".equals(paramString)) {
        localComponentName = new ComponentName("com.eg.android.AlipayGphone", "com.alipay.mobile.scan.as.main.MainCaptureActivity");
      } else if ("alipay_payment_code".equals(paramString)) {
        localComponentName = new ComponentName("com.eg.android.AlipayGphone", "com.alipay.mobile.onsitepay9.payer.OspTabHostActivity");
      }
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/miui/touchassistant/entries/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */