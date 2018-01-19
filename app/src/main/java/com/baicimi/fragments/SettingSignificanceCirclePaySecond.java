package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/18.
 * 个人中心设置界面 账户安全 修改支付密码 密码修改成功
 */
public class SettingSignificanceCirclePaySecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.settting_significance_circle_pay_second , container , false);
        back = (ImageView) view.findViewById(R.id.settting_significance_circle_pay_second_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settting_significance_circle_pay_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
