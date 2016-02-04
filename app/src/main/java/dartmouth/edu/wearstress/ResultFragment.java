package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class ResultFragment extends Fragment{
    private final int[] suggestionWords =
            {R.string.words_stress_1, R.string.words_stress_3, R.string.words_stress_5,
                    R.string.words_stress_7, R.string.words_stress_9, R.string.words_stress_11,
                    R.string.words_stress_13, R.string.words_stress_15};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_result, container, false);

        TextView tv = (TextView) view.findViewById(R.id.suggestion);
        int stressDegree = ((MainActivity)getActivity()).stressDegree;
        if (stressDegree == 0){
            tv.setText(getString(R.string.hint));
        }
        else {
            int words = suggestionWords[(stressDegree-1)/2];
            tv.setText(getString(words));
        }

        TextView t1 = (TextView) view.findViewById(R.id.status1);
        t1.setBackgroundColor(000000);
        return view;
    }
}
