package com.taohf.appbase;

import android.app.Application;

import com.taohf.appbase.database.DaoMaster;
import com.taohf.appbase.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by hongfei.tao on 2017/4/27 17:36.
 */
public class App extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initSQLite();
    }

    private void initSQLite() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), "app.db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }
}
