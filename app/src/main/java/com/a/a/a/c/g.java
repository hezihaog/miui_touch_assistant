package com.a.a.a.c;

import java.io.IOException;
import java.io.InputStream;

final class g
  extends InputStream
{
  private InputStream a;
  private c b;
  private e c;
  private int d = 0;
  
  public g(c paramc, InputStream paramInputStream)
  {
    this.b = paramc;
    this.a = paramInputStream;
  }
  
  public g(e parame, InputStream paramInputStream)
  {
    this.c = parame;
    this.a = paramInputStream;
  }
  
  private void a(Exception paramException)
  {
    if (this.b != null) {
      this.b.a(paramException);
    }
    if (this.c != null) {
      this.c.a(paramException);
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int available()
  {
    try
    {
      int i = this.a.available();
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void close()
  {
    if (this.b != null) {
      this.b.a();
    }
    if (this.c != null) {
      this.c.a();
    }
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    try
    {
      int i = this.a.read();
      if (i != -1) {
        this.d += 1;
      }
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.a.read(paramArrayOfByte);
      if (i != -1) {
        this.d += i;
      }
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.d += paramInt1;
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
  {
    try
    {
      this.a.reset();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    try
    {
      paramLong = this.a.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */