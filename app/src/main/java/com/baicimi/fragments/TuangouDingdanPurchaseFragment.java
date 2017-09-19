package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.MyDingDanPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 * 我的团购订单页面
 */

public class TuangouDingdanPurchaseFragment extends BaseFragment {

    private View view;
    private ViewPager viewPager;
    private MyDingDanPagerSlidingTabStrip tabs;

    private Class[] fragmentClass = {AllMyDingDanFragment.class, NoPayMyDingDanFragment.class,
            NoSendGoodsMyDingDanFragment.class, NoReceiveMyDingDanFragment.class, NoPingJiaDingDanFragment.class};
    private String[] data = new String[]{"全部", "待付款", "待发货", "待收货", "待评价"};
    private List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tuangou_dingdan_purchase_fragment , container , false);

        ViewUtils.inject(this, view);

        viewPager = (ViewPager) view.findViewById(R.id.purchase_vp_my_dingdan);
        tabs = (MyDingDanPagerSlidingTabStrip) view.findViewById(R.id.purchase_my_dingdan_ps);
        init();
        viewPager.setAdapter(new TuangouDingdanPurchaseFragment.MyFPA(getFragmentManager()));
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


    @OnClick({R.id.purchase_login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.purchase_login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }



    @Override
    protected void initData() {

    }
}
