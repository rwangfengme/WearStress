package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class SelectP1Fragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_selectp1, container, false);

        ImageButton i1 = (ImageButton) view.findViewById(R.id.img1);
        ImageButton i2 = (ImageButton) view.findViewById(R.id.img2);
        ImageButton i3 = (ImageButton) view.findViewById(R.id.img3);
        ImageButton i4 = (ImageButton) view.findViewById(R.id.img4);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        Intent i  = new Intent(getActivity(), SelectP2Activity.class);
        switch (v.getId()){
            case R.id.img1:
                Log.d("11111", "1");
                i.putExtra("requestVal", 1);
                startActivityForResult(i, 1);
                break;
            case R.id.img2:
                break;
            case R.id.img3:
                break;
            case R.id.img4:
                break;
            default:
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((MainActivity)getActivity()).changeBackgroud(requestCode, resultCode, data);

    }

}
