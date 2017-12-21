package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/12/20.
 * 个人中心首页 我的生活助手  幂额度首页 幂信用金
 */
public class MilimitFragmentEarnestMoney extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView dredgeearnestmoney;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_limit_fragment_earnest_money , container , false);

        dredgeearnestmoney = (TextView) view.findViewById(R.id.mi_limit_fragment_earnest_money_dredgeearnestmoney);
        dredgeearnestmoney.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_limit_fragment_earnest_money_dredgeearnestmoney:
                startFragment(new DredgeEarnestMoneyFragment());
                break;
        }
    }
}
