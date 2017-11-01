package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MiFriendsJurisdictionDialog;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页  资产中心  幂钱包  我的卡券  限量优惠券
 */
public class MiWalletDiscountCouponFirstItemSecond extends BaseFragment implements View.OnClickListener {

    private View view;

    private TextView particulars;
    private LinearLayout layout_06;
    private boolean isLyoutVisible;

    private TextView giventoone;//转赠

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_discount_coupon_firstitme_second , container , false);

        particulars = (TextView) view.findViewById(R.id.miwalldt_discount_coupon_firstitme_second_particulars);
        layout_06 = (LinearLayout) view.findViewById(R.id.miwalldt_discount_coupon_firstitme_second_layout_06);
        particulars.setOnClickListener(this);
        layout_06.setOnClickListener(this);

        giventoone = (TextView) view.findViewById(R.id.miwalldt_discount_coupon_firstitme_second_giventoone);
        giventoone.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.miwalldt_discount_coupon_firstitme_second_particulars:
                //了解详情
                if (!isLyoutVisible){
                    layout_06.setVisibility(View.VISIBLE);
                }else {
                    layout_06.setVisibility(View.GONE);
                }

                isLyoutVisible = !isLyoutVisible;
                break;
            case R.id.miwalldt_discount_coupon_firstitme_second_giventoone:
                //转赠
                MiFriendsJurisdictionDialog miFriendsJurisdictionDialog = new MiFriendsJurisdictionDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , "转赠给我的幂友");
                miFriendsJurisdictionDialog.show();
                break;

        }
    }
}
