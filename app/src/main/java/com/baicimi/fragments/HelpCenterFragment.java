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
 * 个人中心帮助中心
 */
public class HelpCenterFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView selfHelpServer , hotQuestion , online_consult;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.help_center_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.help_center_fragment_back);
        back.setOnClickListener(this);

        selfHelpServer = (TextView) view.findViewById(R.id.help_center_fragment_myorderform);
        selfHelpServer.setOnClickListener(this);

        hotQuestion = (TextView) view.findViewById(R.id.help_center_fragment_hot_question);
        hotQuestion.setOnClickListener(this);

        online_consult = (TextView) view.findViewById(R.id.help_center_fragment_online_consult);
        online_consult.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.help_center_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.help_center_fragment_myorderform:
                startFragment(new HelpCenterSecondSelfServer());//自助服务
                break;
            case R.id.help_center_fragment_hot_question:
                startFragment(new HelpCenterSecondHotQuestion());//热点问题
                break;
            case R.id.help_center_fragment_online_consult:
                startFragment(new HelpCenterSecondOnlineConsult());//在线咨询
                break;
        }
    }
}
