package com.example.wilsonzhu.calendar_app.HTTPClient;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class HTTPRequestHandler {

    public void HTTPGetRequest(String url, HTTPRequestListener listener, HTTPErrorListener errorListener, String tag, Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
        HTTPRequestQueue.getRequestQueueInstance(context).addToRequestQueue(stringRequest, tag);
    }
}
