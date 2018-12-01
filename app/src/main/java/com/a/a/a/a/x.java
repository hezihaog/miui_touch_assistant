package com.a.a.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.a.a.a.b.j;

public class x
{
  private static af a;
  
  public static j a(Cursor paramCursor)
  {
    new j();
    long l = paramCursor.getLong(2);
    String str2 = paramCursor.getString(4);
    String str4 = paramCursor.getString(5);
    String str1 = paramCursor.getString(1);
    String str3 = paramCursor.getString(3);
    paramCursor = paramCursor.getString(6);
    j localj = new j();
    localj.a = str1;
    localj.c = str3;
    localj.e = str2;
    localj.b = l;
    localj.d = str4;
    localj.f = paramCursor;
    return localj;
  }
  
  public static void a()
  {
    a = new af(b.a());
  }
  
  /* Error */
  public Cursor a(long paramLong)
  {
    // Byte code:
    //   0: getstatic 56	com/a/a/a/a/x:a	Lcom/a/a/a/a/af;
    //   3: invokevirtual 63	com/a/a/a/a/af:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 6
    //   8: aload 6
    //   10: ldc 65
    //   12: aconst_null
    //   13: ldc 67
    //   15: iconst_1
    //   16: anewarray 69	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: lload_1
    //   22: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: ldc 75
    //   30: sipush 200
    //   33: invokestatic 77	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   36: invokevirtual 83	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore 5
    //   41: aload 5
    //   43: ifnull +105 -> 148
    //   46: aload 5
    //   48: invokeinterface 87 1 0
    //   53: ifeq +95 -> 148
    //   56: aload 5
    //   58: aload 5
    //   60: ldc 89
    //   62: invokeinterface 93 2 0
    //   67: invokeinterface 21 2 0
    //   72: lstore_3
    //   73: aload 5
    //   75: invokeinterface 96 1 0
    //   80: aload 6
    //   82: ldc 65
    //   84: aconst_null
    //   85: ldc 98
    //   87: iconst_2
    //   88: anewarray 69	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: lload_1
    //   94: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: lload_3
    //   101: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   104: aastore
    //   105: aconst_null
    //   106: aconst_null
    //   107: ldc 75
    //   109: invokevirtual 101	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore 6
    //   114: aload 6
    //   116: astore 5
    //   118: aload 5
    //   120: areturn
    //   121: astore 6
    //   123: aconst_null
    //   124: astore 5
    //   126: new 103	com/a/a/a/a/ae
    //   129: dup
    //   130: invokespecial 104	com/a/a/a/a/ae:<init>	()V
    //   133: ldc 106
    //   135: aload 6
    //   137: invokevirtual 109	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: goto -22 -> 118
    //   143: astore 6
    //   145: goto -19 -> 126
    //   148: goto -30 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	x
    //   0	151	1	paramLong	long
    //   72	29	3	l	long
    //   39	86	5	localObject1	Object
    //   6	109	6	localObject2	Object
    //   121	15	6	localSQLiteException1	SQLiteException
    //   143	1	6	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	41	121	android/database/sqlite/SQLiteException
    //   46	114	143	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public j a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 56	com/a/a/a/a/x:a	Lcom/a/a/a/a/af;
    //   6: invokevirtual 63	com/a/a/a/a/af:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: ldc 65
    //   11: aconst_null
    //   12: ldc 112
    //   14: iconst_2
    //   15: anewarray 69	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_2
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 101	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +82 -> 116
    //   37: aload_3
    //   38: invokeinterface 115 1 0
    //   43: ifeq +73 -> 116
    //   46: aload_3
    //   47: invokestatic 117	com/a/a/a/a/x:a	(Landroid/database/Cursor;)Lcom/a/a/a/b/j;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: aload_3
    //   58: invokeinterface 96 1 0
    //   63: aload_2
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +40 -> 111
    //   74: aload_3
    //   75: invokeinterface 96 1 0
    //   80: aconst_null
    //   81: astore_1
    //   82: goto -17 -> 65
    //   85: astore_2
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +9 -> 99
    //   93: aload_1
    //   94: invokeinterface 96 1 0
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: aload_3
    //   103: astore_1
    //   104: goto -15 -> 89
    //   107: astore_1
    //   108: goto -38 -> 70
    //   111: aconst_null
    //   112: astore_1
    //   113: goto -48 -> 65
    //   116: aconst_null
    //   117: astore_2
    //   118: goto -67 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	x
    //   0	121	1	paramString1	String
    //   0	121	2	paramString2	String
    //   32	71	3	localCursor	Cursor
    //   1	86	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	33	67	android/database/sqlite/SQLiteException
    //   3	33	85	finally
    //   37	51	101	finally
    //   37	51	107	android/database/sqlite/SQLiteException
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    try
    {
      a.getWritableDatabase().delete("mistat_event", "ts<=? AND ts>=?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        new ae().a("Error while deleting event by ts from DB", localSQLiteException);
      }
    }
  }
  
  public void a(j paramj)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("category", paramj.a);
    String str;
    if (TextUtils.isEmpty(paramj.c)) {
      str = "";
    }
    for (;;)
    {
      localContentValues.put("key", str);
      localContentValues.put("ts", Long.valueOf(paramj.b));
      if (TextUtils.isEmpty(paramj.d))
      {
        str = "";
        label64:
        localContentValues.put("type", str);
        if (!TextUtils.isEmpty(paramj.e)) {
          break label143;
        }
        str = "";
        label84:
        localContentValues.put("value", str);
        if (!TextUtils.isEmpty(paramj.f)) {
          break label151;
        }
        str = "";
        localContentValues.put("extra", str);
      }
      try
      {
        a.getWritableDatabase().insert("mistat_event", "", localContentValues);
        return;
        str = paramj.c;
        continue;
        str = paramj.d;
        break label64;
        label143:
        str = paramj.e;
        break label84;
        label151:
        str = paramj.f;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          new ae().a("Error to insert data into DB, key=" + paramj.c, localSQLiteException);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("value", paramString3);
    try
    {
      a.getWritableDatabase().update("mistat_event", localContentValues, "category=? AND key=?", new String[] { paramString2, paramString1 });
      return;
    }
    catch (SQLiteException paramString2)
    {
      for (;;)
      {
        new ae().a("Error to update data from DB, key=" + paramString1, paramString2);
      }
    }
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    try
    {
      a.getWritableDatabase().delete("mistat_event", "ts<=? and category <> ?", new String[] { String.valueOf(l - 259200000L), "mistat_basic" });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        new ae().a("Error while deleting old data from DB", localSQLiteException);
      }
    }
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 56	com/a/a/a/a/x:a	Lcom/a/a/a/a/af;
    //   5: invokevirtual 63	com/a/a/a/a/af:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: ldc 65
    //   10: iconst_1
    //   11: anewarray 69	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: ldc -52
    //   18: aastore
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 101	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +46 -> 77
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: invokeinterface 115 1 0
    //   44: ifeq +33 -> 77
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: iconst_0
    //   53: invokeinterface 208 2 0
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: aload 4
    //   63: ifnull +12 -> 75
    //   66: aload 4
    //   68: invokeinterface 96 1 0
    //   73: iload_2
    //   74: istore_1
    //   75: iload_1
    //   76: ireturn
    //   77: aload 4
    //   79: ifnull +10 -> 89
    //   82: aload 4
    //   84: invokeinterface 96 1 0
    //   89: iconst_0
    //   90: istore_1
    //   91: goto -16 -> 75
    //   94: astore 5
    //   96: aconst_null
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: new 103	com/a/a/a/a/ae
    //   105: astore 6
    //   107: aload 4
    //   109: astore_3
    //   110: aload 6
    //   112: invokespecial 104	com/a/a/a/a/ae:<init>	()V
    //   115: aload 4
    //   117: astore_3
    //   118: aload 6
    //   120: ldc -46
    //   122: aload 5
    //   124: invokevirtual 109	com/a/a/a/a/ae:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload 4
    //   129: ifnull -40 -> 89
    //   132: aload 4
    //   134: invokeinterface 96 1 0
    //   139: goto -50 -> 89
    //   142: astore 4
    //   144: aload_3
    //   145: ifnull +9 -> 154
    //   148: aload_3
    //   149: invokeinterface 96 1 0
    //   154: aload 4
    //   156: athrow
    //   157: astore 4
    //   159: goto -15 -> 144
    //   162: astore 5
    //   164: goto -65 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	x
    //   60	31	1	i	int
    //   58	16	2	j	int
    //   1	148	3	localObject1	Object
    //   27	106	4	localCursor	Cursor
    //   142	13	4	localObject2	Object
    //   157	1	4	localObject3	Object
    //   94	29	5	localSQLiteException1	SQLiteException
    //   162	1	5	localSQLiteException2	SQLiteException
    //   105	14	6	localae	ae
    // Exception table:
    //   from	to	target	type
    //   2	29	94	android/database/sqlite/SQLiteException
    //   2	29	142	finally
    //   37	47	157	finally
    //   50	59	157	finally
    //   102	107	157	finally
    //   110	115	157	finally
    //   118	127	157	finally
    //   37	47	162	android/database/sqlite/SQLiteException
    //   50	59	162	android/database/sqlite/SQLiteException
  }
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */