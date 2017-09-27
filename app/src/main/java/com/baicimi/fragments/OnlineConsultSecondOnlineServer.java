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
 * 帮助中心，在线咨询，在线客服
 */
public class OnlineConsultSecondOnlineServer extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView millionPlan;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.online_consult_second_online_server , container , false);
        back = (ImageView) view.findViewById(R.id.online_sonsult_second_online_server_fragment_back);
        back.setOnClickListener(this);
        millionPlan = (TextView) view.findViewById(R.id.online_sonsult_second_online_server_fragment_myorderform);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.online_sonsult_second_online_server_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.online_sonsult_second_online_server_fragment_myorderform:
                //百万行动计划
                startFragment(new HelpCenterSecondHotQuestionMillionPlan());
                break;
        }
    }
}
