package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MPNewBookAdapter;
import com.baicimi.adapter.MPSystemGcMyArticleAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MPSystemGcMyArticleEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 回收站  我的文章
 */
public class MPSystemGcMyArticle extends BaseFragment{

    private View view;

    private ListView listViewFirst , listViewSecond , listViewThread;
    private List<MPSystemGcMyArticleEntry> listFirst = new ArrayList<>();
    private List<MPSystemGcMyArticleEntry> listSecond = new ArrayList<>();
    private List<MPSystemGcMyArticleEntry> listThread = new ArrayList<>();
    private MPSystemGcMyArticleAdapter adapterFirst , adapterSecond , adapterThread;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_system_gv_myarticle , container , false);

        //listview布局填充
        initListViewFirst();
        initListViewSecond();
        initListViewThread();

        return view;
    }

    private void initListViewThread() {
        listViewThread = (ListView) view.findViewById(R.id.mp_system_gv_myarticle_listviewthread);
        listThread.clear();
        listThread.add(new MPSystemGcMyArticleEntry("3天20小时" , "我心中的喜马拉雅" , false));
        listThread.add(new MPSystemGcMyArticleEntry("3天20小时" , "我心中的喜马拉雅" , false));
        adapterThread = new MPSystemGcMyArticleAdapter(listThread ,getContext());
        listViewThread.setAdapter(adapterThread);
        fixGridViewHeight(listViewThread);
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.mp_system_gv_myarticle_listviewsecond);
        listSecond.clear();
        listSecond.add(new MPSystemGcMyArticleEntry("3天20小时" , "我心中的喜马拉雅" , false));
        listSecond.add(new MPSystemGcMyArticleEntry("3天20小时" , "我心中的喜马拉雅" , false));
        adapterSecond = new MPSystemGcMyArticleAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixGridViewHeight(listViewSecond);
    }

    private void initListViewFirst() {
        listViewFirst = (ListView) view.findViewById(R.id.mp_system_gv_myarticle_listviewfirst);
        listFirst.clear();
        listFirst.add(new MPSystemGcMyArticleEntry("3天20小时" , "我心中的喜马拉雅" , false));
        adapterFirst = new MPSystemGcMyArticleAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
    }


    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MPSystemGcMyArticleAdapter listAdapter = (MPSystemGcMyArticleAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
//        System.out.println(girdViewHeight + "_______________________________");
    }


    @Override
    protected void initData() {

    }
}
