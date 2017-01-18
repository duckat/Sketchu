package com.honeybin.sketchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button eventButton;
    private Button foodButton;
    private static MediaPlayer mp;
    public static boolean shouldPlay = false;
    public boolean startBackground = true;
    private Sketchu mySketchu;
    private HashMap<String, Integer> beanBag;
    /*
    private SharedPreferences sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.backgroundmusic);

        /*
        mp.setLooping(true);
        mp.start();
        */

        beanBag = new HashMap<String, Integer>();
        beanBag.put("Study Bean", 3);
        beanBag.put("Workout Bean", 2);



        ImageView sketchuMotion = (ImageView) findViewById(R.id.sketchuPic);
        ((AnimationDrawable) sketchuMotion.getBackground()).start();

        eventButton = (Button) findViewById(R.id.eventButton);

        eventButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable d = getResources().getDrawable(R.drawable.eventlistbuttonpressed);

                eventButton.setBackgroundDrawable(d);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shouldPlay = true;
                        Intent i = new Intent(getApplicationContext(), EventListActivity.class);
                        Drawable d1 = getResources().getDrawable(R.drawable.eventlistbutton);
                        eventButton.setBackgroundDrawable(d1);
                        startActivity(i);
                    }
                }, 100);
                //eventButton.setBackgroundDrawable(d1);
            }
        });
        foodButton = (Button) findViewById(R.id.foodButton);

        foodButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable d = getResources().getDrawable(R.drawable.eventlistbuttonpressed);

                foodButton.setBackgroundDrawable(d);
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, foodButton);
                popup.getMenu().add("new menu: 1");
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu

            }
        });

        createSketchu();

        TextView tv1 = (TextView)findViewById(R.id.sketchuName);
        tv1.setText(mySketchu.getName());

        TextView tv2 = (TextView)findViewById(R.id.sketchuAge);
        tv2.setText("Week " + mySketchu.getAge());
        startBackground = false;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void createSketchu(){
        mySketchu = new Sketchu();
    }
/*
    private void loadSketchu() {
        sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);

        sketchuData.getInt("hunger", 0);
        sketchuData.getInt("cleanliness", 0);
        sketchuData.getInt("drowsiness", 0);
        sketchuData.getInt("knowledge", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        sketchuData.getInt("", 0);
        mySketchu = new Sketchu();

    }
*/


    @Override
    public void onResume(){
        super.onResume();
//        Log.d("onresume", mySketchu.getLastUpdate());
        mySketchu.update();
//        Log.d("onresume", mySketchu.getLastUpdate());

        ProgressBar hungerBar = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar loveBar = (ProgressBar) findViewById(R.id.progressBar2);

        hungerBar.setProgress(mySketchu.getHunger());
        loveBar.setProgress(mySketchu.getLove());

        //shouldPlay = false;
        //resumeBGM();
    }

    @Override
    public void onStop() {
        super.onStop();
    //    stopBGM();
    }



    //This should go into every activity's onStop() method as override.
    //public static void stopBGM(){
    //    if (!shouldPlay) { // pause music if it should not play
    //        mp.pause();
    //    }
    //}

    //This should go into every activity's onResume() method as override.
    //public static void resumeBGM(){
//  //      shouldPlay = false;
    //    if(!mp.isPlaying()){
    //        mp.start();
    //    }
    // }
}
