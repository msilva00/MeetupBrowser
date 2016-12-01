package com.example.team23.story;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity{

    private final int SPLASH_DISPLAY_LENGTH = 6000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


                Intent intent = new Intent(this,StoryListFragment.class);
                startActivity(intent);
                finish();
            }
        }


