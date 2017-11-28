package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.TimeButton;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心  密码找回 验证身份手机号验证+证件验证
 */
public class UserIdentityAuthenticationSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private TimeButton timeButton;
    private ImageView back;
    private LinearLayout layoutFirst , layoutSecond;
    private TextView dissmessFirst , dissmessSecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_identity_authentication_second , container , false);

        timeButton = (TimeButton) view.findViewById(R.id.user_identity_authentication_second_find_password);
        timeButton.setTextAfter("秒后重新获取").setTextBefore("点击获取验证码").setLenght(60 * 1000);

        back = (ImageView) view.findViewById(R.id.user_identity_authentication_second_back);
        back.setOnClickListener(this);

        layoutFirst = (LinearLayout) view.findViewById(R.id.user_identity_authentication_second_layout_first);
        layoutSecond = (LinearLayout) view.findViewById(R.id.user_identity_authentication_second_layout_second);
        dissmessFirst = (TextView) view.findViewById(R.id.user_identity_authentication_second_dissmess);
        dissmessSecond = (TextView) view.findViewById(R.id.user_identity_authentication_second_dissmesssecond);

        layoutFirst.setVisibility(View.VISIBLE);
        layoutSecond.setVisibility(View.GONE);

        dissmessFirst.setOnClickListener(this);
        dissmessSecond.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_identity_authentication_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_identity_authentication_second_dissmess:
                layoutFirst.setVisibility(View.GONE);
                layoutSecond.setVisibility(View.VISIBLE);
                break;
            case R.id.user_identity_authentication_second_dissmesssecond:
                //个人中心  密码找回 验证身份手机号验证+证件验证 新密码修改
                startFragment(new UserNewPasswordModification());
                break;
        }
    }
}
