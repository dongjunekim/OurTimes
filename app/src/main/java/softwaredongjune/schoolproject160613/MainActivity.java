package softwaredongjune.schoolproject160613;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("mdata", MODE_PRIVATE);
    }

    public void setOurTime(View v) {

        FragmentManager fm = getSupportFragmentManager();
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(fm, "Fragment_Dialog");


    }


    public void setTime(View v) {

        if (getDone() == true) {
            Toast.makeText(getApplicationContext(), "잠금화면이 활성화되었습니다.", Toast.LENGTH_SHORT).show();
            startService(getServiceIntent());
            setDone(false);
        } else if (getDone() == false) {
            Toast.makeText(getApplicationContext(), "잠금화면이 비활성화되었습니다.", Toast.LENGTH_SHORT).show();
            stopService(getServiceIntent());
            setDone(true);
        }


    }

    final private Intent getServiceIntent() {
        return new Intent(getApplicationContext(), ServiceForCheck.class);
    }

    private void setDone(Boolean isDone) {
        SharedPreferences.Editor editor = sp.edit();
        Log.d("isDone", isDone + "");
        editor.putBoolean("isDone", isDone);
        editor.commit();
    }

    public boolean getDone() {
        Log.d("boolean", sp.getBoolean("isDone", true) + "");
        return sp.getBoolean("isDone", true);
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}

