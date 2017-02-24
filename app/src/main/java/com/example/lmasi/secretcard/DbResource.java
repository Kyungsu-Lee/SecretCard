package com.example.lmasi.secretcard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Vector;

public class DbResource {

    public static DBConect conn;
    public static SQLiteDatabase db;

    public static void insert(String bank, int index, int number)
    {
        db.execSQL("insert into ShinHan values ('" + bank + "', " + index + ","+ number +");");
    }

    public static void update(int idx, int number, String bank)
    {
        db.execSQL("update ShinHan set number = " + number + " where idx = " + idx + " and bank = '" + bank + "';");
    }

    public static int get(int index, String bank)
    {

        Cursor c = db.rawQuery("select number from ShinHan where idx = " + index + " and bank = '" + bank + "';", null);
        c.moveToNext();

        if(c.getCount() == 0)
            return 0;

        return c.getInt(0);
    }
}
