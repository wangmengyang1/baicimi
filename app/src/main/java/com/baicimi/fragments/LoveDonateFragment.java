package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠首页布局
 */
public class LoveDonateFragment extends BaseFragment implements View.OnClickListener {

    private View view;

    private ImageView back;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 7;

    private LoveDonateFragmentFirst loveDonateFragmentFirst;//首页
    private LoveDonateFragmentSecond loveDonateFragmentSecond;//资助进行中
    private LoveDonateFragmentThread loveDonateFragmentThread;//已完成资助
    private LoveDonateFragmentFour loveDonateFragmentFour;//资助审核中
    private LoveDonateFragmentFive loveDonateFragmentFive;//我要资助


    private TextView homepage , underway , accomplish , underreview , wantsupport , applysupport;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.love_donate_fragment , container , false);

        //fragment切换

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        back = (ImageView) view.findViewById(R.id.love_donate_fragment_back);
        back.setOnClickListener(this);

        showTextView();

        return view;
    }

    private void showTextView() {
        homepage = (TextView) view.findViewById(R.id.love_donate_fragment_homepage);
        underway = (TextView) view.findViewById(R.id.love_donate_fragment_underway);
        accomplish = (TextView) view.findViewById(R.id.love_donate_fragment_accomplish);
        underreview = (TextView) view.findViewById(R.id.love_donate_fragment_underreview);
        wantsupport = (TextView) view.findViewById(R.id.love_donate_fragment_wantsupport);
        applysupport = (TextView) view.findViewById(R.id.love_donate_fragment_applysupport);

        homepage.setOnClickListener(this);
        underway.setOnClickListener(this);
        accomplish.setOnClickListener(this);
        underreview.setOnClickListener(this);
        wantsupport.setOnClickListener(this);
        applysupport.setOnClickListener(this);
    }

    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(loveDonateFragmentFirst = new LoveDonateFragmentFirst());
        listFragment.add(loveDonateFragmentSecond = new LoveDonateFragmentSecond());
    }


    private void initializeTextView(){
        homepage.setTextColor(Color.parseColor("#737373"));
        underway.setTextColor(Color.parseColor("#737373"));
        accomplish.setTextColor(Color.parseColor("#737373"));
        underreview.setTextColor(Color.parseColor("#737373"));
        wantsupport.setTextColor(Color.parseColor("#737373"));
        applysupport.setTextColor(Color.parseColor("#737373"));
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
                transaction.add(R.id.love_donate_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.love_donate_fragment_framelayout , listFragment.get(i) , tag);

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
            case R.id.love_donate_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.love_donate_fragment_homepage:
                initializeTextView();
                homepage.setTextColor(Color.parseColor("#0282c3"));
                initShowFragment(0);
                break;
            case R.id.love_donate_fragment_underway:
                initializeTextView();
                underway.setTextColor(Color.parseColor("#0282c3"));
                initShowFragment(1);
                break;
            case R.id.love_donate_fragment_accomplish:
                initializeTextView();
                accomplish.setTextColor(Color.parseColor("#0282c3"));
                break;
            case R.id.love_donate_fragment_underreview:
                initializeTextView();
                underreview.setTextColor(Color.parseColor("#0282c3"));
                break;
            case R.id.love_donate_fragment_wantsupport:
                initializeTextView();
                wantsupport.setTextColor(Color.parseColor("#0282c3"));
                break;
            case R.id.love_donate_fragment_applysupport:
                initializeTextView();
                applysupport.setTextColor(Color.parseColor("#0282c3"));
                break;
        }
    }
}
