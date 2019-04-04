package com.example.wilsonzhu.calendar_app.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wilsonzhu.calendar_app.Adapter.TTCBusInformationAdapter;
import com.example.wilsonzhu.calendar_app.Presenter.TTCBusInformationPresenter;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import java.util.ArrayList;
import java.util.Arrays;

public class TTCStationActivity extends BaseActivity implements TTCBusInformationPresenter.TTCBusView {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> busInformation;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        initSubwayLineData();
        setContentView(R.layout.activity_ttc_station);
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TTCBusInformationAdapter(busInformation, this);
        recyclerView.setAdapter(mAdapter);
    }

    private void initSubwayLineData() {
        if (((MyApplicationVar) this.getApplication()).getLineChosen() == 1) {
            String[] lineOneStations = this.getResources().getStringArray(R.array.line_1_stations);
            busInformation = new ArrayList<>(Arrays.asList(lineOneStations));
        }
        else if (((MyApplicationVar) this.getApplication()).getLineChosen() == 2) {
            String[] lineTwoStations = this.getResources().getStringArray(R.array.line_2_stations);
            busInformation = new ArrayList<>(Arrays.asList(lineTwoStations));
        }
        else if (((MyApplicationVar) this.getApplication()).getLineChosen() == 3) {
            String[] lineThreeStations = this.getResources().getStringArray(R.array.line_3_stations);
            busInformation = new ArrayList<>(Arrays.asList(lineThreeStations));
        }
        else {
            String[] lineFourStations = this.getResources().getStringArray(R.array.line_4_stations);
            busInformation = new ArrayList<>(Arrays.asList(lineFourStations));
        }
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
