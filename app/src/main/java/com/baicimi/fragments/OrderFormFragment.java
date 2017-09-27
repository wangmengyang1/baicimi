package com.baicimi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.activitys.ShowFragmentActivity;
import com.baicimi.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/18.
 * 我的订单首页
 */

public class OrderFormFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ImageView scanning;
    private TextView paymentagency;
    private TextView readly;
    private TextView deliver;
    private TextView dealsucceed;
    private TextView revocation;
    private TextView sales;
    private TextView refundsucceed;
    private TextView myorderform;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_frgment , container , false);

        init();

        return view;
    }

    private void init() {
        back = (ImageView) view.findViewById(R.id.order_form_fragment_back);
        back.setOnClickListener(this);

        scanning = (ImageView) view.findViewById(R.id.order_form_fragment_scanning);
        scanning.setOnClickListener(this);

        paymentagency = (TextView) view.findViewById(R.id.order_form_fragment_paymentagency);
        paymentagency.setOnClickListener(this);

        readly = (TextView) view.findViewById(R.id.order_form_fragment_readly);
        readly.setOnClickListener(this);

        deliver = (TextView) view.findViewById(R.id.order_form_fragment_deliver);
        deliver.setOnClickListener(this);

        dealsucceed = (TextView) view.findViewById(R.id.order_form_fragment_dealsucceed);
        dealsucceed.setOnClickListener(this);

        revocation = (TextView) view.findViewById(R.id.order_form_fragment_revocation);
        revocation.setOnClickListener(this);

        sales = (TextView) view.findViewById(R.id.order_form_fragment_sales);
        sales.setOnClickListener(this);

        refundsucceed = (TextView) view.findViewById(R.id.order_form_fragment_refundsucceed);
        refundsucceed.setOnClickListener(this);

        myorderform = (TextView) view.findViewById(R.id.order_form_fragment_myorderform);
        myorderform.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.order_form_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.order_form_fragment_scanning:
                //二维码扫描
                startActivity(new Intent(getActivity(),
                        ShowFragmentActivity.class));
                break;
            case R.id.order_form_fragment_paymentagency:
                startFragment(new MyOrderFormFragmentParticulars("待付款"));//待付款
                break;
            case R.id.order_form_fragment_readly:
                startFragment(new MyOrderFormFragmentParticulars("准备中"));//准备中
                break;
            case R.id.order_form_fragment_deliver:
                startFragment(new MyOrderFormFragmentParticulars("发货中"));//发货中
                break;
            case R.id.order_form_fragment_dealsucceed:
                startFragment(new MyOrderFormFragmentParticulars("交易成功"));//发货中
                break;
            case R.id.order_form_fragment_revocation:
                startFragment(new MyOrderFormFragmentParticulars("已撤销"));//发货中
                break;
            case R.id.order_form_fragment_sales:
                startFragment(new MyOrderFormFragmentParticulars("已退货"));//发货中
                break;
            case R.id.order_form_fragment_refundsucceed:
                startFragment(new MyOrderFormFragmentParticulars("退款成功"));//发货中
                break;
            case R.id.order_form_fragment_myorderform:
                startFragment(new MyOrderFormFragmentParticulars("我的订单"));//我的订单
                break;
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理扫描结果（在界面上显示）
        if (resultCode == -1) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
//            resultTextView.setText(scanResult);
            Toast.makeText(getContext() , scanResult , Toast.LENGTH_SHORT).show();
        }
    }

}
