package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHomePageEntryFirst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class UserCenterHomePageFragmentMore extends BaseFragment {

    private View view;

    private GridView gridView_01 ,gridView_02 ,gridView_03 ,gridView_04 ,gridView_05 ,gridView_06 ,gridView_07 ,gridView_08 ;
    private UserCenterHomePageAdapter adapter , adapter_02 , adapter_03, adapter_04, adapter_05, adapter_06, adapter_07, adapter_08;
    private List<UserCenterHomePageEntryFirst> list_01 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_02 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_03 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_04 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_05 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_06 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_07 = new ArrayList<>();
    private List<UserCenterHomePageEntryFirst> list_08 = new ArrayList<>();


    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_fragment_more , container , false);

        //GridView布局填充
        initGridView();
        back = (ImageView) view.findViewById(R.id.user_Center_home_page_fragment_more_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
            }
        });


        return view;
    }

    //GridView布局填充
    private void initGridView() {
        gridView_01 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_01_more);
        gridView_02 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_02_more);
        gridView_03 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_03_more);
        gridView_04 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_04_more);
        gridView_05 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_05_more);
        gridView_06 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_06_more);
        gridView_07 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_07_more);
        gridView_08 = (GridView) view.findViewById(R.id.user_center_home_page_fragment_gridview_08_more);

        list_01.clear();
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_01 , new String("我的订单")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_02 , new String("政府采购")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_03 , new String("团购订单")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_04 , new String("分期订单")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_05 , new String("我的预售")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_06 , new String("我的拍卖")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_07 , new String("评价晒单")));
        list_01.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_08 , new String("取消订单记录")));

        adapter = new UserCenterHomePageAdapter(getContext() , list_01);
        gridView_01.setAdapter(adapter);
        fixGrdiViewHeight03(gridView_01 , adapter , 4);

        list_02.clear();
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_09 , new String("幂钱包")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_10 , new String("账户余额")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_11 , new String("转账付款")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_12 , new String("我的积分")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_13 , new String("我的卡券")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_14 , new String("我的分期")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_15 , new String("收支记录")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_16 , new String("礼品寄存处")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_17 , new String("赚取积分")));
        list_02.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_18 , new String("支付管理")));
        adapter_02 = new UserCenterHomePageAdapter(getContext() , list_02);
        gridView_02.setAdapter(adapter_02);
        fixGrdiViewHeight03(gridView_02 , adapter_02 , 4);

        list_03.clear();
        list_03.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_19 , new String("我关注的商品")));
        list_03.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_20 , new String("我关注的品牌")));
        list_03.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_21 , new String("我关注的活动")));
        list_03.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_22 , new String("我的足迹")));
        adapter_03 = new UserCenterHomePageAdapter(getContext() , list_03);
        gridView_03.setAdapter(adapter_03);
        fixGrdiViewHeight03(gridView_03 , adapter_03 , 4);

        list_04.clear();
        list_04.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_23 , new String("我的等级")));
        list_04.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_24 , new String("会员积分")));
        adapter_04 = new UserCenterHomePageAdapter(getContext() , list_04);
        gridView_04.setAdapter(adapter_04);
        fixGrdiViewHeight03(gridView_04 , adapter_04 , 4);

        list_05.clear();
        list_05.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_25 , new String("寻找好友")));
        list_05.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_26 , new String("好友管理")));
        list_05.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_27 , new String("消息")));
        adapter_05 = new UserCenterHomePageAdapter(getContext() , list_05);
        gridView_05.setAdapter(adapter_05);
        fixGrdiViewHeight03(gridView_05 , adapter_05 , 4);


        list_06.clear();
        list_06.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_28 , new String("我的商城")));
        list_06.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_29 , new String("分销入口")));
        adapter_06 = new UserCenterHomePageAdapter(getContext() , list_06);
        gridView_06.setAdapter(adapter_06);
        fixGrdiViewHeight03(gridView_06 , adapter_06 , 4);


        list_07.clear();
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_30 , new String("个人信息")));
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_31 , new String("账户安全")));
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_32 , new String("收货地址")));
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_33 , new String("发票设置")));
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_34 , new String("账号认证")));
        list_07.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_35 , new String("重要时刻")));
        adapter_07 = new UserCenterHomePageAdapter(getContext() , list_07);
        gridView_07.setAdapter(adapter_07);
        fixGrdiViewHeight03(gridView_07 , adapter_07 , 4);

        list_08.clear();
        list_08.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_36 , new String("购买咨询")));
        list_08.add(new UserCenterHomePageEntryFirst(R.drawable.tianjia_37 , new String("投诉与建议")));
        adapter_08 = new UserCenterHomePageAdapter(getContext() , list_08);
        adapter_08 = new UserCenterHomePageAdapter(getContext() , list_08);
        gridView_08.setAdapter(adapter_08);
        fixGrdiViewHeight03(gridView_08 , adapter_08 , 4);

    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView , BaseAdapter listAdapter , int count) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
//        listAdapter = (BaseAdapter) listView.getAdapter();
        int item = 0;
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        if(count > 0){
            if(listAdapter.getCount()%count == 0){
                item = listAdapter.getCount()/count;
            }else{
                item = listAdapter.getCount()/count+1;
            }
        }

        for (int index = 0; index < item; index++) {
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
