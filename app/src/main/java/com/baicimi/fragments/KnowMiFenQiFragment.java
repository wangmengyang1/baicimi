package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/12/21.
 * 幂额度分期
 */
public class KnowMiFenQiFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_konw_mi,container,false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
