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
 * 待付款
 */

@SuppressLint("ValidFragment")
public class PaymentAdencyFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;

    private TextView pay  , type_textview;//支付

    private String type = "";

    public PaymentAdencyFragment(String type) {
        this.type = type;
    }

    public PaymentAdencyFragment() {
    }

    private int index;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.payment_adency_fragment , container , false);
        back = (ImageView) view.findViewById(R.id.payment_adency_fragment_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();



        type_textview = (TextView) view.findViewById(R.id.payment_adency_fragment_type);
        if (type.equals("政府采购订单")){
            type_textview.setText("政府采购订单");
            pay = (TextView) view.findViewById(R.id.payment_adency_fragment_pay);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //关于政府采购的支付跳转
                    startFragment(new PaymentAdencyFragmentGovernment(index));
                    index++;
                }
            });
        }else {
            pay = (TextView) view.findViewById(R.id.payment_adency_fragment_pay);
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //团购订单采购支付页面
                    startFragment(new PayMentSucceedFragment());
                }
            });
        }

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.payment_adency_fragment_listview);
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
            case R.id.payment_adency_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
//            case R.id.payment_adency_fragment_pay:
//                startFragment(new PayMentSucceedFragment());
//                break;
        }
    }
}
