package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/11.
 * 个人中心首页 我的全球生活汇 我的图片
 */
public class RosePersonalMyPicture extends BaseFragment{

    private View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rose_personal_my_picture , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
