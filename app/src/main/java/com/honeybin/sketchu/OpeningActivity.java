package com.honeybin.sketchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OpeningActivity extends AppCompatActivity {
    private boolean isSketchuNamed = false;
    public static final String Name = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);
                String sketchuTempName = sketchuData.getString(Name, "Name undefined");

                if(sketchuTempName.equals("Name undefined")) {
                    Intent i = new Intent(getApplicationContext(), NameActivity.class);
                    startActivityForResult(i, RESULT_OK);
                } else {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(i, RESULT_OK);
                }
            }
        }, 2500);


    }
}
