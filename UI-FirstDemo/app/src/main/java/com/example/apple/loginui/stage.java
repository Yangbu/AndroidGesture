package com.example.apple.loginui;

/**
 * Created by apple on 10/8/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class stage extends AppCompatActivity {
    Button m1Button,m2Button,m3Button,m4Button,m5Button,m6Button,m7Button,m8Button,m9Button,m10Button,m11Button,m12Button,m13Button,m14Button,m15Button,m16Button,m17Button,m18Button,m19Button,
            m20Button;
    MediaPlayer mMediaPlayer1;
    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initSounds();
        mMediaPlayer1.start();
        Button btn= (Button) findViewById(R.id.button25);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer1.pause();
                Intent intent = new Intent(stage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button btn1= (Button) findViewById(R.id.button26);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer1.pause();
                Intent intent = new Intent(stage.this, GameActivity.class);
                startActivity(intent);
            }
        });
//stage 1
        m1Button=(Button)findViewById(R.id.button1);
        m2Button=(Button)findViewById(R.id.button9);
        m3Button=(Button)findViewById(R.id.button);
        m4Button=(Button)findViewById(R.id.button10);
        m5Button=(Button)findViewById(R.id.button11);
 //stage 2
        m6Button=(Button)findViewById(R.id.button4);
        m7Button=(Button)findViewById(R.id.button7);
        m8Button=(Button)findViewById(R.id.button12);
        m9Button=(Button)findViewById(R.id.button13);
        m10Button=(Button)findViewById(R.id.button14);
// stage 3
        m11Button=(Button)findViewById(R.id.button15);
        m12Button=(Button)findViewById(R.id.button16);
        m13Button=(Button)findViewById(R.id.button17);
        m14Button=(Button)findViewById(R.id.button18);
        m15Button=(Button)findViewById(R.id.button19);
//stage 4
        m16Button=(Button)findViewById(R.id.button20);
        m17Button=(Button)findViewById(R.id.button21);
        m18Button=(Button)findViewById(R.id.button22);
        m19Button=(Button)findViewById(R.id.button23);
        m20Button=(Button)findViewById(R.id.button24);


        m1Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.v1);
            }
        });
        m2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.v1);
            }
        });
        m3Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.v1);
            }
        });
        m4Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.v1);
            }
        });
        m5Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.v1);
            }
        });
        m6Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.volcano);
            }
        });
        m7Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.volcano);
            }
        });
        m8Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.volcano);
            }
        });
        m9Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.volcano);
            }
        });
        m10Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.volcano);
            }
        });
        m11Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.m1);
            }
        });
        m12Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.m1);
            }
        });
        m13Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.m1);
            }
        });
        m14Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.m1);
            }
        });
        m15Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.m1);
            }
        });
        m16Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.sky);
            }
        });
        m17Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.sky);
            }
        });
        m18Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.sky);
            }
        });
        m19Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.sky);
            }
        });
        m20Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getWindow().setBackgroundDrawableResource(R.drawable.sky);
            }
        });
    }
    public void initSounds()
    {
        mMediaPlayer1 = MediaPlayer.create(this, R.raw.music1);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(1, soundPool.load(this, R.raw.effect, 1));
        soundPoolMap.put(2, soundPool.load(this, R.raw.bird, 1));
    }

    /**
     * ²¥·ÅÒôÐ§µÄ·½·¨
     */
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

