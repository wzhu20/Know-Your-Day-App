package com.example.wilsonzhu.calendar_app.DTO;

import java.util.ArrayList;
import java.util.List;

public class BusInformation {
    private List<String> departureTime;
    private String destination;
    private String busName;
    private String busNumber;
    private ArrayList<String> busStops = new ArrayList<>();

    public BusInformation(String busName, String busNumber) {
        this.busName = busName;
        this.busNumber = busNumber;
    }

    public List<String> getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTimes(List<String> departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBusName() {
        return this.busName;
    }

    public String getBusNumber() {
        return this.busNumber;
    }

    public ArrayList<String> getBusStops() {
        return busStops;
    }

    public void addBusStop(String busStop) {
        this.busStops.add(busStop);
    }
}
