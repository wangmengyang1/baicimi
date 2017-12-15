package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/15.
 * 幂积分银行 话费充值
 */
public class MiIntegralBrankPrepaidRefill extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_prepaid_refill , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_prepaid_refill_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_prepaid_refill_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
