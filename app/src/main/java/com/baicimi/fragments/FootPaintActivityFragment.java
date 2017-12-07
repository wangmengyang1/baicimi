package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.FootPaintActivityAdapter;
import com.baicimi.adapter.FootPaintEveryTaskAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.FootPaintActivityEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 * 运动页面 首页 赛事活动
 */
public class FootPaintActivityFragment extends BaseFragment{

    private View view;
    private ListView listView , listViewSecond;
    private List<FootPaintActivityEntry> list = new ArrayList<>();
    private List<FootPaintActivityEntry> listSecond = new ArrayList<>();
    private FootPaintActivityAdapter adapter , adapterSecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.foot_paint_activity_fragment , container , false);

        //listview布局填充
        initListView();
        initListSecond();
        return view;
    }

    private void initListSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.foot_paint_activity_fragment_listviewsecond);
        listSecond.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_21 , "团队印花赛" , "经验值 +100 悦币 +5" , false));
        listSecond.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_22 , "十公里挑战赛" , "经验值 +100 悦币 +5" , false));
        adapterSecond = new FootPaintActivityAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixListViewHeight(listViewSecond);
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.foot_paint_activity_fragment_listview);
        list.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "7天习惯养成赛" , "经验值 +100 悦币 +5" , false));
        list.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_18 , "21天习惯养成赛" , "经验值 +100 悦币 +5" , false));
        list.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_19 , "健走闯关赛" , "经验值 +100 悦币 +5" , false));
        list.add(new FootPaintActivityEntry(R.drawable.foot_paint_fragment_checkbox_select_20 , "处女座网络马拉松" , "经验值 +100 悦币 +5" , false));
        adapter = new FootPaintActivityAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    //7天习惯养成
                    startFragment(new FootPaintActivitySevenFragment());
                }
            }
        });
    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        FootPaintActivityAdapter listAdapter = (FootPaintActivityAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    protected void initData() {

    }
}
