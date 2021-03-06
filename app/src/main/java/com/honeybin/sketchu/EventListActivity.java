package com.honeybin.sketchu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.honeybin.sketchu.R.id.addEventButton;
import static com.honeybin.sketchu.R.id.backEventButton;
import static com.honeybin.sketchu.R.id.completeButton;
import static com.honeybin.sketchu.R.id.eventListView;

public class EventListActivity extends AppCompatActivity {

    private ListView eventListView;
    private EventCursorAdapter eventListAdapter;
    private EventsDBHelper eventsdb;
    public static ArrayList<Event> eventList = new ArrayList<Event>();
    private Button addButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventListView = (ListView) findViewById(R.id.eventListView);

        eventsdb = new EventsDBHelper(this);
        eventList  = eventsdb.getAllEvents();
        addButton = (Button) findViewById(addEventButton);
        addButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.shouldPlay = true;
                Intent i = new Intent(getApplicationContext(), AddEventActivity.class);
                startActivityForResult(i, RESULT_OK);
            }
        });
        backButton = (Button) findViewById(backEventButton);
        backButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.shouldPlay = true;
//                Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(i);
                MainActivity.shouldPlay = true;
                finish();
            }
        });

        eventListAdapter = new EventCursorAdapter(this, eventsdb.getEventCursor());
        eventListView.setAdapter(eventListAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

//                String item = ((TextView)view).getText().toString();
//
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                MainActivity.shouldPlay = true;

                Intent i = new Intent(getApplicationContext(), EventDetailActivity.class);
                Event e = eventList.get(position);
                int adapterPosition = position - eventListView.getHeaderViewsCount();
                Cursor cursor = (Cursor) eventListAdapter.getItem(adapterPosition);
                int row_id = cursor.getInt(cursor.getColumnIndex("_id"));

                i.putExtra("name", e.getName());
                i.putExtra("startTime", e.getStartTime());
                i.putExtra("endTime", e.getEndTime());
                i.putExtra("detail", e.getDetail());
                i.putExtra("tagOne", e.getTagOne());
                i.putExtra("tagTwo", e.getTagTwo());
                i.putExtra("tagThree", e.getTagThree());
                i.putExtra("tagFour", e.getTagFour());
                i.putExtra("id", row_id);

                startActivityForResult(i, RESULT_OK);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
//        listViewNotify();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                eventListAdapter.notifyDataSetChanged();
//            }
//        });
        if (eventListView != null)
        {
            updateData();
        }
        Log.d("EventListActivity", "onResume");
        MainActivity.resumeBGM();
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.stopBGM();
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        eventListAdapter.notifyDataSetChanged();
//
//    }
    private void updateData()
    {
        eventList = eventsdb.getAllEvents();
        eventListAdapter = new EventCursorAdapter(this, eventsdb.getEventCursor());
        eventListView.setAdapter(eventListAdapter);
    }
    @Override
    public void onBackPressed(){

        //does not do anything
    }

}
