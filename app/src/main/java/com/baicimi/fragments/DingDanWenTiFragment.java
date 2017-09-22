package com.baicimi.fragments;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/30.
 * 订单问题界面
 */
public class DingDanWenTiFragment extends BaseFragment{

    ExpandableListView expd_lv;
    ExpandableAdapter adapter;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_wenti,container,false);
        expd_lv = (ExpandableListView)view.findViewById(R.id.expd_lv);
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
        GroupData.add("物流配送");
        GroupData.add("售货咨询");
        GroupData.add("退款问题");
        GroupData.add("退货换货");


        ChildrenData = new ArrayList<List<String>>();

        List<String> child1 = new ArrayList<String>();
        child1.add("物流配送");
        child1.add("物流配送");
        child1.add("物流配送");
        child1.add("物流配送");
        ChildrenData.add(child1);
        List<String> child2 = new ArrayList<String>();
        child2.add("发货时间");
        child2.add("包裹到哪了");
        child2.add("修改收货地址/手机号码");
        child2.add("偏远地区是否送到");
        ChildrenData.add(child2);
        List<String> child3 = new ArrayList<String>();
        child3.add("退货后什么时候退款");
        child3.add("拒收包裹后什么时候退款");
        child3.add("发货运费退不退回");
        child3.add("信用卡退款到账时效");
        ChildrenData.add(child3);
        List<String> child4 = new ArrayList<String>();
        child4.add("如何办理退货");
        child4.add("换货运费问题");
        child4.add("不同订单退货嫩个一起寄回吗");
        child4.add("可以换货吗");
        ChildrenData.add(child4);
    }


    private void initView() {
        expd_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                startFragment(new WenTiDetailsFragment(ChildrenData.get(groupPosition).get(childPosition)),null);
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
            if(convertView != null){
                myText = (TextView) convertView;
                myText.setText(ChildrenData.get(groupPosition).get(childPosition));
            }else{
                myText = createView(ChildrenData.get(groupPosition).get(childPosition));
            }
            return myText;
        }

        private TextView createView(String content) {
            // TODO Auto-generated method stub
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
            TextView myText = new TextView(getContext());
            myText.setLayoutParams(params);
            myText.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT );
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
            if(convertView != null){
                myText = (TextView) convertView;
                myText.setText(GroupData.get(groupPosition));
            }else{
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
