package com.example.wilsonzhu.calendar_app.DTO;

import java.util.List;

public class TTCStation {
    private String stationName;
    private List<BusInformation> allBuses;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<BusInformation> getAllBuses() {
        return allBuses;
    }

    public void addBusToStation(List<BusInformation> allBuses) {
        this.allBuses = allBuses;
    }
}
