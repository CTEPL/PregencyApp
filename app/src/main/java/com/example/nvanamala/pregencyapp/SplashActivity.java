package com.example.nvanamala.pregencyapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

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
        Intent intent = new Intent(this,NavigationDrawerActivity.class);
        startActivity(intent);
    }
}
