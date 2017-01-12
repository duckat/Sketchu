package com.honeybin.sketchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private ListView eventListView;
    private ArrayAdapter<Event> eventListAdapter;
    private ArrayList<Event> eventList = new ArrayList<Event>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventListView = (ListView) findViewById(R.id.eventListView);

        for(int i = 0; i < 30; i++) {
            Event e = new Event("hello", 1.0, 1.0, "This is hello event");
            eventList.add(e);
        }

        eventListAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, eventList);
        eventListView.setAdapter(eventListAdapter);
    }
}
