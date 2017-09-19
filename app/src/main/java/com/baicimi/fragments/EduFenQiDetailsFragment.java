package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/12/22.
 * 幂额度分期详情
 */
public class EduFenQiDetailsFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_mifenqi_detail,container,false);
        return view;
    }

    @OnClick({R.id.login_back,R.id.fenqi_details})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
            case R.id.fenqi_details:
                startFragment(new ZhangDanFenqiDetailsFragment(),null);
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
