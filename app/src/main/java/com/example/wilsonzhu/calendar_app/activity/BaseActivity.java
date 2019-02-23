package com.example.wilsonzhu.calendar_app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.wilsonzhu.calendar_app.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    protected void setUpToolbar(Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void adjustToolbarTitle(String newTitle) {
        getSupportActionBar().setTitle(newTitle);
    }
}
