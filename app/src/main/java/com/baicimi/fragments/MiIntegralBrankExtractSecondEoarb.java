package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.ExtractSecondEoarbDialog;

/**
 * Created by Administrator on 2017/12/14.
 * 幂积分银行 柜台 提取 二级页面 定期提取
 */
public class MiIntegralBrankExtractSecondEoarb extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView  extractfirst , extractsecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_extract_second_eoarb , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_extract_second_eoarb_back);
        back.setOnClickListener(this);

        extractfirst = (TextView) view.findViewById(R.id.mi_integral_brank_extract_second_eoarb_extractfirst);
        extractfirst.setOnClickListener(this);

        extractsecond = (TextView) view.findViewById(R.id.mi_integral_brank_extract_second_eoarb_extractsecond);
        extractsecond.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_extract_second_eoarb_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_extract_second_eoarb_extractfirst:
                ExtractSecondEoarbDialog extractSecondEoarbDialog =
                        new ExtractSecondEoarbDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , this);
                extractSecondEoarbDialog.show();
                break;
            case R.id.mi_integral_brank_extract_second_eoarb_extractsecond:
                ExtractSecondEoarbDialog extractSecondEoarbDialogsecond =
                        new ExtractSecondEoarbDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , this);
                extractSecondEoarbDialogsecond.show();
                break;
        }
    }
}
