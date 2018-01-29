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
 * 个人中心，设置，账号认证
 */
public class SettingAccountAuthentication extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView distribution;
    private TextView parttimeuser;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_account_authentication , container , false);
        back = (ImageView) view.findViewById(R.id.setting_account_authentication_fragment_back);
        back.setOnClickListener(this);

        distribution = (TextView) view.findViewById(R.id.settting_account_authentication_distribution);
        distribution.setOnClickListener(this);

        parttimeuser = (TextView) view.findViewById(R.id.settting_account_authentication_parttimeuser);
        parttimeuser.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_account_authentication_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.settting_account_authentication_distribution:
                //分销批发注册入口
                startFragment(new BnnStaffRegisterOptionFragment(),null);
                break;
            case R.id.settting_account_authentication_parttimeuser:
                //兼职员工入口
                startFragment(new UserPartTimeReisterFragment(),null);
                break;
        }
    }
}
