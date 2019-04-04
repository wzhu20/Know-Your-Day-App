package com.example.wilsonzhu.calendar_app.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;
import com.example.wilsonzhu.calendar_app.activity.TTCStationActivity;

import java.util.List;

public class TTCBusInformationAdapter extends RecyclerView.Adapter<TTCBusInformationAdapter.TTCStationViewHolder> {
    private List<String> allStations;
    private Activity activity;

    public TTCBusInformationAdapter(List<String> allStations, Activity activity) {
        this.allStations = allStations;
        this.activity = activity;

    }

    @NonNull
    @Override
    public TTCStationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ttc_station_view_holder, viewGroup, false);
        return new TTCStationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TTCStationViewHolder ttcStationViewHolder, int i) {
        final String stationName = allStations.get(i);
        ttcStationViewHolder.button.setText(stationName.replace("_", " "));
        ttcStationViewHolder.button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyApplicationVar) activity.getApplication()).setStationChosen(stationName.replace(" ", "_"));
                IntentUtils.startBusesActivity(activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allStations.size();
    }

    public static class TTCStationViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public TTCStationViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.ttc_station_button);
        }
    }

}
