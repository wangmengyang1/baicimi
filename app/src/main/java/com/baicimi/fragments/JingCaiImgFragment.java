package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by tan on 2016/10/10.
 * 精彩图片界面
 */
public class JingCaiImgFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_jingcai_img,container,false);
        return view;
    }

    @Override
    protected void initData() {
    }
}
