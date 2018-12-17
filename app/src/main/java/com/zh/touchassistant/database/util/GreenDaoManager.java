package com.zh.touchassistant.database.util;

import android.database.sqlite.SQLiteDatabase;

import com.zh.touchassistant.database.gen.DaoMaster;
import com.zh.touchassistant.database.gen.DaoSession;
import com.zh.touchassistant.provider.ContextProvider;

/**
 * <b>Package:</b> com.zh.touchassistant.database.util <br>
 * <b>FileName:</b> GreenDaoManager <br>
 * <b>Create Date:</b> 2018/12/17  下午3:27 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class GreenDaoManager {
    private static final String DB_NAME = "touch_assistant_db";

    private static volatile GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        if (mInstance == null) {
            TouchAssistantSQLiteOpenHelper openHelper = new TouchAssistantSQLiteOpenHelper(ContextProvider.get().getContext(), DB_NAME);
            SQLiteDatabase db = openHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(db);
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}