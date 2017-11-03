package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.UserCenterMessageCenterAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterMessageCenterEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 * 个人中心  消息  消息中心
 */
public class UserCenterMessageCenter extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<UserCenterMessageCenterEntry> list = new ArrayList<>();
    private UserCenterMessageCenterAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_message_center , container , false);
        back = (ImageView) view.findViewById(R.id.usecenter_message_center_back);
        back.setOnClickListener(this);

        //listview布局填充
        initListView();

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_center_message_center_listview);
        list.clear();
        list.add(new UserCenterMessageCenterEntry(R.drawable.image_convertion_06 , "系统" , "推荐好友逾期未注册通知------" , "亲爱的，我已经开通亲密付了，你也开通吧，以后可以一起购物，享受更多优惠啦，赶紧一起去选购更多商品吧。" , "8月18日" , true));
        list.add(new UserCenterMessageCenterEntry(R.drawable.image_convertion_06 , "系统" , "推荐好友逾期未注册通知------" , "亲爱的，我已经开通亲密付了，你也开通吧，以后可以一起购物，享受更多优惠啦，赶紧一起去选购更多商品吧。" , "8月18日" , true));
        list.add(new UserCenterMessageCenterEntry(R.drawable.image_convertion_06 , "系统" , "推荐好友逾期未注册通知------" , "亲爱的，我已经开通亲密付了，你也开通吧，以后可以一起购物，享受更多优惠啦，赶紧一起去选购更多商品吧。" , "8月18日" , true));
        list.add(new UserCenterMessageCenterEntry(R.drawable.image_convertion_06 , "系统" , "推荐好友逾期未注册通知------" , "亲爱的，我已经开通亲密付了，你也开通吧，以后可以一起购物，享受更多优惠啦，赶紧一起去选购更多商品吧。" , "8月18日" , true));
        adapter = new UserCenterMessageCenterAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);
    }



    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterMessageCenterAdapter listAdapter = (UserCenterMessageCenterAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += 20;
            totalHeight += listViewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usecenter_message_center_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;

        }
    }
}
