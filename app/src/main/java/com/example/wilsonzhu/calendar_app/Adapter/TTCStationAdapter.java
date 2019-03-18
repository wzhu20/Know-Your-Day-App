package com.example.wilsonzhu.calendar_app.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wilsonzhu.calendar_app.R;

import java.util.List;

public class TTCStationAdapter extends RecyclerView.Adapter<TTCStationAdapter.TTCStationViewHolder> {
    private List<String> data;

    public TTCStationAdapter(List<String> dataSet) {
        data = dataSet;
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
        String word = data.get(i);
        ((TextView)ttcStationViewHolder.textView).setText(word);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TTCStationViewHolder extends RecyclerView.ViewHolder {
        private View textView;

        public TTCStationViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.ttc_station_name);
        }
    }

}
