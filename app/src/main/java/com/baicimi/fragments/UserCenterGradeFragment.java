package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/6.
 * 个人中心 会员中心  会员等级
 */
public class UserCenterGradeFragment extends BaseFragment {

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_grade_fragment , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
