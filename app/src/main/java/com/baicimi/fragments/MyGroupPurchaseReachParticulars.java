package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.NoreachListViewAdapter;
import com.baicimi.adapter.PaymentAdencyAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.NoreachEntry;
import com.baicimi.entity.PaymentAdencyEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 * 我的团购，已成团详情
 */
public class MyGroupPurchaseReachParticulars extends BaseFragment implements View.OnClickListener {

    private View view;

    private ListView listView;
    private List<PaymentAdencyEntry> list = new ArrayList<>();
    private PaymentAdencyAdapter adencyAdapter ;

    private ListView secondLV;
    private List<NoreachEntry> listLV = new ArrayList<>();
    private NoreachListViewAdapter adapter;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.my_group_purchase_reach_particulars , container , false);

        //listview头部布局填充
        initListView();

        //listview底部布局填充
        initListviewButtom();

        back = (ImageView) view.findViewById(R.id.my_group_purchase_reach_back);
        back.setOnClickListener(this);
        return view;
    }


    //listview底部布局填充
    private void initListviewButtom() {
        secondLV = (ListView) view.findViewById(R.id.my_group_purchase_reach_particulars_listview_second);
        listLV.clear();
        listLV.add(new NoreachEntry(R.drawable.noreach_imageurl , "头像集" , "数量 1"));
        listLV.add(new NoreachEntry(R.drawable.noreach_imageurl , "头像集" , "数量 1"));
        listLV.add(new NoreachEntry(R.drawable.noreach_imageurl , "头像集" , "数量 1"));
        adapter = new NoreachListViewAdapter(listLV , getContext());
        secondLV.setAdapter(adapter);
        fixGrdiViewHeight03(secondLV);
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.my_group_purchase_reach_listview);
        list.clear();
        list.add(new PaymentAdencyEntry(R.drawable.image_dingdan_01 , new String("链条式连帽运动衫") , new String("白色 编号-5644/216") , new String("L(175/96A)") , new String("¥339.00")));
        adencyAdapter = new PaymentAdencyAdapter(list , getContext());
        listView.setAdapter(adencyAdapter);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        NoreachListViewAdapter listAdapter = (NoreachListViewAdapter) listView.getAdapter();
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
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.my_group_purchase_reach_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
