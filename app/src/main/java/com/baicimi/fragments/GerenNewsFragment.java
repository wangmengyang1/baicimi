package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/8/26.
 */
public class GerenNewsFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_geren_news,container,false);
        return view;
    }

    @OnClick({R.id.login_back,R.id.cheliang_re,R.id.zhiye_xinxi})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
            case R.id.cheliang_re:
               startFragment(new BusNewsFragment(),null);
                break;
            case R.id.zhiye_xinxi:
                startFragment(new WorkNewsFragment(),null);
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
