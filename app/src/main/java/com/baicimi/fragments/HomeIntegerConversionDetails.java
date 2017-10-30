package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.HomeintegerConversionDetailsAdapter;
import com.baicimi.adapter.HomeintegerHotbrandAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.HomeintegerConversionDetailsEntry;
import com.baicimi.entity.HomeintegerHotbrandEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 * 首页  积分商城 兑换详情
 */

public class HomeIntegerConversionDetails extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<HomeintegerConversionDetailsEntry> list = new ArrayList<>();
    private HomeintegerConversionDetailsAdapter adapter;
    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.home_integer_conversion_details_fragment , container , false);

        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.home_integer_conversion_details_back);
        back.setOnClickListener(this);

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.home_integer_conversion_details_listview);

        list.clear();
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));
        list.add(new HomeintegerConversionDetailsEntry(R.drawable.home_integer_conversion_05 , "1" , "2017/09/07 20:00"));

        adapter = new HomeintegerConversionDetailsAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    @Override
    protected void initData() {

    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        HomeintegerConversionDetailsAdapter listAdapter = (HomeintegerConversionDetailsAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+80);
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_integer_conversion_details_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
