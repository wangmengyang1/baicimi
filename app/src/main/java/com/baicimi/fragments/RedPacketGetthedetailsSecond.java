package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.RobRedPacketDialog;

/**
 * Created by Administrator on 2017/11/22.
 * 分享红包页面
 */
public class RedPacketGetthedetailsSecond extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ImageView rob_redpacket;
    private int index;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.red_packet_getthe_details_second , container , false);
        back = (ImageView) view.findViewById(R.id.red_packet_getthe_details_second_back);
        back.setOnClickListener(this);

        rob_redpacket = (ImageView) view.findViewById(R.id.red_packet_getthe_details_second_rob_redpacket);
        rob_redpacket.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.red_packet_getthe_details_second_back:
                ((MainActivity)getActivity()).goBack();
                break;
            case R.id.red_packet_getthe_details_second_rob_redpacket:
                //抢红包
                if (index / 2 == 0){
                    RobRedPacketDialog robRedPacketDialog = new RobRedPacketDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , false , this);
                    robRedPacketDialog.show();
                }else {
                    RobRedPacketDialog robRedPacketDialog = new RobRedPacketDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive , true , this);
                    robRedPacketDialog.show();
                }
                index++;
                break;
        }
    }
}
