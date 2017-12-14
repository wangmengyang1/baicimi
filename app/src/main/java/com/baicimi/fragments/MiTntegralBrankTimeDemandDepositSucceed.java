package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/14.
 * 幂积分银行 存储  存储成功
 */
public class MiTntegralBrankTimeDemandDepositSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_tntegral_brank_time_demand_deposit_succeed , container , false);

        back = (ImageView) view.findViewById(R.id.mi_tntegral_brank_time_demand_deposit_succeed_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_tntegral_brank_time_demand_deposit_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
