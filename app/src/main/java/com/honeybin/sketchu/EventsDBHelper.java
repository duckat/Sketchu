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
    public static final String EVENTS_COLUMN_ID = "_id";
    public static final String EVENTS_COLUMN_NAME = "name";
    public static final String EVENTS_COLUMN_START_TIME = "start_time";
    public static final String EVENTS_COLUMN_END_TIME = "end_time";
    //public static final String EVENTS_COLUMN_DURATION_MIN = "duration_min";
    public static final String EVENTS_COLUMN_DETAIL = "detail";
    private HashMap hp;

    public EventsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
          "create table events " +
                  "(_id integer primary key autoincrement, name text, start_time text, end_time text, detail text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }

    public Cursor getEventCursor() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor eventCursor = db.rawQuery("SELECT  * FROM events", null);
        return eventCursor;
    }

    public boolean insertEvent (String name, String startTime, String endTime, String detail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name", name);
        contentvalues.put("start_time", startTime);
        contentvalues.put("end_time", endTime);
        contentvalues.put("detail", detail);
        db.insert("events", null, contentvalues);
        return true;
    }

    public Integer deleteEvent (long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("events", "_id = ? ",
        new String[] { Long.toString(id)});
    }

    public boolean updateEvent (long id, String name, String startTime, String endTime, String detail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("start_time",startTime);
        cv.put("end_time",endTime);
        cv.put("detail",detail);
        db.update("events", cv, "_id = ? ", new String[] { Long.toString(id) } );
        return true;
    }

/*
    public Event editData(int id, String name, int durationMin, String detail) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from events", null);
        res.moveToFirst();

        while(res.isAfterLast() == false) {
            int row_id = res.getInt(res.getColumnIndex(EVENTS_COLUMN_ID));
            if(row_id == id) {

            }

            res.moveToNext();
        }
    }
*/
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
            String startTime = res.getString(res.getColumnIndex(EVENTS_COLUMN_START_TIME));
            String endTime = res.getString(res.getColumnIndex(EVENTS_COLUMN_END_TIME));
            String detail = res.getString(res.getColumnIndex(EVENTS_COLUMN_DETAIL));
            Event e = new Event(name, startTime, endTime, detail);
            events_list.add(e);
            res.moveToNext();
        }
        return events_list;
    }
}