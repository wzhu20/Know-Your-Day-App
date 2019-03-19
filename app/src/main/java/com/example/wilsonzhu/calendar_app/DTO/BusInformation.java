package com.example.wilsonzhu.calendar_app.DTO;

import java.util.List;

public class BusInformation {
    private List<String> departureTime;
    private String destination;

    public List<String> getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(List<String> departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
