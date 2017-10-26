package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.adapter.UserIntegerInquireGridAdapter;
import com.baicimi.adapter.UserIntegerInquireListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FragmentInquireListEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心 会员积分 积分查询
 */
public class UserIntegerFragmetInquire extends BaseFragment{

    private View view;
    private ListView listView;
    private List<FragmentInquireListEntry> listView_list = new ArrayList<>();
    private UserIntegerInquireListAdapter adapterList ;

    private GridView gridView;
    private List<FragmentInquireListEntry> gridView_list = new ArrayList<>();
    private UserIntegerInquireGridAdapter adapterGrid;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.userinteger_fragment_inquire , container , false);

        //listview布局填充
        initListView();

        //GridView布局填充
        initGridView();
        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.userinteger_fragment_inquire_gridview);
        gridView_list.clear();
        for (int i = 0 ; i< 9 ; i++){
            gridView_list.add(new FragmentInquireListEntry(R.drawable.user_integer_image_03 , "M145684654684" , "积分:1032135"));
        }
        adapterGrid = new UserIntegerInquireGridAdapter(gridView_list , getContext());
        gridView.setAdapter(adapterGrid);
        fixGrdiViewHeight04(gridView);

    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.userinteger_fragment_inquire_listview);
        listView_list.clear();
        listView_list.add(new FragmentInquireListEntry(R.drawable.user_integer_image_02 , "M145684654684" , "积分：1032135"));
        listView_list.add(new FragmentInquireListEntry(R.drawable.user_integer_image_02 , "M145684654684" , "积分：1032135"));
        listView_list.add(new FragmentInquireListEntry(R.drawable.user_integer_image_02 , "M145684654684" , "积分：1032135"));
        adapterList = new UserIntegerInquireListAdapter(listView_list , getContext());
        listView.setAdapter(adapterList);
        fixGrdiViewHeight03(listView);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserIntegerInquireListAdapter listAdapter = (UserIntegerInquireListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1)+30);
        listView.setLayoutParams(params);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight04(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserIntegerInquireGridAdapter listAdapter = (UserIntegerInquireGridAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/3); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
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
    protected void initData() {

    }
}
