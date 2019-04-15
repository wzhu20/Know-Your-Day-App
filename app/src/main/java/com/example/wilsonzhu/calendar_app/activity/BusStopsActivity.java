package com.example.wilsonzhu.calendar_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wilsonzhu.calendar_app.Adapter.BusStopsAdapter;
import com.example.wilsonzhu.calendar_app.Presenter.TTCBusInformationPresenter;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

public class BusStopsActivity extends BaseActivity implements TTCBusInformationPresenter.TTCBusView {
    private String URL = "http://webservices.nextbus.com/service/publicJSONFeed?command=schedule&a=ttc&r=";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MyApplicationVar applicationVar;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        applicationVar = ((MyApplicationVar) this.getApplication());
        setContentView(R.layout.activity_ttc_station);
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initBusStopsData();
    }

    private void initBusStopsData() {
        final Activity activity = this;
        String routeChosen = applicationVar.getBusRouteChoesen();
        String directionChosen = applicationVar.getDIRECTION();
        mAdapter = new BusStopsAdapter(applicationVar.getBusInformation(routeChosen + directionChosen).getBusStops(),
                applicationVar.getBusInformation(routeChosen + directionChosen).getBusStopTags(), activity);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showProgressBar() {
        System.out.println("Loading");
    }

    @Override
    public void hideProgressBar() {
        System.out.println("Done Loading");
    }
}
