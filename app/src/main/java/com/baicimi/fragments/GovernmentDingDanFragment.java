package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.MyDingDanPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */

public class GovernmentDingDanFragment extends BaseFragment {

    private ViewPager viewPager;
    private MyDingDanPagerSlidingTabStrip tabs;

    private Class[] fragmentClass = {AllMyDingDanFragment.class, NoPayMyDingDanFragment.class,
            NoSendGoodsMyDingDanFragment.class, NoReceiveMyDingDanFragment.class, NoPingJiaDingDanFragment.class};
    private String[] data = new String[]{"全部", "待付款", "待发货", "待收货", "待评价"};
    private List<Fragment> list = new ArrayList<Fragment>();

    private int index;
    private View view;


    public GovernmentDingDanFragment() {
    }

    public GovernmentDingDanFragment(int index) {
        this.index = index;
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_government_dingdan , container ,false);
        ViewUtils.inject(this, view);

        viewPager = (ViewPager) view.findViewById(R.id.vp_my_dingdan_government);
        tabs = (MyDingDanPagerSlidingTabStrip) view.findViewById(R.id.my_dingdan_ps_government);
        init();
        viewPager.setAdapter(new GovernmentDingDanFragment.MyFPA(getFragmentManager()));
        tabs.setViewPager(viewPager);
        return view;
    }



    private void init() {
        for (int i = 0; i < fragmentClass.length; i++) {
            try {
                list.add((BaseFragment) fragmentClass[i].newInstance());
            } catch (java.lang.InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class MyFPA extends FragmentStatePagerAdapter {

        public MyFPA(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (list != null) {
                return list.get(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }


    @Override
    protected void initData() {

    }
}
