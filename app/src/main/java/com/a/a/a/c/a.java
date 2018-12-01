package com.a.a.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a
{
  private static int a = 2;
  private static int b = 2;
  private static int c = 2;
  private static BlockingQueue d = new LinkedBlockingQueue();
  private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, d);
  
  public static ThreadPoolExecutor a()
  {
    return e;
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */