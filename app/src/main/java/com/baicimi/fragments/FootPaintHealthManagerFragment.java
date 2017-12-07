package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.FootPaintEveryTaskAdapter;
import com.baicimi.adapter.FootPaintHealthManagerAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FootPaintHealthManagerEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 健康管理
 */
public class FootPaintHealthManagerFragment extends BaseFragment{

    private View view;
    private ListView listView;
    private List<FootPaintHealthManagerEntry> list = new ArrayList<>();
    private FootPaintHealthManagerAdapter adapter;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.foot_paint_health_manager_fragment , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.foot_paint_health_manager_fragment_listview);
        list.clear();
        list.add(new FootPaintHealthManagerEntry(R.drawable.foot_paint_fragment_checkbox_select_23 , "心率测试仪" , "上次测试时间：2017/08/09" , "上次测试心率：102" + "\n" + "心率参照表"));
        list.add(new FootPaintHealthManagerEntry(R.drawable.foot_paint_fragment_checkbox_select_24 , "心率测试仪" , "上次测试时间：2017/08/09" , "上次测试视力：" + "\n" + "左眼：5.2  右眼：4.0"));
        list.add(new FootPaintHealthManagerEntry(R.drawable.foot_paint_fragment_checkbox_select_25 , "心率测试仪" , "上次测试时间：2017/08/09" , "上次测量高血压：" + "\n" + "高：143  低：86" + "\n" + "血压参照表"));
        adapter = new FootPaintHealthManagerAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }



    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        FootPaintHealthManagerAdapter listAdapter = (FootPaintHealthManagerAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
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
