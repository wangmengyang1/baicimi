package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠   我要资助 无息资助页面
 */
public class LoveDonateFragmentFiveFour extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.love_donate_fragment_five_four , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
