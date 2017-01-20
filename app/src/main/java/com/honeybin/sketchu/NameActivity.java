package com.honeybin.sketchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NameActivity extends AppCompatActivity {

    private Button confirmButton;
    private EditText nameEdit;
    public static final String Name = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


        ImageView sketchuMotion = (ImageView) findViewById(R.id.sketchuPic);
        ((AnimationDrawable) sketchuMotion.getBackground()).start();

        confirmButton = (Button) findViewById(R.id.confirmButton);
        nameEdit = (EditText) findViewById(R.id.sketchuEditText);

        confirmButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                SharedPreferences sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);
                SharedPreferences.Editor editor = sketchuData.edit();
                editor.putString(Name, name);
                editor.commit();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(i, RESULT_OK);
            }
        });

    }
    @Override
    public void onBackPressed() {
        // does nothing;
    }
}
