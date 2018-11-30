package com.leiwan.zl.details;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by DELL on 2017/9/12.
 */

public class MyTabAdapter extends FragmentPagerAdapter {
    private List<String> list;
    private List<Fragment> list1;
    private View mCurrentView;
    public MyTabAdapter(FragmentManager fm, List<String> list, List<Fragment> list1) {
        super(fm);
        this.list = list;
        this.list1=list1;
    }

    @Override
    public Fragment getItem(int position) {
        return list1.get(position);

    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (object instanceof View) {
            mCurrentView = (View) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            mCurrentView = fragment.getView();
        }
    }
    public View getPrimaryItem() {
        return mCurrentView;
    }



    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
