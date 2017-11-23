package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.adapter.UserCenterRedPacketAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.UserCenterRedPacketEntry;
import com.baicimi.view.RedPacketSharedDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 * 个人中心首页  我的生活助手  红包首页
 */
public class UserCenterRedPacketFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ListView listView;
    private List<UserCenterRedPacketEntry> list = new ArrayList<>();
    private UserCenterRedPacketAdapter adapter;
    private boolean isCheck;
    private TextView cash , code , giveredenvelopes;
    private LinearLayout shardlayout;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.user_center_red_packet_fragment , container , false);

        //listview布局填充
        initListView();

        cash = (TextView) view.findViewById(R.id.user_center_red_packet_fragment_cash);
        cash.setOnClickListener(this);
        code = (TextView) view.findViewById(R.id.user_center_red_packet_fragment_code);
        code.setOnClickListener(this);

        giveredenvelopes = (TextView) view.findViewById(R.id.user_center_red_packet_fragment_giveredenvelopes);
        giveredenvelopes.setOnClickListener(this);

        shardlayout = (LinearLayout) view.findViewById(R.id.user_center_red_packet_fragment_shardlayout);
        shardlayout.setOnClickListener(this);

        return view;
    }

    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.user_center_red_packet_fragment_listview);
        list.clear();
        list.add(new UserCenterRedPacketEntry("年轻不留白" , "2017.08.20" , "38.80元"));
        list.add(new UserCenterRedPacketEntry("小妖精" , "2017.08.20" , "328.80元"));
        list.add(new UserCenterRedPacketEntry("帅哥哥" , "2017.08.20" , "1138.80元"));
        list.add(new UserCenterRedPacketEntry("该来的总会来" , "2017.08.20" , "58.80元"));

        adapter = new UserCenterRedPacketAdapter(list , getContext());
        listView.setAdapter(adapter);
        fixGrdiViewHeight03(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //发红包说说
                startFragment(new RedPacketGetthedetailsSecond());
            }
        });

    }


    //动态计算GridView的高度
    public void fixGrdiViewHeight03(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        UserCenterRedPacketAdapter listAdapter = (UserCenterRedPacketAdapter) listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }

        for (int index = 0; index < (listAdapter.getCount()); index++) {
            View listViewItem = listAdapter.getView(index, null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight+=20;
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
            case R.id.user_center_red_packet_fragment_cash:
                if (isCheck){
                    isCheck = false;
                }
                break;
            case R.id.user_center_red_packet_fragment_code:
                if (!isCheck){
                    isCheck = true;
                }
                break;

            case R.id.user_center_red_packet_fragment_giveredenvelopes:
                if (isCheck){
                    //现金红包
                    startFragment(new UserCneterRedPacketFirst());
                }else{
                    //积分红包
                    startFragment(new UserCneterRedPacketSecond());
                }
                break;
            case R.id.user_center_red_packet_fragment_shardlayout:
                //分享页面
                RedPacketSharedDialog redpacketSD = new RedPacketSharedDialog(getContext() , R.style.MeiGuiMeiShiSecondMyorderFive);
                redpacketSD.show();
                break;
        }
    }
}
