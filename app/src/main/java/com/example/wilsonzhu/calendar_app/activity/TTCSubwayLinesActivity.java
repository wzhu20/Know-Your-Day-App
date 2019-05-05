package com.example.wilsonzhu.calendar_app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

public class TTCSubwayLinesActivity extends BaseActivity implements Button.OnClickListener {
    private Button lineOneButton;
    private Button lineTwoButton;
    private Button lineThreeButton;
    private Button lineFourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_ttc_lines);
        setup();
    }

    private void setup() {
        lineOneButton = this.findViewById(R.id.line_1);
        lineOneButton.setOnClickListener(this);
        lineTwoButton = this.findViewById(R.id.line_2);
        lineTwoButton.setOnClickListener(this);
//        lineThreeButton = this.findViewById(R.id.line_3);
//        lineThreeButton.setOnClickListener(this);
//        lineFourButton = this.findViewById(R.id.line_4);
//        lineFourButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.line_1) {
            ((MyApplicationVar)this.getApplication()).setLineChosen(1);
            IntentUtils.startBusesActivity(this);
        }
        else if (view.getId() == R.id.line_2) {
            ((MyApplicationVar)this.getApplication()).setLineChosen(2);
            IntentUtils.startWeatherActivity(this);
        }
//        else if (view.getId() == R.id.line_3) {
//            ((MyApplicationVar)this.getApplication()).setLineChosen(3);
//        }
//        else {
//            ((MyApplicationVar)this.getApplication()).setLineChosen(4);
//        }
    }
}
