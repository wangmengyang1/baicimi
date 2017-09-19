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
import com.baicimi.ui.MyPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/8/26.
 */
public class PhoneChongZhiFragment extends BaseFragment {

    private ViewPager viewPager;
    private MyPagerSlidingTabStrip tabs;

    private Class[] fragmentClass = {HuaFeiChongZhiFragment.class,LiuLiangChongZhiFragment.class};
    private String[] data = new String[]{"充话费","充流量"};
    private List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_phone_chongzhi, container, false);
        ViewUtils.inject(this, view);
        viewPager= (ViewPager) view.findViewById(R.id.vp_shoujichongzhi);
        tabs= (MyPagerSlidingTabStrip) view.findViewById(R.id.shoujichongzhi_p);
        init();
        viewPager.setAdapter(new MyFPA(getFragmentManager()));
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

    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
