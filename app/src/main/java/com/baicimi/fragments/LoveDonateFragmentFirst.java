package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.LoveDonateFragmentListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.LoveDonateFragmentEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 * 个人中心首页 爱心捐赠首页fragment
 */
public class LoveDonateFragmentFirst extends BaseFragment{

    private View view;

    private ListView listView;
    private List<LoveDonateFragmentEntry> list = new ArrayList<>();
    private LoveDonateFragmentListAdapter adapterList;

    private GridView gridView;
    private List<LoveDonateFragmentEntry> listSecond = new ArrayList<>();
    private LoveDonateFragmentGirdAdapter adapterGrid;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.love_donate_fragment_first , container , false);

        //listview布局填充
        initListView();

        //girdview布局填充
        initGridView();
        return view;
    }

    //girdview布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.love_donate_fragment_first_gridview);
        listSecond.clear();
        listSecond.add(new LoveDonateFragmentEntry(R.drawable.love_donate_image_09 , "" , ""));
        listSecond.add(new LoveDonateFragmentEntry(R.drawable.love_donate_image_09 , "" , ""));
        listSecond.add(new LoveDonateFragmentEntry(R.drawable.love_donate_image_09 , "" , ""));
        listSecond.add(new LoveDonateFragmentEntry(R.drawable.love_donate_image_09 , "" , ""));
        adapterGrid = new LoveDonateFragmentGirdAdapter(listSecond , getContext());
        gridView.setAdapter(adapterGrid);
        fixGrdiView(gridView);

    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.love_donate_fragment_first_listview);
        list.clear();
        list.add(new LoveDonateFragmentEntry("无偿资助-----6岁孩子重返校园" , R.drawable.love_donate_image_08 , "河南信阳小山村一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书的费用。" , R.drawable.love_donate_image_07 , "小明" , "GuangZhou,China"));
        list.add(new LoveDonateFragmentEntry("无偿资助-----6岁孩子重返校园" , R.drawable.love_donate_image_08 , "河南信阳小山村一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书的费用。" , R.drawable.love_donate_image_07 , "小明" , "GuangZhou,China"));
        list.add(new LoveDonateFragmentEntry("无偿资助-----6岁孩子重返校园" , R.drawable.love_donate_image_08 , "河南信阳小山村一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书的费用。" , R.drawable.love_donate_image_07 , "小明" , "GuangZhou,China"));
        list.add(new LoveDonateFragmentEntry("无偿资助-----6岁孩子重返校园" , R.drawable.love_donate_image_08 , "河南信阳小山村一个6岁男孩豆豆，父母早亡，由年迈的奶奶抚养长大，家境贫寒，无力承担读书的费用。" , R.drawable.love_donate_image_07 , "小明" , "GuangZhou,China"));
        adapterList = new LoveDonateFragmentListAdapter(list , getContext());
        listView.setAdapter(adapterList);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LoveDonateFragmentListAdapter listAdapter = (LoveDonateFragmentListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 35;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    //动态计算GridView的高度
    public void fixGrdiView(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        LoveDonateFragmentGirdAdapter listAdapter = (LoveDonateFragmentGirdAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 10;
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
