package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/27.
 * 个人中心   资产中心  幂钱包   我的账户余额 提现 提现成功
 */
public class MiWalletHomePageAccountBalanceWithdrawdepositSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_homepage_account_balance_withdraw_secceed , container , false);

        back = (ImageView) view.findViewById(R.id.mi_wallet_homepage_account_balance_withdraw_secceed_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_homepage_account_balance_withdraw_secceed_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
