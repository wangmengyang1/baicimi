package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/24.
 * 成功还款页面
 */
public class SeccesePayMonyFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_seccese_payfenqi,container,false);
        return view;
    }

    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }


    @Override
    protected void initData() {

    }
}
