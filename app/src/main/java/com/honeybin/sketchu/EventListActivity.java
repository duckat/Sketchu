package com.honeybin.sketchu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.honeybin.sketchu.R.id.addEventButton;

public class EventListActivity extends AppCompatActivity {

    private ListView eventListView;
    private ArrayAdapter<Event> eventListAdapter;
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventListView = (ListView) findViewById(R.id.eventListView);


        for(int i = 0; i < 30; i++) {
            Event e = new Event("hello", 1.0, 1.0, "This is hello event");
            eventList.add(e);
        }

        addButton = (Button) findViewById(addEventButton);
        addButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddEventActivity.class);
                startActivity(i);
            }
        });

        eventListAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, eventList);
        eventListView.setAdapter(eventListAdapter);
    }
}
