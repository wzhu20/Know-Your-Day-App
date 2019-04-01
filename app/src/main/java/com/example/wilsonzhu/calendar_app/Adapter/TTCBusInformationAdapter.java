package com.example.wilsonzhu.calendar_app.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wilsonzhu.calendar_app.R;

import java.util.List;

public class TTCBusInformationAdapter extends RecyclerView.Adapter<TTCBusInformationAdapter.TTCStationViewHolder> {
    private List<String> allStations;

    public TTCBusInformationAdapter(List<String> allStations) {
        this.allStations = allStations;

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
        String stationName = allStations.get(i);
        ttcStationViewHolder.button.setText(stationName.replace("_", " "));
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
