package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.PhoneTopUpFragmentFlowAdapter;
import com.baicimi.adapter.PhoneTopUpFragmentPhoneAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PhoneTopUpFragmentPhoneEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/8.
 * 个人中心首页 手机充值 充流量
 */
public class PhoneTopUpFragmentFlow extends BaseFragment{

    private View view;

    private GridView gridView;
    private List<PhoneTopUpFragmentPhoneEntry> list = new ArrayList<>();
    private PhoneTopUpFragmentFlowAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.phone_tupup_fragment_flow , container , false);

        //GridView布局填充
        initGridView();
        return view;
    }


    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.phone_tupup_fragment_flow_gridview);
        list.clear();
        list.add(new PhoneTopUpFragmentPhoneEntry("30M" , "" , true));
        list.add(new PhoneTopUpFragmentPhoneEntry("100M" , "" , false));
        list.add(new PhoneTopUpFragmentPhoneEntry("300M" , "" , false));
        list.add(new PhoneTopUpFragmentPhoneEntry("500M" , "" , false));
        list.add(new PhoneTopUpFragmentPhoneEntry("1000M" , "" , false));
        list.add(new PhoneTopUpFragmentPhoneEntry("2000M" , "" , false));

        adapter = new PhoneTopUpFragmentFlowAdapter(list , getContext());
        gridView.setAdapter(adapter);
        fixGrdiViewHeight03(gridView);

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        PhoneTopUpFragmentFlowAdapter listAdapter = (PhoneTopUpFragmentFlowAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() / 3); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
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
