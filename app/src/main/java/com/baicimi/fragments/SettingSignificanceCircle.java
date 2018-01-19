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
 * Created by Administrator on 2018/1/18.
 *  个人中心设置界面 账户安全
 */
public class SettingSignificanceCircle extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView submit;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_significance_sircle , container , false);

        back = (ImageView) view.findViewById(R.id.setting_significance_sircle_back);
        back.setOnClickListener(this);

        submit = (TextView) view.findViewById(R.id.setting_significance_sircle_submit);
        submit.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_significance_sircle_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_significance_sircle_submit:
                //修改登录密码
                startFragment(new SettingSignificanceCircleModificationPsw());
                break;
        }
    }
}
