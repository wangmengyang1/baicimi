package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PaymentAdencyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PaymentAdencyEntry;
import com.baicimi.view.OrderFormDealsucceedDissmessDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 * 交易成功后评价页面
 */
public class OrderFormDealsucceedEvaluate extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;

    private CheckBox firstCheck , secondCheck ,threadCheck;

    private TextView dissmess;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.order_form_dealsucceed_evaluate , container , false);

        back = (ImageView) view.findViewById(R.id.order_form_dealsucceed_evaluate_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        firstCheck = (CheckBox) view.findViewById(R.id.order_form_dealsucceed_evaluate_checkbox_first);
        secondCheck = (CheckBox) view.findViewById(R.id.order_form_dealsucceed_evaluate_checkbox_second);
        threadCheck = (CheckBox) view.findViewById(R.id.order_form_dealsucceed_evaluate_checkbox_thread);

        firstCheck.setOnClickListener(this);
        secondCheck.setOnClickListener(this);
        threadCheck.setOnClickListener(this);

        dissmess = (TextView) view.findViewById(R.id.order_form_dealsucceed_evaluate_dissmess);
        dissmess.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.order_from_dealsucced_evaluate_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.order_form_dealsucceed_evaluate_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.order_form_dealsucceed_evaluate_checkbox_first:
                firstCheck.setChecked(true);
                secondCheck.setChecked(false);
                threadCheck.setChecked(false);
                break;
            case R.id.order_form_dealsucceed_evaluate_checkbox_second:
                firstCheck.setChecked(false);
                secondCheck.setChecked(true);
                threadCheck.setChecked(false);
                break;
            case R.id.order_form_dealsucceed_evaluate_checkbox_thread:
                firstCheck.setChecked(false);
                secondCheck.setChecked(false);
                threadCheck.setChecked(true);
                break;

            case R.id.order_form_dealsucceed_evaluate_dissmess:
                //提交
                OrderFormDealsucceedDissmessDialog orderFormDealsucceedDissmessDialog = new OrderFormDealsucceedDissmessDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                orderFormDealsucceedDissmessDialog.show();
                break;
        }
    }
}
