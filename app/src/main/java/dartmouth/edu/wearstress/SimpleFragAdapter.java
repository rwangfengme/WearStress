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
        mContext = mainAct;
        fragmentRow.add(result);
        fragmentRow.add(selectP1);
    }

    @Override
    public Fragment getFragment(int i, int i1) {
        return fragmentRow.get((i+1)*(i1+1)-1);
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount(int i) {
        return 2;
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
