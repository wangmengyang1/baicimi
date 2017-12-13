package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/13.
 * 幂积分银行 柜台 投资 活期理财
 */
public class MiIntegralBrankCurrentfinancial extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_current_finacial , container , false);
        back = (ImageView) view.findViewById(R.id.mi_integral_brank_current_finacial_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_current_finacial_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
