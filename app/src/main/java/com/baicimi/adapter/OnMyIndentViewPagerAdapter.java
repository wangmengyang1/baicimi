package com.baicimi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baicimi.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
public class OnMyIndentViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> list;
    private FragmentManager fm;

    public OnMyIndentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public OnMyIndentViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        this.fm = fm;
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
