package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页  资产中心  幂钱包  我的卡券  团购
 */
public class MiWalletDiscountCouponFirstItemFirst extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.miwalldt_discount_coupon_firstitme_first , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
