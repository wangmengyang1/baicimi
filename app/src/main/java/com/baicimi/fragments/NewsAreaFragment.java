package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import com.baicimi.view.MyViewPagerPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/9.
 * 积分商城新品区
 */
public class NewsAreaFragment extends BaseFragment{
    private MyViewPagerPager viewPager;
    private PersonUserPagerSlidingTabStrip tabs;
    private NewsManFragment newsManFragment;
    private NewsMeiZhuangFragment newsMeiZhuangFragment;
    private NewsPersonFragment newsPersonFragment;
    private NewsMuYingFragment newsMuYingFragment;
    private String[] titles = {"男士", "美妆", "个人用品", "母婴"};

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_news_area,container,false);
        ViewUtils.inject(this, view);
        viewPager = (MyViewPagerPager) view.findViewById(R.id.vp_news);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.news_page);
        viewPager.setAdapter(new MyPageAdapter((getActivity().getSupportFragmentManager()), titles));
        tabs.setViewPager(viewPager);

        return view;
    }


    public class MyPageAdapter extends FragmentPagerAdapter {
        String[] _titles;

        public MyPageAdapter(FragmentManager fm, String[] titles) {
            super(fm);
            _titles = titles;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _titles[position];
        }

        @Override
        public int getCount() {
            return _titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (newsManFragment == null) {
                        newsManFragment = new NewsManFragment();
                    }
                    return newsManFragment;
                case 1:
                    if (newsMeiZhuangFragment == null) {
                        newsMeiZhuangFragment = new NewsMeiZhuangFragment();
                    }
                    return newsMeiZhuangFragment;
                case 2:
                    if (newsPersonFragment == null) {
                        newsPersonFragment = new NewsPersonFragment();
                    }
                    return newsPersonFragment;
                case 3:
                    if (newsMuYingFragment == null) {
                        newsMuYingFragment = new NewsMuYingFragment();
                    }
                    return newsMuYingFragment;

                default:
                    return null;
            }
        }
    }


    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一页
                break;

        }
    }


    @Override
    protected void initData() {

    }
}
