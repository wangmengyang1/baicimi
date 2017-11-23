package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.RreasureEvaluateFragmentAdapte;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 * 个人中心 我的订单首页  评价管理  宝贝评价首页 我的评论
 */
public class RreasureEvaluateFragmentFirst extends BaseFragment{

    private View view;
    private ListView listView;
    private List<RreasureEvaluateFragmentEntry> list = new ArrayList<>();
    private RreasureEvaluateFragmentAdapte adapte;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.rreasure_evaluate_fragment_first , container , false);

        //listview布局填充
        initListView();
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.rreasure_evaluate_fragment_first_listview);
        list.clear();
        list.add(new RreasureEvaluateFragmentEntry(R.drawable.evaluate_management_image_04 , "穿了一下，特别轻，强力推荐" , "2017/09/10  17:50"));
        list.add(new RreasureEvaluateFragmentEntry(R.drawable.evaluate_management_image_05 , "还行，就是物流慢了点" , "2017/09/10  17:50"));
        list.add(new RreasureEvaluateFragmentEntry(R.drawable.evaluate_management_image_06 , "不好穿，感觉太小了，还有色差" , "2017/09/10  17:50"));
        adapte = new RreasureEvaluateFragmentAdapte(list , getContext());
        listView.setAdapter(adapte);
        fixGrdiViewHeight03(listView);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        RreasureEvaluateFragmentAdapte listAdapter = (RreasureEvaluateFragmentAdapte) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 25;
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
