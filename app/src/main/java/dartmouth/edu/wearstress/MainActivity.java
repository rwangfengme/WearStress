package dartmouth.edu.wearstress;

import android.content.Intent;
import android.os.Bundle;
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
