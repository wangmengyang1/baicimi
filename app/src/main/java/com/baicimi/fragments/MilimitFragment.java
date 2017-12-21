package com.baicimi.fragments;

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
 * Created by Administrator on 2017/12/20.
 * 个人中心首页 我的生活助手  幂额度首页
 *
 */
public class MilimitFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView imageView;


    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 7;

    private MilimitFragmentEarnestMoney milimitFragmentEarnestMoney;//幂信用金
    private MilimitFragmentEarnestCode milimitFragmentEarnestCode;//幂信用积分

    private TextView earnestmoney , earnestcode;

    private MilimitFragmentEarnestMoneySuc milimitFragmentEarnestMoneySuc;//幂信用积分开通成功

    private int count;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_limit_fragment , container , false);

        imageView = (ImageView) view.findViewById(R.id.mi_limit_fragment_back);
        imageView.setOnClickListener(this);

        //fragment切换

        fm = getChildFragmentManager();
        init();
        initShowFragment(0);


        earnestmoney = (TextView) view.findViewById(R.id.mi_limit_fragment_earnestmoney);
        earnestcode = (TextView) view.findViewById(R.id.mi_limit_fragment_earnestcode);

        earnestmoney.setOnClickListener(this);
        earnestcode.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }


    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(milimitFragmentEarnestMoney = new MilimitFragmentEarnestMoney());
        listFragment.add(milimitFragmentEarnestCode = new MilimitFragmentEarnestCode());
        listFragment.add(milimitFragmentEarnestMoneySuc = new MilimitFragmentEarnestMoneySuc());
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
                transaction.add(R.id.mi_limit_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.mi_limit_fragment_framelayout , listFragment.get(i) , tag);

                index = i;
            }

        }
        transaction.commit();
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_limit_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_limit_fragment_earnestmoney:
                if (count % 2 == 0){
                    initShowFragment(0);
                }else {
                    initShowFragment(2);
                }

                count++;
                break;
            case R.id.mi_limit_fragment_earnestcode:

                initShowFragment(1);

                break;
        }
    }
}
