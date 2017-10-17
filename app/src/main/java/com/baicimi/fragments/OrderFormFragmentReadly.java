package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PaymentAdencyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PaymentAdencyEntry;
import com.baicimi.view.OrderFormFragmentClicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 * 我的订单准备中界面详情
 */

public class OrderFormFragmentReadly extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;
    private TextView cancle_tv;

    private String typeS = "无参数";
    private TextView type_tv;

    @SuppressLint("ValidFragment")
    public OrderFormFragmentReadly(String typeS) {
        this.typeS = typeS;
    }


    public OrderFormFragmentReadly() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_fragment_readly , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.payment_adency_fragment_readly_back);
        back.setOnClickListener(this);

        cancle_tv = (TextView) view.findViewById(R.id.order_form_fragment_readly_cancle);
        cancle_tv.setOnClickListener(this);

        type_tv = (TextView) view.findViewById(R.id.order_form_fragment_readly_type);
        if (typeS.equals("无参数")){

        }else {
            type_tv.setText(typeS);
        }

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.payment_adency_fragment_readly_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_adency_fragment_readly_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.order_form_fragment_readly_cancle:
                OrderFormFragmentClicle orderFormFragmentClicle = new OrderFormFragmentClicle(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                orderFormFragmentClicle.show();
                break;
        }
    }
}
