package app.superniania.tabControl;
import app.superniania.MapsFragment;
import app.superniania.model.Location;
import app.superniania.tabFragment.FrequencyFragment;
import app.superniania.tabFragment.RestDetailsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by Łukasz on 2015-06-01.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new MapsFragment();
            case 1:
                return new FrequencyFragment();
            case 2:
                return new RestDetailsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
