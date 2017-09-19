package com.baicimi.fragments;

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
 * Created by Administrator on 2017/9/19.
 * 提交退货申请成功页面
 */

public class AfterSaleServerApplyforFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private ImageView back;

    private TextView salesreturn;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.after_sale_server_applyfor_fragment , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.after_sale_server_applyfor_back);
        back.setOnClickListener(this);


        salesreturn = (TextView) view.findViewById(R.id.after_sale_server_applyfor_salesreturn_textview);
        salesreturn.setOnClickListener(this);

        return view;
    }

    @Override
    protected void initData() {

    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.after_sale_server_applyfor_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.after_sale_server_applyfor_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
            case R.id.after_sale_server_applyfor_salesreturn_textview:
                startFragment(new AfterSaleServerNumberSubmitFragment());//退货申请成功后提交订单号页面
                break;
        }
    }
}
