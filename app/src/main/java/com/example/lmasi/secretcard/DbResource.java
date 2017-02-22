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

    public static void insert(int index, int number)
    {
        db.execSQL("insert into ShinHan values (" + index + ","+ number +");");
    }

    public static void update(int idx, int number)
    {
        db.execSQL("update ShinHan set number = " + number + " where idx = " + idx + ";");
    }

    public static int get(int index)
    {

        Cursor c = db.rawQuery("select number from ShinHan where idx = " + index, null);
        c.moveToNext();

        if(c.getCount() == 0)
            return 0;

        return c.getInt(0);
    }
}
