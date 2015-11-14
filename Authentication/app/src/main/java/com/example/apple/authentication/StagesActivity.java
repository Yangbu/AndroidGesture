package com.example.apple.authentication;

/**
 * Created by apple on 10/8/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.HashMap;

public class StagesActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPref;

    private MediaPlayer mpMusic = null;

    private Button btnStage1_1,btnStage1_2,btnStage1_3,btnStage1_4,btnStage1_5,
                    btnStage2_1,btnStage2_2,btnStage2_3,btnStage2_4,btnStage2_5,
                    btnStage3_1,btnStage3_2,btnStage3_3,btnStage3_4,btnStage3_5,
                    btnStage4_1,btnStage4_2,btnStage4_3,btnStage4_4,btnStage4_5,
                    btnStageBack,btnStageGo;

    private String stagePointer;
    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stages);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        //set default background
        getWindow().setBackgroundDrawableResource(R.drawable.map);
        initSounds();
        initButtons();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_stage_back:
                finish();
                break;
            case R.id.btn_stage_go:
                if(stagePointer == null)break;
                Intent intentStartGame = new Intent(StagesActivity.this,GameActivity.class);
                intentStartGame.putExtra("stageChosen",stagePointer);
                startActivity(intentStartGame);
                break;
            case R.id.btn_stage1_1:
                getWindow().setBackgroundDrawableResource(R.drawable.background_village);
                stagePointer = "1-1";
                break;
            case R.id.btn_stage1_2:
                getWindow().setBackgroundDrawableResource(R.drawable.background_village);
                stagePointer = "1-2";
                break;
            case R.id.btn_stage1_3:
                getWindow().setBackgroundDrawableResource(R.drawable.background_village);
                stagePointer = "1-3";
                break;
            case R.id.btn_stage1_4:
                getWindow().setBackgroundDrawableResource(R.drawable.background_village);
                stagePointer = "1-4";
                break;
            case R.id.btn_stage1_5:
                getWindow().setBackgroundDrawableResource(R.drawable.background_village);
                stagePointer = "1-5";
                break;
            case R.id.btn_stage2_1:
                getWindow().setBackgroundDrawableResource(R.drawable.background_volcano);
                stagePointer = "2-1";
                break;
            case R.id.btn_stage2_2:
                getWindow().setBackgroundDrawableResource(R.drawable.background_volcano);
                stagePointer = "2-2";
                break;
            case R.id.btn_stage2_3:
                getWindow().setBackgroundDrawableResource(R.drawable.background_volcano);
                stagePointer = "2-3";
                break;
            case R.id.btn_stage2_4:
                getWindow().setBackgroundDrawableResource(R.drawable.background_volcano);
                stagePointer = "2-4";
                break;
            case R.id.btn_stage2_5:
                getWindow().setBackgroundDrawableResource(R.drawable.background_volcano);
                stagePointer = "2-5";
                break;
            case R.id.btn_stage3_1:
                getWindow().setBackgroundDrawableResource(R.drawable.background_marine);
                stagePointer = "3-1";
                break;
            case R.id.btn_stage3_2:
                getWindow().setBackgroundDrawableResource(R.drawable.background_marine);
                stagePointer = "3-2";
                break;
            case R.id.btn_stage3_3:
                getWindow().setBackgroundDrawableResource(R.drawable.background_marine);
                stagePointer = "3-3";
                break;
            case R.id.btn_stage3_4:
                getWindow().setBackgroundDrawableResource(R.drawable.background_marine);
                stagePointer = "3-4";
                break;
            case R.id.btn_stage3_5:
                getWindow().setBackgroundDrawableResource(R.drawable.background_marine);
                stagePointer = "3-5";
                break;
            case R.id.btn_stage4_1:
                getWindow().setBackgroundDrawableResource(R.drawable.background_sky);
                stagePointer = "4-1";
                break;
            case R.id.btn_stage4_2:
                getWindow().setBackgroundDrawableResource(R.drawable.background_sky);
                stagePointer = "4-2";
                break;
            case R.id.btn_stage4_3:
                getWindow().setBackgroundDrawableResource(R.drawable.background_sky);
                stagePointer = "4-3";
                break;
            case R.id.btn_stage4_4:
                getWindow().setBackgroundDrawableResource(R.drawable.background_sky);
                stagePointer = "4-4";
                break;
            case R.id.btn_stage4_5:
                getWindow().setBackgroundDrawableResource(R.drawable.background_sky);
                stagePointer = "4-5";
                break;

        }
    }

    public void initButtons()
    {
        btnStageBack= (Button)findViewById(R.id.btn_stage_back);
        btnStageGo= (Button)findViewById(R.id.btn_stage_go);

        //Stage 1
        btnStage1_1=(Button)findViewById(R.id.btn_stage1_1);
        btnStage1_2=(Button)findViewById(R.id.btn_stage1_2);
        btnStage1_3=(Button)findViewById(R.id.btn_stage1_3);
        btnStage1_4=(Button)findViewById(R.id.btn_stage1_4);
        btnStage1_5=(Button)findViewById(R.id.btn_stage1_5);
        //Stage 2
        btnStage2_1=(Button)findViewById(R.id.btn_stage2_1);
        btnStage2_2=(Button)findViewById(R.id.btn_stage2_2);
        btnStage2_3=(Button)findViewById(R.id.btn_stage2_3);
        btnStage2_4=(Button)findViewById(R.id.btn_stage2_4);
        btnStage2_5=(Button)findViewById(R.id.btn_stage2_5);
// Stage 3
        btnStage3_1=(Button)findViewById(R.id.btn_stage3_1);
        btnStage3_2=(Button)findViewById(R.id.btn_stage3_2);
        btnStage3_3=(Button)findViewById(R.id.btn_stage3_3);
        btnStage3_4=(Button)findViewById(R.id.btn_stage3_4);
        btnStage3_5=(Button)findViewById(R.id.btn_stage3_5);
//Stage 4
        btnStage4_1=(Button)findViewById(R.id.btn_stage4_1);
        btnStage4_2=(Button)findViewById(R.id.btn_stage4_2);
        btnStage4_3=(Button)findViewById(R.id.btn_stage4_3);
        btnStage4_4=(Button)findViewById(R.id.btn_stage4_4);
        btnStage4_5=(Button)findViewById(R.id.btn_stage4_5);

        btnStageBack.setOnClickListener(this);
        btnStageGo.setOnClickListener(this);
        btnStage1_1.setOnClickListener(this);
        btnStage1_2.setOnClickListener(this);
        btnStage1_3.setOnClickListener(this);
        btnStage1_4.setOnClickListener(this);
        btnStage1_5.setOnClickListener(this);
        btnStage2_1.setOnClickListener(this);
        btnStage2_2.setOnClickListener(this);
        btnStage2_3.setOnClickListener(this);
        btnStage2_4.setOnClickListener(this);
        btnStage2_5.setOnClickListener(this);
        btnStage3_1.setOnClickListener(this);
        btnStage3_2.setOnClickListener(this);
        btnStage3_3.setOnClickListener(this);
        btnStage3_4.setOnClickListener(this);
        btnStage3_5.setOnClickListener(this);
        btnStage4_1.setOnClickListener(this);
        btnStage4_2.setOnClickListener(this);
        btnStage4_3.setOnClickListener(this);
        btnStage4_4.setOnClickListener(this);
        btnStage4_5.setOnClickListener(this);
    }

    public void initMusic()
    {
        mpMusic = MediaPlayer.create(this, R.raw.music_stages);
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
        //mMediaPlayer1 = MediaPlayer.create(this, R.raw.music_stages);
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

