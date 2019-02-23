package com.example.wilsonzhu.calendar_app.HTTPClient;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class HTTPErrorListener implements Response.ErrorListener{
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error.getStackTrace());
    }
}
