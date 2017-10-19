package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/27.
 * 个人中心我的预售页面
 */

public class MyPresellFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView myorderform;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_presell_fragment , container ,false);
        back = (ImageView) view.findViewById(R.id.my_presell_fragment_back);
        back.setOnClickListener(this);

        myorderform = (TextView) view.findViewById(R.id.my_presell_fragment_myorderform);
        myorderform.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_presell_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.my_presell_fragment_myorderform:
                startFragment(new MyOrderFormFragmentParticulars("我的预售订单"));//待付款
                break;
        }
    }
}
