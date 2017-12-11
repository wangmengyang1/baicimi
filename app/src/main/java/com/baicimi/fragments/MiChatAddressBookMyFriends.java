package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MiChatAddFriendsAdapter;
import com.baicimi.adapter.MiChatAddressBookMyFriendsAdapter;
import com.baicimi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 通讯录 我的粉丝
 */
public class MiChatAddressBookMyFriends extends BaseFragment{

    private View view;

    private ListView listView;
    private List<MiChatAddressBookMyFriendsEntry> list = new ArrayList<>();
    private MiChatAddressBookMyFriendsAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_friends_circle , container , false);

        //listview 布局填充
        initListView();
        return view;
    }

    //listview 布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.mi_chat_friends_circle_listviewfirst);
        list.clear();
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_31));
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        list.add(new MiChatAddressBookMyFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        adapter = new MiChatAddressBookMyFriendsAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGridViewHeight(listView);
    }

    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiChatAddressBookMyFriendsAdapter listAdapter = (MiChatAddressBookMyFriendsAdapter) listView.getAdapter();
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
