package dartmouth.edu.wearstress;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class SelectP2Activity extends WearableActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_selectp2);

        ImageButton i1 = (ImageButton) findViewById(R.id.imgp1);
        ImageButton i2 = (ImageButton) findViewById(R.id.imgp2);
        ImageButton i3 = (ImageButton) findViewById(R.id.imgp3);
        ImageButton i4 = (ImageButton) findViewById(R.id.imgp4);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent();
        switch (v.getId()){
            case R.id.imgp1:
                mIntent.putExtra("selection", 5);
                // 设置结果，并进行传送
                this.setResult(0, mIntent);
                this.finish();
                break;
            case R.id.imgp2:
                mIntent.putExtra("selection", 13);
                // 设置结果，并进行传送
                this.setResult(0, mIntent);
                this.finish();
                break;
        }
    }
}
