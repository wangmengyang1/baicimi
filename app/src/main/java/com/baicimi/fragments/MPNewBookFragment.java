package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MPNewBookAdapter;
import com.baicimi.adapter.MiChatAddFriendsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MPNewBookEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 新建
 */
public class MPNewBookFragment extends BaseFragment{

    private View view;
    private GridView gridView;
    private List<MPNewBookEntry> list = new ArrayList<>();
    private MPNewBookAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_new_book_fragment , container , false);

        //GridView布局填充
        initGridView();
        return view;
    }

    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.mp_new_book_fragment_gridview );
        list.clear();
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_01 , "空白文档"));
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_01 , "幂笔记"));
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_02 , "日记类模板"));
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_03 , "商务类模板"));
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_04 , "小册子"));
        list.add(new MPNewBookEntry(R.drawable.mp_new_book_image_05 , "旅游日记"));
        adapter = new MPNewBookAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGridViewHeight(gridView);
    }

    //动态计算listview的高度
    public void fixGridViewHeight(GridView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MPNewBookAdapter listAdapter = (MPNewBookAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount()/3; index++) {
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
