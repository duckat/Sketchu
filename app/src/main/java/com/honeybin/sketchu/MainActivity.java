package com.honeybin.sketchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
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

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button eventButton;
    private Button foodButton;
    private ClipDrawable mImageDrawable;
    private static MediaPlayer mp;
    public static boolean shouldPlay = false;
    public boolean startBackground = true;
    private Sketchu mySketchu;
    private HashMap<String, Integer> beanBag;
    private ImageView sketchuImage;
    public static final int MAX_LEVEL = 10000;
    public static final int LEVEL_DIFF = 100;
    public static final int DELAY = 30;
    public static final String myPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static Typeface custom_font;

    private int mLevel = 0;
    private int fromLevel = 0;
    private int toLevel = 0;

    private Handler mDownHandler = new Handler();

    private Runnable animateDownImage = new Runnable() {
        @Override
        public void run() {
            doTheDownAnimation(fromLevel, toLevel);
        }
    };

    /*
    public static final String hunger = "hungerKey";
    public static final String love = "loveKey";
    public static final String knowledge = "knowledgeKey";
    public static final String creativity = "creativityKey";
    public static final String comprehensibility = "comprehensibilityKey";
    public static final String musicalAbility = "musicalKey";
    public static final String appearance = "appearanceKey";
    public static final String physicality = "physicalKey";
    public static final String fitness = "fitnessKey";
    public static final String sociability = "sociabilityKey";
    public static final String friendliness = "friendlinessKey";
    public static final String expressiveness = "expressivenessKey";
    public static final String confidence = "confidenceKey";
    public static final String concentration = "concentrationKey";
    public static final String sentimentality = "sentimentalityKey";
    public static final String shoppingImpulsiveness = "shoppingImpulsivenessKey";
    public static final String otakuness = "otakunessKey";
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.backgroundmusic);


        mp.setLooping(true);

        SharedPreferences sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);

        String sketchuTempName = sketchuData.getString(Name, "Name undefined");

        createSketchu(sketchuTempName);

        beanBag = new HashMap<String, Integer>();
        beanBag.put("Study Bean", 3);
        beanBag.put("Workout Bean", 2);



        TextView sketchuName = (TextView)findViewById(R.id.sketchuName);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/rudimentfont.ttf");
        sketchuName.setTypeface(custom_font);


        ImageView sketchuMotion = (ImageView) findViewById(R.id.sketchuNamePic);
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

        //createSketchu(temp);

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
    private void createSketchu(String name){
        mySketchu = new Sketchu(name);
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


        ImageView img = (ImageView) findViewById(R.id.progressGauge);
        mImageDrawable = (ClipDrawable) img.getDrawable();
        mImageDrawable.setLevel(mySketchu.getHunger());

        /*
        int temp_level = ((Integer.parseInt(etPercent.getText().toString())) * MAX_LEVEL) / 100;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel = (temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {

            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            MainActivity.this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
        }

        */

        /*
        ProgressBar hungerBar = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar loveBar = (ProgressBar) findViewById(R.id.progressBar2);

        hungerBar.setProgress(mySketchu.getHunger());
        loveBar.setProgress(mySketchu.getLove());
*/
        Log.d("MainActivity", "onResume");
//        mp.start();
        resumeBGM();
    }

    private void doTheDownAnimation(int fromLevel, int toLevel) {
        //mySketchu.getHunger() -= LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if(mLevel >= toLevel) {
            mDownHandler.postDelayed(animateDownImage, DELAY);

        } else {
            mDownHandler.removeCallbacks(animateDownImage);
            MainActivity.this.fromLevel = toLevel;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
        stopBGM();

    }



    //This should go into every activity's onStop() method as override.
    public static void stopBGM(){
        if (!shouldPlay) { // pause music if it should not play
            mp.pause();
        }
        shouldPlay = false;
    }

    //This should go into every activity's onResume() method as override.
    public static void resumeBGM(){
  //      shouldPlay = false;
        if(!mp.isPlaying()){
            mp.start();
        }
     }

    @Override
    public void onBackPressed() {
        //does nothing
    }
}
