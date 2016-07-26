package softwaredongjune.schoolproject160613;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 김동준 on 2016-06-14.
 */
public class BroadCasts extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.d("BroadCastReceiver_", "Boot OK");

            if (new MainActivity().getDone() == false) {
                onLock(context);
            }
        }
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Log.d("BroadCastReceiver_", "Screen OK");
            onLock(context);
        }
    }

    private void onLock(Context context) {
        Intent intent = new Intent(context, SubActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        Log.d("receiver Activity", "Called");
    }
}
