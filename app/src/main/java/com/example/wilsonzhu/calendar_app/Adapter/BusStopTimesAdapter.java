package com.example.wilsonzhu.calendar_app.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.R;

import java.util.List;

public class BusStopTimesAdapter extends RecyclerView.Adapter<BusStopTimesAdapter.BusStopTimeViewHolder>{
    private List<String> allBusStopTimes;
    private Activity activity;

    public BusStopTimesAdapter(List<String> allBusStopTimes, Activity activity) {
        this.allBusStopTimes = allBusStopTimes;
        this.activity = activity;

    }

    @NonNull
    @Override
    public BusStopTimesAdapter.BusStopTimeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ttc_station_view_holder, viewGroup, false);
        return new BusStopTimesAdapter.BusStopTimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStopTimesAdapter.BusStopTimeViewHolder ttcStationViewHolder, int i) {
        final String busInformation = allBusStopTimes.get(i);
        ttcStationViewHolder.button.setText(busInformation);
    }

    @Override
    public int getItemCount() {
        return allBusStopTimes.size();
    }

    public static class BusStopTimeViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public BusStopTimeViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.ttc_station_button);
        }
    }
}
