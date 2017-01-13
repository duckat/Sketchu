package com.honeybin.sketchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        String name = i.getExtras().getString("name");
        int duration = i.getExtras().getInt("duration");
        String detail = i.getExtras().getString("detail");

        final EditText nameEditText = (EditText) findViewById(R.id.editText);
        EditText durationEditText = (EditText) findViewById(R.id.editText2);
        EditText detailEditText = (EditText) findViewById(R.id.editText3);
        nameEditText.setText(name, EditText.BufferType.EDITABLE);
        durationEditText.setText(duration + "", EditText.BufferType.EDITABLE);
        detailEditText.setText(detail, EditText.BufferType.EDITABLE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Editable test = nameEditText.getText();
                Toast.makeText(getBaseContext(), test, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getBaseContext(), "Successfully updated!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
