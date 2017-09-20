package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;


/**
 * Created by tan on 2017/2/21.
 * 玫瑰社区我的相册界面
 */
public class MyPhotoFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_myphoto,container,false);
        return view;
    }


    @Override
    protected void initData() {

    }
}
