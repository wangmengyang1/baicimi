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
 * 已退货
 */

public class OrderFormFragmentSales extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;
    private TextView type_tv;
    private String typeS = "无参数";

    @SuppressLint("ValidFragment")
    public OrderFormFragmentSales(String typeS) {
        this.typeS = typeS;
    }

    public OrderFormFragmentSales() {
    }

    private TextView particulars , more;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_fragment_sales , container ,false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.payment_adency_fragment_sales_back);
        back.setOnClickListener(this);

        type_tv = (TextView) view.findViewById(R.id.payment_adency_fragment_sales_type);
        if (!typeS.equals("无参数")){
            type_tv.setText(typeS);
        }

        particulars = (TextView) view.findViewById(R.id.order_form_fragment_sales_particulars);
        more = (TextView) view.findViewById(R.id.order_form_fragment_sales_more);
        particulars.setOnClickListener(this);
        more.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.payment_adency_fragment_sales_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_adency_fragment_sales_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.order_form_fragment_sales_particulars:
               //查看详情
                startFragment(new AfterSaleServerApplyforFragment());//提交退货申请成功页面
                break;
            case R.id.order_form_fragment_sales_more:
                //已申请退货
                startFragment(new AfterSaleServerOrderFormSalesFragment());//退货申请页面
                break;
        }
    }
}
