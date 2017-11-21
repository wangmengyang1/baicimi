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
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页  提问页面
 */
public class UserCenterHelpCenterMessage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView dissmess;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_help_center_message , container , false);

        back = (ImageView) view.findViewById(R.id.user_center_help_center_message_back);
        back.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.user_center_help_center_message_dissmass);
        dissmess.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_help_center_message_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.user_center_help_center_message_dissmass:
                //个人中心，帮助中心首页  提问页面  提交问题
                startFragment(new UserCenterHelpCenterMessageSecond());
                break;
        }
    }
}
