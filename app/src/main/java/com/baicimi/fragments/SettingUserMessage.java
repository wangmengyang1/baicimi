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
 * 个人中心，设置，个人信息界面
 */
public class SettingUserMessage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private TextView myorderform , moreDate;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.setting_user_message , container , false);
        back = (ImageView) view.findViewById(R.id.setting_user_message_fragment_back);
        back.setOnClickListener(this);

        myorderform = (TextView) view.findViewById(R.id.setting_user_message_myorderform);
        moreDate = (TextView) view.findViewById(R.id.setting_user_message_moredate);

        myorderform.setOnClickListener(this);
        moreDate.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_user_message_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.setting_user_message_myorderform:
                //基本资料
                startFragment(new SettingUserMessageBasicDate());
                break;
            case R.id.setting_user_message_moredate:
                //更多资料
                startFragment(new SettingUserMessageMoreDate());
                break;
        }
    }
}
