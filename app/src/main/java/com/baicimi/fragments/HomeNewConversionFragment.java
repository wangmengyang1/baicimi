package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.EverydayConversionAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.EverydayConversionEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 * 积分商城  限时兑换 新品必兑
 */

public class HomeNewConversionFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private List<EverydayConversionEntry> list = new ArrayList<>();
    private EverydayConversionAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_new_conversion_fragment , container , false);

        //listview布局填充
        initListView();
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.home_new_convetsion_fragment_listview);
        list.clear();
        list.add(new EverydayConversionEntry("10月5日 9:00" , "进行中" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("10月5日 17:00" , "20天17小时6分钟" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("10月5日 19:00" , "20天17小时6分钟" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("10月5日 20:00" , "20天17小时6分钟" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        list.add(new EverydayConversionEntry("10月5日 7:00" , "兑换结束" , R.drawable.home_integer_conversion_01 , "香奈儿NO5香水" , "市场价：¥216.00"  , "积分：6556" , "数量：16556"));
        adapter = new EverydayConversionAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+50);
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }
}
