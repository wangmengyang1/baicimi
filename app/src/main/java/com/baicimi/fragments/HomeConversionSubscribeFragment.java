package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 * 积分商城   节日必兑  兑换预约
 */

public class HomeConversionSubscribeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> listTag = new ArrayList<>();
    private int index = 4;

    private ConversionSubscribeFirst conversionSubscribeFirst;
    private ConversionSubscribeFirst conversionSubscribeSecond;
    private ConversionSubscribeFirst conversionSubscribeThread;

    private View brandView_01 , brandView_02 ,brandView_03 ,brandView_04 ,brandView_05 ,brandView_06 ,
            brandView_07 ,brandView_08 ,brandView_09 ,brandView_10 ,brandView_11 ,brandView_12 ;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_conversion_subscribe_fragment , container , false);


        init();

        //fragment数据源添加
        initAddFragment();

        //fragment显示
        initShowFragment(0);
        return view;
    }

    private void init() {
        brandView_01 = view.findViewById(R.id.home_conversion_subscrive_01);
        brandView_02 = view.findViewById(R.id.home_conversion_subscrive_02);
        brandView_03 = view.findViewById(R.id.home_conversion_subscrive_03);
        brandView_04 = view.findViewById(R.id.home_conversion_subscrive_04);
        brandView_05 = view.findViewById(R.id.home_conversion_subscrive_05);
        brandView_06 = view.findViewById(R.id.home_conversion_subscrive_06);
        brandView_07 = view.findViewById(R.id.home_conversion_subscrive_07);
        brandView_08 = view.findViewById(R.id.home_conversion_subscrive_08);
        brandView_09 = view.findViewById(R.id.home_conversion_subscrive_09);
        brandView_10 = view.findViewById(R.id.home_conversion_subscrive_10);
        brandView_11 = view.findViewById(R.id.home_conversion_subscrive_11);
        brandView_12 = view.findViewById(R.id.home_conversion_subscrive_12);

        brandView_01.setOnClickListener(this);
        brandView_02.setOnClickListener(this);
        brandView_03.setOnClickListener(this);
        brandView_04.setOnClickListener(this);
        brandView_05.setOnClickListener(this);
        brandView_06.setOnClickListener(this);
        brandView_07.setOnClickListener(this);
        brandView_08.setOnClickListener(this);
        brandView_09.setOnClickListener(this);
        brandView_10.setOnClickListener(this);
        brandView_11.setOnClickListener(this);
        brandView_12.setOnClickListener(this);
    }

    //fragment数据源添加
    private void initAddFragment() {
        fm = getChildFragmentManager();
        listFragment.clear();
        listFragment.add(conversionSubscribeFirst = new ConversionSubscribeFirst());
        listFragment.add(conversionSubscribeSecond = new ConversionSubscribeFirst());
        listFragment.add(conversionSubscribeThread = new ConversionSubscribeFirst());
    }

    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (listTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));
            index = i;
        }else {
            listTag.add(tag);
            transaction.add(R.id.home_conversion_subcribe_fragment_framglayout , listFragment.get(i) , tag);
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
            case R.id.home_conversion_subscrive_01:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_02:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_03:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_04:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_05:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_06:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_07:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_08:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_09:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_10:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_11:
                startFragment(new HomeIntegerHotBrandFragment());
                break;
            case R.id.home_conversion_subscrive_12:
                startFragment(new HomeIntegerHotBrandFragment());
                break;

        }
    }
}
