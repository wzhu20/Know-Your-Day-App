package com.example.wilsonzhu.calendar_app.Presenter;

import com.example.wilsonzhu.calendar_app.DTO.BusInformation;

import java.util.List;

public class TTCBusInformationPresenter {
    private TTCBusView TTCBusView;

    public TTCBusInformationPresenter(TTCBusView ttcBusView) {
        this.TTCBusView = ttcBusView;
    }

    public void updateDepartureTimes(List<String> depatureTimes, BusInformation busInformation) {
        this.TTCBusView.showProgressBar();
        busInformation.setDepartureTimes(depatureTimes);
        this.TTCBusView.hideProgressBar();
    }

    public interface TTCBusView {
        void showProgressBar();
        void hideProgressBar();
    }
}
