package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/9/20.
 * 政府采购订单
 */
public class CaiGouDingDanFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_shenqincaigou,container,false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
