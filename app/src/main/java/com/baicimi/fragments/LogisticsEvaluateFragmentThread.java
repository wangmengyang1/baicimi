package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.RreasureEvaluateFragmentSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RreasureEvaluateFragmentSecondEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理 物流评价首页 写评价
 */
public class LogisticsEvaluateFragmentThread extends BaseFragment{

    private View view;
    private ListView listView;
    private List<RreasureEvaluateFragmentSecondEntry> list = new ArrayList<>();
    private LogisticsEvaluateFragmentThreadAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.logistics_evaluate_fragment_thread , container , false);

        //listview布局填充
        initListView();


        return view;
    }

    private void initListView() {
        listView = (ListView) view.findViewById(R.id.logistics_evaluate_fragment_thread_listview);
        list.clear();
        list.add(new RreasureEvaluateFragmentSecondEntry(1));
        list.add(new RreasureEvaluateFragmentSecondEntry(1));
        list.add(new RreasureEvaluateFragmentSecondEntry(1));
        adapter = new LogisticsEvaluateFragmentThreadAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LogisticsEvaluateFragmentThreadAdapter listAdapter = (LogisticsEvaluateFragmentThreadAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 45;
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
}
