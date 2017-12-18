package com.baicimi.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.ui.OnDrawingException;
import com.baicimi.view.CustomExpandableListView;
import com.baicimi.view.RingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 * //个人中心首页fragment
 */

public class UserIntegralFragmentFirst extends BaseFragment {

    private View view;
    private CustomExpandableListView expandableListView;
    private UserIntegralFragmentFirst.ExpandableAdapter adapters;

    private List<String> GroupData;
    private List<List<Fragment>> ChildrenData;
    private List<Integer> groupDageImage  = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_imagral_fragment_first , container , false);

        expandableListView = (CustomExpandableListView)view.findViewById(R.id.user_imageral_fragment_first_exp_listview);
        LoadListData();
        adapters = new UserIntegralFragmentFirst.ExpandableAdapter();
        expandableListView.setAdapter(adapters);
        expandableListView.setChildIndicator(null);
        expandableListView.setGroupIndicator(null);
        return view;
    }

    @Override
    protected void initData() {

    }
    //数据源填充
    private void LoadListData() {
        groupDageImage.clear();
        groupDageImage.add(R.drawable.image_usercenter_12);
        groupDageImage.add(R.drawable.image_usercenter_13);
        groupDageImage.add(R.drawable.image_usercenter_14);
        groupDageImage.add(R.drawable.image_usercenter_15);

        GroupData = new ArrayList<String>();
        GroupData.add("我的积分");
        GroupData.add("积分市值");
        GroupData.add("积分排行");
        GroupData.add("积分介绍");


        ChildrenData = new ArrayList<>();

        List<Fragment> list_child1 = new ArrayList<>();
        list_child1.add(new UserIntegralFragment());
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);
        ChildrenData.add(null);
    }


    private class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return ChildrenData.get(groupPosition);
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

            if (groupPosition == 0){
                GetGroupViewHolder holder = null;
                convertView = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_fragment , null);
                    holder = new GetGroupViewHolder();
                    holder.ringView = (RingView) convertView.findViewById(R.id.user_integral_fragmentringview);
                    holder.getLayout_01 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_01);
                    holder.getLayout_02 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_02);
                    holder.getLayout_03 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_03);
                    holder.getLayout_04 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_04);
                    holder.getLayout_05 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_05);
                    holder.getLayout_06 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_06);
                    holder.getLayout_07 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_07);
                    holder.getLayout_08 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_08);
                    holder.getLayout_09 = (LinearLayout) convertView.findViewById(R.id.user_integral_fragment_getlayout_09);
                    convertView.setTag(holder);
                }else{
                    holder = (GetGroupViewHolder) convertView.getTag();
                }

                holder.ringView.setColors(new int[]{Color.parseColor("#2a8fd3"),Color.parseColor("#f15f48"), Color.parseColor("#2ac770")
                        , Color.parseColor("#f1c40f"),Color.parseColor("#2ac770"),Color.parseColor("#9a59b5") , Color.parseColor("#2ac770"),Color.parseColor("#f15f48")});
                holder.ringView.setValues(new int[]{33, 27, 18, 10,10 , 10 ,  7,5});

                try {
                    holder.ringView.startDraw();
                } catch (OnDrawingException e) {
                    e.printStackTrace();
                }

                holder.getLayout_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //签到所得
                        startFragment(new UserIntegralSignInGet());
                    }
                });
                holder.getLayout_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //购物所得
                        startFragment(new UserIntegralSignInShopping());
                    }
                });
                holder.getLayout_03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //登录所得
                        startFragment(new UserIntegralSignInLogin());
                    }
                });
                holder.getLayout_04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //游戏所得
                        startFragment(new UserIntegralSignInGame());
                    }
                });
                holder.getLayout_05.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //分享所得
                        startFragment(new UserIntegralSignInShare());
                    }
                });
                holder.getLayout_06.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //推荐所得
                        startFragment(new UserIntegralSignInRecommend());
                    }
                });
                holder.getLayout_07.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //发布所得
                        startFragment(new UserIntegralSignInIssue());
                    }
                });
                holder.getLayout_08.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //广告所得
                        startFragment(new UserIntegralSignInAdvertising());
                    }
                });
                holder.getLayout_09.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //其他所得
                        startFragment(new UserIntegralSignInMore());
                    }
                });

            }else if (groupPosition == 1){
                convertView = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_fragment_thread , null);
                }
            }else if (groupPosition == 2){
                convertView = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_fragment_second , null);
                }
            }else if (groupPosition == 3){

            }




            return convertView;
        }


        private class GetChildViewHolder{
            private TextView textViews;
            private ImageView imageUrl;
            private View textview_v;
        }

        private class GetGroupViewHolder{
            private RingView ringView;
            private LinearLayout getLayout_01 ,  getLayout_02 , getLayout_03 , getLayout_04 , getLayout_05 , getLayout_06 ,
                    getLayout_07 , getLayout_08 , getLayout_09 ;
        }





        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            if (ChildrenData.get(groupPosition) == null){
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

            UserIntegralFragmentFirst.ExpandableAdapter.GetChildViewHolder holder = null;
            if (convertView == null){
                convertView  = LayoutInflater.from(getContext()).inflate(R.layout.user_center_homepage_head_fragment_listview_item_group_second , null);
                holder = new UserIntegralFragmentFirst.ExpandableAdapter.GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.user_center_home_page_head_fragment_listview_item_group_lible_second);
                holder.imageUrl = (ImageView) convertView.findViewById(R.id.user_center_home_page_head_fragment_listview_item_group_imageurl_second);
                convertView.setTag(holder);
            }else {
                holder = (UserIntegralFragmentFirst.ExpandableAdapter.GetChildViewHolder) convertView.getTag();
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



}
