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
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理  宝贝评价首页
 */
public class RreasureEvaluateFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView myevaluate , formyevaluate , writeevaluate;

    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 3;

    private RreasureEvaluateFragmentFirst rreasureEvaluateFragmentFirst;//我的评论
    private RreasureEvaluateFragmentSecond rreasureEvaluateFragmentSecond;//给我的评价
    private RreasureEvaluateFragmentThread rreasureEvaluateFragmentThread;//写评价



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rreasure_evaluate_fragment , container , false);


        fm = getChildFragmentManager();
        back = (ImageView) view.findViewById(R.id.rreasure_evaluate_fragment_back);
        back.setOnClickListener(this);

        myevaluate = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_myevaluate);
        formyevaluate = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_formyevaluate);
        writeevaluate = (TextView) view.findViewById(R.id.rreasure_evaluate_fragment_writeevaluate);
        myevaluate.setOnClickListener(this);
        formyevaluate.setOnClickListener(this);
        writeevaluate.setOnClickListener(this);


        //fragment数据源
        initListAddFragment();
        initShowFragment(0);

        return view;
    }

    @Override
    protected void initData() {

    }


    //fragment数据源
    private void initListAddFragment() {
        listFragment.clear();
        listFragment.add(rreasureEvaluateFragmentFirst = new RreasureEvaluateFragmentFirst());
        listFragment.add(rreasureEvaluateFragmentSecond = new RreasureEvaluateFragmentSecond());
        listFragment.add(rreasureEvaluateFragmentThread = new RreasureEvaluateFragmentThread());
//        listFragment.add(earnFragment = new UserIntegerFragmentEarn());
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
                transaction.add(R.id.rreasure_evaluate_fragment_framelayout , listFragment.get(i) , tag);
                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.rreasure_evaluate_fragment_framelayout , listFragment.get(i) , tag);
                index = i;
            }

        }
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rreasure_evaluate_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.rreasure_evaluate_fragment_myevaluate:
                myevaluate.setBackgroundColor(Color.parseColor("#d2d2d2"));
                formyevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                writeevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                initShowFragment(0);
                break;
            case R.id.rreasure_evaluate_fragment_formyevaluate:
                myevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                formyevaluate.setBackgroundColor(Color.parseColor("#d2d2d2"));
                writeevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                initShowFragment(1);
                break;
            case R.id.rreasure_evaluate_fragment_writeevaluate:
                myevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                formyevaluate.setBackgroundColor(Color.parseColor("#e5e5e5"));
                writeevaluate.setBackgroundColor(Color.parseColor("#d2d2d2"));
                initShowFragment(2);
                break;
        }
    }
}
