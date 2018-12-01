package com.a.a.a.c;

import java.io.IOException;
import java.io.OutputStream;

final class h
  extends OutputStream
{
  private OutputStream a;
  private c b;
  private e c;
  private int d = 0;
  
  public h(c paramc, OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
    this.b = paramc;
  }
  
  public h(e parame, OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
    this.c = parame;
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
  
  public void close()
  {
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
  
  public void flush()
  {
    try
    {
      this.a.flush();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      this.a.write(paramInt);
      this.d += 1;
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    try
    {
      this.a.write(paramArrayOfByte);
      this.d += paramArrayOfByte.length;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.a.write(paramArrayOfByte, paramInt1, paramInt2);
      this.d += paramInt2;
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */