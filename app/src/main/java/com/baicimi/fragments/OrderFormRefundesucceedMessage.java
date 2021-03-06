package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/17.
 * 退款成功详情页
 */
public class OrderFormRefundesucceedMessage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_refundesucceed_message , container , false);

        back = (ImageView) view.findViewById(R.id.order_form_refundesucceed_message_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.order_form_refundesucceed_message_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
