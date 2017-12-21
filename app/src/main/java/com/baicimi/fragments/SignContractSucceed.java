package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.SignContractSucceedDialog;

/**
 * Created by Administrator on 2017/12/21.
 * 个人中心首页 我的生活助手  幂额度首页 身份验证 签约成功
 */
public class SignContractSucceed extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView get;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.sign_contract_succeed , container , false);

        back = (ImageView) view.findViewById(R.id.sign_contract_succeed_back);
        back.setOnClickListener(this);

        get = (TextView) view.findViewById(R.id.sign_contract_succeed_get);
        get.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_contract_succeed_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.sign_contract_succeed_get:
                //领取成功
                SignContractSucceedDialog signContractSucceedDialog = new SignContractSucceedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                signContractSucceedDialog.show();
                break;
        }
    }
}
