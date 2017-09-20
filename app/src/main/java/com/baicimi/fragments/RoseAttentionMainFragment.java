package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;


/**
 * Created by tan on 2017/3/3.
 * 全球汇关注主页
 */
public class RoseAttentionMainFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_attention_main,container,false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
