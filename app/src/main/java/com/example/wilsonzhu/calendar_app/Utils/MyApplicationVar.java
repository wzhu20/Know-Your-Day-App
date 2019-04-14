package com.example.wilsonzhu.calendar_app.Utils;

import android.app.Application;

import com.example.wilsonzhu.calendar_app.DTO.BusInformation;

import java.util.ArrayList;
import java.util.HashMap;

public class MyApplicationVar extends Application {
    private int LINECHOSEN = 0;
    private String STATION = "finch_station";
    private String BUSROUTE = "53";
    private String BUSNAME = "";
    private String DIRECTION = "";
    private HashMap<String, BusInformation> busInformationMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> busDirectionMap = new HashMap<>();

    public void updateBusDirectionMap(String key, ArrayList<String> value) {
        busDirectionMap.put(key, value);
    }

    public ArrayList<String> getBusDirections(String key) {
        if (busDirectionMap.containsKey(key)) {
            return busDirectionMap.get(key);
        }
        return new ArrayList<>();
    }
    public String getDIRECTION() {
        return DIRECTION;
    }

    public void setDIRECTION(String DIRECTION) {
        this.DIRECTION = DIRECTION;
    }

    public String getBUSNAME() {
        return BUSNAME;
    }

    public void setBUSNAME(String BUSNAME) {
        this.BUSNAME = BUSNAME;
    }

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

    public void setBusRouteChosen(String busRouteChosen) {
        BUSROUTE = busRouteChosen;
    }

    public String getBusRouteChoesen() {
        return BUSROUTE;
    }

    public void updateBusInformationMap(String key, BusInformation value) {
        if (!busInformationMap.containsKey(key)) {
            busInformationMap.put(key, value);
        }
    }

    public void updateBusInformationKey(String oldKey, String newKey) {
        if (busInformationMap.containsKey(oldKey)) {
            busInformationMap.put(newKey, busInformationMap.get(oldKey));
            busInformationMap.remove(oldKey);
        }
    }

    public BusInformation getBusInformation(String key) {
        if (busInformationMap.containsKey(key)) {
            return busInformationMap.get(key);
        }
        return null;
    }
}
