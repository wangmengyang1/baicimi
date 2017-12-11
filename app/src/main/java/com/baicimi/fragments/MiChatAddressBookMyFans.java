package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MiChatGroupEntry;
import com.baicimi.view.CustomExpandableListView;
import com.baicimi.view.RingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 通讯录 我的朋友
 */
public class MiChatAddressBookMyFans extends BaseFragment{

    private View view;

    private CustomExpandableListView customExpandableListView;
    private List<MiChatGroupEntry> listGroup = new ArrayList<>();
    private List<List<View>> listChiled = new ArrayList<>();
    private MiChatAddressBookMyFans.ExpandableAdapter adapter;

    private LinearLayout layoutFirst;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_address_book_myfans , container , false);


        //下拉菜单布局添加
        initExpandableListView();

        layoutFirst = (LinearLayout) view.findViewById(R.id.mi_chat_address_book_myfans_layoutfirst);

        return view;
    }


    //下拉菜单布局添加
    private void initExpandableListView() {
        customExpandableListView = (CustomExpandableListView) view.findViewById(R.id.mi_chat_address_book_myfans_customlistview);
        customExpandableListView.setChildIndicator(null);
        customExpandableListView.setGroupIndicator(null);
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "新的朋友"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "群聊"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "幂友"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "幂好友"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "企业"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "品牌"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "美食"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "旅游"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "我的快递"));
        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "我的消息"));
//        listGroup.add(new MiChatGroupEntry(R.drawable.foot_paint_fragment_checkbox_select_17 , "客服咨询"));


        listChiled.clear();
        List<View> listchiled01 = new ArrayList<>();
        listchiled01.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_chat_address_book_fragment_chiled_one , null));
//        listchiled01.add(LayoutInflater.from(getContext()).inflate(R.layout.mi_chat_fragment_chiled_one , null));
        List<View> listchiled02 = new ArrayList<>();
        List<View> listchiled03 = new ArrayList<>();
        List<View> listchiled04 = new ArrayList<>();
        List<View> listchiled05 = new ArrayList<>();
        List<View> listchiled06 = new ArrayList<>();
        List<View> listchiled07 = new ArrayList<>();
        List<View> listchiled08 = new ArrayList<>();
        List<View> listchiled09 = new ArrayList<>();
        List<View> listchiled10 = new ArrayList<>();
//        List<View> listchiled11 = new ArrayList<>();
        listChiled.add(listchiled01);
        listChiled.add(listchiled02);
        listChiled.add(listchiled03);
        listChiled.add(listchiled04);
        listChiled.add(listchiled05);
        listChiled.add(listchiled06);
        listChiled.add(listchiled07);
        listChiled.add(listchiled08);
        listChiled.add(listchiled09);
        listChiled.add(listchiled10);
//        listChiled.add(listchiled11);

        adapter = new MiChatAddressBookMyFans.ExpandableAdapter();
        customExpandableListView.setAdapter(adapter);
    }



    private class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return listChiled.get(groupPosition);
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
            convertView = null;
            TextView manager = null;
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.mi_chat_address_book_fragment_chiled_one , null);
                manager = (TextView) convertView.findViewById(R.id.mi_chat_address_book_fragment_chiled_one_manager);
            }

            manager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    customExpandableListView.setVisibility(View.INVISIBLE);
                    layoutFirst.setVisibility(View.VISIBLE);
                }
            });
            

            return convertView;
        }


        private class GetChildViewHolder{
            private TextView textViews;
            private ImageView imageUrl;
            private View textview_v;
        }

        private class GetGroupViewHolder{
            private RingView ringView;
        }





        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            if (groupPosition == 2){
                return 1;
            }
            return 0;
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return listGroup.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return listGroup.size();
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

            MiChatAddressBookMyFans.ExpandableAdapter.GetChildViewHolder holder = null;

            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.mi_chat_fragment_listgroup , null);
                holder = new MiChatAddressBookMyFans.ExpandableAdapter.GetChildViewHolder();
                holder.textViews = (TextView) convertView.findViewById(R.id.mi_chat_fragment_listgroup_lible);
                convertView.setTag(holder);
            }else{
                holder = (MiChatAddressBookMyFans.ExpandableAdapter.GetChildViewHolder) convertView.getTag();
            }


            holder.textViews.setText(listGroup.get(groupPosition).getLible());


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
