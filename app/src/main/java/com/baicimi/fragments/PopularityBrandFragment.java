package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Administrator on 2017/4/9.
 * 人气品牌二级界面
 */

public class PopularityBrandFragment extends BaseFragment implements View.OnClickListener  , DistributionNumberOnitemClick{

    private View view;

    private ScheduledExecutorService scheduledExecutorService;

    private ViewPager viewPager_huodpng;
    private PersonUserPagerSlidingTabStrip tabs;
    DisplayMetrics dm;
    private HeadJiFenNanShiFragment headJiFenNanShiFragment;
    private HeadJiFenMeiZhuangFragment headJiFenMeiZhuangFragment;
    private HeadJiFenGeRenFragment headJiFenGeRenFragment;
    private HeadJiFenMuYingFragment headJiFenMuYingFragment;
    private String[] titles = {"畅销", "新品", "折扣", "价格"};


    private ImageView back_image;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.popularity_brand_fragment , container , false);

        //控件查找
        initUI();

        //对viewpager进行适配数据
        viewPagerGet();
        return view;
    }

    private void initUI() {

        back_image = (ImageView) view.findViewById(R.id.popularity_brand_back);
        back_image.setOnClickListener(this);

    }

    //对viewpager进行适配数据
    private void viewPagerGet() {
        dm = getResources().getDisplayMetrics();
        viewPager_huodpng = (ViewPager) view.findViewById(R.id.populatity_vp_huodong);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.popularity_huodongzhuanchang);
        viewPager_huodpng.setAdapter(new PopularityBrandFragment.MyPageAdapter(getChildFragmentManager(),titles));
        tabs.setViewPager(viewPager_huodpng);

    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {

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
                    if (headJiFenNanShiFragment == null) {
                        headJiFenNanShiFragment = new HeadJiFenNanShiFragment();
                    }
                    return headJiFenNanShiFragment;
                case 1:
                    if (headJiFenMeiZhuangFragment == null) {
                        headJiFenMeiZhuangFragment = new HeadJiFenMeiZhuangFragment();
                    }
                    return headJiFenMeiZhuangFragment;
                case 2:
                    if (headJiFenGeRenFragment == null) {
                        headJiFenGeRenFragment = new HeadJiFenGeRenFragment();
                    }
                    return headJiFenGeRenFragment;
                case 3:
                    if (headJiFenMuYingFragment == null) {
                        headJiFenMuYingFragment = new HeadJiFenMuYingFragment();
                    }
                    return headJiFenMuYingFragment;
                default:
                    return null;
            }
        }
    }

    @Override
    protected void initData() {

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.popularity_brand_back:
                ((MainActivity) getActivity()).goBack();//返回到上层界面
                break;
        }
    }
}
