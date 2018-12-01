package com.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.a.a.a.a.ae;
import com.a.a.a.a.ag;
import com.a.a.a.a.al;
import com.a.a.a.a.b;
import com.a.a.a.a.v;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;

public class e
  implements Thread.UncaughtExceptionHandler
{
  private static boolean a = false;
  private static int b = 1;
  private final Thread.UncaughtExceptionHandler c;
  
  public static void a(Throwable paramThrowable)
  {
    if (!a) {}
    do
    {
      return;
      if (paramThrowable == null) {
        throw new IllegalArgumentException("the throwable is null.");
      }
    } while ((paramThrowable.getStackTrace() == null) || (paramThrowable.getStackTrace().length == 0));
    Object localObject1 = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject1));
    localObject1 = localObject1.toString();
    Object localObject2 = new TreeMap();
    ((Map)localObject2).put("app_id", b.b());
    ((Map)localObject2).put("app_key", b.c());
    ((Map)localObject2).put("device_uuid", v.a(b.a()));
    ((Map)localObject2).put("device_os", "Android " + VERSION.SDK_INT);
    ((Map)localObject2).put("device_model", Build.MODEL);
    ((Map)localObject2).put("app_version", b.e());
    ((Map)localObject2).put("app_channel", b.d());
    ((Map)localObject2).put("app_start_time", String.valueOf(System.currentTimeMillis()));
    ((Map)localObject2).put("app_crash_time", String.valueOf(System.currentTimeMillis()));
    ((Map)localObject2).put("crash_exception_type", paramThrowable.getClass().getName() + ":" + paramThrowable.getMessage());
    if ((paramThrowable instanceof OutOfMemoryError))
    {
      paramThrowable = "OutOfMemoryError";
      label255:
      ((Map)localObject2).put("crash_exception_desc", paramThrowable);
      ((Map)localObject2).put("crash_callstack", localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = b.a();
        if (!a.a()) {
          break label353;
        }
        paramThrowable = "http://10.99.168.145:8097/micrash";
        localObject1 = ag.b((Context)localObject1, paramThrowable, (Map)localObject2);
        localObject2 = new com/a/a/a/a/ae;
        ((ae)localObject2).<init>();
        paramThrowable = new java/lang/StringBuilder;
        paramThrowable.<init>();
        ((ae)localObject2).a("upload the exception " + (String)localObject1);
      }
      catch (IOException paramThrowable)
      {
        new ae().a("Error to upload the exception", paramThrowable);
      }
      break;
      paramThrowable = (Throwable)localObject1;
      break label255;
      label353:
      paramThrowable = "https://data.mistat.xiaomi.com/micrash";
    }
  }
  
  /* Error */
  public static java.util.ArrayList b()
  {
    // Byte code:
    //   0: new 191	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 192	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_2
    //   12: invokestatic 77	com/a/a/a/a/b:a	()Landroid/content/Context;
    //   15: invokevirtual 198	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: astore 5
    //   20: aload 5
    //   22: ifnull +168 -> 190
    //   25: new 200	java/io/File
    //   28: astore 4
    //   30: aload 4
    //   32: aload 5
    //   34: ldc -54
    //   36: invokespecial 205	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: aload 4
    //   41: invokevirtual 208	java/io/File:isFile	()Z
    //   44: ifeq +146 -> 190
    //   47: new 210	java/io/ObjectInputStream
    //   50: astore_2
    //   51: new 212	java/io/FileInputStream
    //   54: astore 5
    //   56: aload 5
    //   58: aload 4
    //   60: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: aload_2
    //   64: aload 5
    //   66: invokespecial 218	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: invokevirtual 222	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   75: checkcast 191	java/util/ArrayList
    //   78: astore 4
    //   80: aload 4
    //   82: astore_1
    //   83: aload_2
    //   84: ifnull +101 -> 185
    //   87: aload_2
    //   88: invokevirtual 225	java/io/ObjectInputStream:close	()V
    //   91: iconst_0
    //   92: istore_0
    //   93: iload_0
    //   94: ifeq +6 -> 100
    //   97: invokestatic 227	com/a/a/a/e:c	()V
    //   100: aload_1
    //   101: areturn
    //   102: astore_2
    //   103: iconst_0
    //   104: istore_0
    //   105: goto -12 -> 93
    //   108: astore 4
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: astore_3
    //   114: new 174	com/a/a/a/a/ae
    //   117: astore 5
    //   119: aload_2
    //   120: astore_3
    //   121: aload 5
    //   123: invokespecial 175	com/a/a/a/a/ae:<init>	()V
    //   126: aload_2
    //   127: astore_3
    //   128: aload 5
    //   130: ldc -27
    //   132: aload 4
    //   134: invokevirtual 184	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: iconst_1
    //   138: istore_0
    //   139: aload_2
    //   140: ifnull +42 -> 182
    //   143: aload_2
    //   144: invokevirtual 225	java/io/ObjectInputStream:close	()V
    //   147: goto -54 -> 93
    //   150: astore_2
    //   151: goto -58 -> 93
    //   154: astore_1
    //   155: aload_3
    //   156: astore_2
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 225	java/io/ObjectInputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_2
    //   168: goto -3 -> 165
    //   171: astore_1
    //   172: aload_3
    //   173: astore_2
    //   174: goto -17 -> 157
    //   177: astore 4
    //   179: goto -67 -> 112
    //   182: goto -89 -> 93
    //   185: iconst_0
    //   186: istore_0
    //   187: goto -94 -> 93
    //   190: goto -107 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   92	95	0	i	int
    //   7	94	1	localObject1	Object
    //   154	12	1	localObject2	Object
    //   171	1	1	localObject3	Object
    //   11	77	2	localObjectInputStream	java.io.ObjectInputStream
    //   102	1	2	localIOException1	IOException
    //   111	33	2	localObject4	Object
    //   150	1	2	localIOException2	IOException
    //   156	6	2	localObject5	Object
    //   167	1	2	localIOException3	IOException
    //   173	1	2	localObject6	Object
    //   9	164	3	localObject7	Object
    //   28	53	4	localObject8	Object
    //   108	25	4	localException1	Exception
    //   177	1	4	localException2	Exception
    //   18	111	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   87	91	102	java/io/IOException
    //   12	20	108	java/lang/Exception
    //   25	69	108	java/lang/Exception
    //   143	147	150	java/io/IOException
    //   12	20	154	finally
    //   25	69	154	finally
    //   161	165	167	java/io/IOException
    //   71	80	171	finally
    //   114	119	171	finally
    //   121	126	171	finally
    //   128	137	171	finally
    //   71	80	177	java/lang/Exception
  }
  
  /* Error */
  public static void b(Throwable paramThrowable)
  {
    // Byte code:
    //   0: invokestatic 231	com/a/a/a/e:b	()Ljava/util/ArrayList;
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload_2
    //   11: invokevirtual 239	java/util/ArrayList:size	()I
    //   14: iconst_5
    //   15: if_icmple +9 -> 24
    //   18: aload_2
    //   19: iconst_0
    //   20: invokevirtual 243	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   23: pop
    //   24: invokestatic 77	com/a/a/a/a/b:a	()Landroid/content/Context;
    //   27: ldc -54
    //   29: iconst_0
    //   30: invokevirtual 247	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   33: astore_0
    //   34: new 249	java/io/ObjectOutputStream
    //   37: astore_1
    //   38: aload_1
    //   39: aload_0
    //   40: invokespecial 252	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 256	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 257	java/io/ObjectOutputStream:close	()V
    //   58: return
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: astore_0
    //   64: new 174	com/a/a/a/a/ae
    //   67: astore_3
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: invokespecial 175	com/a/a/a/a/ae:<init>	()V
    //   74: aload_1
    //   75: astore_0
    //   76: aload_3
    //   77: ldc -27
    //   79: aload_2
    //   80: invokevirtual 184	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_1
    //   84: ifnull -26 -> 58
    //   87: aload_1
    //   88: invokevirtual 257	java/io/ObjectOutputStream:close	()V
    //   91: goto -33 -> 58
    //   94: astore_0
    //   95: goto -37 -> 58
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 257	java/io/ObjectOutputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_0
    //   112: goto -54 -> 58
    //   115: astore_0
    //   116: goto -7 -> 109
    //   119: astore_1
    //   120: goto -19 -> 101
    //   123: astore_2
    //   124: goto -62 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramThrowable	Throwable
    //   37	51	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   98	12	1	localObject1	Object
    //   119	1	1	localObject2	Object
    //   3	44	2	localArrayList	java.util.ArrayList
    //   59	21	2	localIOException1	IOException
    //   123	1	2	localIOException2	IOException
    //   67	10	3	localae	ae
    // Exception table:
    //   from	to	target	type
    //   24	43	59	java/io/IOException
    //   87	91	94	java/io/IOException
    //   24	43	98	finally
    //   54	58	111	java/io/IOException
    //   105	109	115	java/io/IOException
    //   45	50	119	finally
    //   64	68	119	finally
    //   70	74	119	finally
    //   76	83	119	finally
    //   45	50	123	java/io/IOException
  }
  
  public static void c()
  {
    new File(b.a().getFilesDir(), ".exception").delete();
  }
  
  public static int d()
  {
    return b;
  }
  
  public boolean a()
  {
    boolean bool = true;
    long l = al.a(b.a(), "crash_time", 0L);
    if (System.currentTimeMillis() - l > 300000L)
    {
      al.b(b.a(), "crash_count", 1);
      al.b(b.a(), "crash_time", System.currentTimeMillis());
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i = al.a(b.a(), "crash_count", 0);
      if (i == 0) {
        al.b(b.a(), "crash_time", System.currentTimeMillis());
      }
      i++;
      al.b(b.a(), "crash_count", i);
      if (i <= 10) {
        break;
      }
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (VERSION.SDK_INT >= 9) {
      StrictMode.setThreadPolicy(new Builder().build());
    }
    if (c.b()) {
      if (!a()) {
        a(paramThrowable);
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.uncaughtException(paramThread, paramThrowable);
      }
      return;
      new ae().a("crazy crash...");
      continue;
      b(paramThrowable);
    }
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */