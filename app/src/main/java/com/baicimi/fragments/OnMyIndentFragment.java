package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.adapter.NoticeDialogPagerAdapterpa;
import com.baicimi.adapter.OnMyIndentViewPagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.TodayCosmeticsEntry;
import com.baicimi.interfaces.OnMyIndentViewListener;
import com.baicimi.view.MyViewPagerMeasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
public class OnMyIndentFragment extends BaseFragment {

    private View view;
    private MyViewPagerMeasure viewPager;
    private OnMyIndentViewPagerAdapter adapter;
    private List<Fragment> list = new ArrayList<>();

    private OnMyIndentNotYetShipped onMyIndentNotYetShipped = new OnMyIndentNotYetShipped();//待发货

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.on_my_indent_fragment , container , false);
        //viewpager进行布局填充
        initViewPagre();
        return view;
    }

    //viewpager进行布局填充
    private void initViewPagre() {

        viewPager = (MyViewPagerMeasure) view.findViewById(R.id.on_my_indent_fragment_viewpager);
        list.clear();
        list.add(onMyIndentNotYetShipped);
        adapter = new OnMyIndentViewPagerAdapter(getChildFragmentManager() , list);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

}
