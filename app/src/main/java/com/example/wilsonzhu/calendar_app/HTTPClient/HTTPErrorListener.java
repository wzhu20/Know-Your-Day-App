package com.example.wilsonzhu.calendar_app.HTTPClient;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public interface HTTPErrorListener extends Response.ErrorListener {
    @Override
    void onErrorResponse(VolleyError error);
}
