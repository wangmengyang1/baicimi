package com.baicimi.fragments;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/30.
 * 其他问题界面
 */
public class QiTaWenTiFragment extends BaseFragment{
    ExpandableListView expd_lv;
    ExpandableAdapter adapter;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_wenti, container, false);
        expd_lv = (ExpandableListView) view.findViewById(R.id.expd_lv);
        LoadListData();
        adapter = new ExpandableAdapter();
        expd_lv.setAdapter(adapter);
        expd_lv.setChildIndicator(null);
        initView();
        return view;
    }

    private void LoadListData() {
        // TODO Auto-generated method stub
        GroupData = new ArrayList<String>();
        GroupData.add("我的钱包");
        GroupData.add("我的卡券");
        GroupData.add("账户问题");
        GroupData.add("投诉与建议");

        ChildrenData = new ArrayList<List<String>>();
        List<String> child1 = new ArrayList<String>();
        child1.add("账户余额怎么提现");
        child1.add("积分怎么提现");
        child1.add("提现超出时效没有到账怎么办");
        child1.add("如何使用积分支付");
        ChildrenData.add(child1);
        List<String> child2 = new ArrayList<String>();
        child2.add("积分");
        child2.add("积分激活问题");
        ChildrenData.add(child2);
        List<String> child3 = new ArrayList<String>();
        child3.add("有绑定手机找回钱包密码方式");
        child3.add("如何结算");
        child3.add("修改绑定手机");
        child3.add("如何注册成为会员");
        child3.add("注册失败");
        child3.add("微信登录后原油账户信息怎么不见了");
        child3.add("使用手机号码注册不了新账户");
        ChildrenData.add(child3);
        List<String> child4 = new ArrayList<String>();
        child3.add("正品问题");
        child3.add("反馈商品质量差");
        child3.add("相同商品不同时期价格不同");
        child3.add("建议反馈");
        ChildrenData.add(child4);
    }


    private void initView() {
        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startFragment(new WenTiDetailsFragment(ChildrenData.get(groupPosition).get(childPosition)), null);
                return true;
            }
        });
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
            TextView myText = null;
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(ChildrenData.get(groupPosition).get(childPosition));
            } else {
                myText = createView(ChildrenData.get(groupPosition).get(childPosition));
            }
            return myText;
        }

        private TextView createView(String content) {
            // TODO Auto-generated method stub
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
            TextView myText = new TextView(getContext());
            myText.setLayoutParams(params);
            myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            myText.setPadding(90, 0, 0, 0);
            myText.setText(content);
            myText.setTextColor(0xFF8C8C8C);
            myText.setTextSize(15);
            return myText;
        }


        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
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
            TextView myText = new TextView(getContext());
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(GroupData.get(groupPosition));
            } else {
                myText = createView(GroupData.get(groupPosition));
            }
            return myText;
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
