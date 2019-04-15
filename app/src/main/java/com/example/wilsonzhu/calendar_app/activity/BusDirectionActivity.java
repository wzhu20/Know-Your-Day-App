package com.example.wilsonzhu.calendar_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPErrorListener;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestHandler;
import com.example.wilsonzhu.calendar_app.HTTPClient.HTTPRequestListener;
import com.example.wilsonzhu.calendar_app.R;
import com.example.wilsonzhu.calendar_app.Utils.IntentUtils;
import com.example.wilsonzhu.calendar_app.Utils.MyApplicationVar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusDirectionActivity extends BaseActivity implements Button.OnClickListener {
    private String URL = "http://webservices.nextbus.com/service/publicJSONFeed?command=schedule&a=ttc&r=";

    private Button firstDirectionButton;
    private Button secondDirectionButton;
    private HTTPRequestHandler requestHandler;
    private Activity activity;
    private MyApplicationVar applicationVar;

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.activity_bus_direction);
        setUp();
    }

    private void setUp() {
        activity = this;
        applicationVar = ((MyApplicationVar) this.getApplication());
        requestHandler = new HTTPRequestHandler();
        firstDirectionButton = findViewById(R.id.first_direction);
        secondDirectionButton = findViewById(R.id.second_direction);

        URL += applicationVar.getBusRouteChoesen();

        if (!applicationVar.getBusDirections(applicationVar.getBusRouteChoesen()).isEmpty()) {
            firstDirectionButton.setText(applicationVar.getBusDirections(applicationVar.getBusRouteChoesen()).get(0));
            secondDirectionButton.setText(applicationVar.getBusDirections(applicationVar.getBusRouteChoesen()).get(1));
            firstDirectionButton.setOnClickListener(this);
            secondDirectionButton.setOnClickListener(this);

        } else {
            requestHandler.HTTPGetRequest(URL, new HTTPRequestListener() {
                @Override
                public void onResponse(String response) {
                    try {

                        JSONObject responseObject = new JSONObject(response);
                        JSONObject jsonObject1 = ((JSONObject) responseObject.getJSONArray("route").get(0));
                        JSONObject jsonObject2 = ((JSONObject) responseObject.getJSONArray("route").get(1));

                        JSONArray jsonArray1 = ((JSONObject) responseObject.getJSONArray("route").get(0)).getJSONObject("header").getJSONArray("stop");
                        JSONArray jsonArray2 = ((JSONObject) responseObject.getJSONArray("route").get(1)).getJSONObject("header").getJSONArray("stop");

                        String firstDirection = jsonObject1.getString("direction");
                        String secondDirection = jsonObject2.getString("direction");
                        firstDirectionButton.setText(firstDirection);
                        secondDirectionButton.setText(secondDirection);
                        ArrayList<String> directions = new ArrayList<>();
                        directions.add(firstDirection);
                        directions.add(secondDirection);
                        applicationVar.updateBusDirectionMap(applicationVar.getBusRouteChoesen(), directions);

                        String oldKey1 = applicationVar.getBusRouteChoesen() + "1";
                        String oldKey2 = applicationVar.getBusRouteChoesen() + "2";
                        String firstNewKey = applicationVar.getBusRouteChoesen() + firstDirection;
                        String secondNewKey = applicationVar.getBusRouteChoesen() + secondDirection;

                        applicationVar.updateBusInformationKey(oldKey1, firstNewKey);
                        applicationVar.updateBusInformationKey(oldKey2, secondNewKey);

                        for (int i = 0; i < jsonArray1.length(); i++) {
                            applicationVar.getBusInformation(firstNewKey).addBusStop(((JSONObject) jsonArray1.get(i)).getString("content"));
                            applicationVar.getBusInformation(firstNewKey).addBusStopTags(((JSONObject) jsonArray1.get(i)).getString("tag"));
                        }

                        for (int i = 0; i < jsonArray2.length(); i++) {
                            applicationVar.getBusInformation(secondNewKey).addBusStop(((JSONObject) jsonArray2.get(i)).getString("content"));
                            applicationVar.getBusInformation(secondNewKey).addBusStopTags(((JSONObject) jsonArray2.get(i)).getString("tag"));
                        }

                        firstDirectionButton.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (view.getId() == R.id.first_direction) {
                                    applicationVar.setDIRECTION((String)firstDirectionButton.getText());
                                } else if (view.getId() == R.id.second_direction) {
                                    applicationVar.setDIRECTION((String)secondDirectionButton.getText());
                                }
                                IntentUtils.startBusStopsActivity(activity);
                            }
                        });

                        secondDirectionButton.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (view.getId() == R.id.first_direction) {
                                    applicationVar.setDIRECTION((String)firstDirectionButton.getText());
                                } else if (view.getId() == R.id.second_direction) {
                                    applicationVar.setDIRECTION((String)secondDirectionButton.getText());
                                }
                                IntentUtils.startBusStopsActivity(activity);
                            }
                        });


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
    public void onClick(View view) {
        if (view.getId() == R.id.first_direction) {
            applicationVar.setDIRECTION((String)firstDirectionButton.getText());
        } else if (view.getId() == R.id.second_direction) {
            applicationVar.setDIRECTION((String)secondDirectionButton.getText());
        }
        IntentUtils.startBusStopsActivity(this);
    }
}
