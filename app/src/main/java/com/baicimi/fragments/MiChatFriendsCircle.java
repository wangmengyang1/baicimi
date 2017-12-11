package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.MiChatFriendsCircleAdapter;
import com.baicimi.adapter.MiChatInviteFriendsAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MiChatFriendsCircleEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 * 个人中心首页 幂聊首页 幂友圈
 */
public class MiChatFriendsCircle extends BaseFragment{

    private View view;
    private ListView listView;
    private List<MiChatFriendsCircleEntry> list = new ArrayList<>();
    private MiChatFriendsCircleAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.mi_chat_friends_circle , container , false);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.mi_chat_friends_circle_listviewfirst);
        list.clear();
        list.add(new MiChatFriendsCircleEntry(R.drawable.mi_chat_friends_circle_image_01 , 0 , "全五分，发货速度超快，正品无疑！价格再优惠些就好了，嘻嘻！打开包装盒看到里面的填充物好可爱，泡沫球球，突然想吃棉花糖和爆米花了！" , "昨天19:20 来自生活汇" , R.drawable.mi_people_chat_fragment_image_30 , "w****f(匿名)" , "GuangZhou,China"));
        list.add(new MiChatFriendsCircleEntry(R.drawable.mi_chat_friends_circle_image_01 , 0 , "全五分，发货速度超快，正品无疑！价格再优惠些就好了，嘻嘻！打开包装盒看到里面的填充物好可爱，泡沫球球，突然想吃棉花糖和爆米花了！" , "昨天19:20 来自生活汇" , R.drawable.mi_people_chat_fragment_image_30 , "w****f(匿名)" , "GuangZhou,China"));
        adapter = new MiChatFriendsCircleAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGridViewHeight(listView);
    }

    //动态计算listview的高度
    public void fixGridViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        MiChatFriendsCircleAdapter listAdapter = (MiChatFriendsCircleAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < listAdapter.getCount(); index++) {
            View listViewItem = listAdapter.getView(index , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 40;
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
