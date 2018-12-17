package com.zh.touchassistant.database.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.zh.touchassistant.database.gen.AutoHideFloatEntityDao;
import com.zh.touchassistant.database.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * <b>Package:</b> com.zh.touchassistant.database.util <br>
 * <b>FileName:</b> TouchAssistantSQLiteOpenHelper <br>
 * <b>Create Date:</b> 2018/12/17  下午3:28 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class TouchAssistantSQLiteOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = TouchAssistantSQLiteOpenHelper.class.getSimpleName();

    public TouchAssistantSQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public TouchAssistantSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion == newVersion) {
            Log.i(TAG, "数据库无需升级");
            return;
        }
        Log.i(TAG, "数据库从" + oldVersion + "升级到 ::: " + newVersion + "版本");
        //使用GreenDaoUpgradeHelper辅助类进行升级
        MigrationHelper.migrate(db,
                AutoHideFloatEntityDao.class
        );
    }
}