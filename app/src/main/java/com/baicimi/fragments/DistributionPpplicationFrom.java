package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 * 个人中心，帮助中心首页 点此咨询提问跳转页面 详细咨询页面  百次幂分销点/店申请表
 */
public class DistributionPpplicationFrom extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    //下拉菜单问题
    CustomExpandableListView expd_lv;
    DistributionPpplicationFrom.ExpandableAdapter adapters;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.distribution_plication_from , container , false);


        //下拉菜单问题
        initCusListView();


        back = (ImageView) view.findViewById(R.id.distribution_plication_from_back);
        back.setOnClickListener(this);
        return view;
    }



    private void initCusListView() {
        expd_lv = (CustomExpandableListView) view.findViewById(R.id.distribution_plication_from_mycustom_expandable_listview);
        LoadListData();
        adapters = new DistributionPpplicationFrom.ExpandableAdapter();
        expd_lv.setAdapter(adapters);
        expd_lv.setChildIndicator(null);
        expd_lv.setGroupIndicator(null);
    }

    //数据填充
    private void LoadListData() {
//        groupDageImage.clear();
//        groupDageImage.add(R.drawable.image_usercenter_01);
//        groupDageImage.add(R.drawable.image_usercenter_02);
//        groupDageImage.add(R.drawable.image_usercenter_03);
//        groupDageImage.add(R.drawable.image_usercenter_04);
//        groupDageImage.add(R.drawable.image_usercenter_05);
//        groupDageImage.add(R.drawable.image_usercenter_06);
//        groupDageImage.add(R.drawable.image_usercenter_07);
//        groupDageImage.add(R.drawable.image_usercenter_08);
//        groupDageImage.add(R.drawable.image_usercenter_09);
//        groupDageImage.add(R.drawable.image_usercenter_10);
//        groupDageImage.add(R.drawable.image_usercenter_11);

        GroupData = new ArrayList<String>();
        GroupData.add("申请人信息");
        GroupData.add("自零售店信息");
        GroupData.add("店主信息");
        GroupData.add("申请信息");


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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.distribution_plication_from_back:
                ((MainActivity)getActivity()).goBack();
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

            DistributionPpplicationFrom.ExpandableAdapter.GetChildViewHolder holder = null;
            if (groupPosition == 0) {
                convertView = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.distribution_plication_from_zero, null);

                }
            }else if (groupPosition == 1){
                convertView = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.distribution_plication_from_first , null);

                }
            }else if (groupPosition == 2){
                convertView = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.distribution_plication_from_second , null);

                }
            }else if (groupPosition == 3){
                convertView = null;
                LinearLayout layout = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.distribution_plication_from_thread , null);

                }

            }
            return convertView;
        }


        private class GetChildViewHolder {
            private TextView textViews;
            private ImageView imageUrl;
            private View textview_v;
        }


        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
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

            DistributionPpplicationFrom.ExpandableAdapter.GetChildViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_center_help_center_item_group, null);
                holder = new DistributionPpplicationFrom.ExpandableAdapter.GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.ucer_center_help_center_item_group_lible);

                convertView.setTag(holder);
            } else {
                holder = (DistributionPpplicationFrom.ExpandableAdapter.GetChildViewHolder) convertView.getTag();
            }

            holder.textViews.setText(GroupData.get(groupPosition));

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
}
