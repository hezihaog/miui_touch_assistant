package com.a.a.a.a;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class aj
  extends FilterInputStream
{
  private boolean a;
  
  public aj(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.a)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1) {}
    }
    for (;;)
    {
      return paramInt1;
      this.a = true;
      paramInt1 = -1;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */