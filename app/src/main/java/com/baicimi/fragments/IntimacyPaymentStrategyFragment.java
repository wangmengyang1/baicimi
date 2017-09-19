package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/16.
 */

public class IntimacyPaymentStrategyFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.intimacy_payment_strategy_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.teacher_status_login_title);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.teacher_status_login_title:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
