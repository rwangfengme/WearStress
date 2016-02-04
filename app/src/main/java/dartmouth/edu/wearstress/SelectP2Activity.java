package dartmouth.edu.wearstress;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class SelectP2Activity extends WearableActivity implements View.OnClickListener{
    private int groupIndex;
    private int p1;
    private int[][] p2Matix = {{1,2,5,6},{3,4,7,8},{9,10,13,14},{11,12,15,16}};
    private int[][] stressMatix = {{6,8,5,7},{14,16,13,15},{2,4,1,3},{10,12,9,11}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_selectp2);

        Intent fromIntent = getIntent();
        groupIndex = fromIntent.getIntExtra("groupIndex", 1);
        p1 = fromIntent.getIntExtra("p1", 1);
        Log.d("p1", ""+p1);


        ImageButton i1 = (ImageButton) findViewById(R.id.imgp1);
        ImageButton i2 = (ImageButton) findViewById(R.id.imgp2);
        ImageButton i3 = (ImageButton) findViewById(R.id.imgp3);
        ImageButton i4 = (ImageButton) findViewById(R.id.imgp4);

        i1.setBackground(getDrawable(PSM.getGridById(groupIndex)[p2Matix[p1-1][0]-1]));
        i2.setBackground(getDrawable(PSM.getGridById(groupIndex)[p2Matix[p1-1][1]-1]));
        i3.setBackground(getDrawable(PSM.getGridById(groupIndex)[p2Matix[p1-1][2]-1]));
        i4.setBackground(getDrawable(PSM.getGridById(groupIndex)[p2Matix[p1-1][3]-1]));

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent();
        switch (v.getId()){
            case R.id.imgp1:
                mIntent.putExtra("p2", stressMatix[p1-1][0]);
                break;
            case R.id.imgp2:
                mIntent.putExtra("p2", stressMatix[p1-1][1]);
                break;
            case R.id.imgp3:
                mIntent.putExtra("p2", stressMatix[p1-1][2]);
                break;
            case R.id.imgp4:
                mIntent.putExtra("p2", stressMatix[p1-1][3]);
                break;
        }

        this.setResult(0, mIntent);
        this.finish();
    }
}
