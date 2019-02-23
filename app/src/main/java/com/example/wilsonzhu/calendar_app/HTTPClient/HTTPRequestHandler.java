package com.example.wilsonzhu.calendar_app.HTTPClient;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class HTTPRequestHandler {

    public void HTTPGetRequest(String url, HTTPRequestListener listener, HTTPErrorListener errorListener, String tag) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
        HTTPRequestQueue.getRequestQueueInstance().addToRequestQueue(stringRequest, tag);
    }
}
