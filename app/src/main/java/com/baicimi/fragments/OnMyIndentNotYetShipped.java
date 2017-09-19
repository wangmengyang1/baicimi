package com.baicimi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.adapter.HomePageViewButtonAdapte;
import com.baicimi.adapter.OnMyIndentNotYetShippedAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.OnMyIndentNotYetShippedEntry;
import com.baicimi.interfaces.OnMyIndentViewListener;
import com.baicimi.ui.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 * 待发货
 */
public class OnMyIndentNotYetShipped extends BaseFragment{

    private View view;

    private ListView listView;
    private List<OnMyIndentNotYetShippedEntry> list = new ArrayList<>();
    private OnMyIndentNotYetShippedAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.onmy_indent_notyetshipped_fragment , container , false);
        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.onmy_indent_notyetshipped_fragment_listview);
        list.add(new OnMyIndentNotYetShippedEntry(new String("联盟猫旗舰店") , new String("买家已付款") , R.drawable.onmy_indent_notyesshipped_adapter_image_02 , new String("Go5最新游戏原画设计视频教程cg插画ps基础手绘动漫") , new String("¥124.00") , new String("¥589.00") , new String("X1") , new String("合计：¥124.80（含运费¥0.00）") , false , false));
        list.add(new OnMyIndentNotYetShippedEntry(new String("联盟猫旗舰店") , new String("买家已付款") , R.drawable.onmy_indent_notyesshipped_adapter_image_03 , new String("Go5最新游戏原画设计视频教程cg插画ps基础手绘动漫") , new String("¥124.00") , new String("¥589.00") , new String("X1") , new String("合计：¥124.80（含运费¥0.00）") , false , false));
        list.add(new OnMyIndentNotYetShippedEntry(new String("联盟猫旗舰店") , new String("买家已付款") , R.drawable.onmy_indent_notyesshipped_adapter_image_04 , new String("Go5最新游戏原画设计视频教程cg插画ps基础手绘动漫") , new String("¥124.00") , new String("¥589.00") , new String("X1") , new String("合计：¥124.80（含运费¥0.00）") , false , false));
        list.add(new OnMyIndentNotYetShippedEntry(new String("联盟猫旗舰店") , new String("买家已付款") , R.drawable.onmy_indent_notyesshipped_adapter_image_05 , new String("Go5最新游戏原画设计视频教程cg插画ps基础手绘动漫") , new String("¥124.00") , new String("¥589.00") , new String("X1") , new String("合计：¥124.80（含运费¥0.00）") , false , false));
        adapter = new OnMyIndentNotYetShippedAdapter(getContext() , list);
        listView.setAdapter(adapter);
        fixGridViewHeight(listView);
//        listView.getParent().requestDisallowInterceptTouchEvent(true);
    }

    @Override
    protected void initData() {

    }




    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        OnMyIndentNotYetShippedAdapter listAdapter = (OnMyIndentNotYetShippedAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
