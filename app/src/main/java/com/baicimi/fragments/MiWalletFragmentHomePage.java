package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/1.
 * 个人中心首页  资产中心  幂钱包
 */

public class MiWalletFragmentHomePage extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView record , myorderform ,transferaccounts , code , mybystages , discountcoupon;
    private int indext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_fragment_homepage , container , false);

        record = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_record);
        record.setOnClickListener(this);
        myorderform = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_myorderform);
        myorderform.setOnClickListener(this);

        transferaccounts = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_transferaccounts);
        transferaccounts.setOnClickListener(this);

        code = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_code);
        code.setOnClickListener(this);

        mybystages = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_mybystages);
        mybystages.setOnClickListener(this);

        discountcoupon = (TextView) view.findViewById(R.id.mi_wallet_fragment_homepage_discountcoupon);
        discountcoupon.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_fragment_homepage_record:
                //我的收支记录
                startFragment(new MiWalletHomePageRecord());
                break;
            case R.id.mi_wallet_fragment_homepage_myorderform:
                //我的账户余额
                startFragment(new MiWalletHomePageAccountBalance());
                break;
            case R.id.mi_wallet_fragment_homepage_transferaccounts:
                //转账付款
                startFragment(new MiWalletHomePageTransFeraccounts());
                break;
            case R.id.mi_wallet_fragment_homepage_code:
                startFragment(new MiWalldtMyCodeFragment(),null);//我的积分（新）
                break;
            case R.id.mi_wallet_fragment_homepage_mybystages:
                //我的分期
                startFragment(new MiWalletMybustagesFirst());
                break;
            case R.id.mi_wallet_fragment_homepage_discountcoupon:
                //我的卡券
                if (indext % 3 == 0){
                    startFragment(new MiWalletDiscountCouponFirst("团购优惠券"));
                }else if (indext % 3 == 1){
                    startFragment(new MiWalletDiscountCouponFirst("限量优惠券"));
                }else if (indext % 3 == 2){
                    startFragment(new MiWalletDiscountCouponFirst("政府采购优惠券"));
                }
                indext++;
                break;
        }
    }
}
