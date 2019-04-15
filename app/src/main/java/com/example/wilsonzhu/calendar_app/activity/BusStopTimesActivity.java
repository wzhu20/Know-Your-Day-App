package com.example.wilsonzhu.calendar_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.wilsonzhu.calendar_app.Adapter.BusStopTimesAdapter;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPErrorListener;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestHandler;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestListener;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusStopTimesActivity extends BaseActivity {
    private String URL = "http://webservices.nextbus.com/service/publicJSONFeed?command=predictions&a=ttc&r=";
    private RecyclerView recyclerView;
    private MyApplicationVar applicationVar;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    private HTTPRequestHandler requestHandler;
    private ArrayList<String> allBusTimes;
    private Activity activity;

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setUp();
    }

    private void setUp() {
        activity = this;
        allBusTimes = new ArrayList<>();
        requestHandler = new HTTPRequestHandler();
        applicationVar = ((MyApplicationVar) this.getApplication());
        setContentView(R.layout.activity_ttc_station);
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initData();
    }

    private void initData() {
        URL += applicationVar.getBusRouteChoesen() + "&s=" + applicationVar.getTAG();

        requestHandler.HTTPGetRequest(URL, new HTTPRequestListener() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseObject = new JSONObject(response);
                    JSONObject firstObject = responseObject.getJSONObject("predictions");
                    if (firstObject.has("direction")) {
                        Object directions = firstObject.get("direction");

                        if (directions instanceof JSONArray) {
                            for (int i = 0; i < ((JSONArray) directions).length(); i++) {
                                JSONObject jsonObject = ((JSONObject) ((JSONArray) directions).get(i));
                                String busName = jsonObject.getString("title");
                                Object predictions = jsonObject.get("prediction");

                                if (predictions instanceof JSONArray) {
                                    for (int x = 0; x < ((JSONArray) predictions).length(); x++) {
                                        JSONObject prediction = ((JSONArray) predictions).getJSONObject(x);
                                        String minute = prediction.getString("minutes");
                                        allBusTimes.add(busName + " in " + minute + " minutes");
                                    }
                                } else {
                                    String minutes = ((JSONObject) predictions).optString("minutes");
                                    allBusTimes.add(busName + " in " + minutes + " minutes");
                                }
                            }

                        } else if (directions instanceof JSONObject) {
                            Object jsonObject =  ((JSONObject) directions).get("prediction");
                            String busName = ((JSONObject)directions).getString("title");

                            if (jsonObject instanceof JSONArray) {
                                for (int x = 0; x < ((JSONArray) jsonObject).length(); x++) {
                                    JSONObject prediction = ((JSONArray) jsonObject).getJSONObject(x);
                                    String minute = prediction.getString("minutes");
                                    allBusTimes.add(busName + " in " + minute + " minutes");
                                }
                            } else {
                                allBusTimes.add("No more buses!");
                            }
                        } else {
                            allBusTimes.add("No more buses!");
                        }
                    }
                    mAdapter = new BusStopTimesAdapter(allBusTimes, activity);
                    recyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new HTTPErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, "henlo", this);
    }
}
