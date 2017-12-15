package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.ConsumptionListAdapter;
import com.baicimi.adapter.PaymentAdencyGovernmentCusListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ConsumptionListEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 * 我的资产，消费清单
 */
public class MiIntegralBrankMyTreasureConsumptionList extends BaseFragment {

    private View view;
    private ListView listView;
    private List<ConsumptionListEntry> list = new ArrayList<>();
    private ConsumptionListAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_mu_treasure_consumption_list , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.im_integral_brank_mu_treasure_consumption_list_listview);
        list.add(new ConsumptionListEntry("2017.08.20" , "等待确认收货" , "宁菲深层去污洗发水" , "兑换礼品" + "\n"+"59.9" , "确认收货"));
        list.add(new ConsumptionListEntry("2017.08.20" , "详情" , "宁菲深层去污洗发水" , "积分抵现" + "\n"+"59.9" , "确认收货"));
        list.add(new ConsumptionListEntry("2017.08.20" , "详情" , "宁菲深层去污洗发水" , "积分抵现" + "\n"+"59.9" , "确认收货"));
        adapter = new ConsumptionListAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ConsumptionListAdapter listAdapter = (ConsumptionListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
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
