package com.baicimi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class MyViewPagerFragmetAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    public MyViewPagerFragmetAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyViewPagerFragmetAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
