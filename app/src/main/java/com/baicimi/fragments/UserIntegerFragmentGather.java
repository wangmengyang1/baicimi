package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.GatherListViewAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UseEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面 收集积分
 */
public class UserIntegerFragmentGather extends BaseFragment{

    private View view;
    private ListView listView;
    private List<UseEntry> list = new ArrayList<>();
    private GatherListViewAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integer_fragment_gathedr , container , false);

        //listview布局填充
        initListView();
        return view;
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_integer_fragment_grather_listview);
        list.clear();
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "在实体店，淘宝，天猫，京东，百次幂商场等各种渠道购买的宁菲产品，瓶身背面均标有产品积分码。" , "1.刮开积分码"));
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "刮开积分码，在网页版百次幂商城，手机端菜单栏上找到 输入积分码 ，点击输入积分，即可获得相应积分。" , "2.输入积分码"));
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "个人所得积分可提现，兑换礼品及购买商品时抵用现金。" , "3.积分即刻到账"));
        adapter = new GatherListViewAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        GatherListViewAdapter listAdapter = (GatherListViewAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
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
