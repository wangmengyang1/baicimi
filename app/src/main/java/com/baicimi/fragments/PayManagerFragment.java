package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.ModificationPayPasswordDialog;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心  资产中心   支付管理
 */
public class PayManagerFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView pay_password;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.pay_nameger_fragment , container , false);

        back = (ImageView) view.findViewById(R.id.pay_nameger_fragment_back);
        back.setOnClickListener(this);

        pay_password = (TextView) view.findViewById(R.id.pay_nameger_fragment_pay_password);
        pay_password.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pay_nameger_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.pay_nameger_fragment_pay_password:
                //修改支付 密码
                ModificationPayPasswordDialog paySucceedDialog = new ModificationPayPasswordDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                paySucceedDialog.show();
                break;
        }
    }
}
