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
 * 购物问题界面
 */
public class GouWuWenTiFragment extends BaseFragment {
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
        GroupData.add("订单修改");
        GroupData.add("选购商品");
        GroupData.add("结算支付");
        GroupData.add("活动咨询");

        ChildrenData = new ArrayList<List<String>>();
        List<String> child1 = new ArrayList<String>();
        child1.add("取消订单");
        child1.add("合并订单");
        child1.add("下单后看不到订单");
        child1.add("订单提交后显示为待审核状态");
        child1.add("修改商品尺码/数量");
        child1.add("修改订单地址/电话");
        child1.add("修改历史收货地址");
        child1.add("如何操作换货");
        ChildrenData.add(child1);
        List<String> child2 = new ArrayList<String>();
        child2.add("正品问题");
        child2.add("拒收包裹后什么时候退款");
        child2.add("相同商品不同时期价格不一");
        child2.add("商品材料/资料");
        ChildrenData.add(child2);
        List<String> child3 = new ArrayList<String>();
        child3.add("支持哪些支付方式");
        child3.add("如何结算");
        child3.add("如何使用礼券");
        child3.add("支付不成功订单重新支付");
        child3.add("支付安全赔付说明");
        ChildrenData.add(child3);
        List<String> child4 = new ArrayList<String>();
        child3.add("活动问题反馈");
        child3.add("更多活动咨询");
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
