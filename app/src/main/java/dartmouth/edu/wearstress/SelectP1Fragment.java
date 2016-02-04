package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class SelectP1Fragment extends Fragment implements View.OnClickListener{
    private int groupIndex;

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

        Random rand = new Random();
        groupIndex =  1 + rand.nextInt(3);
        i1.setBackground(getActivity().getDrawable(PSM.getGridById(groupIndex)[0]));
        i2.setBackground(getActivity().getDrawable(PSM.getGridById(groupIndex)[2]));
        i3.setBackground(getActivity().getDrawable(PSM.getGridById(groupIndex)[8]));
        i4.setBackground(getActivity().getDrawable(PSM.getGridById(groupIndex)[10]));

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent i  = new Intent(getActivity(), SelectP2Activity.class);
        i.putExtra("groupIndex", groupIndex);
        switch (v.getId()){
            case R.id.img1:
                i.putExtra("p1", 1);
                startActivityForResult(i, 1);
                break;
            case R.id.img2:
                i.putExtra("p1", 2);
                startActivityForResult(i, 1);
                break;
            case R.id.img3:
                i.putExtra("p1", 3);
                startActivityForResult(i, 1);
                break;
            case R.id.img4:
                i.putExtra("p1", 4);
                startActivityForResult(i, 1);
                break;
            default:
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((MainActivity)getActivity()).repaint(requestCode, resultCode, data);
    }

}
