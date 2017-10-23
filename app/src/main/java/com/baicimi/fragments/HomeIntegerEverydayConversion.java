package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.EverydayConversionAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.EverydayConversionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 * 积分商城  限时兑换 每日必兑
 */

public class HomeIntegerEverydayConversion extends BaseFragment {

    private View view;
    private ListView listView;
    private List<EverydayConversionEntry> list = new ArrayList<>();
    private EverydayConversionAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_everyday_conversion , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.home_integer_everyday_conversion_listview);
        list.clear();
        list.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("9:00场" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("9:00场" , "兑换结束" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        adapter = new EverydayConversionAdapter(list , getContext() , 0 , this);
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    @Override
    protected void initData() {

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        EverydayConversionAdapter listAdapter = (EverydayConversionAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+40);
        listView.setLayoutParams(params);
    }


}
