package com.example.wilsonzhu.calendar_app.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.DTO.BusInformation;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import java.util.ArrayList;
import java.util.List;

public class BusesAdapter extends RecyclerView.Adapter<TTCBusInformationAdapter.TTCStationViewHolder> {
    private List<BusInformation> allBuses;
    private Activity activity;

    public BusesAdapter(ArrayList<BusInformation> allBuses, Activity activity) {
        this.allBuses = allBuses;
        this.activity = activity;
    }

    @Override
    public TTCBusInformationAdapter.TTCStationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ttc_station_view_holder, parent, false);
        return new TTCBusInformationAdapter.TTCStationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TTCBusInformationAdapter.TTCStationViewHolder holder, int position) {
        final String busName = allBuses.get(position).getBusName();
        final String busTag = allBuses.get(position).getBusNumber();
        holder.button.setText(busName);
        holder.button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyApplicationVar) activity.getApplication()).setBusRouteChosen(busTag);
                ((MyApplicationVar) activity.getApplication()).setBUSNAME(busName);
                IntentUtils.startTTCStationActivity(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allBuses.size();
    }
}
