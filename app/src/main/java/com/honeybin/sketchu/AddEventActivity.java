package com.honeybin.sketchu;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStartTimePicker, btnEndTimePicker;
    private int mHour, mMinute;
    private EditText txtStart, txtEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnStartTimePicker = (Button) findViewById(R.id.setStartTimeButton);
        btnEndTimePicker = (Button) findViewById(R.id.setEndTimeButton);
        txtStart=(EditText)findViewById(R.id.startTimeText);
        txtEnd=(EditText)findViewById(R.id.endTimeText);

        btnStartTimePicker.setOnClickListener(this);
        btnEndTimePicker.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnStartTimePicker) {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtStart.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if(v == btnEndTimePicker) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtEnd.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
