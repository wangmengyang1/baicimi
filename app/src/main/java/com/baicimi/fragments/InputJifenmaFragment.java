package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2017/3/20.
 * 输入积分码界面
 */
public class InputJifenmaFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_input_jifenma, container, false);
        return view;
    }


    @OnClick({R.id.btn_ok})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_ok:
                startFragment(new GetPointFragment(),null);
                break;

        }
    }

    @Override
    protected void initData() {

    }
}
