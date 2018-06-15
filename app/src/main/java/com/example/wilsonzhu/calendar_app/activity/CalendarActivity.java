package com.example.wilsonzhu.calendar_app.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.CalendarView;

import com.example.wilsonzhu.calendar_app.ApplicationPreferences;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;

public class CalendarActivity extends BaseActivity implements CalendarView.OnDateChangeListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final CalendarView calendarView = findViewById(R.id.calendar_view);
        super.setUpToolbar((Toolbar) findViewById(R.id.toolbar));
        adjustToolbarTitle("Calendar");
        calendarView.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int day, int month, int year) {
        ApplicationPreferences prefs = new ApplicationPreferences(getApplicationContext());
        prefs.setString("date", Integer.toString(day) + " / " + Integer.toString(month + 1) + " / " + Integer.toString(year));
        IntentUtils.startDescriptionDetails(this);
    }
}
