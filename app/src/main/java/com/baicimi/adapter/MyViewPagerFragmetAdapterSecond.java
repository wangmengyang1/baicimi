package com.baicimi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/9/10.
 */

public class MyViewPagerFragmetAdapterSecond extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    private String[] title;

    public MyViewPagerFragmetAdapterSecond(FragmentManager fm) {
        super(fm);
    }

    public MyViewPagerFragmetAdapterSecond(FragmentManager fm, List<Fragment> list, String[] title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    public MyViewPagerFragmetAdapterSecond(FragmentManager fm, List<Fragment> list) {
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


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
//        System.out.println("我执行了*****************");
    }
}
