package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.EverydaySigninAdapter;
import com.baicimi.adapter.NewPeoplePrefectureAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.EverydaySigninEntry;
import com.baicimi.view.GetPresentDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 * 积分商城 每日签到
 */

public class HomeIntegerEverydaySignin extends BaseFragment {

    private View view;
    private GridView gridView;
    private List<EverydaySigninEntry> list = new ArrayList<>();
    private EverydaySigninAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_everyday_signin , container , false);

        //gridview布局填充
        initGridView();

        return view;
    }

    //gridview布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.home_integer_everyday_signin_gridview);
        list.clear();
        for (int i = 1 ; i <= 30 ; i++){
            if (i == 15){
                list.add(new EverydaySigninEntry(i + "" , true , false , i + ""));
            }else if (i >= 22 && i < 30 ){
                list.add(new EverydaySigninEntry(i + "" , false , true , i + ""));
            }else if (i == 30){
                list.add(new EverydaySigninEntry(i + "" , true , true , i + ""));
            } else {
                list.add(new EverydaySigninEntry(i + "" , false , false , i + ""));
            }
        }
        adapter = new EverydaySigninAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 15){
                    GetPresentDialog getpresentDialog = new GetPresentDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                    getpresentDialog.show();
                }else{
                    boolean b = list.get(i).isState();
                    list.get(i).setState(!b);
                }
                adapter.notifyDataSetChanged();
            }
        });

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        EverydaySigninAdapter listAdapter = (EverydaySigninAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/5); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+30);
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }
}
