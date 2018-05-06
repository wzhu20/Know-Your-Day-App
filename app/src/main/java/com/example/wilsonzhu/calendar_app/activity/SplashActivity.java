package com.example.wilsonzhu.calendar_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        //IntentUtils.startSplashScreenActivity(this);
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
        finish();
    }
}
