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
 * Created by Administrator on 2017/12/14.
 * 幂积分银行 柜台 提取
 */
public class MiIntegralBrankExtract extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView currentextraction , eoarb;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_extract , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_extract_back);
        back.setOnClickListener(this);

        currentextraction = (TextView) view.findViewById(R.id.mi_integral_brank_extract_currentextraction);
        currentextraction.setOnClickListener(this);

        eoarb = (TextView) view.findViewById(R.id.mi_integral_brank_extract_eoarb);
        eoarb.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_extract_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_extract_currentextraction:
                //活期提取
                startFragment(new MiIntegralBrankExtractSecond("活期提取"));
                break;
            case R.id.mi_integral_brank_extract_eoarb:
                //定期提取
                startFragment(new MiIntegralBrankExtractSecond("定期提取"));
                break;
        }
    }
}
