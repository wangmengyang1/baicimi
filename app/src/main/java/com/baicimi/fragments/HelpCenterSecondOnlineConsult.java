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
 * 帮助中心，在线咨询
 */
public class HelpCenterSecondOnlineConsult extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView onlineServer;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.help_center_second_online_consult , container , false);
        back = (ImageView) view.findViewById(R.id.help_center_online_consult_fragment_back);
        back.setOnClickListener(this);
        onlineServer = (TextView) view.findViewById(R.id.help_center_online_consult_fragment_myorderform);
        onlineServer.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.help_center_online_consult_fragment_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.help_center_online_consult_fragment_myorderform:
                //在线客服
                startFragment(new OnlineConsultSecondOnlineServer());
                break;
        }
    }
}
