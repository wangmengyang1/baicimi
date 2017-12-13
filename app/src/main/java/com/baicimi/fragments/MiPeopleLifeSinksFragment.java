package com.baicimi.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇
 */
public class MiPeopleLifeSinksFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    //fragment布局切换
    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 6;


    private MPLifeSinksManager mpLifeSinksManager;//管理首页
    private MPNewBookFragment mpNewBookFragment;//新建
    private MPSystemGcFragment mpSystemGcFragment;//回收站
    private MPFileFragment mpFileFragment;//文件


    private LinearLayout layoutfirst , layoutsecond , layoutThread , layoutFour , layoutFive;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_people_life_sinks_fragment , container , false);

        //fragment布局切换
        fm = getChildFragmentManager();
        init();
        initShowFragment(0);

        layoutfirst = (LinearLayout) view.findViewById(R.id.mi_people_life_sinks_fragment_layoutfirst);
        layoutfirst.setOnClickListener(this);

        layoutsecond = (LinearLayout) view.findViewById(R.id.mi_people_life_sinks_fragment_layoutsecond);
        layoutsecond.setOnClickListener(this);

        layoutThread = (LinearLayout) view.findViewById(R.id.mi_people_life_sinks_fragment_mifriendscircle);
        layoutThread.setOnClickListener(this);

        layoutFour = (LinearLayout) view.findViewById(R.id.mi_people_life_sinks_fragment_layoutfour);
        layoutFour.setOnClickListener(this);

        layoutFive = (LinearLayout) view.findViewById(R.id.mi_people_life_sinks_fragment_layoutfive);
        layoutFive.setOnClickListener(this);
        return view;
    }



    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(mpNewBookFragment = new MPNewBookFragment());//新建
        listFragment.add(mpSystemGcFragment = new MPSystemGcFragment());//回收站
        listFragment.add(mpFileFragment = new MPFileFragment());//文件
        listFragment.add(mpLifeSinksManager = new MPLifeSinksManager());//管理首页
    }


    //fragment切换
    public void initShowFragment( int i) {

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
                    transaction.add(R.id.mi_people_life_sinks_fragment_framelayout , listFragment.get(i) , tag);

                    index = i;
                }else{
                    transaction.hide(listFragment.get(index));
                    fragmentTag.add(tag);
                    transaction.add(R.id.mi_people_life_sinks_fragment_framelayout , listFragment.get(i) , tag);

                    index = i;
                }

            }
            transaction.addToBackStack(tag);
            transaction.commit();


    }





    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_people_life_sinks_fragment_layoutfirst:
//                initShowFragment(0);
                break;
            case R.id.mi_people_life_sinks_fragment_layoutsecond:
                initShowFragment(0);
                break;
            case R.id.mi_people_life_sinks_fragment_mifriendscircle:
                initShowFragment(1);
                break;
            case R.id.mi_people_life_sinks_fragment_layoutfour:
                initShowFragment(2);
                break;
            case R.id.mi_people_life_sinks_fragment_layoutfive:
                initShowFragment(3);
                break;
        }
    }
}
