package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/18.
 * 个人中心设置界面 账户安全
 */
public class SettingSignificanceHomeCircle extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout passwordLayout , phonePaslayout , payPswLayout;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_significance_home_circle , container , false);

        back = (ImageView) view.findViewById(R.id.setting_significance_home_circle_back);
        back.setOnClickListener(this);

        passwordLayout = (LinearLayout) view.findViewById(R.id.setting_significance_home_circle_password);
        passwordLayout.setOnClickListener(this);
        phonePaslayout = (LinearLayout) view.findViewById(R.id.setting_significance_home_circle_phonepassword);
        phonePaslayout.setOnClickListener(this);
        payPswLayout = (LinearLayout) view.findViewById(R.id.setting_significance_home_circle_paypassword);
        payPswLayout.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_significance_home_circle_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_significance_home_circle_password:
                //修改登录密码
                startFragment(new SettingSignificanceCircle());
                break;
            case R.id.setting_significance_home_circle_phonepassword:
                //手机认证
                break;
            case R.id.setting_significance_home_circle_paypassword:
                //修改支付密码
                startFragment(new SettingSignificanceCirclePay());
                break;
        }
    }
}
