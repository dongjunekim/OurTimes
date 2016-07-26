package softwaredongjune.schoolproject160613;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 김동준 on 2016-06-13.
 */
public class ServiceForCheck extends Service {

    private IntentFilter intentFilter;
    private BroadCasts broadCasts=new BroadCasts();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Serviece_","was Start");
        registerReceiver(broadCasts, IntentFilterProcess());

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("Service_", "was Dead");
        unregisterReceiver(broadCasts);
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private IntentFilter IntentFilterProcess() {
        intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
        return intentFilter;
    }


}
