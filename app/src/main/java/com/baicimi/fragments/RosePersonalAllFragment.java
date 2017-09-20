package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.baicimi.R;
import com.baicimi.adapter.RosePersonalAllAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.RosePersonalAllEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2017/2/13.
 * 个人中心我的图片
 */
public class RosePersonalAllFragment extends BaseFragment {

    private ListView listView;
    private List<RosePersonalAllEntry> list = new ArrayList<>();
    private RosePersonalAllAdapter adapter ;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_rose_all,container,false);
        //listview布局填充
        initListView();

        return view;
    }

    private void initListView() {
        listView = (ListView) view.findViewById(R.id.fragment_rose_all_liatview);
        list.clear();
        list.add(new RosePersonalAllEntry(R.drawable.rose_personal_all_adapter_imaghe_01 , new String("Olympians's dreams cut shortwhen he tirps on first hurdle") , new String("百事加冰") , new String("GuangZhou,China")));
        list.add(new RosePersonalAllEntry(R.drawable.rose_personal_all_adapter_imaghe_01 , new String("Olympians's dreams cut shortwhen he tirps on first hurdle") , new String("百事加冰") , new String("GuangZhou,China")));
        list.add(new RosePersonalAllEntry(R.drawable.rose_personal_all_adapter_imaghe_01 , new String("Olympians's dreams cut shortwhen he tirps on first hurdle") , new String("百事加冰") , new String("GuangZhou,China")));
        adapter = new RosePersonalAllAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGridViewHeight(listView);
    }

    @Override
    protected void initData() {

    }

    //动态计算Gridview的高度
    public void fixGridViewHeight(ListView listView ) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        RosePersonalAllAdapter gridAdapter = (RosePersonalAllAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (gridAdapter == null) {
            return;
        }
        for (int index = 0; index < gridAdapter.getCount(); index++) {
            View listViewItem = gridAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (gridAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
