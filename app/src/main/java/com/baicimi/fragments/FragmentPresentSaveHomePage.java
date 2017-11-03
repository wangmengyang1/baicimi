package com.baicimi.fragments;

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
 * Created by Administrator on 2017/11/3.
 * 个人中心 我的生活助手 礼品寄存处
 */
public class FragmentPresentSaveHomePage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 4;

    private FragmentPresentSaveFirst presentSaveFirst;
    private FragmentPresentSaveSecond presentSaveSecond;
    private FragmentPresentSaveThread presentSaveThread;

    private LinearLayout layout_01 , layout_02 ,layout_03 ;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_present_save_homepage , container , false);

        back = (ImageView) view.findViewById(R.id.fragment_present_save_homepage_back);
        back.setOnClickListener(this);


        fm = getChildFragmentManager();
        init();
        initShowFragment(0);

        layout_01 = (LinearLayout) view.findViewById(R.id.fragment_present_save_homepage_layout_01);
        layout_02 = (LinearLayout) view.findViewById(R.id.fragment_present_save_homepage_layout_02);
        layout_03 = (LinearLayout) view.findViewById(R.id.fragment_present_save_homepage_layout_03);
        layout_01.setOnClickListener(this);
        layout_02.setOnClickListener(this);
        layout_03.setOnClickListener(this);

        return view;
    }

    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(presentSaveFirst = new FragmentPresentSaveFirst(0));
        listFragment.add(presentSaveSecond = new FragmentPresentSaveSecond(1));
        listFragment.add(presentSaveThread = new FragmentPresentSaveThread(2));
    }


    //fragment切换
    private void initShowFragment(int i) {
        if(index == i){
            return;
        }

        String tag = listFragment.get(i).getMTag();
        FragmentTransaction transaction =  fm.beginTransaction();
        if (fragmentTag.contains(tag)){
            transaction.hide(listFragment.get(index));
            transaction.show(fm.findFragmentByTag(tag));

            index = i;
        }else {
            if (fragmentTag.isEmpty()){
                fragmentTag.add(tag);
                transaction.add(R.id.fragment_present_save_homepage_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.fragment_present_save_homepage_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_present_save_homepage_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.fragment_present_save_homepage_layout_01:
                initShowFragment(0);
                break;
            case R.id.fragment_present_save_homepage_layout_02:
                initShowFragment(1);
                break;
            case R.id.fragment_present_save_homepage_layout_03:
                initShowFragment(2);
                break;
        }
    }
}
