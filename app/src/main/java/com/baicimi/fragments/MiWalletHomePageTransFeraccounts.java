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
 * Created by Administrator on 2017/11/1.
 * 个人中心首页  资产中心  幂钱包 转账付款
 */
public class MiWalletHomePageTransFeraccounts extends BaseFragment {

    private View view;
    private FragmentManager fm;
    private List<BaseFragment> listFragment = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private int index = 3;

    private TransFeraccountsFirst transFeraccountsFirst;
    private TransFeraccountsSecond transFeraccountsSecond;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.miwallet_homepage_trans_feraccounts , container , false);

        fm = getChildFragmentManager();
        init();

        initShowFragment(0);
        return view;
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
                transaction.add(R.id.miwallet_homepage_trans_feraccounts_framelayout , listFragment.get(i) , tag);
                index = i;
            }else{
                transaction.hide(listFragment.get(index));
                fragmentTag.add(tag);
                transaction.add(R.id.miwallet_homepage_trans_feraccounts_framelayout , listFragment.get(i) , tag);
                index = i;
            }

        }
        transaction.commit();
    }

    //数据填充
    private void init() {
        listFragment.clear();
        listFragment.add(transFeraccountsFirst = new TransFeraccountsFirst());
        listFragment.add(transFeraccountsSecond = new TransFeraccountsSecond());
    }



    @Override
    protected void initData() {

    }
}
