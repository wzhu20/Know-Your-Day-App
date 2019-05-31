package com.example.wilsonzhu.calendar_app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

public class AppMenuActivity extends BaseActivity implements Button.OnClickListener {
    private Button TTCButton;
    private Button weatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_ttc_lines);
        setup();
    }

    private void setup() {
        TTCButton = this.findViewById(R.id.ttc_menu_button);
        TTCButton.setOnClickListener(this);
        weatherButton = this.findViewById(R.id.weather_menu_button);
        weatherButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ttc_menu_button) {
            ((MyApplicationVar)this.getApplication()).setLineChosen(1);
            IntentUtils.startBusesActivity(this);
        }
        else if (view.getId() == R.id.weather_menu_button) {
            ((MyApplicationVar)this.getApplication()).setLineChosen(2);
            IntentUtils.startWeatherActivity(this);
        }
    }
}
