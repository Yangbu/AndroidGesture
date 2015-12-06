package com.example.gesturegame;


	
	import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
	import android.os.Handler;
	import android.os.Looper;
	import android.os.Message;
    import android.view.View;
	import android.view.animation.Animation;
	import android.view.animation.AnimationUtils;
	import android.widget.TextView;

	import java.util.Random;



	public class SingleGameActivity extends Activity implements View.OnClickListener{
		
		DatabaseHelper helper=new DatabaseHelper(this);

	    TextView tvMonsterHP, tvPlayerHP, tvMonsterGesture, tvPlayerGesture, tvCounting, tvCompareResult;
	    //Button btnReady, btnRock, btnScissor, btnPaper;
	    int playerGesture = 0;
	    int monsterGesture = -1;
	    Animation anim3, anim2, anim1;
	    Handler handler;
	    int monsterHP, playerHP;
	    int flagStarted = 0;
	    String currentStage;
	    String nextStage;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.single_game_activity);
	        tvMonsterHP = (TextView)findViewById(R.id.tv_monster_hp);
	        tvPlayerHP = (TextView)findViewById(R.id.tv_player_hp);
	        tvMonsterGesture = (TextView)findViewById(R.id.tv_monster_gesture);
	        tvPlayerGesture = (TextView)findViewById(R.id.tv_player_gesture);
	        tvCounting = (TextView)findViewById(R.id.tv_counting);
	        tvCompareResult = (TextView)findViewById(R.id.tv_compare_result);
	        findViewById(R.id.btn_ready).setOnClickListener(this);
	        findViewById(R.id.btn_rock).setOnClickListener(this);
	        findViewById(R.id.btn_scissor).setOnClickListener(this);
	        findViewById(R.id.btn_paper).setOnClickListener(this);
	        monsterHP = 10;
	        playerHP = 100;

	        AnimInit();

	        handler = new Handler(Looper.getMainLooper()){
	            @Override
	            public void handleMessage(Message msg) {
	                super.handleMessage(msg);

	                //long counting end
	                //show compare result
	                if(msg.what == 3000){
	                    GenerateRandomMonsterGesture();
	                    DisplayMonsterGesture();
	                    if(CompareGestures()==1){
	                        monsterHP = monsterHP - 10;
	                        tvMonsterHP.setText("HP: "+monsterHP);
	                        tvCompareResult.setText("Win!");
	                    }
	                    if(CompareGestures()==-1){
	                        playerHP = playerHP - 10;
	                        tvPlayerHP.setText("HP:"+playerHP);
	                        tvCompareResult.setText("Lose!");
	                    }
	                    if(CompareGestures()==0){
	                        tvCompareResult.setText("Draw!");
	                    }
	                    new Thread(new MyCounter(1000)).start();
	                       /* new Thread(new MyCounter(3)).start();
	                        AnimStart();*/
	                }

	                //short counting end
	                //stop showing result
	                //see if another long counting will start
	                if(msg.what==1000){
	                    if(monsterHP!=0&&playerHP!=0){
	                        tvMonsterGesture.setText("Gesture: ");
	                        tvCompareResult.setText("");
	                        AnimStart();
	                        new Thread(new MyCounter(3000)).start();
	                    }else if(monsterHP ==0){
	                    	showWin();
	                    	//win
	                    }else{
	                    	showLose();
	                    	//lose
	                    }
	                }
	            }
	        };
	    }
	    
	    //new
	    public void showWin(){
	    	AlertDialog dialog = new AlertDialog.Builder(this)
	    	.setMessage("Congratulation")
	    	.setNegativeButton("Play Again",
	    			 new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialog, int whichButton) { 
	            	Intent intent3 = getIntent();
	            	Bundle bunde2 = intent3.getExtras();
	            	
	            	
	            	Intent intent = new Intent(SingleGameActivity.this, SingleGameActivity.class);
	            	intent.putExtras(bunde2);
	                startActivity(intent); 
	            }  
	        })
	    	.setPositiveButton("Next Stage",
	    			 new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialog, int whichButton) {  
	                Intent intent2 = getIntent();
	            	Bundle bunde = intent2.getExtras();  	                
	                
	                String uname = bunde.getString("uname");  
	                currentStage = bunde.getString("stageChosen");
	            	helper.modifyContact(uname, currentStage);
	            	
	            	nextStage();
	            	Intent intentStartGame = new Intent(SingleGameActivity.this,SingleGameActivity.class);
	                Intent intentStartedFrom = getIntent();
	                Bundle bundle = new Bundle();  
	                bundle.putString("stageChosen",nextStage);
	                bundle.putString("uname", uname);
	                intentStartGame.putExtras(bundle);
	                startActivity(intentStartGame);
//	            	Intent intent3 = new Intent(SingleGameActivity.this, StagesActivity.class);
//	                startActivity(intent3); 
	                
	            }  
	        })  
	    	.show();
	    }
	    
	    public void nextStage(){
	    	switch (currentStage){
            case "1-1":
                nextStage = "1-2";
                break;
            case "1-2":
                nextStage = "1-3";
                break;
            case "1-3":
                nextStage = "1-4";
                break;
            case "1-4":
            	nextStage = "1-5";
                break;
            case "1-5":
            	nextStage = "2-1";
                break;
            case "2-1":
            	nextStage = "2-2";
                break;
            case "2-2":
            	nextStage = "2-3";
                break;
            case "2-3":
            	nextStage = "2-4";
                break;
            case "2-4":
            	nextStage = "2-5";
                break;
            case "2-5":
            	nextStage = "3-1";
                break;
            case "3-1":
            	nextStage = "3-2";
                break;
            case "3-2":
            	nextStage = "3-3";
                break;
            case "3-3":
            	nextStage = "3-4";
                break;
            case "3-4":
            	nextStage = "3-5";
                break;
            case "4-1":
            	nextStage = "4-2";
                break;
            case "4-2":
            	nextStage = "4-3";
                break;
            case "4-3":
            	nextStage = "4-4";
                break;
            case "4-4":
            	nextStage = "4-5";
                break;
                


        }
	    }
	    
	    public void showLose(){
	    	AlertDialog dialog = new AlertDialog.Builder(this)
	    	.setMessage("You failed")
	    	.setNegativeButton("Play Again",
	    			 new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialog, int whichButton) {  
	            	Intent intent = new Intent(SingleGameActivity.this, SingleGameActivity.class);
	                startActivity(intent); 
	            }  
	        })
	    	.show();
	    }
	    	


	    @Override
	    public void onClick(View v) {
	        switch (v.getId()){
	            case R.id.btn_ready:
	                AnimStart();
	                break;
	            case R.id.btn_rock:
	                playerGesture= 0;
	                tvPlayerGesture.setText("Rock");
	                break;
	            case R.id.btn_scissor:
	                playerGesture= 2;
	                tvPlayerGesture.setText("Scissor");
	                break;
	            case R.id.btn_paper:
	                playerGesture= 5;
	                tvPlayerGesture.setText("Paper");
	                break;
	            default:
	                break;
	        }
	    }

	    public void AnimInit(){
	        anim3 = new AnimationUtils().loadAnimation(SingleGameActivity.this, R.anim.anim_scale_alpha);
	        anim2 = new AnimationUtils().loadAnimation(SingleGameActivity.this, R.anim.anim_scale_alpha);
	        anim1 = new AnimationUtils().loadAnimation(SingleGameActivity.this, R.anim.anim_scale_alpha);

	        anim3.setAnimationListener(new Animation.AnimationListener() {
	            @Override
	            public void onAnimationStart(Animation animation) {
	            }
	            @Override
	            public void onAnimationEnd(Animation animation) {
	                System.out.println("3 end");
	                tvCounting.setText("2");
	                tvCounting.startAnimation(anim2);
	            }
	            @Override
	            public void onAnimationRepeat(Animation animation) {
	            }
	        });

	        anim2.setAnimationListener(new Animation.AnimationListener() {
	            @Override
	            public void onAnimationStart(Animation animation) {
	            }
	            @Override
	            public void onAnimationEnd(Animation animation) {
	                System.out.println("2 end");
	                tvCounting.setText("1");
	                tvCounting.startAnimation(anim1);
	            }
	            @Override
	            public void onAnimationRepeat(Animation animation) {
	            }
	        });

	        anim1.setAnimationListener(new Animation.AnimationListener() {
	            @Override
	            public void onAnimationStart(Animation animation) {
	            }
	            @Override
	            public void onAnimationEnd(Animation animation) {
	                System.out.println("1 end");
	                tvCounting.setText("");
	                if(flagStarted==0){
	                    flagStarted = 1;
	                    AnimStart();
	                    new Thread(new MyCounter(3000)).start();
	                }
	            }
	            @Override
	            public void onAnimationRepeat(Animation animation) {
	            }
	        });
	    }

	    public void AnimStart(){
	        tvCounting.setText("3");
	        tvCounting.startAnimation(anim3);
	    }

	    public class MyCounter implements Runnable {
	       int time = 0;

	        public MyCounter(int time) {
	            super();
	            this.time = time;
	        }

	        @Override
	        public void run() {
	            try {
	                Message message = new Message();
	                message.what = this.time;
	                Thread.sleep(this.time);
	                handler.sendMessage(message);
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	        }
	    }

	    public void GenerateRandomMonsterGesture(){
			Bundle b = getIntent().getExtras();
			int fingers = b.getInt("fingers");
	    	switch (fingers){
	    	case -1:
//				userChoice = Choice.UNKNOWN;
				break;
	    		
			case 0:
			case 1:
				monsterGesture = 0;
				break;

			case 2:
			case 3:
				monsterGesture = 2;
				break;

			default:
				monsterGesture = 5;
				break;
	        }
	    }

	    public void DisplayMonsterGesture(){
	        switch (monsterGesture){
	            case 0:
	                tvMonsterGesture.setText("Rock");
	                break;
	            case 2:
	                tvMonsterGesture.setText("Scissor");
	                break;
	            case 5:
	                tvMonsterGesture.setText("Paper");
	                break;
	            default:
	                break;
	        }
	    }

	    public int CompareGestures(){
	        if(monsterGesture==playerGesture) return 0;
	        if(monsterGesture==0 && playerGesture==2) return -1;
	        if(monsterGesture==0 && playerGesture==5) return 1;
	        if(monsterGesture==2 && playerGesture==0) return 1;
	        if(monsterGesture==2 && playerGesture==5) return -1;
	        if(monsterGesture==5 && playerGesture==0) return -1;
	        if(monsterGesture==5 && playerGesture==2) return 1;
	        return 100;
	    }
	}


