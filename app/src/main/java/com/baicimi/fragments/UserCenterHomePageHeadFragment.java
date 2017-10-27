package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserCenterHomePageSecondAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.CommodityNumberEntry;
import com.baicimi.entity.UserCenterHomePageEntrySecond;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 * 个人中心首页
 * 2017-10-11
 * 王梦阳
 */
public class UserCenterHomePageHeadFragment extends BaseFragment implements View.OnClickListener {

    private View view;


    //下拉菜单问题
    CustomExpandableListView expd_lv;
    UserCenterHomePageHeadFragment.ExpandableAdapter adapters;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;
    private List<Integer> groupDageImage  = new ArrayList<>();

    private ImageView back , headImage;

    private FragmentManager fm;
    private List<BaseFragment> fragments = new ArrayList<>();
    private int index = 5;
    private List<String> fragmentTag = new ArrayList<>();
    private String showFragemtnTag = "null";

    private LinearLayout shopping, community;
    private TextView shopping_tv, community_tv , shardSDk;

    //今日推荐
    private GridView gridview_03;
    private List<UserCenterHomePageEntrySecond> list_03 = new ArrayList<>();
    private UserCenterHomePageSecondAdapter adapter_03;
    private LinearLayout showLayout;

    private int shardSdk;

    private TextView setting;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_head_fragment , container , false);

        //下拉菜单问题
        initCusListView();
        fm = getChildFragmentManager();
        fragments.clear();
        fragments.add(new UserIntegralFragmentFirst());
        fragments.add(new RosePerSonalFragment());

        back = (ImageView) view.findViewById(R.id.user_center_home_page_head_fragment_back);
        back.setOnClickListener(this);

        //fragment切换
        initShowFragment(0);

        shopping = (LinearLayout) view.findViewById(R.id.user_center_home_page_fragment_shopping);
        community = (LinearLayout) view.findViewById(R.id.user_center_home_page_fragment_community);
        shopping.setOnClickListener(this);
        community.setOnClickListener(this);
        shopping_tv = (TextView) view.findViewById(R.id.user_center_home_page_fragment_shopping_textiview);
        community_tv = (TextView) view.findViewById(R.id.user_center_home_page_fragment_community_textview);

        //今日推荐GridView布局填充
        initRecommend();

        showLayout = (LinearLayout) view.findViewById(R.id.user_center_home_page_head_fragment_layout);


        headImage = (ImageView) view.findViewById(R.id.user_headimage);
        headImage.setOnClickListener(this);
        shardSDk = (TextView) view.findViewById(R.id.user_name);
        shardSDk.setOnClickListener(this);


        setting = (TextView) view.findViewById(R.id.user_center_home_page_head_fragment_setting);
        setting.setOnClickListener(this);
        return view;
    }


    //今日推荐GridView布局填充
    private void initRecommend() {
        gridview_03 = (GridView) view.findViewById(R.id.user_center_home_page_fragmet_gridview);
        list_03.clear();
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_37, new String("官方授权 自然堂乐园补水保湿面膜"), new String("54543人购买"), new String("¥39"), new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_38, new String("官方授权 自然堂乐园补水保湿面膜"), new String("54543人购买"), new String("¥39"), new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_39, new String("官方授权 自然堂乐园补水保湿面膜"), new String("54543人购买"), new String("¥39"), new String("¥100")));
        list_03.add(new UserCenterHomePageEntrySecond(R.drawable.user_integral_gridview_item_image_40, new String("官方授权 自然堂乐园补水保湿面膜"), new String("54543人购买"), new String("¥39"), new String("¥100")));
        adapter_03 = new UserCenterHomePageSecondAdapter(getContext(), list_03);
        gridview_03.setAdapter(adapter_03);
        fixGrdiViewHeight03(gridview_03);
    }

    //fragment切换
    private void initShowFragment(int count) {


        String tag = fragments.get(count).getMTag();
        if (tag == null) {
            return;
        }
        if (showFragemtnTag.equals(tag)) {//如果要切换的fragment是当前显示的fragment，则跳出
            return;
        }
        FragmentTransaction transtction = fm.beginTransaction();
        if (fragmentTag.contains(tag)) {//包含这个标记的时候
            if (showFragemtnTag.equals("null")) {
                transtction.add(R.id.user_center_home_page_head_fragment_framelayout, fragments.get(count), tag);
            } else {
                transtction.hide(fm.findFragmentByTag(showFragemtnTag));
            }
            transtction.show(fragments.get(count));
        } else {
            fragmentTag.add(tag);//添加标记
            transtction.add(R.id.user_center_home_page_head_fragment_framelayout, fragments.get(count), tag);
            transtction.show(fragments.get(count));
        }

        showFragemtnTag = tag;//讲个这个标记添加到标记队列
        transtction.commit();

    }

    //下拉菜单问题
    private void initCusListView() {
        expd_lv = (CustomExpandableListView)view.findViewById(R.id.user_center_home_page_head_fragment_expd_lv);
        LoadListData();
        adapters = new UserCenterHomePageHeadFragment.ExpandableAdapter();
        expd_lv.setAdapter(adapters);
        expd_lv.setChildIndicator(null);
        expd_lv.setGroupIndicator(null);

        expd_lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (i == 8 ) {
                    //我的购物袋
                    startFragment(new ShopingCarFragment(CommodityNumberEntry.commodityNumberEntryIntereal().getCount()) , null);
                }else if (i == 10) {
                    //员工物品申请
                    startFragment(new DistributorPurchaseOption() , null);
                }
                return false;
            }
        });

        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                //此处执行二级下拉菜单点击事件
                if (i == 0 && i1 == 0) {
                    startFragment(new OrderFormFragment());//我的订单
                } else if (i == 0 && i1 == 1) {
                    startFragment(new MyGroupPurchaseFragment());//团购订单
                } else if (i == 0 && i1 == 2) {
                    startFragment(new UserCenterHomePageHeadIntimacy());//亲密付订单
                } else if (i == 0 && i1 == 3) {
                    startFragment(new GovernmentPurchaseFragment());//政府采购
                } else if (i == 0 && i1 == 4) {
                    startFragment(new ByStagesFragment());//分期订单
                } else if (i == 0 && i1 == 5) {
                    startFragment(new MyAuctionFragment());//我的拍卖
                } else if (i == 0 && i1 == 6) {
                    startFragment(new MyPresellFragment());//我的预售
                } else if (i == 1 && i1 == 0) {
                    startFragment(new MiWalletFragment());//幂钱包
                } else if (i == 1 && i1 == 1) {
                    //幂积分银行
                } else if (i == 1 && i1 == 2) {
                    //赚取积分
                } else if (i == 1 && i1 == 3) {
                    //支付管理
                } else if (i == 2 && i1 == 0) {
                    //我的等级
                } else if (i == 2 && i1 == 1) {
                    //会员积分
                    startFragment(new UserCenterUserIntegerFragment());
                }else if (i == 4 && i1 == 0) {
                    //发起亲密付
                    startFragment(new UserCenterHomepageHeadIntimacyRequest());
                }else if (i == 4 && i1 == 1) {
                    //红包
                }else if (i == 4 && i1 == 2) {
                    //礼品寄存处
                    startFragment(new FragmentPresentSave() , null);
                }else if (i == 4 && i1 == 3) {
                    //爱心捐赠
                }else if (i == 4 && i1 == 4) {
                    //手机充值
                }else if (i == 4 && i1 == 5) {
                    //记账本
                }else if (i == 4 && i1 == 6) {
                    //幂额度
                }else if (i == 4 && i1 == 7) {
                    //幂信用积分
                }else if (i == 4 && i1 == 8) {
                    //信用卡还款
                }else if (i == 5 && i1 == 0) {
                    //加入分销点/点
                }else if (i == 5 && i1 == 1) {
                    //我要推荐
                }else if (i == 6 && i1 == 0) {
                    //我的商城
                }else if (i == 6 && i1 == 1) {
                    //分销入口
                }else if (i == 7 && i1 == 0) {
                    //购买咨询
                }else if (i == 7 && i1 == 1) {
                    //投诉与建议
                }else if (i == 8 ) {
                    //我的购物袋
                    startFragment(new ShopingCarFragment(CommodityNumberEntry.commodityNumberEntryIntereal().getCount()) , null);
                }else if (i == 10) {
                    //员工物品申请
                    startFragment(new DistributorPurchaseOption() , null);
                }


                return true;
            }
        });
    }

    //数据源填充
    private void LoadListData() {
        groupDageImage.clear();
        groupDageImage.add(R.drawable.user_center_head_image_01);
        groupDageImage.add(R.drawable.user_center_head_image_02);
        groupDageImage.add(R.drawable.user_center_head_image_03);
        groupDageImage.add(R.drawable.user_center_head_image_04);
        groupDageImage.add(R.drawable.user_center_head_image_05);
        groupDageImage.add(R.drawable.user_center_head_image_06);
        groupDageImage.add(R.drawable.user_center_head_image_07);
        groupDageImage.add(R.drawable.user_center_head_image_08);
        groupDageImage.add(R.drawable.user_center_head_image_09);
        groupDageImage.add(R.drawable.user_center_head_image_06);
        groupDageImage.add(R.drawable.user_center_head_image_04);

        GroupData = new ArrayList<String>();
        GroupData.add("订单中心");
        GroupData.add("资产中心");
        GroupData.add("会员中心");
        GroupData.add("幂聊");
        GroupData.add("我的生活助手");
        GroupData.add("百万行动计划");
        GroupData.add("我的商城");
        GroupData.add("客户服务");
        GroupData.add("我的购物袋");
        GroupData.add("我的快递");
        GroupData.add("员工物品申请");

        ChildrenData = new ArrayList<List<String>>();

        List<String> child1 = new ArrayList<String>();
        child1.add("我的订单");
        child1.add("团购订单");
        child1.add("亲密付订单");
        child1.add("政府采购订单");
        child1.add("分期订单");
        child1.add("我的拍卖");
        child1.add("我的预售");
        ChildrenData.add(child1);
        List<String> child2 = new ArrayList<String>();
        child2.add("幂钱包");
        child2.add("幂积分银行");
        child2.add("赚取积分");
        child2.add("支付管理");
        ChildrenData.add(child2);
        List<String> child3 = new ArrayList<String>();
        child3.add("我的等级");
        child3.add("会员积分");
        ChildrenData.add(child3);
        List<String> child4 = new ArrayList<String>();
        child4.add("");
        ChildrenData.add(child4);
        List<String> child5 = new ArrayList<String>();
        child5.add("亲密付");
        child5.add("红包");
        child5.add("礼品寄存处");
        child5.add("爱心捐赠");
        child5.add("手机充值");
        child5.add("记账本");
        child5.add("幂额度");
        child5.add("幂信用积分");
        child5.add("信用卡还款");
        ChildrenData.add(child5);
        List<String> child6 = new ArrayList<String>();
        child6.add("加入分销点/店");
        child6.add("我要推荐");
        ChildrenData.add(child6);
        List<String> child7 = new ArrayList<String>();
        child7.add("我的商城");
        child7.add("分销入口");
        ChildrenData.add(child7);
        List<String> child8 = new ArrayList<String>();
        child8.add("购买咨询");
        child8.add("投诉与建议");
        ChildrenData.add(child8);
        List<String> child9 = new ArrayList<String>();
        child9.add("");
        ChildrenData.add(child9);
        List<String> child10 = new ArrayList<String>();
        child10.add("");
        ChildrenData.add(child10);
        List<String> child11 = new ArrayList<String>();
        child11.add("");
        ChildrenData.add(child11);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_home_page_head_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
            case R.id.user_center_home_page_fragment_shopping:
                shopping_tv.setTextColor(Color.parseColor("#c22737"));
                shopping_tv.setBackgroundResource(R.drawable.user_center_title_bar_indicator_layer_list);
                community_tv.setTextColor(Color.parseColor("#737373"));
                community_tv.setBackgroundResource(R.drawable.background_null);
                initShowFragment(0);
                showLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.user_center_home_page_fragment_community:
                community_tv.setTextColor(Color.parseColor("#c22737"));
                community_tv.setBackgroundResource(R.drawable.user_center_title_bar_indicator_layer_list);
                shopping_tv.setTextColor(Color.parseColor("#737373"));
                shopping_tv.setBackgroundResource(R.drawable.background_null);
                initShowFragment(1);
                showLayout.setVisibility(View.GONE);
                break;
            case R.id.user_headimage:
                //封面设置
//                startFragment(new UserCenterCoverSettingFragment());
                startFragment(new UserCenterCoverSettingCatalogyFragment());
                break;

            case R.id.user_name:

                if (shardSdk % 2 == 0){
                    //分享
                    startFragment(new UserCenterHomePageShardSDK());
                }else {
                    //产品分享
                    startFragment(new UserCenterHomePageProductShardSDK());
                }

                shardSdk++;
                break;
            case R.id.user_center_home_page_head_fragment_setting:
                //设置界面
                startFragment(new UserCenterHomePagerSetting());
                break;
        }
    }


    private class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return ChildrenData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub


            GetChildViewHolder holder = null;
            if (convertView == null){
                convertView  = LayoutInflater.from(getContext()).inflate(R.layout.user_center_homepage_head_fragment_listview_item_child , null);
                holder = new GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.user_center_homepage_head_fragment_listview_item_child_textview);
                holder.textview_v = convertView.findViewById(R.id.user_center_homepage_head_fragment_listview_item_child_view);
                convertView.setTag(holder);
            }else {
                holder = (GetChildViewHolder) convertView.getTag();
            }

            holder.textViews.setText(ChildrenData.get(groupPosition).get(childPosition));
            if (childPosition == 0){
                holder.textview_v.setVisibility(View.VISIBLE);
            }else {
                holder.textview_v.setVisibility(View.INVISIBLE);
            }

            return convertView;
        }


        private class GetChildViewHolder{
            private TextView textViews;
            private ImageView imageUrl;
            private View textview_v;
        }



        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            if (ChildrenData.get(groupPosition).size() == 1){
               return 0;
            }
            return ChildrenData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return GroupData.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return GroupData.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub

            GetChildViewHolder holder = null;
            if (convertView == null){
                convertView  = LayoutInflater.from(getContext()).inflate(R.layout.user_center_homepage_head_fragment_listview_item_group , null);
                holder = new GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.user_center_home_page_head_fragment_listview_item_group_lible);
                holder.imageUrl = (ImageView) convertView.findViewById(R.id.user_center_home_page_head_fragment_listview_item_group_imageurl);
                convertView.setTag(holder);
            }else {
                holder = (GetChildViewHolder) convertView.getTag();
            }

            holder.textViews.setText(GroupData.get(groupPosition));
            holder.imageUrl.setImageResource(groupDageImage.get(groupPosition));

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub

            return true;
        }

    }


    @Override
    protected void initData() {

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(GridView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageSecondAdapter listAdapter = (UserCenterHomePageSecondAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount() / 2); index++) {
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
