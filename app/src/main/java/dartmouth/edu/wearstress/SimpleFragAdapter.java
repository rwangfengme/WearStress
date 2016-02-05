package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class SimpleFragAdapter extends FragmentGridPagerAdapter{
    private ArrayList<Fragment> fragmentRow = new ArrayList<>();
    private Context mContext;

    public SimpleFragAdapter(MainActivity mainAct, FragmentManager fragmentManager) {
        super(fragmentManager);
        ResultFragment result = new ResultFragment();
        SelectP1Fragment selectP1 = new SelectP1Fragment();
        ResultDetailFragment detail = new ResultDetailFragment();
        mContext = mainAct;
        fragmentRow.add(result);
        fragmentRow.add(selectP1);
        fragmentRow.add(detail);
    }

    @Override
    public Fragment getFragment(int row, int col) {
        if (row == 0 && col == 0)
            return fragmentRow.get(0);
        else if (row == 0 && col == 1)
            return fragmentRow.get(1);
        else
            return fragmentRow.get(2);
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount(int i) {
        if (i == 0)
            return 2;
        else
            return 1;
    }

    @Override
    public Drawable getBackgroundForRow(int row) {
        int[] bg = {R.drawable.stress_bg1, R.drawable.stress_bg3, R.drawable.stress_bg5,
                R.drawable.stress_bg7, R.drawable.stress_bg9, R.drawable.stress_bg11,
                R.drawable.stress_bg13, R.drawable.stress_bg15};
        int degree = ((MainActivity) mContext).stressDegree;
        if (degree == 0)
            degree = 8;
        return mContext.getDrawable(bg[(degree-1)/2]);
    }
}
