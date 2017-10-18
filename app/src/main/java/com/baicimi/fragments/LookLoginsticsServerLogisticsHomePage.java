package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/10/18.
 * 个人中心，我的订单  物流详情  物流客服首页
 */
public class LookLoginsticsServerLogisticsHomePage extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private LinearLayout layout;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_login_seticsserver_logistics_homepage , container , false);
        back = (ImageView) view.findViewById(R.id.look_logistics_server_logisticsf_homepage_back);
        back.setOnClickListener(this);

        layout = (LinearLayout) view.findViewById(R.id.look_login_seicsserver_logistics_homepage_layout);
        layout.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_server_logisticsf_homepage_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.look_login_seicsserver_logistics_homepage_layout:
                //跳转到物流客服界面
                startFragment(new LookLoginsticsServerLogistics());
                break;
        }
    }
}
