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
 * 幂积分银行 存储 整存整取
 */
public class MiTntegralBrankWeaww extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView succeed;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_tnetgral_brank_weaww , container , false);

        back = (ImageView) view.findViewById(R.id.mi_tnetgral_brank_weaww_back);
        back.setOnClickListener(this);

        succeed = (TextView) view.findViewById(R.id.mi_tnetgral_brank_weaww_succeed);
        succeed.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_tnetgral_brank_weaww_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_tnetgral_brank_weaww_succeed:
                //存储成功
                startFragment(new MiTntegralBrankTimeDemandDepositSucceed());
                break;
        }
    }
}
