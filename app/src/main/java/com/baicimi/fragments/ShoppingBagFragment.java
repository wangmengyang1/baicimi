package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.ShoppingBagAdapter;
import com.baicimi.adapter.TodayCosmeticsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ShoppingBagEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 分销订货 首页 购物袋
 */
public class ShoppingBagFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private List<ShoppingBagEntry> list = new ArrayList<>();
    private ShoppingBagAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.shoppint_bag_fragment , container , false);

        //listview布局填充
        initListView();
        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.shoppint_bag_fragment_listview);
        list.clear();
        list.add(new ShoppingBagEntry(false , R.drawable.image_shangpin_01 , "中药固发去污洗发水" , "产品编号 HB1235312",
                "700ml" , "库存 2728件" , "¥490.00" , 48));
        list.add(new ShoppingBagEntry(false , R.drawable.image_shangpin_01 , "中药固发去污洗发水" , "产品编号 HB1235312",
                "700ml" , "库存 2728件" , "¥490.00" , 48));
        adapter = new ShoppingBagAdapter(list , getContext() , this);
        listView.setAdapter(adapter);
        fixListViewHeight(listView);
    }



    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ShoppingBagAdapter listAdapter = (ShoppingBagAdapter) listView.getAdapter();
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
