package com.baicimi.fragments;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.NanShiGoodsGvAdapter;
import com.baicimi.adapter.UserCenterHomePageSecondHeadadapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterHeadEntry;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 * 个人中心首页
 * 2017-10-11
 * 王梦阳
 */
public class UserCenterHomePageHeadFragment extends BaseFragment {

    private View view;
    private ListView listView;
    private List<UserCenterHeadEntry> list = new ArrayList<>();
    private UserCenterHomePageHeadAdapter adapter;

    private int celaListview = -1;//侧拉菜单状态


    //下拉菜单问题
    CustomExpandableListView expd_lv;
    UserCenterHomePageHeadFragment.ExpandableAdapter adapters;

    private List<String> GroupData;
    private List<List<String>> ChildrenData;
    private List<List<String>> list_content = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_home_page_head_fragment , container , false);
        //listview布局填充
//        initListView();


        //下拉菜单问题
        expd_lv = (CustomExpandableListView)view.findViewById(R.id.user_center_home_page_head_fragment_expd_lv);
        LoadListData();
        adapters = new UserCenterHomePageHeadFragment.ExpandableAdapter();
        expd_lv.setAdapter(adapters);
        expd_lv.setChildIndicator(null);
//        fixListViewHeight(expd_lv);

        return view;
    }

    //数据源填充
    private void LoadListData() {
        GroupData = new ArrayList<String>();
        GroupData.add("订单中心");
        GroupData.add("资产中心");
        GroupData.add("会员中心");
        GroupData.add("幂聊");
//        GroupData.add("我的生活助手");
//        GroupData.add("百万行动计划");
//        GroupData.add("我的商城");
//        GroupData.add("客户服务");
//        GroupData.add("我的快递");


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
                myText = createViewPull(ChildrenData.get(groupPosition).get(childPosition));
                myText.setMaxLines(1);
                myText.setEllipsize(TextUtils.TruncateAt.END);
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
            myText.setTextSize(14);
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
            return myText;
        }
        private TextView createViewPull(String content) {
            // TODO Auto-generated method stub
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
            TextView myText = new TextView(getContext());
            params.height = 80;
            myText.setLayoutParams(params);
            myText.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT );
            myText.setPadding(90, 0, 0, 0);
            myText.setText(content);
            myText.setTextColor(0xFF8C8C8C);
            myText.setTextSize(14);
            myText.setMaxLines(1);
            myText.setEllipsize(TextUtils.TruncateAt.END);
            myText.setBackgroundColor(Color.parseColor("#eeeeee"));
            return myText;
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
            TextView myText = new TextView(getContext());
            if(convertView != null){
                myText = (TextView) convertView;
                myText.setText(GroupData.get(groupPosition));
            }else{
                myText = createView(GroupData.get(groupPosition));
                myText.setMaxLines(1);
                myText.setEllipsize(TextUtils.TruncateAt.END);
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


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_center_home_page_head_fragment_listview);
        list.clear();
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_01 , "订单中心" , new String[]{"我的订单"  , "团购订单"
                , "亲密付订单"  , "政府采购订单"  , "分期订单"  , "我的拍卖"  , "我的预售" }));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_02 , "资产中心" , new String[]{"幂钱包" , "积分银行"
          , "赚取积分" , "支付管理"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_03 , "会员中心" , new String[]{"我的等级" , "会员积分"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_04 , "幂聊" , new String[]{""}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_05 , "我的生活助手" , new String[]{"亲密付" , "红包"
         , "礼品寄存处", "爱心捐赠", "手机充值", "记账本", "幂额度", "幂信用积分", "信用卡还款", "我的购物袋"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_06 , "百万行动计划" , new String[]{"加入分销点/店" , "我要推荐"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_07 , "我的商城" , new String[]{"我的商城" , "分销入口"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_08 , "客户服务" , new String[]{"购买咨询" , "投诉与建议"}));
        list.add(new UserCenterHeadEntry(R.drawable.user_center_head_image_09 , "我的快递" , new String[]{""}));
        adapter = new UserCenterHomePageHeadAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixListViewHeight(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == celaListview){
                    celaListview = -1;
                }else{
                    celaListview = i;
                }
                adapter.notifyDataSetChanged();
            }
        });

    }
    @Override
    protected void initData() {

    }
    //listview适配器
    public class UserCenterHomePageHeadAdapter extends BaseAdapter{


        private List<UserCenterHeadEntry> list;
        private Context context;
        private LayoutInflater inflater;

        private List<String> secondListview = new ArrayList<>();
        private UserCenterHomePageSecondHeadadapter userCenterHomePageSecondHeadadapter;

        public UserCenterHomePageHeadAdapter(List<UserCenterHeadEntry> list, Context context) {
            this.list = list;
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            UserCenterHomePageHeadFragment.UserCenterHomePageHeadAdapter.UserCenterHeadHolder holder = null;
            if (view == null){
                view = inflater.inflate(R.layout.usercenter_homepage_head_adapter , null);
                holder = new UserCenterHomePageHeadFragment.UserCenterHomePageHeadAdapter.UserCenterHeadHolder();
                holder.imageUrl = (ImageView) view.findViewById(R.id.usercneter_homepage_head_adapater_listview_image);
                holder.lible = (TextView) view.findViewById(R.id.usercneter_homepage_head_adapater_name);
                holder.listView = (ListView) view.findViewById(R.id.cela_usercneter_homepage_head_adapater_lv);
                holder.pull_layout = (LinearLayout) view.findViewById(R.id.usercneter_homepage_head_adapater_lv);
                view.setTag(holder);
            }else{
                holder = (UserCenterHomePageHeadFragment.UserCenterHomePageHeadAdapter.UserCenterHeadHolder) view.getTag();
            }
            UserCenterHeadEntry init = (UserCenterHeadEntry) getItem(i);

            holder.imageUrl.setImageResource(init.getImageUrl());
            holder.lible.setText(init.getLible());

            //二级listview子菜单布局填充

            holder.pull_layout.setVisibility(i == celaListview ? View.VISIBLE : View.GONE);

            secondListview.clear();
            for (int l = 0 ;  l < init.getListContent().length ; l++){
                secondListview.add(init.getListContent()[l]);
            }
            userCenterHomePageSecondHeadadapter = new UserCenterHomePageSecondHeadadapter(secondListview , context);
            holder.listView.setAdapter(userCenterHomePageSecondHeadadapter);
            fixListViewHeightSecond(holder.listView);
            return view;
        }

        public class UserCenterHeadHolder{
            private ImageView imageUrl;
            private TextView lible;
            private ListView listView;
            private LinearLayout pull_layout;
        }
    }

    //动态计算listview的高度
    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageHeadAdapter listAdapter = (UserCenterHomePageHeadAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    //动态计算listview的高度
    public void fixListViewHeightSecond(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterHomePageSecondHeadadapter listAdapter = (UserCenterHomePageSecondHeadadapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
