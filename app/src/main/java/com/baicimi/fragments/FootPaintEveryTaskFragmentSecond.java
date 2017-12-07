package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.FootPaintEveryTaskAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FootPaintEveryTaskEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */
public class FootPaintEveryTaskFragmentSecond extends BaseFragment{


    private View view;
    private ListView listView;
    private List<FootPaintEveryTaskEntry> list = new ArrayList<>();
    private FootPaintEveryTaskAdapter adapter;
    private boolean state;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {

        view = inflater.inflate(R.layout.foot_paint_every_task_fragment , container , false);
        initListViewNP();
        return view;
    }


    private void initListViewNP() {
        listView = (ListView) view.findViewById(R.id.foot_paint_every_task_fragment_listview);
        list.add(new FootPaintEveryTaskEntry("绑定微信" , "奖励10积分" , true));
        list.add(new FootPaintEveryTaskEntry("邀请好友" , "奖励10积分" , false));
        list.add(new FootPaintEveryTaskEntry("完成一项运动" , "奖励10积分" , false));
        list.add(new FootPaintEveryTaskEntry("完成所有新手任务" , "奖励10积分" , false));


        adapter = new FootPaintEveryTaskAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        FootPaintEveryTaskAdapter listAdapter = (FootPaintEveryTaskAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 16;
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
