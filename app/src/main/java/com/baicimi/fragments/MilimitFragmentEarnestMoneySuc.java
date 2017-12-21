package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MilimitFragmentEarnestCodeAdapter;
import com.baicimi.adapter.MilimitFragmentEarnestMoneySucGridAdapter;
import com.baicimi.adapter.MilimitFragmentEarnestMoneySucListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.AuthenticationEntry;
import com.baicimi.entity.AuthenticationListEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 * 个人中心首页 我的生活助手  幂额度首页   幂信用积分开通成功
 */
public class MilimitFragmentEarnestMoneySuc extends BaseFragment{

    private View view;

    private GridView gridView;
    private List<AuthenticationEntry> listGrid = new ArrayList<>();
    private MilimitFragmentEarnestMoneySucGridAdapter adapterGrid;

    private ListView listview;
    private List<AuthenticationListEntry> listList = new ArrayList<>();
    private MilimitFragmentEarnestMoneySucListAdapter adapterList;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_limit_fragment_earnest_money_suc , container , false);

        //GridView布局填充
        initGridView();

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listview = (ListView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_listview);
        listList.clear();
        listList.add(new AuthenticationListEntry("幂信用付款得奖励金" , "笔笔有惊喜" , "" , false , R.drawable.mi_limit_image_36));
        listList.add(new AuthenticationListEntry("热门话剧演出" , "" , "超低价抢购" , true , R.drawable.mi_limit_image_36));
        listList.add(new AuthenticationListEntry("幂信用付款得奖励金" , "" , "限时积分兑换" , true , R.drawable.mi_limit_image_37));
        listList.add(new AuthenticationListEntry("幂信用付款得奖励金" , "" , "超低价抢购" , true , R.drawable.mi_limit_image_37));
        adapterList = new MilimitFragmentEarnestMoneySucListAdapter(listList , getContext());
        listview.setAdapter(adapterList);
        fixListView(listview);
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.mi_limit_fragment_earnest_money_suc_gridview);
        listGrid.clear();
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_27 , "超值权益"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_28 , "分期好货"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_29 , "看电影"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_30 , "住酒店"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_31 , "吃喝玩乐"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_32 , "告诉ETC"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_33 , "租车"));
        listGrid.add(new AuthenticationEntry(R.drawable.mi_limit_image_34 , "帮助"));
        adapterGrid = new MilimitFragmentEarnestMoneySucGridAdapter(listGrid , getContext());
        gridView.setAdapter(adapterGrid);
        fixGrdiView(gridView);
    }

    //动态计算GridView的高度
    public void fixGrdiView(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MilimitFragmentEarnestMoneySucGridAdapter listAdapter = (MilimitFragmentEarnestMoneySucGridAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/4); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 20;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    //动态计算GridView的高度
    public void fixListView(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MilimitFragmentEarnestMoneySucListAdapter listAdapter = (MilimitFragmentEarnestMoneySucListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/4); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 20;
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
