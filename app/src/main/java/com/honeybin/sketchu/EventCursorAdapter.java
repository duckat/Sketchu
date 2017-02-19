package com.honeybin.sketchu;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EventCursorAdapter extends CursorAdapter {

    private final Context ctx;
    private Button tagButton;
    private TextView name;
    private EventsDBHelper events_db;
    public EventCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        ctx = context;
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, final Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false);
    }



    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, final Cursor cursor) {
        final int itemId = cursor.getInt(cursor.getColumnIndex("_id"));
        // Find fields to populate in inflated template
        name = (TextView) view.findViewById(R.id.nameCursor);
        // Extract properties from cursor
        String nameString = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        // Populate fields with extracted properties
        name.setText(nameString);
        events_db = new EventsDBHelper(ctx);

        tagButton = (Button) view.findViewById(R.id.completeButton);
        tagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event e = events_db.getEvent(itemId);
                Toast.makeText(ctx, e.getTagOne() + " / " + e.getTagTwo() + " / " + e.getTagThree() + " / " + e.getTagFour(), Toast.LENGTH_SHORT).show();
                MainActivity.mySketchu.raiseStats(e.getTagOne(), e.getDurationMin());
                events_db.deleteEvent(itemId);
                cursor.requery();
                notifyDataSetChanged();
            }
        });

    }
}