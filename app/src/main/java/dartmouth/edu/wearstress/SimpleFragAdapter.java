package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.FragmentGridPagerAdapter;
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
        int degree = ((MainActivity) mContext).stressDegree;
        int bg;
        if(degree == 5){
            bg = R.drawable.stressbg5;
        }else{

            bg = R.drawable.stressbg13;
        }
        return mContext.getDrawable(bg);
    }
}
