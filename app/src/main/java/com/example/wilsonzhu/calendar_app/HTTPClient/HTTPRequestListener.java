package com.example.wilsonzhu.calendar_app.HTTPClient;

import com.android.volley.Response;

// application uses this listener to it is abstracted from Volley
public class HTTPRequestListener implements Response.Listener<String> {

    @Override
    public void onResponse(String response) {
        System.out.println(response);
    }
}
