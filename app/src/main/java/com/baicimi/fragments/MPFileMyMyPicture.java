package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 文件 我的图片
 */
public class MPFileMyMyPicture extends BaseFragment{

    private View view;

    private GridView gridViewFirst , gridViewSecond , gridViewThread;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_file_mymy_picture , container , false);
        return view;
    }

    @Override
    protected void initData() {

    }
}
