package com.example.wilsonzhu.calendar_app.Utils;

import android.app.Activity;
import android.content.Intent;

import com.example.wilsonzhu.calendar_app.Adapter.BusesAdapter;
import com.example.wilsonzhu.calendar_app.activity.BusesActivity;
import com.example.wilsonzhu.calendar_app.activity.CalendarActivity;
import com.example.wilsonzhu.calendar_app.activity.DescriptionDetailsActivity;
import com.example.wilsonzhu.calendar_app.activity.SplashActivity;
import com.example.wilsonzhu.calendar_app.activity.TTCStationActivity;
import com.example.wilsonzhu.calendar_app.activity.TTCSubwayLinesActivity;

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

    public static void startTTCStationActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, TTCStationActivity.class));
    }

    public static void startBusesActivity(Activity activity) {
        StartActivityWrapper startActivityWrapper = new StartActivityWrapper(activity);
        startActivityWrapper.startActivity(new Intent (activity, BusesActivity.class));
    }
}
