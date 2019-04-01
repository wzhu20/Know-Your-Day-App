package com.example.wilsonzhu.calendar_app.HTTPClient;

import com.android.volley.Response;

// application uses this listener to it is abstracted from Volley
public interface HTTPRequestListener extends Response.Listener<String> {

    @Override
    void onResponse(String response);
}
