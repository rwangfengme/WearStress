package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Weichen on 16/2/5.
 */
public class ResultDetailFragment extends Fragment {
    private int groupIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_result_detail, container, false);
        LinearLayout details = (LinearLayout) view.findViewById(R.id.result_detail);

        TextView rowTextView = new TextView(getActivity());
        rowTextView.setText("Time        Stress");
        rowTextView.setTextColor(Color.WHITE);
        rowTextView.setTextSize(16);
        rowTextView.setGravity(Gravity.CENTER);
        details.addView(rowTextView);

        TextView headerLine = new TextView(getActivity());
        headerLine.setHeight(1);
        headerLine.setBackgroundColor(Color.WHITE);
        headerLine.setGravity(Gravity.CENTER);
        details.addView(headerLine);


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        LinearLayout details = (LinearLayout) getActivity().findViewById(R.id.result_detail);
        ResultFragment result = (ResultFragment)((SimpleFragAdapter)((MainActivity)getActivity()).mGridPager.getAdapter()).getFragment(0, 0);
        ArrayList<String> times = result.getTimes();
        ArrayList<String> stresses = result.getStresses();

        for (int i = times.size() - 1; i >= 0 ; i--) {
            // create a new textview
            final TextView detailTextView = new TextView(getActivity());
            detailTextView.setText(times.get(i) + "       " + stresses.get(i));
            detailTextView.setTextColor(Color.WHITE);
            detailTextView.setTextSize(16);
            detailTextView.setGravity(Gravity.CENTER);

            // add the textview to the linearlayout
            details.addView(detailTextView);
        }


    }
}
