package com.honeybin.sketchu;

import android.animation.ValueAnimator;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

//AddEventsActivity
//what is it
public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStartTimePicker, btnEndTimePicker;
    private Button addButton;
    private Button backButton;
    private Button tagButton1, tagButton2, tagButton3, tagButton4;
    private int startHour, startMinute;
    private int endHour, endMinute;
    private int mHour, mMinute;
    private EventsDBHelper dbHelper;
    private TextView txtStart, txtEnd;
    private EditText txtName, txtDetail;
    private String[] choices = {"1", "2", "3", "4"};
    private String choice1, choice2, choice3, choice4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        dbHelper = new EventsDBHelper(this);


        btnStartTimePicker = (Button) findViewById(R.id.setStartTimeButton);
        btnEndTimePicker = (Button) findViewById(R.id.setEndTimeButton);
        addButton = (Button) findViewById(R.id.confirmButton);
        backButton = (Button) findViewById(R.id.backButton);
        tagButton1 = (Button) findViewById(R.id.tagButton1);
        tagButton2 = (Button) findViewById(R.id.tagButton2);
        tagButton3 = (Button) findViewById(R.id.tagButton3);
        tagButton4 = (Button) findViewById(R.id.tagButton4);


        txtName = (EditText)findViewById(R.id.nameTxt);
        txtDetail = (EditText) findViewById(R.id.detailTxt);
        txtStart=(TextView)findViewById(R.id.startTimeText);
        txtEnd=(TextView)findViewById(R.id.endTimeText);

        btnStartTimePicker.setOnClickListener(this);
        btnEndTimePicker.setOnClickListener(this);
        addButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        tagButton1.setOnClickListener(this);
        tagButton2.setOnClickListener(this);
        tagButton3.setOnClickListener(this);
        tagButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnStartTimePicker) {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            startHour = c.get(Calendar.HOUR_OF_DAY);
            startMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtStart.setText(hourOfDay + ":" + minute);
                        }
                    }, startHour, startMinute, false);
            timePickerDialog.show();
        }

        if(v == btnEndTimePicker) {
            final Calendar c = Calendar.getInstance();
            endHour = c.get(Calendar.HOUR_OF_DAY);
            endMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtEnd.setText(hourOfDay + ":" + minute);
                        }
                    }, endHour, endMinute, false);
            timePickerDialog.show();
        }
        if(v == addButton) {
            String name = txtName.getText().toString();
            String detail = txtDetail.getText().toString();
            String startTime = txtStart.getText().toString();
            String endTime = txtEnd.getText().toString();


            dbHelper.insertEvent(name, startTime, endTime, detail, choices[0], choices[1], choices[2], choices[3]);
            //EventListActivity.eventList.add(new Event(name, startHour, startMinute, endHour, endMinute, detail));
//            Intent i = new Intent(getApplicationContext(), EventListActivity.class);
//            startActivity(i);
            MainActivity.shouldPlay = true;
            this.finish();
//            EventListActivity.listViewNotify();
//            onBackPressed();
        }
        if(v == backButton) {
//            Intent i = new Intent(getApplicationContext(), EventListActivity.class);
//            startActivity(i);
            MainActivity.shouldPlay = true;
            finish();
        }
        if(v == tagButton1){
            MainActivity.shouldPlay = true;
            Intent i = new Intent(getApplicationContext(), SelectTagActivity.class);
            i.putExtra("tag", 1);
            startActivityForResult(i, 1);
        }
        if(v == tagButton2){
            MainActivity.shouldPlay = true;
            Intent i = new Intent(getApplicationContext(), SelectTagActivity.class);
            i.putExtra("tag", 2);
            startActivityForResult(i, 2);
        }
        if(v == tagButton3){
            MainActivity.shouldPlay = true;
            Intent i = new Intent(getApplicationContext(), SelectTagActivity.class);
            i.putExtra("tag", 3);
            startActivityForResult(i, 3);
        }
        if(v == tagButton4){
            MainActivity.shouldPlay = true;
            Intent i = new Intent(getApplicationContext(), SelectTagActivity.class);
            i.putExtra("tag", 4);
            startActivityForResult(i, 4);
        }
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
    public void onBackPressed() {
        //does nothing
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("codes", requestCode + " / " + resultCode);

//        switch(resultCode){
//            case 1: choice1 = data.getStringExtra("choice"); break;
//            case 2: choice2 = data.getStringExtra("choice"); break;
//            case 3: choice3 = data.getStringExtra("choice"); break;
//            case 4: choice4 = data.getStringExtra("choice"); break;
//            default: break;
//        }

        if(resultCode >=1 && resultCode <= 4){
            choices[resultCode - 1] = data.getStringExtra("choice");
            Toast.makeText(getApplicationContext(), "HI + " + choices[resultCode - 1], Toast.LENGTH_SHORT).show();
        }



        tagButton1.setText(choices[0]);
        tagButton2.setText(choices[1]);
        tagButton3.setText(choices[2]);
        tagButton4.setText(choices[3]);

    }
}
