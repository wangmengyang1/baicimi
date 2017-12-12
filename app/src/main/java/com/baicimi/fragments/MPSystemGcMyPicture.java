package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MPSystemGcMyPictureAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MPSystemGcMyPictureEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * 个人中心首页 幂聊首页 全球生活汇 回收站 我的图片
 */
public class MPSystemGcMyPicture extends BaseFragment{

    private View view;
    private ListView listViewFirst , listViewSecond;
    private List<MPSystemGcMyPictureEntry> listFirst = new ArrayList<>();
    private List<MPSystemGcMyPictureEntry> listSecond = new ArrayList<>();
    private MPSystemGcMyPictureAdapter adapterFirst , adapterSecond;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mp_system_gc_my_picture , container , false);

        //listview布局填充
        initListView();
        initListViewSecond();


        return view;
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.mp_system_gc_my_picture_listviewsecond);
        listSecond.clear();
        listSecond.add(new MPSystemGcMyPictureEntry(R.drawable.mp_new_book_image_07 , "3天20小时"));
        adapterSecond = new MPSystemGcMyPictureAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
    }

    private void initListView() {
        listViewFirst = (ListView) view.findViewById(R.id.mp_system_gc_my_picture_listviewfirst);
        listFirst.clear();
        listFirst.add(new MPSystemGcMyPictureEntry(R.drawable.mp_new_book_image_07 , "3天20小时"));
        adapterFirst = new MPSystemGcMyPictureAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
    }

    @Override
    protected void initData() {

    }
}
