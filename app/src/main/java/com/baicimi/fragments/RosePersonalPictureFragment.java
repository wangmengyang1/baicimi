package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2017/2/13.
 * 个人中心我的图片v
 */
public class RosePersonalPictureFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_picture,container,false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
