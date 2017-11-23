package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.LogisticsEvaluateFragmentAdapter;
import com.baicimi.adapter.RreasureEvaluateFragmentAdapte;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理 物流评价首页 我的评价页面
 */
public class LogisticsEvaluateFragmentFirst extends BaseFragment implements View.OnClickListener {

    private View view;
    private LinearLayout home_layout_01 , home_layout_02 , home_layout_03 , layout_show01 ,layout_show02 ;

    private ListView listView;
    private List<LogisticsEvaluateFragmentEntry> list = new ArrayList<>();
    private LogisticsEvaluateFragmentAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.logistics_evaluate_fragment_first , container , false);

        home_layout_01 = (LinearLayout) view.findViewById(R.id.logistics_evaluate_fragment_first_home_01);
        home_layout_02 = (LinearLayout) view.findViewById(R.id.logistics_evaluate_fragment_first_home_02);
        home_layout_03 = (LinearLayout) view.findViewById(R.id.logistics_evaluate_fragment_first_home_03);

        home_layout_01.setOnClickListener(this);
        home_layout_02.setOnClickListener(this);
        home_layout_03.setOnClickListener(this);

        layout_show01 = (LinearLayout) view.findViewById(R.id.logistics_evaluate_fragment_first_layout_01);
        layout_show02 = (LinearLayout) view.findViewById(R.id.logistics_evaluate_fragment_first_layout_02);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.logistics_evaluate_fragment_first_listview);
        list.clear();
        list.add(new LogisticsEvaluateFragmentEntry(1));
        list.add(new LogisticsEvaluateFragmentEntry(1));
        adapter = new LogisticsEvaluateFragmentAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LogisticsEvaluateFragmentAdapter listAdapter = (LogisticsEvaluateFragmentAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logistics_evaluate_fragment_first_home_01:
                layout_show01.setVisibility(View.VISIBLE);
                layout_show02.setVisibility(View.GONE);
                break;
            case R.id.logistics_evaluate_fragment_first_home_02:
                layout_show01.setVisibility(View.VISIBLE);
                layout_show02.setVisibility(View.GONE);
                break;
            case R.id.logistics_evaluate_fragment_first_home_03:
                layout_show01.setVisibility(View.GONE);
                layout_show02.setVisibility(View.VISIBLE);
                break;
        }
    }
}
