package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 * 积分商城  限时兑换 首页
 */

public class HomeIntegerTimelimitConversion extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private HomeIntegerEverydayConversion homeintegereverydayconversion;//每日必兑
    private HomeBrandConvertion homebrandconvertion;//大牌必兑
    private HomeFestivalConversionFragment homefestivalconversionfragment;//节日必兑
    private HomeNewConversionFragment homenewconversionfragment;//新品必兑

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> listFragmentTag = new ArrayList<>();
    private int index = 5;

    private LinearLayout layout_01 , layout_02 ,layout_03 ,layout_04 ;
    private View view_01,view_02,view_03,view_04;

    private int count;

    @SuppressLint("ValidFragment")
    public HomeIntegerTimelimitConversion(int count) {
        this.count = count;
    }

    public HomeIntegerTimelimitConversion() {
    }

    private View viewBrand_01 , viewBrand_02 ,viewBrand_03 ,viewBrand_04 ,viewBrand_05 ,viewBrand_06 ,
            viewBrand_07 ,viewBrand_08 ,viewBrand_09 ,viewBrand_10 ,viewBrand_11 ,viewBrand_12 ;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_timelimit_conversion , container ,false);

        back = (ImageView) view.findViewById(R.id.home_integer_timelimit_conversion_back);
        back.setOnClickListener(this);

        fm = getChildFragmentManager();
        //fragment数据源
        initListAddFragment();



        init();

        if (count != 0){
            //fragment切换
            initShowFragment(count);
            if (count == 1){
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#e16170"));
                view_03.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_04.setBackgroundColor(Color.parseColor("#eeeeee"));
            }else if (count == 2){
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_03.setBackgroundColor(Color.parseColor("#e16170"));
                view_04.setBackgroundColor(Color.parseColor("#eeeeee"));
            }else if (count == 3){
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_03.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_04.setBackgroundColor(Color.parseColor("#e16170"));
            }
        }else {
            //fragment切换
            initShowFragment(0);
        }





        return view;
    }

    private void init() {
        layout_01 = (LinearLayout) view.findViewById(R.id.home_integer_timelimit_conversion_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.home_integer_timelimit_conversion_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.home_integer_timelimit_conversion_layout_03);
        layout_04 = (LinearLayout) view.findViewById(R.id.home_integer_timelimit_conversion_layout_04);

        view_01 = view.findViewById(R.id.home_integer_timelimit_conversion_view_01);
        view_02 = view.findViewById(R.id.home_integer_timelimit_conversion_view_02);
        view_03 = view.findViewById(R.id.home_integer_timelimit_conversion_view_03);
        view_04 = view.findViewById(R.id.home_integer_timelimit_conversion_view_04);

        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);
        layout_04.setOnClickListener(this);

        viewBrand_01 = view.findViewById(R.id.home_integer_timelimit_conversion_01);
        viewBrand_02 = view.findViewById(R.id.home_integer_timelimit_conversion_02);
        viewBrand_03 = view.findViewById(R.id.home_integer_timelimit_conversion_03);
        viewBrand_04 = view.findViewById(R.id.home_integer_timelimit_conversion_04);
        viewBrand_05 = view.findViewById(R.id.home_integer_timelimit_conversion_05);
        viewBrand_06 = view.findViewById(R.id.home_integer_timelimit_conversion_06);
        viewBrand_07 = view.findViewById(R.id.home_integer_timelimit_conversion_07);
        viewBrand_08 = view.findViewById(R.id.home_integer_timelimit_conversion_08);
        viewBrand_09 = view.findViewById(R.id.home_integer_timelimit_conversion_09);
        viewBrand_10 = view.findViewById(R.id.home_integer_timelimit_conversion_10);
        viewBrand_11 = view.findViewById(R.id.home_integer_timelimit_conversion_11);
        viewBrand_12 = view.findViewById(R.id.home_integer_timelimit_conversion_12);

        viewBrand_01.setOnClickListener(this);
        viewBrand_02.setOnClickListener(this);
        viewBrand_03.setOnClickListener(this);
        viewBrand_04.setOnClickListener(this);
        viewBrand_05.setOnClickListener(this);
        viewBrand_06.setOnClickListener(this);
        viewBrand_07.setOnClickListener(this);
        viewBrand_08.setOnClickListener(this);
        viewBrand_09.setOnClickListener(this);
        viewBrand_10.setOnClickListener(this);
        viewBrand_11.setOnClickListener(this);
        viewBrand_12.setOnClickListener(this);
    }

    //fragment数据源
    private void initListAddFragment() {
        listFragment.clear();
        listFragment.add(homeintegereverydayconversion = new HomeIntegerEverydayConversion());
        listFragment.add(homebrandconvertion = new HomeBrandConvertion());
        listFragment.add(homefestivalconversionfragment = new HomeFestivalConversionFragment());
        listFragment.add(homenewconversionfragment = new HomeNewConversionFragment());
    }

    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (listFragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            listFragmentTag.add(tag);
            transaction.add(R.id.home_integer_timelimit_conversion_framelayout , listFragment.get(i) , tag);
            index = i;
        }
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_timelimit_conversion_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.home_integer_timelimit_conversion_layout_01:
                view_01.setBackgroundColor(Color.parseColor("#e16170"));
                view_02.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_03.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_04.setBackgroundColor(Color.parseColor("#eeeeee"));
                initShowFragment(0);
                break;
            case R.id.home_integer_timelimit_conversion_layout_02:
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#e16170"));
                view_03.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_04.setBackgroundColor(Color.parseColor("#eeeeee"));
                initShowFragment(1);
                break;
            case R.id.home_integer_timelimit_conversion_layout_03:
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_03.setBackgroundColor(Color.parseColor("#e16170"));
                view_04.setBackgroundColor(Color.parseColor("#eeeeee"));
                initShowFragment(2);
                break;
            case R.id.home_integer_timelimit_conversion_layout_04:
                view_01.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_02.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_03.setBackgroundColor(Color.parseColor("#eeeeee"));
                view_04.setBackgroundColor(Color.parseColor("#e16170"));
                initShowFragment(3);
                break;
            case R.id.home_integer_timelimit_conversion_01:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_02:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_03:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_04:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_05:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_06:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_07:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_08:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_09:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_10:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_11:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_integer_timelimit_conversion_12:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
        }
    }
}
