package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/25.
 */
public class MiXinYongFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_mixinyong,container,false);
        return view;
    }

    @OnClick({R.id.login_back,R.id.xinyongjiedu,R.id.xinyongtisheng,R.id.tv_xinyongguanli,R.id.xinyonglife})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.xinyongjiedu:
                startFragment(new XinYongJieDuFragment());
                break;
            case R.id.xinyongtisheng:
                startFragment(new XinYongTiShengFragment());
                break;
            case R.id.tv_xinyongguanli:
                startFragment(new XinYongGuanLiFragment());
                break;
            case R.id.xinyonglife:
                startFragment(new XinYongLifeFragment());
                break;
        }
    }
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
