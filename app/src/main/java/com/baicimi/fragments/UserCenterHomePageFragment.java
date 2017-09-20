package com.baicimi.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePageEntryFirst;
import com.baicimi.entity.UserCenterHomePageEntrySecond;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

public class UserCenterHomePageFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private GridView gridview_01;
    private List<UserCenterHomePageEntryFirst> list = new ArrayList<>();
    private UserCenterHomePageAdapter adapter , adapter_02;

    private GridView gridview_02;
    private List<UserCenterHomePageEntryFirst> list_02 = new ArrayList<>();

    private GridView gridview_03;
    private List<UserCenterHomePageEntrySecond> list_03 = new ArrayList<>();
    private UserCenterHomePageSecondAdapter adapter_03;

    private FragmentManager fragmentManager;
    private int showIndex;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> listFragment = new ArrayList<>();


    private UserIntegralFragment userInteralFragment;

    private TextView more;

    private LinearLayout layout_live;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_fragment , container , false);

        //订单中心GridView布局填充
        initIndent();

        //我的生活助手
        initLive();

        //会员推荐GridView布局填充
        initRecommend();

        //头部fragment布局切换
        initFragmentLayoutShow();

        layout_live = (LinearLayout) view.findViewById(R.id.user_center_home_page_fragment_live);
        layout_live.setOnClickListener(this);

        return view;
    }
    //头部fragment布局切换
    private void initFragmentLayoutShow() {
        fragmentManager = getChildFragmentManager();
        listFragment.add(new UserIntegralFragment());
        setShowFragment(0);
    }


    //今日推荐GridView布局填充
    private void initRecommend() {
        gridview_03 = (GridView) view.findViewById(R.id.user_center_home_page_fragmet_gridview_03);
        list_03.clear();
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_37 , new String("官方授权 自然堂乐园补水保湿面膜") , new String("54543人购买") , new String("¥39") , new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_38 , new String("官方授权 自然堂乐园补水保湿面膜") , new String("54543人购买") , new String("¥39") , new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_39 , new String("官方授权 自然堂乐园补水保湿面膜") , new String("54543人购买") , new String("¥39") , new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_40 , new String("官方授权 自然堂乐园补水保湿面膜") , new String("54543人购买") , new String("¥39") , new String("¥100")));
        adapter_03 = new UserCenterHomePageSecondAdapter(getContext() , list_03);
        gridview_03.setAdapter(adapter_03);
        fixGrdiViewHeight03(gridview_03);
    }

    //我的生活助手
    private void initLive() {
        gridview_02 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_01);
        list_02.clear();
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_18 , new String("ME全球汇")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_19 , new String("手机充值")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_20 , new String("亲密付")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_21 , new String("记账本")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_22 , new String("红包")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_23 , new String("爱心捐款")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_24 , new String("信用卡还款")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_25 , new String("迷信用分")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_26 , new String("支付转账")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_27 , new String("我的购物车")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_28 , new String("添加更多")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.fragment_muying_user_image_05 , new String("更多")));
        adapter_02 = new UserCenterHomePageAdapter(getContext() , list_02);
        gridview_02.setAdapter(adapter_02);
        fixGrdiViewHeight02(gridview_02);
    }

    //订单中心GridView布局填充
    private void initIndent() {
        gridview_01 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_02);
        list.clear();
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_29 , new String("我的订单")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_30 , new String("政府采购")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_31 , new String("团购订单")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_32 , new String("分期订单")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_33 , new String("我的预售")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_34 , new String("我的拍卖")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_35 , new String("评价晒单")));
        list.add(new UserCenterHomePageEntryFirst(R.drawable.user_integral_gridview_item_image_36 , new String("取消订单记录")));
        adapter = new UserCenterHomePageAdapter(getContext() , list);
        gridview_01.setAdapter(adapter);
        fixGrdiViewHeight(gridview_01);

        gridview_01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                startFragment(new UserCenterHomePageFragmentUserIndent());
            }
        });
    }

    @Override
    protected void initData() {

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageAdapter listAdapter = (UserCenterHomePageAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/4); index++) {
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

    //动态计算GridView的高度
    public void fixGrdiViewHeight02(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageAdapter listAdapter = (UserCenterHomePageAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/4); index++) {
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

    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageSecondAdapter listAdapter = (UserCenterHomePageSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()/2); index++) {
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




    //显示fragment
    private void setShowFragment(int index){
        if (index > listFragment.size()){
            return;
        }else{
            if(listFragment.get(index) == null){
                return;
            }else{
                String tag = listFragment.get(index).getTag();
                fragmentTransaction = fragmentManager.beginTransaction();
                // 3 控制Fragment 的动画
                fragmentTransaction.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_right_exit, R.anim.slide_right_enter,
                        R.anim.slide_left_exit);
                if(listFragment.get(index).isAdded()){
                    //如果已经添加了，则显示
                    fragmentTransaction.hide(listFragment.get(showIndex));
                    fragmentTransaction.show(listFragment.get(index));
                }else{
                    //如果没有添加，则添加之后显示
                    fragmentTransaction.add(R.id.user_cnenter_page_fragment_framelayout , listFragment.get(index) , tag).show(listFragment.get(index));
                }
                showIndex = index;
                fragmentTransaction.commit();
            }

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.user_center_home_page_fragment_more://点击跳转到详细页面
//                startFragment(new UserCenterHomePageFragmentMore());
////                startFragment(new UserCenterHomePageFragmentUserIndent());
//                break;
            case R.id.user_center_home_page_fragment_live:
                startFragment(new RosePerSonalFragment());
                break;
        }
    }
}
