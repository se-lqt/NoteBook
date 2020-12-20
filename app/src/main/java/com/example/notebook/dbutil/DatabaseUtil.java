package com.example.notebook.dbutil;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 2018/10/14.
 */

public class DatabaseUtil extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PhoneBook.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseUtil(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }

    /**
     * 建立数据表
     * */
    private void createTable(SQLiteDatabase db){
        db.execSQL("create table UserInfo(" +
                "_id integer primary key autoincrement," + "userName text," + "userPhone text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
