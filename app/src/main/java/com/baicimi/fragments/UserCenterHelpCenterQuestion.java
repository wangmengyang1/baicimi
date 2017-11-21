package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
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
 * 个人中心，帮助中心首页 热点问题二级页面
 */
public class UserCenterHelpCenterQuestion extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    //下拉菜单问题
    CustomExpandableListView expd_lv;
    UserCenterHelpCenterQuestion.ExpandableAdapter adapters;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_help_center_question , container , false);

        back = (ImageView) view.findViewById(R.id.user_center_help_center_question_back);
        back.setOnClickListener(this);

        //下拉菜单问题
        initCusListView();
        return view;
    }


    private void initCusListView() {
        expd_lv = (CustomExpandableListView) view.findViewById(R.id.user_center_help_center_question_mycustom_expandable_listview);
        LoadListData();
        adapters = new UserCenterHelpCenterQuestion.ExpandableAdapter();
        expd_lv.setAdapter(adapters);
        expd_lv.setChildIndicator(null);
        expd_lv.setGroupIndicator(null);

        expd_lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return false;
            }
        });
    }

    //数据填充
    private void LoadListData() {


        GroupData = new ArrayList<String>();
        GroupData.add("购买咨询");
        GroupData.add("账户咨询");
        GroupData.add("支付咨询");
        GroupData.add("积分咨询");
        GroupData.add("卡券咨询");
        GroupData.add("会员咨询");
        GroupData.add("物流咨询");
        GroupData.add("认证咨询");
        GroupData.add("亲密付咨询");


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
        child6.add("");
        ChildrenData.add(child6);

        List<String> child7 = new ArrayList<String>();
        child7.add("");
        ChildrenData.add(child7);

        List<String> child8 = new ArrayList<String>();
        child8.add("");
        ChildrenData.add(child8);

        List<String> child9 = new ArrayList<String>();
        child9.add("");
        ChildrenData.add(child9);

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

            if (groupPosition == 0) {
                convertView = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_center_help_center_question_child_first, null);

                }
            }
//            else if (groupPosition == 1){
//                convertView = null;
//                if (convertView == null){
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_cneter_help_center , null);
//
//                }
//            }else if (groupPosition == 2){
//                convertView = null;
//                if (convertView == null){
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_cneter_help_center_first , null);
//
//                }
//            }else if (groupPosition == 3){
//                convertView = null;
//                LinearLayout layout = null;
//                if (convertView == null){
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_cneter_help_center_second , null);
//                    layout = (LinearLayout) convertView.findViewById(R.id.usercenter_help_center_second_layout_01);
//
//                }
//
//                layout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //热点问题二级页面
//                        startFragment(new UserCenterHelpCenterQuestion());
//                    }
//                });
//
//            }else if (groupPosition == 4){
//                convertView = null;
//                if (convertView == null){
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_cneter_help_center_thread , null);
//
//                }
//            }
            return convertView;
        }


        private class GetChildViewHolder {
            private TextView textViews;
            private ImageView imageUrl;
            private View textview_v;
        }


        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
//            if (ChildrenData.get(groupPosition).size() == 1) {
//                return 0;
//            }
            if(groupPosition == 0){
                return 1;
            }else {
                return 0;
            }
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

            UserCenterHelpCenterQuestion.ExpandableAdapter.GetChildViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_center_help_center_item_group, null);
                holder = new UserCenterHelpCenterQuestion.ExpandableAdapter.GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.ucer_center_help_center_item_group_lible);

                convertView.setTag(holder);
            } else {
                holder = (UserCenterHelpCenterQuestion.ExpandableAdapter.GetChildViewHolder) convertView.getTag();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_center_help_center_question_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
    }
}
