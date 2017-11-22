package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/22.
 * 积分红包发放页面
 */
public class UserCneterRedPacketSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_red_packet_second , container , false);

        back = (ImageView) view.findViewById(R.id.user_center_red_packet_second_back);
        back.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_red_packet_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
