package dartmouth.edu.wearstress;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.GridViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends WearableActivity {
    public GridViewPager mGridPager;
    public int stressDegree = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridPager = (GridViewPager) findViewById(R.id.pager);
        SimpleFragAdapter mAdapter = new SimpleFragAdapter(this, getFragmentManager());
        mGridPager.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 0){
            Log.d("selection", data.getStringExtra("selection"));
            stressDegree = data.getIntExtra("selection", 1);
            mGridPager.scrollTo(0, 0);
        }
    }
}