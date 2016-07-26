package softwaredongjune.schoolproject160613;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView ourTime, realTime;
    private TimeProcess timeProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        giveData();
        findId();
        LockScreenInit();

        setRealTime();
        setOurTime();

    }

    private void giveData() {
        SharedPreferences sp = getSharedPreferences("mdata", MODE_PRIVATE);
        int setTime = sp.getInt("SettingTime", 0);
        timeProcess = new TimeProcess(setTime);
    }

    private void setRealTime() {
        int realTimeArr[] = timeProcess.Nowtime();
        realTime.setText(realTimeArr[0] + " : " + realTimeArr[1] + "");
    }

    private void setOurTime() {
        int ourTimes[];
        ourTimes = timeProcess.unRendering(timeProcess.Rendering(timeProcess.Nowtime()));
        ourTime.setText(ourTimes[0] + " : " + ourTimes[1]);
    }


    private void findId() {
        ourTime = (TextView) findViewById(R.id.ourTime);
        realTime = (TextView) findViewById(R.id.realTime);

    }

    private void LockScreenInit() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

    }/*
    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }*/

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
