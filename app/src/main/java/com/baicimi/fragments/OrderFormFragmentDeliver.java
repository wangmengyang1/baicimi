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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 * 发货中
 */

public class OrderFormFragmentDeliver extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;


    private TextView aftersale;

    private String typeS = "无参数";
    private TextView type_tv;

    private TextView looklogistics;

    private int index;


    @SuppressLint("ValidFragment")
    public OrderFormFragmentDeliver(String typeS) {
        this.typeS = typeS;
    }

    public OrderFormFragmentDeliver() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_fragment_deliver , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.payment_adency_fragment_deliver_back);
        back.setOnClickListener(this);

        aftersale = (TextView) view.findViewById(R.id.ordre_form_fragment_deliver_aftersale);
        aftersale.setOnClickListener(this);

        type_tv = (TextView) view.findViewById(R.id.order_form_fragment_deliver_type);
        if (typeS.equals("无参数")){

        }else {
            type_tv.setText(typeS);
        }

        looklogistics = (TextView) view.findViewById(R.id.order_form_fragment_deliver_looklogistics);
        looklogistics.setOnClickListener(this);

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.payment_adency_fragment_deliver_listview);
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
            case R.id.payment_adency_fragment_deliver_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.ordre_form_fragment_deliver_aftersale:
                //退货申请页面
                startFragment(new AfterSaleServerFragment());
                break;
            case R.id.order_form_fragment_deliver_looklogistics:
                //查看物流
                if (index % 4  == 0){
                    startFragment(new LookLogisticsFragment());//01
                }else if (index % 4  == 1){
                    startFragment(new LookLogisticsFragmentSecond());//02
                }else if (index % 4  == 2){
                    startFragment(new LookLogisticsFragmentThread());//03
                }else if (index % 4  == 3){
                    startFragment(new LookLogisticsFragmentFour());//04
                }

                index++;
                break;
        }
    }
}
