package com.example.wilsonzhu.calendar_app.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.DTO.BusInformation;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import java.util.List;

public class BusStopsAdapter extends RecyclerView.Adapter<BusStopsAdapter.BusViewHolder> {
    private List<String> allBusStops;
    private List<String> allBusStopTags;
    private Activity activity;

    public BusStopsAdapter(List<String> allBusStops, List<String> allBusStopTags, Activity activity) {
        this.allBusStops = allBusStops;
        this.allBusStopTags = allBusStopTags;
        this.activity = activity;

    }

    @NonNull
    @Override
    public BusStopsAdapter.BusViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ttc_station_view_holder, viewGroup, false);
        return new BusStopsAdapter.BusViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStopsAdapter.BusViewHolder ttcStationViewHolder, int i) {
        final String busInformation = allBusStops.get(i);
        final String busTag = allBusStopTags.get(i);
        ttcStationViewHolder.button.setText(busInformation);
        ttcStationViewHolder.button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((MyApplicationVar) activity.getApplication()).setBusRouteChosen(busInformation);
                ((MyApplicationVar) activity.getApplication()).setTAG(busTag);
                IntentUtils.startBusStopTimesActivity(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allBusStops.size();
    }

    public static class BusViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public BusViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.ttc_station_button);
        }
    }
}
