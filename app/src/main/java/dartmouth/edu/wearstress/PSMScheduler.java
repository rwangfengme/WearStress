package dartmouth.edu.wearstress;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;


/**
 * Created by varun on 1/20/16.
 */
public class PSMScheduler {

    public static void setSchedule(Context context) {
        Calendar cal = Calendar.getInstance();
        long milli = cal.getTimeInMillis();
        setSchedule(context, milli + 30000);
        setSchedule(context, milli + 60000);
        setSchedule(context, milli + 90000);
        setSchedule(context, milli + 120000);
        setSchedule(context, milli + 150000);
        setSchedule(context, milli + 180000);
    }

    private static void setSchedule(Context context, long milli) {

        // the request code distinguish different stress meter schedule instances
        int requestCode = (int)milli;
        Intent intent = new Intent(context, EMAAlarmReceiver.class);

        PendingIntent pi = PendingIntent.getBroadcast(context, requestCode, intent,
                PendingIntent.FLAG_CANCEL_CURRENT); //set pending intent to call EMAAlarmReceiver.

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milli);

        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(Calendar.DATE, 1);
        }

        //set repeating alarm, and pass the pending intent,
        //so that the broadcast is sent everytime the alarm
        // is triggered
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pi);
    }

}
