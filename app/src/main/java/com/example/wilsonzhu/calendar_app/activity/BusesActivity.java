package com.example.wilsonzhu.calendar_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.wilsonzhu.calendar_app.Adapter.BusesAdapter;
import com.example.wilsonzhu.calendar_app.DTO.BusInformation;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPErrorListener;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestHandler;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestListener;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusesActivity extends BaseActivity {
    private final String URL = "http://webservices.nextbus.com/service/publicJSONFeed?command=routeList&a=ttc";

    private ArrayList<BusInformation> allBuses = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private HTTPRequestHandler httpRequestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttc_station);
        httpRequestHandler = new HTTPRequestHandler();
        initData();
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initData() {
        // Make Api call to Myttc to get all buses to a station and display it
        String path = ((MyApplicationVar) this.getApplication()).getStation();
        final Activity activity = this;
        httpRequestHandler.HTTPGetRequest(URL , new HTTPRequestListener() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray stops = jsonObject.getJSONArray("route");
                    if (stops != null) {
                        for(int i = 0; i < stops.length(); i++) {
                            String tag = ((JSONObject)stops.get(i)).getString("tag");
                            BusInformation busInformation = new BusInformation(((JSONObject)stops.get(i)).getString("title"), tag);
                            ((MyApplicationVar)activity.getApplication()).updateBusInformationMap(tag, busInformation);
                            allBuses.add(busInformation);
                        }
                        mAdapter = new BusesAdapter(allBuses, activity);
                        recyclerView.setAdapter(mAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new HTTPErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, "made request to get this station: " + path, this);
    }
}
