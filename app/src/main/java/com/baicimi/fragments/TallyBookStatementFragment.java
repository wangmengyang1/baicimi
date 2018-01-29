package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/26.
 * 个人中心  我的生活助手  记账本 类别报表
 */
public class TallyBookStatementFragment extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.tally_book_statement_fragment , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
