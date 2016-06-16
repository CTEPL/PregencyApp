package com.example.nvanamala.pregnencyapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This class used to display splash screen to the user
 */
public class SplashActivity extends AppCompatActivity implements Runnable {

    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        mHandler.postDelayed(this,5000);
    }

    @Override
    public void run() {
        if(Utils.getBooleanFromSP(this,"LoggedIn")){
            Intent intent = new Intent(this,NavigationDrawerActivity.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
