package tomer.com.alwaysonamoledplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
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
        Settings.System.putInt(getContentResolver(), "button_key_light", 1500);
        stopSelf();
    }
}
