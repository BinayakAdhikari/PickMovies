package com.rent.blaze.pickmovies;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreen();
    }

    public void splashScreen() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent startMainActivity =
                        new Intent(SplashScreen.this, OnThePick.class);
                startActivity(startMainActivity);
                finish();

            }
        }, SPLASH_TIME);


    }
}
