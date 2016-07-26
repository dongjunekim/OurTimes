package softwaredongjune.schoolproject160613;

import android.content.SharedPreferences;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 김동준 on 2016-06-14.
 */
public class TimeProcess {

    private int setTime;

    public TimeProcess(int setTime) {
        this.setTime = setTime;
    }

    final public int[] Nowtime() {
        int times[] = new int[3];

        long getTime = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("hh:mm:ss");
        String nowtime = dayTime.format(new Date(getTime));

        String nowtimes[];

        for (int i = 0; i < times.length; i++) {
            nowtimes = new String(nowtime).split(":");
            times[i] = Integer.parseInt(nowtimes[i]);
            Log.d("times+" + i, times[i] + "");
        }

        return times;
    }

    final public int Rendering(int[] times) {
        int sumTime = 0;
        sumTime += times[0] * 3600;
        sumTime += times[1] * 60;

        sumTime += setTime * 60;

        sumTime += times[2];

        return sumTime;
    }

    final public int[] unRendering(int sumTime) {
        int[] nowTimes = new int[3];
        nowTimes[0] = sumTime / 3600;
        sumTime -= nowTimes[0] * 3600;
        nowTimes[1] = sumTime / 60;
        sumTime -= nowTimes[1] * 60;
        nowTimes[2] = sumTime;
        return nowTimes;
    }

}
