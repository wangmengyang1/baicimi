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
 * Created by Administrator on 2017/11/28.
 * 个人中心  密码找回 验证身份手机号验证+证件验证 新密码修改
 */
public class UserNewPasswordModification extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmass;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_new_password_modification , container , false);

        back = (ImageView) view.findViewById(R.id.user_new_password_modification_back);
        back.setOnClickListener(this);

        dissmass = (TextView) view.findViewById(R.id.user_new_password_modification_dissmess);
        dissmass.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_new_password_modification_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_new_password_modification_dissmess:
                //个人中心  密码找回 验证身份手机号验证+证件验证 新密码修改完成
                startFragment(new UserNewPasswordModificationSucceed());
                break;
        }
    }
}
