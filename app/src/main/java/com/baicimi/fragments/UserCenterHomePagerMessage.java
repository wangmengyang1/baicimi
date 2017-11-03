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
 * Created by Administrator on 2017/11/2.
 * 个人中心  消息中心首页
 */
public class UserCenterHomePagerMessage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView messageCenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_homepage_message , container , false);

        back = (ImageView) view.findViewById(R.id.usecenter_homepage_message_back);
        back.setOnClickListener(this);

        messageCenter = (TextView) view.findViewById(R.id.usecenter_homepage_message_messagecenter);
        messageCenter.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usecenter_homepage_message_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.usecenter_homepage_message_messagecenter:
                //消息中心
                startFragment(new UserCenterMessageCenter());
                break;
        }
    }
}
