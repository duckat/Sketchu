package com.honeybin.sketchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EventDetailActivity extends AppCompatActivity {
    private EventsDBHelper events_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        events_db = new EventsDBHelper(this);

        Intent i = getIntent();
        String name = i.getExtras().getString("name");
        String startTime = i.getExtras().getString("startTime");
        String endTime = i.getExtras().getString("endTime");
        int duration = i.getExtras().getInt("duration");
        String detail = i.getExtras().getString("detail");
        final int id = i.getExtras().getInt("id");

        final EditText nameEditText = (EditText) findViewById(R.id.editText4);
        EditText startTimeText = (EditText) findViewById(R.id.startText);
        EditText endTimeText = (EditText) findViewById(R.id.endText);
        EditText detailEditText = (EditText) findViewById(R.id.editText3);
        nameEditText.setText(name, EditText.BufferType.EDITABLE);
        startTimeText.setText(startTime, EditText.BufferType.EDITABLE);
        endTimeText.setText(endTime, EditText.BufferType.EDITABLE);
        detailEditText.setText(detail, EditText.BufferType.EDITABLE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Editable test = nameEditText.getText();

//                events_db.getData(id);

                Toast.makeText(getBaseContext(), id + "", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getBaseContext(), "Successfully updated!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        MainActivity.resumeBGM();
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.stopBGM();
    }
}
