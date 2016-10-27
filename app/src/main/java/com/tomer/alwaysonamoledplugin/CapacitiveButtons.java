package com.tomer.alwaysonamoledplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;

public class CapacitiveButtons extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean state = intent.getBooleanExtra("state", false);
        int originalCapacitiveButtonsState = intent.getIntExtra("originalCapacitiveButtonsState", 1500);
        System.out.println("Started service");
        System.out.println("State " + state);
        System.out.println("Original Brightness  " + originalCapacitiveButtonsState);
        Settings.System.putInt(getContentResolver(), "button_key_light", state ? 0 : originalCapacitiveButtonsState);
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
