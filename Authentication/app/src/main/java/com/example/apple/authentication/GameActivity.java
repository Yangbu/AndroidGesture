package com.example.apple.authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class GameActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private MediaPlayer mpMusic = null;
    private String currentStage;
    private int monsterHP;
    private int playerHP;

    //widgets
    private TextView tvGameStage,tvMonsterHP,tvPlayerHP;
    private Button btnGameQuit;
    private ImageView ivMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        tvGameStage = (TextView)findViewById(R.id.tv_game_stage);
        tvMonsterHP = (TextView)findViewById(R.id.tv_monster_hp);
        tvPlayerHP = (TextView)findViewById(R.id.tv_player_hp);
        btnGameQuit = (Button)findViewById(R.id.btn_game_quit);
        ivMonster = (ImageView)findViewById(R.id.iv_monster);

        btnGameQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initStage();
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
        mpMusic = MediaPlayer.create(this, R.raw.music_game);
        try{
            mpMusic.prepare();
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initStage(){
        //Set current stage title
        Intent intentStartedFrom = getIntent();
        currentStage = intentStartedFrom.getStringExtra("stageChosen");
        if(currentStage!=null) tvGameStage.setText("Stage "+currentStage);
        //Set HPs
        switch(currentStage){
            case "1-1":
                tvMonsterHP.setText("HP:100");
                tvPlayerHP.setText("HP:100");
                break;
            case "1-2":
                tvMonsterHP.setText("HP:200");
                tvPlayerHP.setText("HP:100");
                break;
            case "1-3":
                tvMonsterHP.setText("HP:300");
                tvPlayerHP.setText("HP:100");
                break;
            case "1-4":
                tvMonsterHP.setText("HP:400");
                tvPlayerHP.setText("HP:100");
                break;
            case "1-5":
                tvMonsterHP.setText("HP:500");
                tvPlayerHP.setText("HP:100");
                ivMonster.setBackgroundResource(R.drawable.monster_king);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
