package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/1.
 * 个人中心首页  资产中心  幂钱包 转账付款  银行卡
 */
public class TransFeraccountsSecond extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.trans_feraccounts_second_fragment , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
