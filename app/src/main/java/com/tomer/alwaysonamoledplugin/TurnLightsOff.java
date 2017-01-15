package com.tomer.alwaysonamoledplugin;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.Settings;

public class TurnLightsOff extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Started service");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putInt("default_lights_value", Settings.System.getInt(getContentResolver(), "button_key_light", 1500)).apply();
        Settings.System.putInt(getContentResolver(), "button_key_light", 0);
        stopSelf();
    }
}
