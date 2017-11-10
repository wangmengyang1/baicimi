package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.MyBustagesRepaymentDialog;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页资产中心  幂钱包  我的分期
 */
public class MiWalletFragmentMybustages extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView repayment;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_fragment_my_bustages , container , false);
        back = (ImageView) view.findViewById(R.id.mi_wallet_fragment_my_bustages_back);
        back.setOnClickListener(this);

        repayment = (TextView) view.findViewById(R.id.mi_wallet_fragment_my_bustages_repayment);
        repayment.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_fragment_my_bustages_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.mi_wallet_fragment_my_bustages_repayment:
                //去还款
                MyBustagesRepaymentDialog myBustagesRepaymentDialog = new MyBustagesRepaymentDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                myBustagesRepaymentDialog.show();
                break;
        }
    }
}
