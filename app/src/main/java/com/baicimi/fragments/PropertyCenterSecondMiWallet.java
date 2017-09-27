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
 * Created by Administrator on 2017/9/27.
 * 个人中心我的资产幂钱包界面
 */
public class PropertyCenterSecondMiWallet extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView myCoupon;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.property_center_second_mi_wallet_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.property_center_second_miwallet_fragment_back);
        back.setOnClickListener(this);

        myCoupon = (TextView) view.findViewById(R.id.property_center_second_miwallet_fragment_mycoupon);
        myCoupon.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.property_center_second_miwallet_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.property_center_second_miwallet_fragment_mycoupon:
                //我的卡券
                startFragment(new MiWalletMyCouponFragment());
                break;
        }
    }
}
