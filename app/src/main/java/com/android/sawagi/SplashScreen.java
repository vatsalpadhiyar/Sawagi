package com.android.sawagi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.sawagi.login.LoginScreen;

public class SplashScreen extends AppCompatActivity {

    public static Typeface Roboto_Regular, Roboto_Bold;
    // Loading screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Roboto_Regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "Roboto-Regular.ttf");
        Roboto_Bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "Roboto-Bold.ttf");

        //call Handler for Timer
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing loading screen with a timer. This will be useful when you
             * want to show case your app logo / companyR
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over

                // Open your app   Walktrough activity and Finish current Activity

                if (sUtils.isFirstOpen(getApplicationContext())) {
                    startActivity(new Intent(SplashScreen.this, WalkThrough.class));
                } else {
                    startActivity(new Intent(SplashScreen.this, LoginScreen.class));
                }

                finish();

            }
        }, SPLASH_TIME_OUT);

    }
}
