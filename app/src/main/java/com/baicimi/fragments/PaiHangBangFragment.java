package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/10/10.
 * 排行榜界面
 */
public class PaiHangBangFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_jifen_paihang,container,false);
        return view;
    }


    @Override
    protected void initData() {
    }
}
