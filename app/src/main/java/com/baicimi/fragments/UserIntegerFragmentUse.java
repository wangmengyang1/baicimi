package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.UseListViewAdapter;
import com.baicimi.adapter.UserIntegerInquireListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UseEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 * 个人中心，会员积分页面 使用积分
 */
public class UserIntegerFragmentUse extends BaseFragment{

    private View view;
    private ListView listView;
    private List<UseEntry> list = new ArrayList<>();
    private UseListViewAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_inreger_fragment_user , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_integer_fragment_user_listview);
        list.clear();
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "在百次幂积分商城上兑换礼品（礼品包含大牌化妆品，使用日用品，进口母婴产品等高品质产品）" , "现在兑换"));
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "在百次幂积分商城上兑换礼品（礼品包含大牌化妆品，使用日用品，进口母婴产品等高品质产品）" , "去逛逛"));
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "在百次幂积分商城上兑换礼品（礼品包含大牌化妆品，使用日用品，进口母婴产品等高品质产品）" , "null"));
        list.add(new UseEntry(R.drawable.user_integer_image_04 , "在百次幂积分商城上兑换礼品（礼品包含大牌化妆品，使用日用品，进口母婴产品等高品质产品）" , "null"));
        adapter = new UseListViewAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);

    }

    @Override
    protected void initData() {

    }

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UseListViewAdapter listAdapter = (UseListViewAdapter) listView.getAdapter();
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


}
