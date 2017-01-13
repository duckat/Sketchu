package com.honeybin.sketchu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by klee166 on 1/13/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE EVENT (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, duration_min INTEGER, detail TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, int durationMin, String detail) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO EVENT VALUES(null, '" + name + "', " + durationMin + ", '" + detail + "');");
        db.close();
    }

    public void delete() {


    }
}
