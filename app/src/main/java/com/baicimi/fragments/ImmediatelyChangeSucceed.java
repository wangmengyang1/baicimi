package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/22.
 * 积分商城   新人专区 立即兑换 兑换失败页面
 */
public class ImmediatelyChangeSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.immediately_change_succeed , container , false);

        back = (ImageView) view.findViewById(R.id.immediately_change_succeed_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.immediately_change_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
