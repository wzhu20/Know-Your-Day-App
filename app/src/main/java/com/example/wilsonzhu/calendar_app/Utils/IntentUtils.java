package com.example.wilsonzhu.calendar_app.Utils;

import android.app.Activity;
import android.content.Intent;

import com.example.wilsonzhu.calendar_app.activity.BusDirectionActivity;
import com.example.wilsonzhu.calendar_app.activity.BusStopTimesActivity;
import com.example.wilsonzhu.calendar_app.activity.BusesActivity;
import com.example.wilsonzhu.calendar_app.activity.DescriptionDetailsActivity;
import com.example.wilsonzhu.calendar_app.activity.BusStopsActivity;
import com.example.wilsonzhu.calendar_app.activity.TTCSubwayLinesActivity;
import com.example.wilsonzhu.calendar_app.activity.WeatherActivity;

/**
 * Created by Wilson Zhu on 3/4/2018.
 */

public class IntentUtils {
    private static final class StartActivityWrapper
    {
        private Activity activity;
        private StartActivityWrapper(Activity activity)
        {
            this.activity = activity;
        }

        private void startActivity(Intent intent)
        {
            activity.startActivity(intent);
        }
    }

    public static void startDescriptionDetails(Activity activity)
    {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent(activity, DescriptionDetailsActivity.class));
    }

    public static void startSplashScreenActivity(Activity activity)
    {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, TTCSubwayLinesActivity.class));
    }

    public static void startBusStopsActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, BusStopsActivity.class));
    }

    public static void startBusesActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, BusesActivity.class));
    }

    public static void startBusesDirectionActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, BusDirectionActivity.class));
    }

    public static void startBusStopTimesActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, BusStopTimesActivity.class));
    }

    public static void startWeatherActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, WeatherActivity.class));
    }
}
