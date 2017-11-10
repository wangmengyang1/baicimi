package com.baicimi.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ChildViewListViewAdapter;
import com.baicimi.adapter.MyustagesAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.ChildViewListViewEntry;
import com.baicimi.ui.OnDrawingException;
import com.baicimi.view.CustomExpandableListView;
import com.baicimi.view.RingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 * 个人中心  首页 资产中心  幂钱包  我的积分
 */
public class MiWalldtMyCodeFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private CustomExpandableListView customExpandableListView;
    public List<String> grouplist = new ArrayList<>();
    private List<List<View>> childlist = new ArrayList<>();
    private MiWalldtMyCodeCutListView miWalldtMyCodeCutListView;

    private List<ChildViewListViewEntry> listChildLV = new ArrayList<>();
    private ChildViewListViewAdapter adapterChildLv;

    private ImageView back;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_wallet_my_code_fragment, container, false);

        //下拉菜单布局填充
        initShowCusListView();

        back = (ImageView) view.findViewById(R.id.mi_wallet_my_code_fragment_back);
        back.setOnClickListener(this);

        return view;
    }

    //下拉菜单布局填充
    private void initShowCusListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.mi_wallet_my_code_fragment_customlistview);
        //数据填充
        initList();

        miWalldtMyCodeCutListView = new MiWalldtMyCodeCutListView();
        customExpandableListView.setAdapter(miWalldtMyCodeCutListView);
        customExpandableListView.setGroupIndicator(null);
    }

    //下拉菜单数据填充
    private void initList() {
        grouplist.clear();
        grouplist.add("我的积分");
        grouplist.add("收入/支出分析");
        grouplist.add("积分获得分析");
        grouplist.add("积分支出分析");
        grouplist.add("积分明细");
        grouplist.add("积分兑换");

        List<View> childViewItem01 = new ArrayList<>();
        childViewItem01.add(LayoutInflater.from(getContext()).inflate(R.layout.user_integral_fragment , null));
        List<View> childViewItem02 = new ArrayList<>();
        childViewItem02.add(LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_second , null));
        List<View> childViewItem03 = new ArrayList<>();
        childViewItem03.add(LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_thread, null));
        List<View> childViewItem04 = new ArrayList<>();
        childViewItem04.add(LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_four, null));
        List<View> childViewItem05 = new ArrayList<>();
        childViewItem05.add(LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_five, null));
        List<View> childViewItem06 = new ArrayList<>();
        childViewItem06.add(LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_six, null));
        childlist.clear();
        childlist.add(childViewItem01);
        childlist.add(childViewItem02);
        childlist.add(childViewItem03);
        childlist.add(childViewItem04);
        childlist.add(childViewItem05);
        childlist.add(childViewItem06);

        listChildLV.clear();
        listChildLV.add(new ChildViewListViewEntry( "2016.01.10", "关联好友在百次幂商城一次性购物满1000元均有好礼相赠" ,"+3000.00" ));
        listChildLV.add(new ChildViewListViewEntry( "2016.01.10", "关联好友在百次幂商城一次性购物满1000元均有好礼相赠" ,"+3000.00" ));
        listChildLV.add(new ChildViewListViewEntry( "2016.01.10", "关联好友在百次幂商城一次性购物满1000元均有好礼相赠" ,"+3000.00" ));
        listChildLV.add(new ChildViewListViewEntry( "2016.01.10", "关联好友在百次幂商城一次性购物满1000元均有好礼相赠" ,"+3000.00" ));
        adapterChildLv = new ChildViewListViewAdapter(listChildLV , getContext());
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mi_wallet_my_code_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }

    public class MiWalldtMyCodeCutListView extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return grouplist.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return childlist.get(i).size();
        }

        @Override
        public Object getGroup(int i) {
            return grouplist.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return childlist.get(i).get(i1);
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
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            MiWalldtMyCodeGroupHolder holder = null;
            if (view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.miwalldt_mycode_fragment_group , null);
                holder = new MiWalldtMyCodeGroupHolder();
                holder.lible = (TextView) view.findViewById(R.id.miwalldt_my_code_fragment_group_lible);
                view.setTag(holder);
            }else{
                holder = (MiWalldtMyCodeGroupHolder) view.getTag();
            }

            holder.lible.setText(getGroup(i).toString());

            return view;
        }

        public class MiWalldtMyCodeGroupHolder{
            private TextView lible;
        }


        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            GetGroupViewHolder holderFirst = null;
            ListviewViewFiveHolder holderFive = null;
            if (i == 0){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.user_integral_fragment , null);
                    holderFirst = new GetGroupViewHolder();
                    holderFirst.ringView = (RingView) view.findViewById(R.id.user_integral_fragmentringview);
                    view.setTag(holderFirst);
                }
                holderFirst.ringView.setColors(new int[]{Color.parseColor("#2a8fd3"),Color.parseColor("#f15f48"), Color.parseColor("#2ac770")
                        , Color.parseColor("#f1c40f"),Color.parseColor("#2ac770"),Color.parseColor("#9a59b5") , Color.parseColor("#2ac770"),Color.parseColor("#f15f48")});
                holderFirst.ringView.setValues(new int[]{33, 27, 18, 10,10 , 10 ,  7,5});

                try {
                    holderFirst.ringView.startDraw();
                } catch (OnDrawingException e) {
                    e.printStackTrace();
                }
                return view;

            }else if (i == 1){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_second , null);
                }
                return view;
            }else if (i == 2){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_thread , null);
                }
                return view;
            }else if (i == 3){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_four , null);
                }
                return view;
            }else if (i == 4){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_five , null);
                    holderFive = new ListviewViewFiveHolder();
                    holderFive.listview = (ListView) view.findViewById(R.id.cuslistview_child_view_item_five_listview);
                    view.setTag(holderFive);
                }

                if (adapterChildLv != null){
                    holderFive.listview.setAdapter(adapterChildLv);
                    fixGrdiViewHeight03(holderFive.listview);
                }
                return view;

            }else if (i == 5){
                view = null;
                if (view == null){
                    view = LayoutInflater.from(getContext()).inflate(R.layout.cuslistview_child_view_item_six , null);
                }
                return view;
            }

            return null;
        }




        private class GetGroupViewHolder{
            private RingView ringView;
        }

        private class ListviewViewFiveHolder{
            private ListView listview;
        }


        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ChildViewListViewAdapter listAdapter = (ChildViewListViewAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            totalHeight += 20;//manger上下高度和
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
