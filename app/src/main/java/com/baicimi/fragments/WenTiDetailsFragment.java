package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by tan on 2016/10/8.
 * 问题详情界面
 */
public class WenTiDetailsFragment extends BaseFragment{

    private TextView lible;
    private String libles = "";

    public WenTiDetailsFragment(String libles) {
        this.libles = libles;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_wenti_details,container,false);

        lible = (TextView) view.findViewById(R.id.fragment_wenti_details_lible);
        lible.setText(libles);
        return view;
    }

    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity)getActivity()).goBack();//返回上一层页面
                break;
        }
    }
    @Override
    protected void initData() {

    }
}
