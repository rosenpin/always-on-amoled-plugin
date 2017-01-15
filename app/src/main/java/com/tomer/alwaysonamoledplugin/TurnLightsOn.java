package com.tomer.alwaysonamoledplugin;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.Settings;

public class TurnLightsOn extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Started service");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Settings.System.putInt(getContentResolver(), "button_key_light", sharedPreferences.getInt("default_lights_value", 1500));
        stopSelf();
    }
}
