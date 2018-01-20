package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/20.
 * 个人中心，设置，个人信息界面 基本资料 昵称
 */
public class SettingUserMessageBasicDateNickName extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_user_message_basic_date_nike_name , container , false);

        back = (ImageView) view.findViewById(R.id.setting_user_message_basic_date_nike_name_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_user_message_basic_date_nike_name_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
