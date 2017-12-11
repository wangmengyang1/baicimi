package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MiChatInviteFriendsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MiChatAddFriendsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 邀请朋友赢积分页面
 */
public class MiChatInviteFriends extends BaseFragment{

    private View view;

    private ListView listViewFirst , listViewSecond;
    private List<MiChatAddFriendsEntry> listFirst = new ArrayList<>();
    private List<MiChatAddFriendsEntry> listSecond = new ArrayList<>();
    private MiChatInviteFriendsAdapter adapterFirst , adapterSecond;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_invite_friends , container , false);

        //listview布局填充
        initListView();
        initListViewSecond();

        return view;
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.mi_chat_invite_friends_listviewsecond);
        listSecond.clear();
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        adapterSecond = new MiChatInviteFriendsAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixGridViewHeight(listViewSecond);
    }

    //listview布局填充
    private void initListView() {
        listViewFirst = (ListView) view.findViewById(R.id.mi_chat_invite_friends_listviewfirst);
        listFirst.clear();
        listFirst.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        listFirst.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        adapterFirst = new MiChatInviteFriendsAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
        fixGridViewHeight(listViewFirst);
    }

    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiChatInviteFriendsAdapter listAdapter = (MiChatInviteFriendsAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 24;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getHeight() * (listAdapter.getCount() - 1)+10);
        listView.setLayoutParams(params);
//        System.out.println(girdViewHeight + "_______________________________");
    }


    @Override
    protected void initData() {

    }
}
