package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;


/**
 * Created by tan on 2017/2/22.
 * 玫瑰社区个人中心设置：隐私
 */
public class RosePersonYinSiFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_yinsi,container,false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
