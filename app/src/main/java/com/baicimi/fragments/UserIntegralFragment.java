package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePageEntryFirst;
import com.baicimi.ui.OnDrawingException;
import com.baicimi.view.RingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */
public class UserIntegralFragment extends BaseFragment{

    private View view;
    private GridView gridView;
    private List<UserCenterHomePageEntryFirst> list = new ArrayList<>();
    private UserCenterHomePageAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integral_fragment , container ,false);

        //GridView布局填充
        initGridView();

        RingView ringView = (RingView) view.findViewById(R.id.user_integral_fragmentringview);
        ringView.setColors(new int[]{Color.parseColor("#2a8fd3"),Color.parseColor("#f15f48"), Color.parseColor("#2ac770")
                , Color.parseColor("#f1c40f"),Color.parseColor("#2ac770"),Color.parseColor("#9a59b5")});
        ringView.setValues(new int[]{33, 27, 18, 10, 7,5});

        try {
            ringView.startDraw();
        } catch (OnDrawingException e) {
            e.printStackTrace();
        }



        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView = (GridView) view.findViewById(R.id.user_integral_fragment_gridview);
        list.clear();
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_01 , new String("订单中心")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_02 , new String("资产中心")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_03 , new String("我的关注")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_04 , new String("会员中心")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_05 , new String("好友圈")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_06 , new String("我的商城")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_07 , new String("我的等级")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_08 , new String("客户服务")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_09 , new String("我的购物车")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_10 , new String("帮助中心")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_11 , new String("投诉与建议")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.fragment_muying_user_image_05 , new String("更多")));

        adapter = new UserCenterHomePageAdapter(getContext() , list);
        gridView.setAdapter(adapter);
        fixGrdiViewHeight(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 11){
                    startFragment(new UserCenterHomePageFragmentMore());
                }
                if(i == 0){
                    startFragment(new OrderFormFragment());
                }
            }
        });


    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight(GridView listView) {
        int count = 0;
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageAdapter listAdapter = (UserCenterHomePageAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        if(listAdapter.getCount()%4 != 0){
            count = listAdapter.getCount()/4 + 1;
        }else{
            count = listAdapter.getCount()/4;
        }

        for (int index = 0; index < count; index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
    }



    @Override
    protected void initData() {

    }
}
