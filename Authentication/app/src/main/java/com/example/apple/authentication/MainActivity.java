package com.example.apple.authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.io.IOException;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    static{
//        if(!OpenCVLoader.initDebug()){
//            Log.i("opencv", "opencv initialized failed");
//
//        }else{
//            Log.i("opencv","opencv initialized successfully!!");
//            //some changes
//        }
//
//    }

    //private Button btnMainSinglePlayer,btnMainMultiPlayer,btnMainExtra,btnMainSettings,btnMainExit;
    private SharedPreferences sharedPref;

    private MediaPlayer mpMusic = null;

    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        initSounds();
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_single_player).setOnClickListener(this);
        findViewById(R.id.btn_main_multi_player).setOnClickListener(this);
        findViewById(R.id.btn_main_extra).setOnClickListener(this);
        findViewById(R.id.btn_main_settings).setOnClickListener(this);
        findViewById(R.id.btn_main_exit).setOnClickListener(this);

       /* findViewById(R.id.btn_main_single_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StagesActivity.class));
            }
        });

        findViewById(R.id.btn_main_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        findViewById(R.id.btn_main_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        //Button btn= (Button) findViewById(R.id.button1);

        /*findViewById(R.id.btn_main_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });*/

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMediaPlayer.pause();
                Intent intent = new Intent(MainActivity.this, StagesActivity.class);
                startActivity(intent);
            }
        });

        Button btn1= (Button) findViewById(R.id.button5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_main_single_player:
                startActivity(new Intent(MainActivity.this,SingleMode.class));
                break;
            case R.id.btn_main_multi_player:
                startActivity(new Intent(MainActivity.this,MultiMode.class));
                break;
            case R.id.btn_main_extra:
                startActivity(new Intent(MainActivity.this,ExtraActivity.class));
                break;
            case R.id.btn_main_settings:
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                break;
            case R.id.btn_main_exit:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMusic();
        boolean prefMusicSwitch = sharedPref.getBoolean("prefMusicSwitch",true);
        if(mpMusic!=null && prefMusicSwitch==true){
            mpMusic.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mpMusic!=null) mpMusic.release();
    }

    public void initMusic()
    {
        mpMusic = MediaPlayer.create(this, R.raw.music_main);
        try{
            mpMusic.prepare();
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public void initSounds()
    {
        //mMediaPlayer = MediaPlayer.create(this, R.raw.music_main);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(1, soundPool.load(this, R.raw.effect, 1));
        soundPoolMap.put(2, soundPool.load(this, R.raw.bird, 1));
    }
    public void playSound(int sound, int loop)
    {
        AudioManager mgr = (AudioManager) this
                .getSystemService(Context.AUDIO_SERVICE);
        float streamVolumeCurrent = mgr
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float streamVolumeMax = mgr
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = streamVolumeCurrent / streamVolumeMax;
        soundPool.play(soundPoolMap.get(sound), volume, volume, 1, loop, 1f);
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

}
