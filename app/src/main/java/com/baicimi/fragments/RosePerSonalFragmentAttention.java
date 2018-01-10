package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/10.
 * 全球生活汇  首页 他的钉
 */
public class RosePerSonalFragmentAttention extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rose_personal_fragment_attention , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
