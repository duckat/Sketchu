package com.honeybin.sketchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button eventButton;
    private Button foodButton;
    private ClipDrawable mImageDrawableHunger, mImageDrawableLove;
    private static MediaPlayer mp;
    public static boolean shouldPlay = false;
    public boolean startBackground = true;
    private Sketchu mySketchu;
    private HashMap<String, Integer> beanBag;
    private ImageView sketchuImage;
    public static final int MAX_LEVEL = 10000;
    public static final int LEVEL_DIFF = 50;
    public static final int DELAY = 30;
    public static final String myPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static Typeface custom_font;

    private int mLevelHunger, mLevelLove = 0;
    private int fromLevelHunger, fromLevelLove = 0;
    private int toLevelHunger, toLevelLove = 0;

    private Handler mDownHandler = new Handler();

    private Runnable animateDownImageHunger = new Runnable() {
        @Override
        public void run() {
            doTheDownAnimationHunger(fromLevelHunger, toLevelHunger);
//            doTheDownAnimationLove(fromLevelLove, toLevelLove);
        }
    };
    private Runnable animateDownImageLove = new Runnable() {
        @Override
        public void run() {
//            doTheDownAnimationHunger(fromLevelHunger, toLevelHunger);
            doTheDownAnimationLove(fromLevelLove, toLevelLove);
        }
    };
    private Handler mUpHandler = new Handler();
    private Runnable animateUpImageHunger = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimationHunger(fromLevelHunger, toLevelHunger);
//            doTheUpAnimationLove(fromLevelLove, toLevelLove);
        }
    };
    private Runnable animateUpImageLove = new Runnable() {

        @Override
        public void run() {
//            doTheUpAnimationHunger(fromLevelHunger, toLevelHunger);
            doTheUpAnimationLove(fromLevelLove, toLevelLove);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.backgroundmusic);
        mp.setLooping(true);

        final SharedPreferences sketchuData = getSharedPreferences("Sketchu", MODE_PRIVATE);

        String sketchuTempName = sketchuData.getString(Name, "Name undefined");

        createSketchu(sketchuTempName);

        beanBag = new HashMap<String, Integer>();
        beanBag.put("Study Bean", 3);
        beanBag.put("Workout Bean", 2);

        //initializing drawables for bars
        ImageView img = (ImageView) findViewById(R.id.hungerBarContent);
        mImageDrawableHunger = (ClipDrawable) img.getDrawable();
        mImageDrawableHunger.setLevel(0);
        ImageView img2 = (ImageView) findViewById(R.id.loveBarContent);
        mImageDrawableLove = (ClipDrawable) img2.getDrawable();
        mImageDrawableLove.setLevel(0);

        TextView sketchuName = (TextView)findViewById(R.id.sketchuName);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/rudimentfont.ttf");
        sketchuName.setTypeface(custom_font);


        final ImageView sketchuMotion = (ImageView) findViewById(R.id.sketchuNamePic);
        ((AnimationDrawable) sketchuMotion.getBackground()).start();

/*
        sketchuMotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 500);
            }
        });

*/


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



    @Override
    public void onResume(){
        super.onResume();
//        Log.d("onresume", mySketchu.getLastUpdate());
        mySketchu.update();
//        Log.d("onresume", mySketchu.getLastUpdate());
        onClickOk();

        Log.d("MainActivity", "onResume");
        resumeBGM();
    }

    private void doTheUpAnimationHunger(int fromLevel, int toLevel) {
        mLevelHunger += LEVEL_DIFF;
        mImageDrawableHunger.setLevel(mLevelHunger);
        if (mLevelHunger <= toLevel) {
            Log.d("DUA", "1st cond " + mLevelHunger + " / " + toLevel);
            mUpHandler.postDelayed(animateUpImageHunger, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImageHunger);
            Log.d("DUA", "2nd cond " + mLevelHunger + " / " + toLevel);
            MainActivity.this.fromLevelHunger = toLevel;
        }
    }
    private void doTheUpAnimationLove(int fromLevel, int toLevel) {
        mLevelLove += LEVEL_DIFF;
        mImageDrawableLove.setLevel(mLevelLove);
        if (mLevelLove <= toLevel) {
            Log.d("DUA", "1st cond " + mLevelLove + " / " + toLevel);
            mUpHandler.postDelayed(animateUpImageLove, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImageLove);
            Log.d("DUA", "2nd cond " + mLevelLove+ " / " + toLevel);
            MainActivity.this.fromLevelLove = toLevel;
        }
    }

    private void doTheDownAnimationHunger(int fromLevel, int toLevel) {
        mLevelHunger -= LEVEL_DIFF;
        mImageDrawableHunger.setLevel(mLevelHunger);
        if (mLevelHunger >= toLevel) {
            Log.d("DDA", "1st cond " + mLevelHunger + " / " + toLevel);
            mDownHandler.postDelayed(animateDownImageHunger, DELAY);
        } else {
            Log.d("DDA", "2nd cond " + mLevelHunger + " / " + toLevel);
            mDownHandler.removeCallbacks(animateDownImageHunger);
            MainActivity.this.fromLevelHunger = toLevel;
        }
    }

    private void doTheDownAnimationLove(int fromLevel, int toLevel) {
        mLevelLove -= LEVEL_DIFF;
        mImageDrawableLove.setLevel(mLevelLove);
        if (mLevelLove >= toLevel) {
            Log.d("DDA", "1st cond " + mLevelLove + " / " + toLevel);
            mDownHandler.postDelayed(animateDownImageLove, DELAY);
        } else {
            Log.d("DDA", "2nd cond " + mLevelLove + " / " + toLevel);
            mDownHandler.removeCallbacks(animateDownImageLove);
            MainActivity.this.fromLevelLove = toLevel;
        }
    }

    public void onClickOk() {
        Log.d("onclickok", "enter");
        int tempHunger = (mySketchu.getHunger() * MAX_LEVEL) / 100;
        int tempLove = (mySketchu.getLove() * MAX_LEVEL) / 100;
        drawHunger(tempHunger);
        drawLove(tempLove);
    }

    public void drawHunger(int tempHunger){
        if (toLevelHunger == tempHunger || tempHunger > MAX_LEVEL) {
            return;
        }
        toLevelHunger = (tempHunger <= MAX_LEVEL) ? tempHunger : toLevelHunger;
        if (toLevelHunger > fromLevelHunger) {
            // cancel previous process first
            Log.d("onclickok", "to > from");
            mDownHandler.removeCallbacks(animateDownImageHunger);
            MainActivity.this.fromLevelHunger = toLevelHunger;

            mUpHandler.post(animateUpImageHunger);
        } else {
            // cancel previous process first
            Log.d("onclickok", "else");
            mUpHandler.removeCallbacks(animateUpImageHunger);
            MainActivity.this.fromLevelHunger = toLevelHunger;

            mDownHandler.post(animateDownImageHunger);
        }
    }
    public void drawLove(int tempLove){
        if (toLevelLove == tempLove || tempLove > MAX_LEVEL) {
            return;
        }
        toLevelLove = (tempLove <= MAX_LEVEL) ? tempLove : toLevelLove;
        if (toLevelLove > fromLevelLove) {
            // cancel previous process first
            Log.d("onclickok", "to > from");
            mDownHandler.removeCallbacks(animateDownImageLove);
            MainActivity.this.fromLevelLove = toLevelLove;

            mUpHandler.post(animateUpImageLove);
        } else {
            // cancel previous process first
            Log.d("onclickok", "else");
            mUpHandler.removeCallbacks(animateUpImageLove);
            MainActivity.this.fromLevelLove = toLevelLove;

            mDownHandler.post(animateDownImageLove);
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
