package com.a.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class af
  extends SQLiteOpenHelper
{
  public static final Object a = new Object();
  
  public af(Context paramContext)
  {
    super(paramContext, "mistat.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (a)
    {
      paramSQLiteDatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, category text, ts integer, key text, value text, type text, extra text)", new Object[] { "mistat_event" }));
      return;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              /Users/wally/Downloads/091615pltj0byl8hjhyp8b-dex/classes-d2j.jar!/com/a/a/a/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */