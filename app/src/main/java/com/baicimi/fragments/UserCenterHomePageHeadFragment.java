package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
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

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_head_fragment , container , false);

        //下拉菜单问题
        expd_lv = (CustomExpandableListView)view.findViewById(R.id.user_center_home_page_head_fragment_expd_lv);
        LoadListData();
        adapters = new UserCenterHomePageHeadFragment.ExpandableAdapter();
        expd_lv.setAdapter(adapters);
        expd_lv.setChildIndicator(null);
        expd_lv.setGroupIndicator(null);

        back = (ImageView) view.findViewById(R.id.user_center_home_page_head_fragment_back);
        back.setOnClickListener(this);

        return view;
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

        GroupData = new ArrayList<String>();
        GroupData.add("订单中心");
        GroupData.add("资产中心");
        GroupData.add("会员中心");
        GroupData.add("幂聊");
        GroupData.add("我的生活助手");
        GroupData.add("百万行动计划");
        GroupData.add("我的商城");
        GroupData.add("客户服务");
        GroupData.add("我的快递");


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
        child5.add("我的购物袋");
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_home_page_head_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
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
            //此处执行二级下拉菜单点击事件
            return true;
        }

    }


    @Override
    protected void initData() {

    }



}
