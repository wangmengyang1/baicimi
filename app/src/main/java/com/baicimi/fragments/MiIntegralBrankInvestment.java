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
 * Created by Administrator on 2017/12/13.
 * 幂积分银行 柜台 投资
 */
public class MiIntegralBrankInvestment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView currentfinancial;//活期理财
    private TextView fmparb;//定期理财
    private TextView shorttermfinancing;//短期理财

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_investment , container , false);
        back = (ImageView) view.findViewById(R.id.mi_integral_brank_investment_back);
        back.setOnClickListener(this);

        currentfinancial = (TextView) view.findViewById(R.id.mi_integral_brank_invertment_currentfinancial);
        fmparb = (TextView) view.findViewById(R.id.mi_integral_brank_invertment_fmparb);
        shorttermfinancing = (TextView) view.findViewById(R.id.mi_integral_brank_invertment_shorttermfinancing);

        currentfinancial.setOnClickListener(this);
        fmparb.setOnClickListener(this);
        shorttermfinancing.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_investment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_invertment_currentfinancial:
                //活期理财
                startFragment(new MiIntegralBrankCurrentfinancial());
                break;
            case R.id.mi_integral_brank_invertment_fmparb:
                //定期理财
                startFragment(new MiIntegralBrankFmparb());
                break;
            case R.id.mi_integral_brank_invertment_shorttermfinancing:
                //短期理财
                startFragment(new MiIntegralBrankShorttermfinancing());
                break;
        }
    }
}
