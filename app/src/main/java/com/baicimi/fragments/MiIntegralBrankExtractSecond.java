package com.baicimi.fragments;

import android.annotation.SuppressLint;
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
 * 幂积分银行 柜台 提取 二级页面
 */
public class MiIntegralBrankExtractSecond extends BaseFragment implements View.OnClickListener {

    private String lible;
    private View view;
    private TextView libleS;
    private ImageView back;

    private TextView affirm;

    @SuppressLint("ValidFragment")
    public MiIntegralBrankExtractSecond(String lible) {
        this.lible = lible;
    }

    public MiIntegralBrankExtractSecond() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_extract_second , container , false);

        back = (ImageView) view.findViewById(R.id.mi_integral_brank_extract_second_back);
        back.setOnClickListener(this);

        libleS = (TextView) view.findViewById(R.id.mi_integral_brank_extract_second_lible);
        libleS.setText(lible);

        affirm = (TextView) view.findViewById(R.id.mi_integral_brank_extract_second_affirm);
        affirm.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_integral_brank_extract_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_integral_brank_extract_second_lible:
                break;
            case R.id.mi_integral_brank_extract_second_affirm:
                //确认
                if (lible.equals("定期提取")){
                    startFragment(new MiIntegralBrankExtractSecondEoarb());
                }
                break;
        }
    }
}
