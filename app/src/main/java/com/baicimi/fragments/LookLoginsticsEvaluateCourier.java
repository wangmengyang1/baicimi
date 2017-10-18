package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/18.
 * 个人中心，我的订单  物流详情  评价快递员页面
 */
public class LookLoginsticsEvaluateCourier extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_loginstice_evaluate_courier , container , false);

        back = (ImageView) view.findViewById(R.id.look_logistics_evaluate_courier_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_evaluate_courier_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
