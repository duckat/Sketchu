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
    public static final String EVENTS_COLUMN_TAG_ONE = "tag_one";
    public static final String EVENTS_COLUMN_TAG_TWO = "tag_two";
    public static final String EVENTS_COLUMN_TAG_THREE = "tag_three";
    public static final String EVENTS_COLUMN_TAG_FOUR = "tag_four";
    public static final String EVENTS_COLUMN_DETAIL = "detail";
    private HashMap hp;

    public EventsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
          "create table events " +
                  "(_id integer primary key autoincrement, name text, start_time text, end_time text, detail text, tag_one text, tag_two text, tag_three text, tag_four text)"
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

    public boolean insertEvent (String name, String startTime, String endTime, String detail, String tagOne, String tagTwo, String tagThree, String tagFour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name", name);
        contentvalues.put("start_time", startTime);
        contentvalues.put("end_time", endTime);
        contentvalues.put("detail", detail);
        contentvalues.put("tag_one",tagOne);
        contentvalues.put("tag_two", tagTwo);
        contentvalues.put("tag_three", tagThree);
        contentvalues.put("tag_four", tagFour);
        db.insert("events", null, contentvalues);
        return true;
    }

    public Event getEvent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(EVENTS_TABLE_NAME, new String[] { EVENTS_COLUMN_NAME,
                        EVENTS_COLUMN_START_TIME, EVENTS_COLUMN_END_TIME, EVENTS_COLUMN_DETAIL, EVENTS_COLUMN_TAG_ONE,
        EVENTS_COLUMN_TAG_TWO, EVENTS_COLUMN_TAG_THREE, EVENTS_COLUMN_TAG_FOUR}, EVENTS_COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Event event = new Event(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
        return event;
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
            String tagOne = res.getString(res.getColumnIndex(EVENTS_COLUMN_TAG_ONE));
            String tagTwo = res.getString(res.getColumnIndex(EVENTS_COLUMN_TAG_TWO));
            String tagThree = res.getString(res.getColumnIndex(EVENTS_COLUMN_TAG_THREE));
            String tagFour = res.getString(res.getColumnIndex(EVENTS_COLUMN_TAG_FOUR));
            Event e = new Event(name, startTime, endTime, detail, tagOne, tagTwo, tagThree, tagFour);
            events_list.add(e);
            res.moveToNext();
        }
        return events_list;
    }
}