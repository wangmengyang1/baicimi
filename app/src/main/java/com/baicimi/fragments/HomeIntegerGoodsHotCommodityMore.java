package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MyViewPagerFragmetAdapterSecond;
import com.baicimi.base.BaseFragment;
import com.baicimi.interfaces.DistributionNumberOnitemClick;
import com.baicimi.ui.PersonUserPagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城  兑换排行 热门商品  查看更多
 */
public class HomeIntegerGoodsHotCommodityMore extends BaseFragment implements DistributionNumberOnitemClick, View.OnClickListener {

    private View view;

    private ViewPager viewPager;
    private PersonUserPagerSlidingTabStrip tabs;
    private String[] titles = { "日化" , "绿色食品" , "美妆",  "母婴" , "个人用品","男士"};
    private List<Fragment> listFragment = new ArrayList<>();
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.homeinteger_goods_hot_commodity_more , container , false);

        initFragment();
        viewPager = (ViewPager) view.findViewById(R.id.homeinteger_goods_hot_commodity_more_jifenshangcheng);
        tabs = (PersonUserPagerSlidingTabStrip) view.findViewById(R.id.homeinteger_goods_hot_commodity_more_jifen);
        viewPager.setAdapter(new MyViewPagerFragmetAdapterSecond(getChildFragmentManager() , listFragment , titles));
        tabs.setViewPager(viewPager);


        back = (ImageView) view.findViewById(R.id.home_integer_goods_conversion_brand_more_back);
        back.setOnClickListener(this);


        return view;
    }



    private void initFragment() {
        listFragment.clear();
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));
        listFragment.add(new HeadJiFenNanShiFragment(this));

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setNumberOnitemClick(View view, int i, long l) {
        if(this.view != null){
            ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
            layoutParams.height = 1865;
            viewPager.setLayoutParams(layoutParams);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_goods_conversion_brand_more_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
