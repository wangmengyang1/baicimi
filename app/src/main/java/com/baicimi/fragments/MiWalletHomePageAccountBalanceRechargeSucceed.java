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
 * Created by Administrator on 2017/12/27.
 * 个人中心   资产中心  幂钱包   我的账户余额 充值 充值成功
 */
public class MiWalletHomePageAccountBalanceRechargeSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView cancle;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_homepage_account_balance_recahrge_succeed , container , false);

        back = (ImageView) view.findViewById(R.id.mi_wallet_homepage_account_balance_recahrge_succeed_back);
        cancle = (TextView) view.findViewById(R.id.mi_wallet_homepage_account_balance_recahrge_succeed_cancle);

        back.setOnClickListener(this);
        cancle.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_homepage_account_balance_recahrge_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.mi_wallet_homepage_account_balance_recahrge_succeed_cancle:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
