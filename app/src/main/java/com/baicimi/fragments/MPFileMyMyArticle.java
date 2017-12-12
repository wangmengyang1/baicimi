package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MPFileMyMyArticleAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MPSystemGcMyArticleEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 文件 我的文章
 */
public class MPFileMyMyArticle extends BaseFragment{

    private View view;

    private ListView listViewFirst , listViewSecond , listViewThread;
    private List<MPSystemGcMyArticleEntry> listFirst , listSecond , listThread;
    private MPFileMyMyArticleAdapter adapterFirst , adapterSecond , adapterThread;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_file_my_article_fragmemt , container , false);

        //listview布局填充
        initListView();
        initListViewSecond();
        initListViewThread();
        return view;
    }

    private void initListViewThread() {
        listViewThread = (ListView) view.findViewById(R.id.mp_file_my_article_fragmemt_listviewsecond);
        listThread = new ArrayList<>();
        listThread.add(new MPSystemGcMyArticleEntry("今天" , "我心中的喜马拉雅" , false));
        listThread.add(new MPSystemGcMyArticleEntry("2017年9月10日" , "我心中的喜马拉雅" , false));
        adapterThread = new MPFileMyMyArticleAdapter(listThread , getContext());
        listViewThread.setAdapter(adapterThread);
        fixGridViewHeight(listViewThread);
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.mp_file_my_article_fragmemt_listviewsecond);
        listSecond = new ArrayList<>();
        listSecond.add(new MPSystemGcMyArticleEntry("今天" , "我心中的喜马拉雅" , false));
        listSecond.add(new MPSystemGcMyArticleEntry("2017年9月10日" , "我心中的喜马拉雅" , false));
        adapterSecond = new MPFileMyMyArticleAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixGridViewHeight(listViewSecond);
    }

    //listview布局填充
    private void initListView() {
        listViewFirst = (ListView) view.findViewById(R.id.mp_file_my_article_fragmemt_listviewfirst);
        listFirst = new ArrayList<>();
        listFirst.add(new MPSystemGcMyArticleEntry("今天" , "我心中的喜马拉雅" , false));
        listFirst.add(new MPSystemGcMyArticleEntry("2017年9月10日" , "我心中的喜马拉雅" , false));
        adapterFirst = new MPFileMyMyArticleAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
        fixGridViewHeight(listViewFirst);
    }


    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MPFileMyMyArticleAdapter listAdapter = (MPFileMyMyArticleAdapter) listView.getAdapter();
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
