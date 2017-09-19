package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.PaymentAdencyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PaymentAdencyEntry;
import com.baicimi.view.AfterSaleServerDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 * 退货退款页
 */

public class AfterSaleServerRefundanFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;
    private Spinner spinner_02;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    private TextView submit_tv;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_refundandreturntheproduct_fragment , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.after_sale_server_refundandreturntheproduct_back);
        back.setOnClickListener(this);

        spinner_02 = (Spinner) view.findViewById(R.id.after_sale_server_refundandreturntheproduct_spinner);
        initSpinnerSecond(spinner_02);

        submit_tv = (TextView) view.findViewById(R.id.after_sale_server_refundandreturntheproduct_submit);
        submit_tv.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.after_sale_server_refundandreturntheproduct_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }


    //数字选择器进行适配
    private void initSpinnerSecond(Spinner spinner) {
        //数据
        data_list = new ArrayList<String>();
        data_list.add("请选择");
        data_list.add(" 重复购买 ");
        data_list.add("  我不想要了  ");
        data_list.add("  发货时间过长 ");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getContext(), R.layout.person_centered_spinner_item_textview, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.after_sale_server_refundandreturntheproduct_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.after_sale_server_refundandreturntheproduct_submit:
                //提交
                AfterSaleServerDialog afterSaleServerDialog = new AfterSaleServerDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive  , this);
                afterSaleServerDialog.show();
                break;
        }
    }
}
