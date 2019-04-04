package com.example.wilsonzhu.calendar_app.Utils;

import android.app.Application;

public class MyApplicationVar extends Application {
    private int LINECHOSEN = 0;
    private String STATION = "finch_station";

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

    public void setStationChosen(String stationName) {
        STATION = stationName;
    }

    public String getStation() {
        return STATION;
    }
}
