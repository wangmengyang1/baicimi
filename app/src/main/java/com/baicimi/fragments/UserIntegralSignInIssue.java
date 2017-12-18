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
import com.baicimi.entity.UserIntegralSignInRecommendEntry;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 个人中心首页fragment 发布所得
 */
public class UserIntegralSignInIssue extends BaseFragment implements View.OnClickListener {

    private View view;

    private CustomExpandableListView expandableListView;
    private ExpandableAdapter adapters;

    private List<UserIntegralSignInRecommendEntry> GroupData = new ArrayList<>();
    private List<List<View>> ChildrenData = new ArrayList<>();

    private ImageView back;



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_integral_sign_in_issue , container , false);


        expandableListView = (CustomExpandableListView)view.findViewById(R.id.user_integral_sign_in_issue_exp_listview);
        LoadListData();
        adapters = new ExpandableAdapter();
        expandableListView.setAdapter(adapters);
        expandableListView.setChildIndicator(null);
        expandableListView.setGroupIndicator(null);

        back = (ImageView) view.findViewById(R.id.user_integral_sign_in_issue_back);
        back.setOnClickListener(this);

        return view;
    }


    //数据源填充
    private void LoadListData() {



        GroupData.add(new UserIntegralSignInRecommendEntry("2017.08.25" , "文章      《我的一天》"));
        GroupData.add(new UserIntegralSignInRecommendEntry("2017.08.25" , "文章      《我的旅途》"));
        GroupData.add(new UserIntegralSignInRecommendEntry("2017.08.25" , "图片      无标题"));
        GroupData.add(new UserIntegralSignInRecommendEntry("2017.08.25" , "图片      《我的自拍》"));
        GroupData.add(new UserIntegralSignInRecommendEntry("2017.08.25" , "图片      无标题"));


        List<View> list_child1 = new ArrayList<>();
        list_child1.add(LayoutInflater.from(getContext()).inflate(R.layout.user_integral_sign_in_issue_firat , null));
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);
        ChildrenData.add(list_child1);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_integral_sign_in_issue_back:
                ((MainActivity)getActivity()).goBack();
                break;
        }
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


            ExpandableAdapter.GetGroupViewHolder holder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_sign_int_recommend_child_firat , null);
                holder = new ExpandableAdapter.GetGroupViewHolder();

                convertView.setTag(holder);
            }else{
                holder = (ExpandableAdapter.GetGroupViewHolder) convertView.getTag();
            }



            return convertView;
        }


        private class GetChildViewHolder{
            private TextView date;
            private TextView lible;
        }

        private class GetGroupViewHolder{
            private TextView date;
            private TextView lible;
        }





        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub

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

            GetChildViewHolder holder = null;
            if (convertView == null){
                convertView  = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_sign_in_recommend_group , null);
                holder = new GetChildViewHolder();
                holder.date = (TextView) convertView.findViewById(R.id.user_integral_sign_in_recommend_group_date);
                holder.lible= (TextView) convertView.findViewById(R.id.user_integral_sign_in_recommend_group_lible);
                convertView.setTag(holder);
            }else {
                holder = (GetChildViewHolder) convertView.getTag();
            }

            holder.date.setText(GroupData.get(groupPosition).getDate());
            holder.lible.setText(GroupData.get(groupPosition).getLible());


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
