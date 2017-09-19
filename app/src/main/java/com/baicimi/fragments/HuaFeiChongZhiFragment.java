package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by Administrator on 2016/8/26.
 * 话费充值界面
 */
public class HuaFeiChongZhiFragment extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_huafei_chongzhi,container,false);
        ViewUtils.inject(this, view);
        return view;
    }

    @OnClick({R.id.chongzhi_zhangdan})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.chongzhi_zhangdan:
               startFragment(new ChongZhiZhangDanFragment(),null);
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
