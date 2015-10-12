package com.example.apple.loginui;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import org.opencv.android.OpenCVLoader;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    static{
        if(!OpenCVLoader.initDebug()){
            Log.i("opencv", "opencv initialized failed");

        }else{
            Log.i("opencv","opencv initialized successfully!!");
            //some changes
        }

    }

    MediaPlayer mMediaPlayer;
    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSounds();
        mMediaPlayer.start();
        setContentView(R.layout.activity_main);
        Button btn= (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
                Intent intent = new Intent(MainActivity.this, stage.class);
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

    }
    public void initSounds()
    {
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
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
