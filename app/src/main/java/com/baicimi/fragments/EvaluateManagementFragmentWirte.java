package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/27.
 * 评价管理   物流评价 写评价
 */
public class EvaluateManagementFragmentWirte extends BaseFragment {

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.evaluate_mange_ment_fragment_write , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
