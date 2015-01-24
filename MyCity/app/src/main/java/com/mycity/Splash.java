package com.mycity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Akhil Bhai on 1/8/2015.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Thread() {
            @Override
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(1000);
                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getApplicationContext(),Main.class);
                    startActivity(i);
                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        }.start();
    }
}
