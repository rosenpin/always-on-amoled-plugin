package tomer.com.alwaysonamoledplugin;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;

public class CapacitiveButtons extends Service {
    boolean state;
    int originalCapacitiveButtonsState;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        state = intent.getBooleanExtra("state", false);
        originalCapacitiveButtonsState = intent.getIntExtra("originalCapacitiveButtonsState", 1500);
        System.out.println("Started service");
        System.out.println("State " + state);
        System.out.println("Original Brightness  " + originalCapacitiveButtonsState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(getApplicationContext()))
                Settings.System.putInt(getContentResolver(), "button_key_light", state ? 0 : originalCapacitiveButtonsState);
        } else
            Settings.System.putInt(getContentResolver(), "button_key_light", state ? 0 : originalCapacitiveButtonsState);
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
