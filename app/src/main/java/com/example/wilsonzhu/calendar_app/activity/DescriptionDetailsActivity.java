package com.example.wilsonzhu.calendar_app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wilsonzhu.calendar_app.ApplicationPreferences;
import com.example.wilsonzhu.calendar_app.R;

public class DescriptionDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private String calendarDate;
    private Button saveButton;
    private TextView descriptionDetailsDateText;
    private EditText descriptionDetails;
    private static ApplicationPreferences prefs;

    public DescriptionDetailsActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_details);
        setUp();
    }

    private void setUp()
    {
        prefs = new ApplicationPreferences(getApplicationContext());
        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);
        calendarDate = prefs.getString("date");
        descriptionDetailsDateText = findViewById(R.id.calendar_date_chosen);
        descriptionDetailsDateText.setText(calendarDate);
        descriptionDetails = findViewById(R.id.date_description);
        descriptionDetails.setText(prefs.getString(calendarDate));
        descriptionDetails.setFocusableInTouchMode(false);
        saveButton.setOnClickListener(this);
        descriptionDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == saveButton)
        {
            Toast.makeText(this, R.string.saved_text, Toast.LENGTH_SHORT).show();
            refreshScreen();
        }

        else if (v == descriptionDetails)
        {
            descriptionDetails.setFocusableInTouchMode(true);
            descriptionDetails.setCursorVisible(true);
        }
    }

    private void refreshScreen()
    {
        prefs.setString(prefs.getString("date"), descriptionDetails.getEditableText().toString());
        descriptionDetails.setText(prefs.getString(calendarDate));
        onBackPressed();
    }
}
