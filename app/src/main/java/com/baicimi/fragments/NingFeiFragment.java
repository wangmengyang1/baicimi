package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.image.GlideImageLoader;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import com.lidroid.xutils.ViewUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/14.
 * 宁菲页面
 */
public class NingFeiFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager viewPager;
    private PersonUserPagerSlidingTabStrip tabs;
    private String[] titles = {" "};

    private SevenMonFragmentGridViewFragment sevenMonFragmentGridViewFragment;

    private View new_01 , new_02 , new_03;


    //头部轮播图集合
    List<Integer> images = new ArrayList<>();
    List<String> title = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_ningfei,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.vp_ningfei);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.my_head_ningfei);
        viewPager.setAdapter(new MyPageAdapter(getChildFragmentManager(),titles));
        tabs.setViewPager(viewPager);



        new_01 = view.findViewById(R.id.fragment_ningfei_new_01);
        new_02 = view.findViewById(R.id.fragment_ningfei_new_02);
        new_03 = view.findViewById(R.id.fragment_ningfei_new_03);

        new_01.setOnClickListener(this);
        new_02.setOnClickListener(this);
        new_03.setOnClickListener(this);


        //头部轮播方法
        initBanner();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_ningfei_new_01:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_ningfei_new_02:
                startFragment(new SerchGoodsFragment(),null);
                break;
            case R.id.fragment_ningfei_new_03:
                startFragment(new SerchGoodsFragment(),null);
                break;
        }
    }


    public class MyPageAdapter extends FragmentPagerAdapter {
        String[] _titles;

        public MyPageAdapter(FragmentManager fm, String[] titles) {
            super(fm);
            _titles=titles;
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
                    if (sevenMonFragmentGridViewFragment == null) {
                        sevenMonFragmentGridViewFragment = new SevenMonFragmentGridViewFragment();
                    }
                    return sevenMonFragmentGridViewFragment;
                default:
                    return null;
            }
        }
    }


    @Override
    protected void initData() {

    }

    //头部轮播方法
    private void initBanner() {
        title.clear();
        images.clear();
        for(int i = 0 ; i < 3 ; i++){

            title.add(new String(""));
            images.add(R.mipmap.new_ningfei_1);
        }

        //头部轮播图片
        Banner banner = (Banner)view.findViewById(R.id.fragment_ningfei_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(title);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                startFragment(new SerchGoodsFragment(),null);
            }
        });
    }


    @Override
    public void onDetach() {
        if (view != null){
            sevenMonFragmentGridViewFragment = null;
            view = null;

        }
        System.gc();
        super.onDetach();


    }

}
