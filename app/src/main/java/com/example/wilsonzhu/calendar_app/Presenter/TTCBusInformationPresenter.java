package com.example.wilsonzhu.calendar_app.Presenter;

import com.example.wilsonzhu.calendar_app.DTO.BusInformation;

import java.util.List;

public class TTCBusInformationPresenter {
    private BusInformation busInformation;
    private TTCBusView TTCBusView;

    public TTCBusInformationPresenter(TTCBusView ttcBusView, BusInformation busInformation) {
        this.busInformation = busInformation;
        this.TTCBusView = ttcBusView;
    }

    public void updateDepartureTimes(List<String> depatureTimes) {
        this.busInformation.setDepartureTimes(depatureTimes);
    }

    public interface TTCBusView {
        void showProgressBar();
        void hideProgressBar();
    }
}
