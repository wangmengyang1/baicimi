package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.PaymentAdencyGovernmentCusListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.PaymentAdencyGovernmentCusEntry;
import com.baicimi.view.CustomExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 * 幂积分银行   我的财富
 */
public class MiIntegralBrankMyTreasureFragment extends BaseFragment {

    private View view;

    //下拉菜单布局添加
    private CustomExpandableListView customExpandableListView;
    private List<String> gruopList = new ArrayList<>();
    private List<List<View>> childList = new ArrayList<>();
    private PaymentAdencyGovernmentCusAdaapter adencyGovernmentCusAdaapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_integral_brank_my_treasure_fragment , container , false);


        //下拉菜单布局添加
        initCusListView();
        return view;
    }

    //下拉菜单布局添加
    private void initCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.mi_integral_brank_my_treasure_fragment_cusendlistview);
        customExpandableListView.setGroupIndicator(null);
        gruopList.clear();
        gruopList.add("资产总览");
        gruopList.add("银行卡管理");
        gruopList.add("储蓄管理");
        gruopList.add("投资管理");
        gruopList.add("资产清单");



        List<View> list_01 = new ArrayList<>();
        list_01.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfirst, null));
        List<View> list_02 = new ArrayList<>();
        list_02.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childsecond, null));
        List<View> list_03 = new ArrayList<>();
        list_03.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childthread, null));
        List<View> list_04 = new ArrayList<>();
        list_04.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfour, null));
        List<View> list_05 = new ArrayList<>();
        list_05.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfive, null));

        childList.add(list_01);
        childList.add(list_02);
        childList.add(list_03);
        childList.add(list_04);
        childList.add(list_05);

        adencyGovernmentCusAdaapter = new PaymentAdencyGovernmentCusAdaapter();
        customExpandableListView.setAdapter(adencyGovernmentCusAdaapter);
    }




    public class PaymentAdencyGovernmentCusAdaapter extends BaseExpandableListAdapter {


        @Override
        public int getGroupCount() {
            return gruopList.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return 1;
        }

        @Override
        public Object getGroup(int i) {
            return gruopList.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return childList.get(i).get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            PaymentAdencyGovernmentCusGroupHolder holder = null;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_fragmetn, null);
                holder = new PaymentAdencyGovernmentCusGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.mi_integral_brank_fragment_lible);
                view.setTag(holder);
            } else {
                holder = (PaymentAdencyGovernmentCusGroupHolder) view.getTag();
            }

            holder.lible.setText(gruopList.get(i));

            return view;
        }

        //标题holder
        public class PaymentAdencyGovernmentCusGroupHolder {
            private TextView lible;
            private TextView conbtent;
        }


        @Override
        public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
            view = null;
            if (i == 0){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfirst , null);
            }else if (i == 1){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childsecond , null);
            }else if (i == 2){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childthread , null);
            }else if (i == 3){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfour , null);
            }else if (i == 4){
                view = LayoutInflater.from(getContext()).inflate(R.layout.mi_integral_brank_my_treasure_fragment_childfive , null);
                //listview布局填充
                initChildListView(view);
            }

            return view;

        }

        private void initChildListView(View view) {
            ListView listview = (ListView) view.findViewById(R.id.mi_integral_brank_my_treasure_fragment_childfive_listview);
            List<PaymentAdencyGovernmentCusEntry> list = new ArrayList<>();
            list.add(new PaymentAdencyGovernmentCusEntry("2017.08.09" , "提现" , "¥200" , "交易成功"));
            list.add(new PaymentAdencyGovernmentCusEntry("2017.08.09" , "储蓄" , "5000积分" , "交易成功"));
            list.add(new PaymentAdencyGovernmentCusEntry("2017.08.09" , "转账" , "1000积分" , "交易成功"));
            list.add(new PaymentAdencyGovernmentCusEntry("2017.08.09" , "购买" , "10000积分" , "交易成功"));
            PaymentAdencyGovernmentCusListAdapter adapter = new PaymentAdencyGovernmentCusListAdapter(list , getContext());
            listview.setAdapter(adapter);
            fixGrdiViewHeight03(listview);
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
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        PaymentAdencyGovernmentCusListAdapter listAdapter = (PaymentAdencyGovernmentCusListAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
