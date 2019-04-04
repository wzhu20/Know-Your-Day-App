package com.example.wilsonzhu.calendar_app.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wilsonzhu.calendar_app.R;

import java.util.ArrayList;
import java.util.List;

public class BusesAdapter extends RecyclerView.Adapter<TTCBusInformationAdapter.TTCStationViewHolder> {
    private List<String> allBuses;
    private Activity activity;

    public BusesAdapter(ArrayList<String> allBuses) {
        this.allBuses = allBuses;
    }

    @Override
    public TTCBusInformationAdapter.TTCStationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ttc_station_view_holder, parent, false);
        return new TTCBusInformationAdapter.TTCStationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TTCBusInformationAdapter.TTCStationViewHolder holder, int position) {
        final String busName = allBuses.get(position);
        holder.button.setText(busName);
    }

    @Override
    public int getItemCount() {
        return allBuses.size();
    }
}
