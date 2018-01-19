package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/17.
 * 个人中心设置界面 发票设置
 */
public class SettingSignificanceInvoiceSetting extends BaseFragment implements View.OnClickListener {

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.setting_signnficance_invoice_setting , container , false);

        back = (ImageView) view.findViewById(R.id.setting_signnficance_invoice_setting_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_signnficance_invoice_setting_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
