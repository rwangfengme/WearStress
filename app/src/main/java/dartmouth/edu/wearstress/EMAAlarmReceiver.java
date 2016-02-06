package dartmouth.edu.wearstress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;

/**
 * Created by varun on 1/20/15.
 */

public class EMAAlarmReceiver extends BroadcastReceiver {
    //Receive broadcas
    @Override
    public void onReceive(final Context context, Intent intent) {
        startPSM(context);
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(3000);
    }

    // start the stress meter
    private void startPSM(Context context) {
        Intent emaIntent = new Intent(context, MainActivity.class); //The activity you  want to start.
        emaIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(emaIntent);
    }
}