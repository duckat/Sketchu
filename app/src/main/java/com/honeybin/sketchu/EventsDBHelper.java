package com.honeybin.sketchu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

//Events Database
public class EventsDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyEvents.db";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String EVENTS_COLUMN_ID = "id";
    public static final String EVENTS_COLUMN_NAME = "name";
    public static final String EVENTS_COLUMN_DURATION_MIN = "duration_min";
    public static final String EVENTS_COLUMN_DETAIL = "detail";
    private HashMap hp;

    public EventsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
          "create table events " +
                  "(id integer primary key, name text, duration_min INTEGER, detail text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }

    public boolean insertEvent (String name, int durationMin, String detail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name", name);
        contentvalues.put("duration_min", durationMin);
        contentvalues.put("detail", detail);
        db.insert("events", null, contentvalues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from events where id="+id+"", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, EVENTS_TABLE_NAME);
        return numRows;
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> events_list = new ArrayList<Event>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from events", null);
        res.moveToFirst();

        while(res.isAfterLast() == false) {
            String name = res.getString(res.getColumnIndex(EVENTS_COLUMN_NAME));
            int durationMin = res.getInt(res.getColumnIndex(EVENTS_COLUMN_DURATION_MIN));
            String detail = res.getString(res.getColumnIndex(EVENTS_COLUMN_DETAIL));
            Event e = new Event(name, durationMin, detail);
            events_list.add(e);
            res.moveToNext();
        }
        return events_list;
    }
}