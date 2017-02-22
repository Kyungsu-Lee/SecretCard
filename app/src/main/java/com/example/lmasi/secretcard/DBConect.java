package com.example.lmasi.secretcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConect extends SQLiteOpenHelper {

    public DBConect(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists ShinHan(idx integer PRIMARY KEY, number integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /////flow
    //Activity_Start    Activity_Main   Activity_Local  Activity_chooseStore    Activity_ShopList   Activity_ChooseCoupons  Activity_TimeLine   Activity_Result
}
