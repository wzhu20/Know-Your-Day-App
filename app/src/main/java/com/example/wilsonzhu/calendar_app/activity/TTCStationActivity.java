package com.example.wilsonzhu.calendar_app.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wilsonzhu.calendar_app.Adapter.TTCBusInformationAdapter;
import com.example.wilsonzhu.calendar_app.R;

import java.util.ArrayList;
import java.util.List;

public class TTCStationActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_ttc_station);
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        mAdapter = new TTCBusInformationAdapter(words);
        recyclerView.setAdapter(mAdapter);

    }
}
