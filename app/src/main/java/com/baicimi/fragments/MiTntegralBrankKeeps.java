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
 * 幂积分银行 存储 整存零取
 */
public class MiTntegralBrankKeeps extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private String libles = "null";
    private TextView lible;

    private TextView succeed;

    @SuppressLint("ValidFragment")
    public MiTntegralBrankKeeps(String libles) {
        this.libles = libles;
    }


    public MiTntegralBrankKeeps() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_tntegral_brank_keeps , container , false);

        back = (ImageView) view.findViewById(R.id.mi_tntegral_brank_keeps_back);
        back.setOnClickListener(this);

        lible = (TextView) view.findViewById(R.id.mi_tntegral_brank_keeps_lible);
        if (!libles.equals("null")){
            lible.setText(libles);
        }

        succeed = (TextView) view.findViewById(R.id.mi_tntegral_brank_keeps_succeed);
        succeed.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_tntegral_brank_keeps_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_tntegral_brank_keeps_succeed:
                //存储成功
                startFragment(new MiTntegralBrankTimeDemandDepositSucceed());
                break;
        }
    }
}
