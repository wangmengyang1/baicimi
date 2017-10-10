package com.baicimi.fragments;

import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.adapter.MyViewPagerFragmetAdapterSecond;
import com.baicimi.adapter.NoticeDialogPagerAdapterpa;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tan on 2016/8/10.
 * 幂商城首页
 */
public class HeadFragment extends BaseFragment {
    private ViewPager viewPager;
    private PersonUserPagerSlidingTabStrip tabs;

//    private NoticeDialogPagerAdapterpa noticeDialogPagerAdapterpa;
    private List<View> listVoiew = new ArrayList<>();

//    private MyViewPagerFragmetAdapterSecond myViewPagerFragmetAdapterSecond;
    private List<Fragment> listFragment = new ArrayList<>();

    private String[] titles = {"畅销热卖", "七月菊", "宁菲", "绿色食品"
            , "积分商城", "团购","个人用品", "母婴用品"
            , "男士主页", "美妆个护", "试用申请", "品牌"
            , "周五之夜" , "玫瑰社区"};

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.cehua_view, container, false);
        ViewUtils.inject(this, view);
        initFragment();

        viewPager = (ViewPager) view.findViewById(R.id.vp_head_viewpager);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.head_page_pupst);
        viewPager.setAdapter(new MyViewPagerFragmetAdapterSecond(getChildFragmentManager() , listFragment , titles));
        tabs.setViewPager(viewPager);
        return view;
    }

    private void initFragment() {
        listFragment.clear();
        listFragment.add(new ChangXiaoFragment());
        listFragment.add(new SevenMonFragment());
        listFragment.add(new NingFeiFragment());
        listFragment.add(new GreenFoodFragment());
        listFragment.add(new JiFenGoodsFragment());//积分
        listFragment.add(new GrouBuyFragment());
        listFragment.add(new PerSonUseFragment());//个人用品
        listFragment.add(new MuYingFragment());
        listFragment.add(new ManMainFragment());
        listFragment.add(new MeiZhuangFragment());
        listFragment.add(new TryoutApplyforFragment());
        listFragment.add(new HomePageBrandFragment());
        listFragment.add(new FridayNightFragment());
        listFragment.add(new HeadMeiguiRoseFragment());
    }

    @Override
    protected void initData() {
    }

}
