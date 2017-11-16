package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.GreenFoodFragmentFruitsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 * 首页  绿色食品  鲜果专区
 */
public class GreenFoodFragmentFruits extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<ShaiXuanListBean> list;
    private GreenFoodFragmentFruitsAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.green_food_fragment_fruits , container , false);
        back = (ImageView) view.findViewById(R.id.green_food_fragment_fruits_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();
        return view;
    }
    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.green_food_fragment_fruits_listview);
        list = new ArrayList<>();
        list.clear();
        list.add(new ShaiXuanListBean("" , "水清浅青岛红苹果" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        list.add(new ShaiXuanListBean("" , "水清浅青岛红苹果" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        list.add(new ShaiXuanListBean("" , "水清浅青岛红苹果" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        list.add(new ShaiXuanListBean("" , "水清浅青岛红苹果" , "5000" , "100" , "9899.00" , "8908.00" , R.drawable.green_food_image_15));
        adapter = new GreenFoodFragmentFruitsAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }

    @Override
    protected void initData() {

    }


    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        GreenFoodFragmentFruitsAdapter listAdapter = (GreenFoodFragmentFruitsAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            totalHeight += 16;
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.green_food_fragment_fruits_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
