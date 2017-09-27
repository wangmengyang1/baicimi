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
 * 个人中心设置界面
 */
public class UserCenterHomePagerSetting extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView user_message ,account_authentication ,privacy_seting ,significance_moment;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_setting , container , false);

        back = (ImageView) view.findViewById(R.id.user_center_homepager_setting_fragment_back);
        back.setOnClickListener(this);

        user_message = (TextView) view.findViewById(R.id.user_center_homepager_setting_fragment_user_message);
        user_message.setOnClickListener(this);
        account_authentication = (TextView) view.findViewById(R.id.user_center_homepager_setting_fragment_account_authentication);
        account_authentication.setOnClickListener(this);
        privacy_seting = (TextView) view.findViewById(R.id.user_center_homepager_setting_fragment_privacy_seting);
        privacy_seting.setOnClickListener(this);
        significance_moment = (TextView) view.findViewById(R.id.user_center_homepager_setting_fragment_significance_moment);
        significance_moment.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_homepager_setting_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_center_homepager_setting_fragment_user_message:
                //个人信息
                startFragment(new SettingUserMessage());
                break;
            case R.id.user_center_homepager_setting_fragment_account_authentication:
                //账号认证
                startFragment(new SettingAccountAuthentication());
                break;
            case R.id.user_center_homepager_setting_fragment_privacy_seting:
                //隐私设置
                startFragment(new SettingPrivacySetting());
                break;
            case R.id.user_center_homepager_setting_fragment_significance_moment:
                //人生重要时刻
                startFragment(new SettingSignificanceMoment());
                break;
        }
    }
}
