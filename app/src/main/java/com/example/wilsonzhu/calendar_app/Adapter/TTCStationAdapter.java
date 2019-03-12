package com.example.wilsonzhu.calendar_app.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TTCStationAdapter extends RecyclerView.Adapter<TTCStationAdapter.TTCStationViewHolder> {

    @NonNull
    @Override
    public TTCStationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TTCStationViewHolder ttcStationViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TTCStationViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TTCStationViewHolder(View view) {
            super(view);
        }
    }

}
