package com.example.wilsonzhu.calendar_app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Wilson Zhu on 3/4/2018.
 */

public class ApplicationPreferences {
    private SharedPreferences preferences;
    private static final String PREFERENCE_KEY = ApplicationPreferences.class.getCanonicalName();

    public ApplicationPreferences(Context context)
    {
        this.preferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public void setString(String key, String value)
    {
        final SharedPreferences.Editor editor = this.preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key)
    {
        if (this.preferences.contains(key))
        {
            return this.preferences.getString(key, null);
        }
        return "";
    }
}
