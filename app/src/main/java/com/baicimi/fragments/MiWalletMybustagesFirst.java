package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MyustagesAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MybustagesEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页  资产中心  幂钱包   我的分期
 */

public class MiWalletMybustagesFirst extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<MybustagesEntry> list = new ArrayList<>();
    private MyustagesAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_my_bustages_first , container , false);
        back = (ImageView) view.findViewById(R.id.mi_wallet_my_bustages_first_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.mi_wallet_my_bustages_first_libview);
        list.clear();
        list.add(new MybustagesEntry("订单编号：165436854321354" , "分期类型：消费分期" , "办理时间：2017-07-05" , "交易本金：4000.00元" , "总期数：24期" , "已通过" , "查看"));
        list.add(new MybustagesEntry("订单编号：165436854321354" , "分期类型：消费分期" , "办理时间：2017-07-05" , "交易本金：4000.00元" , "总期数：24期" , "未通过" , "重新申请"));
        list.add(new MybustagesEntry("订单编号：165436854321354" , "分期类型：消费分期" , "办理时间：2017-07-05" , "交易本金：4000.00元" , "总期数：24期" , "审核中" , "查看"));
        adapter = new MyustagesAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    @Override
    protected void initData() {

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MyustagesAdapter listAdapter = (MyustagesAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            totalHeight += 30;//manger上下高度和
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_my_bustages_first_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
