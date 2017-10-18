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
 * Created by Administrator on 2017/10/18.
 * 个人中心我的订单，发货中页面，查看物流页面
 */
public class LookLogisticsFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private TextView logistics , courier;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.look_logistics_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.look_logistics_back);
        back.setOnClickListener(this);
        logistics = (TextView) view.findViewById(R.id.look_logistics_fragment_server_logistics);
        courier = (TextView) view.findViewById(R.id.look_logistics_fragment_evaluate_courier);

        logistics.setOnClickListener(this);
        courier.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.look_logistics_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.look_logistics_fragment_server_logistics:
                //物流客服界面首页
                startFragment(new LookLoginsticsServerLogisticsHomePage());
                break;
            case R.id.look_logistics_fragment_evaluate_courier:
                //评价快递员界面
                startFragment(new LookLoginsticsEvaluateCourier());
                break;
        }
    }
}
