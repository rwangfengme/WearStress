package dartmouth.edu.wearstress;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.GridViewPager;
import android.util.Log;


public class MainActivity extends WearableActivity {
    public GridViewPager mGridPager;
    public int stressDegree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentName receiver = new ComponentName(this, dartmouth.edu.wearstress.EMAAlarmReceiver.class);
        PackageManager pm = this.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        PSMScheduler psm = new PSMScheduler();
        psm.setSchedule(this);

        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);

        setAdapter();
    }

    public void setAdapter(){
        mGridPager = (GridViewPager) findViewById(R.id.pager);
        SimpleFragAdapter mAdapter = new SimpleFragAdapter(this, getFragmentManager());
        mGridPager.setAdapter(mAdapter);
    }


    public void repaint(int requestCode, int resultCode, Intent data) {
        Log.d("resultCode", ""+resultCode);
        if(resultCode == 0){
            if(data == null)
                return;
            stressDegree = data.getIntExtra("p2", 1);
            Log.d("stress", ""+stressDegree);
            mGridPager.scrollTo(0, 0);
            setAdapter();
        }
    }
}
