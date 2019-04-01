package com.example.wilsonzhu.calendar_app.Utils;

import android.app.Application;

public class MyApplicationVar extends Application {
    private int LINECHOSEN = 0;

    public boolean setLineChosen(int lineChosen) {
        if (lineChosen > 4 || lineChosen < 1) {
            return false;
        }
        LINECHOSEN = lineChosen;
        return true;
    }

    public int getLineChosen() {
        return LINECHOSEN;
    }
}
