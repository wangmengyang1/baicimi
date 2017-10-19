package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
 * 我的订单交易成功页面
 */

public class OrderFormFragmentDealsucced extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;

    private TextView evaluate;

    private String typeS = "无参数";
    private TextView type_tv , pay_way;
    private LinearLayout layout_02 , layout_03 , layout_04;

    @SuppressLint("ValidFragment")
    public OrderFormFragmentDealsucced(String typeS) {
        this.typeS = typeS;
    }

    public OrderFormFragmentDealsucced() {
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_fragment_dealsucced , container , false);
        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.payment_adency_fragment_dealsucced_back);
        back.setOnClickListener(this);

        evaluate = (TextView) view.findViewById(R.id.order_form_fragment_dealsucceed_evaluate);
        evaluate.setOnClickListener(this);

        type_tv = (TextView) view.findViewById(R.id.order_form_fragment_dealsucceed_type);
        if (!typeS.equals("无参数")){
            type_tv.setText(typeS);
            if (typeS.equals("分期订单")){
                pay_way = (TextView) view.findViewById(R.id.order_form_fragment_dealsucceed_pay_way);
                pay_way.setText("分期订单");
                layout_02 = (LinearLayout) view.findViewById(R.id.order_form_fragment_dealsucceed_layout_02);
                layout_02.setVisibility(View.VISIBLE);
            }else if (typeS.equals("我的预售订单")){
                layout_03 = (LinearLayout) view.findViewById(R.id.order_form_fragment_dealsucceed_layout_03);
                layout_03.setVisibility(View.VISIBLE);
                layout_04 = (LinearLayout) view.findViewById(R.id.order_form_fragment_dealsucceed_layout_04);
                layout_04.setVisibility(View.VISIBLE);
            }
        }

        return view;
    }

    @Override
    protected void initData() {

    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.payment_adency_fragment_dealsucced_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_adency_fragment_dealsucced_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.order_form_fragment_dealsucceed_evaluate:
                //评价
                startFragment(new OrderFormDealsucceedEvaluate());
                break;
        }
    }
}
