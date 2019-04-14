package com.example.wilsonzhu.calendar_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.wilsonzhu.calendar_app.Adapter.BusStopsAdapter;
import com.example.wilsonzhu.calendar_app.DTO.BusInformation;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPErrorListener;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestHandler;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestListener;
import com.example.wilsonzhu.calendar_app.Presenter.TTCBusInformationPresenter;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusStopsActivity extends BaseActivity implements TTCBusInformationPresenter.TTCBusView {
    private String URL = "http://webservices.nextbus.com/service/publicJSONFeed?command=schedule&a=ttc&r=";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> busStops = new ArrayList<>();
    private HTTPRequestHandler requestHandler;
    private MyApplicationVar applicationVar;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        applicationVar = ((MyApplicationVar) this.getApplication());
        requestHandler = new HTTPRequestHandler();
        setContentView(R.layout.activity_ttc_station);
        recyclerView = findViewById(R.id.ttc_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initBusStopsData();
    }

    private void initBusStopsData() {
        final Activity activity = this;
        String routeChosen = applicationVar.getBusRouteChoesen();
        URL += routeChosen;

        if (!applicationVar.getBusInformation(routeChosen).getBusStops().isEmpty()) {
            mAdapter = new BusStopsAdapter(applicationVar.getBusInformation(routeChosen).getBusStops(), activity);
            recyclerView.setAdapter(mAdapter);
        } else {
            requestHandler.HTTPGetRequest(URL, new HTTPRequestListener() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = ((JSONObject) jsonObject.getJSONArray("route").get(0)).getJSONObject("header").getJSONArray("stop");
                        for (int i = 0; i < jsonArray.length(); i++) {
                        applicationVar.getBusInformation(applicationVar.getBusRouteChoesen()).addBusStop(((JSONObject)jsonArray.get(i)).getString("content"));
                        }
                        mAdapter = new BusStopsAdapter(applicationVar.getBusInformation(applicationVar.getBusRouteChoesen()).getBusStops(), activity);
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

    @Override
    public void showProgressBar() {
        System.out.println("Loading");
    }

    @Override
    public void hideProgressBar() {
        System.out.println("Done Loading");
    }
}
