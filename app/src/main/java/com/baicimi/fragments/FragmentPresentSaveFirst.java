package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.FragmentPresentSaveFirstAdapter;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FragmentPresentSaveFirstEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 * 个人中心 我的生活助手 礼品寄存处列表布局
 */
@SuppressLint("ValidFragment")
public class FragmentPresentSaveFirst extends BaseFragment{

    private View view;
    private ListView listView;
    private List<FragmentPresentSaveFirstEntry> list = new ArrayList<>();
    private FragmentPresentSaveFirstAdapter adapter;
    private int index;

    public FragmentPresentSaveFirst(int index) {
        this.index = index;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_present_save_first , container , false);

        //listview布局填充
        initListView(index);

        return view;
    }

    //listview布局填充
    private void initListView(int index) {
        listView = (ListView) view.findViewById(R.id.fragment_present_save_first_listview);
        list.clear();
        if (index == 0){
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "" , false , false));
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "" , false , false));
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "" , false , false));
        }else if (index == 1){
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "" , false , false));
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "" , false , true));
        }else if (index == 2){
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "寄存有效时长：2016-09-15 - 2017-10-10" , false , false));
            list.add(new FragmentPresentSaveFirstEntry(R.drawable.fragment_present_save_home_image_01 , "纯棉毛巾" , "新人专区0积分兑换" , "寄存有效时长：2016-09-15 - 2017-10-10" , true , false));
        }

        adapter = new FragmentPresentSaveFirstAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }




    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        FragmentPresentSaveFirstAdapter listAdapter = (FragmentPresentSaveFirstAdapter) listView.getAdapter();
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

    @Override
    protected void initData() {

    }
}
