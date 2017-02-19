package com.honeybin.sketchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailActivity extends AppCompatActivity {
    private EventsDBHelper events_db;
    private Button removeEventButton;
    private Button editButton;
    private String nameString;
    private String startTimeString;
    private String endTimeString;
    private String detailString;
    private EditText nameEditText;
    private EditText startTimeText;
    private EditText endTimeText;
    private EditText detailEditText;
    private TextView tagOneText;
    private TextView tagTwoText;
    private TextView tagThreeText;
    private TextView tagFourText;
    private long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        events_db = new EventsDBHelper(this);

        Intent i = getIntent();
        String name = i.getExtras().getString("name");
        String startTime = i.getExtras().getString("startTime");
        String endTime = i.getExtras().getString("endTime");
        int duration = i.getExtras().getInt("duration");
        String detail = i.getExtras().getString("detail");
        String tagOne = i.getExtras().getString("tagOne");
        String tagTwo = i.getExtras().getString("tagTwo");
        String tagThree = i.getExtras().getString("tagThree");
        String tagFour = i.getExtras().getString("tagFour");

        id = i.getExtras().getInt("id");

        nameEditText = (EditText) findViewById(R.id.editText4);
        startTimeText = (EditText) findViewById(R.id.startText);
        endTimeText = (EditText) findViewById(R.id.endText);
        detailEditText = (EditText) findViewById(R.id.editText3);
        tagOneText = (TextView) findViewById(R.id.tagOneText);
        tagTwoText = (TextView) findViewById(R.id.tagTwoText);
        tagThreeText = (TextView) findViewById(R.id.tagThreeText);
        tagFourText = (TextView) findViewById(R.id.tagFourText);


        nameEditText.setText(name);
        startTimeText.setText(startTime);
        endTimeText.setText(endTime);
        detailEditText.setText(detail);
        tagOneText.setText(tagOne);
        tagTwoText.setText(tagTwo);
        tagThreeText.setText(tagThree);
        tagFourText.setText(tagFour);

        /*
        nameEditText.setText(name, EditText.BufferType.EDITABLE);
        startTimeText.setText(startTime, EditText.BufferType.EDITABLE);
        endTimeText.setText(endTime, EditText.BufferType.EDITABLE);
        detailEditText.setText(detail, EditText.BufferType.EDITABLE);
        */
        removeEventButton = (Button) findViewById(R.id.removeEventButton);


        removeEventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                events_db.deleteEvent(id);
                MainActivity.shouldPlay = true;
                finish();
//                Intent i = new Intent(getApplicationContext(), EventListActivity.class);
//                startActivity(i);
            }
        });

        editButton = (Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = nameEditText.getText().toString();
                detailString = detailEditText.getText().toString();
                startTimeString = startTimeText.getText().toString();
                endTimeString = endTimeText.getText().toString();

                events_db.updateEvent(id, nameString, startTimeString, endTimeString, detailString);
//                Intent i = new Intent(getApplicationContext(), EventListActivity.class);
//                startActivity(i);
                MainActivity.shouldPlay = true;
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

    @Override
    public void onBackPressed(){
        //doesn't do anything
    }
}
