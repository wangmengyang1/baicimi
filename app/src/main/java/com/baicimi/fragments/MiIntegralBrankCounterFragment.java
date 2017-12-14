package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/13.
 * 幂积分银行 柜台
 */
public class MiIntegralBrankCounterFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout investment , extract;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_counter_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.mi_integral_brank_counter_fragment_back);
        back.setOnClickListener(this);

        investment = (LinearLayout) view.findViewById(R.id.mi_integral_brank_counter_fragment_investment);
        investment.setOnClickListener(this);

        extract = (LinearLayout) view.findViewById(R.id.mi_integral_brank_counter_fragment_extract);
        extract.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_counter_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_counter_fragment_investment:
                //投资
                startFragment(new MiIntegralBrankInvestment());
                break;
            case R.id.mi_integral_brank_counter_fragment_extract:
                //提取
                startFragment(new MiIntegralBrankExtract());
                break;
        }
    }
}
