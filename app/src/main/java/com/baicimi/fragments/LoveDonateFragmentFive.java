package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠   我要资助
 */
public class LoveDonateFragmentFive extends BaseFragment implements View.OnClickListener {

    private View view;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 7;

    private LoveDonateFragmentFiveFirst loveDonateFragmentFiveFirst;//我要资助首页
    private LoveDonateFragmentFiveSecond loveDonateFragmentFiveSecond;//文化资助首页
    private LoveDonateFragmentFiveThread loveDonateFragmentFiveThread;//教育资助首页
    private LoveDonateFragmentFiveFour loveDonateFragmentFiveFour;//无息资助首页

    private TextView textView_01 , textView_02 ,textView_03;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.love_donate_fragment_five , container , false);

        //fragment切换

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        textView_01 = (TextView) view.findViewById(R.id.love_donate_fragment_five_01);
        textView_02 = (TextView) view.findViewById(R.id.love_donate_fragment_five_02);
        textView_03 = (TextView) view.findViewById(R.id.love_donate_fragment_five_03);

        textView_01.setOnClickListener(this);
        textView_02.setOnClickListener(this);
        textView_03.setOnClickListener(this);

        return view;
    }



    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(loveDonateFragmentFiveFirst = new LoveDonateFragmentFiveFirst());
        listFragment.add(loveDonateFragmentFiveSecond = new LoveDonateFragmentFiveSecond());
        listFragment.add(loveDonateFragmentFiveThread = new LoveDonateFragmentFiveThread());
        listFragment.add(loveDonateFragmentFiveFour = new LoveDonateFragmentFiveFour());
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
                transaction.add(R.id.love_donate_fragment_five_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.love_donate_fragment_five_framelayout , listFragment.get(i) , tag);

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
            case R.id.love_donate_fragment_five_01:
                textView_01.setTextColor(Color.parseColor("#343434"));
                textView_02.setTextColor(Color.parseColor("#737373"));
                textView_03.setTextColor(Color.parseColor("#737373"));
                initShowFragment(1);
                break;
            case R.id.love_donate_fragment_five_02:
                textView_01.setTextColor(Color.parseColor("#737373"));
                textView_02.setTextColor(Color.parseColor("#343434"));
                textView_03.setTextColor(Color.parseColor("#737373"));
                initShowFragment(2);
                break;
            case R.id.love_donate_fragment_five_03:
                textView_01.setTextColor(Color.parseColor("#737373"));
                textView_02.setTextColor(Color.parseColor("#737373"));
                textView_03.setTextColor(Color.parseColor("#343434"));
                initShowFragment(3);
                break;
        }
    }
}
