package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.MiChatAddFriendsAdapter;
import com.baicimi.adapter.MiPeopleChatAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MiChatAddFriendsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 加号 添加朋友
 */
public class MiChatAddFriends extends BaseFragment{

    private View view;
    private ListView listViewFirst , listViewSecond;
    private List<MiChatAddFriendsEntry> listFirst = new ArrayList<>();
    private List<MiChatAddFriendsEntry> listSecond = new ArrayList<>();
    private MiChatAddFriendsAdapter adapterFirst , adapterSecond;

    private TextView seekfriends;//搜索好友

    private LinearLayout layoutFirst , layoutSecond;
    private boolean stateLayout = false;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_add_friends , container , false);

        //listview布局填充
        initListView();
        initListViewSecond();
        layoutFirst = (LinearLayout) view.findViewById(R.id.mi_chat_add_friends_layout_first);
        layoutSecond = (LinearLayout) view.findViewById(R.id.mi_chat_add_friends_layout_second);


        seekfriends = (TextView) view.findViewById(R.id.mi_chat_add_friends_seekfriends);
        seekfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateLayout){
                    layoutFirst.setVisibility(View.INVISIBLE);
                    layoutSecond.setVisibility(View.VISIBLE);
                }else{
                    layoutFirst.setVisibility(View.VISIBLE);
                    layoutSecond.setVisibility(View.INVISIBLE);
                }
            }
        });
        return view;
    }

    private void initListViewSecond() {
        listViewSecond = (ListView) view.findViewById(R.id.mi_chat_add_friends_listviewfirst);
        listSecond.clear();
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        listSecond.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        adapterSecond = new MiChatAddFriendsAdapter(listSecond , getContext());
        listViewSecond.setAdapter(adapterSecond);
        fixGridViewHeight(listViewSecond);
    }

    //listview布局填充
    private void initListView() {
        listViewFirst = (ListView) view.findViewById(R.id.mi_chat_add_friends_listviewfirst);
        listFirst.clear();
        listFirst.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_29));
        listFirst.add(new MiChatAddFriendsEntry(R.drawable.mi_people_chat_fragment_image_30 , "angela" , "今天百次幂商城有搞活动了！快点去和我。。。" , R.drawable.mi_people_chat_fragment_image_20));
        adapterFirst = new MiChatAddFriendsAdapter(listFirst , getContext());
        listViewFirst.setAdapter(adapterFirst);
        fixGridViewHeight(listViewFirst);
    }

    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiChatAddFriendsAdapter listAdapter = (MiChatAddFriendsAdapter) listView.getAdapter();
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
