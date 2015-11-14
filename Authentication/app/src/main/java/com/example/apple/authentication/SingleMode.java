package com.example.apple.authentication;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

public class SingleMode extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    Button bLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink;
    /* Is there a ConnectionResult resolution in progress? */
    private boolean mIsResolving = false;

    /* Should we automatically resolve ConnectionResults when possible? */
    private boolean mShouldResolve = false;
    private static final int RC_SIGN_IN =0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayermode);

        etUsername = (EditText)findViewById(R.id.TFusername);
        etPassword = (EditText)findViewById(R.id.TFpassword);
        //bLogin = (Button)findViewById(R.id.bLogin);
        //tvRegisterLink = (TextView)findViewById(R.id.tvRegisterLink);

        //bLogin.setOnClickListener(this);
        // tvRegisterLink.setOnClickListener(this);


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



    public void onButtonClick(View v)
    {
        if(v.getId()==R.id.Blogin){
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str=a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass=b.getText().toString();

            String password= helper.searchPass(str);
            if (pass.equals(password)) {
                Intent i = new Intent(SingleMode.this, StagesActivity.class);
                i.putExtra("Username", str);
                i.putExtra("login",true);
                startActivity(i);
            }
            else
            {
                Toast temp=Toast.makeText(SingleMode.this,"Username & Passwords don't match",Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if(v.getId()==R.id.Bsignup){
            Intent i=new Intent(SingleMode.this,SignUp.class);
            i.putExtra("login",true);
            startActivity(i);
        }

    }
}