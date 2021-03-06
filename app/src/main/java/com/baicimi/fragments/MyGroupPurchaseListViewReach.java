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
 * Created by Administrator on 2017/10/11.
 * 团购页面，已完成团购人数要求页面
 */
public class MyGroupPurchaseListViewReach extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;
    private TextView particulars;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_group_purchase_listview_reach , container , false);
        back = (ImageView) view.findViewById(R.id.my_group_purchase_listview_reach_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        //查看详情
        particulars = (TextView) view.findViewById(R.id.my_group_purchase_listview_reach_particulars);
        particulars.setOnClickListener(this);
        return view;
    }



    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.my_group_purchase_listview_reach_listview);
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
            case R.id.my_group_purchase_listview_reach_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.my_group_purchase_listview_reach_particulars:
                startFragment(new MyGroupPurchaseReachParticulars());//我的团购已成团详情
                break;
        }
    }
}
