package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/20.
 * 个人中心首页 我的生活助手  幂额度首页 幂信用金
 */
public class MilimitFragmentEarnestMoney extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_limit_fragment_earnest_money , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
