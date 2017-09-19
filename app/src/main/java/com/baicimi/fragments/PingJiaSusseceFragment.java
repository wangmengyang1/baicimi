package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.ShaiDanPingJiaListAdapter;
import com.baicimi.adapter.ShaiXuanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiDnaPingJiaListBean;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/9/29.
 * 评价成功界面
 */
public class PingJiaSusseceFragment extends BaseFragment {
    private MyListView mList;
    private ArrayList<ShaiDnaPingJiaListBean> arrayList;
    private ShaiDanPingJiaListAdapter xuanListAdapter;
    final ShaiDnaPingJiaListBean shaiXuanListBean_list = new ShaiDnaPingJiaListBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_shaidan_success, container, false);
        mList = (MyListView) view.findViewById(R.id.pingjia_list);

        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shaiXuanListBean_list.setTv_shaidan_goods_message("正品韩国品驰长效补水保湿玻尿酸能量面膜蚕丝弹力女士祛痘抗辐射");
            arrayList.add(shaiXuanListBean_list);
        }
        xuanListAdapter = new ShaiDanPingJiaListAdapter(getActivity(), arrayList);
        mList.setAdapter(xuanListAdapter);

        return view;
    }

    @OnClick({R.id.login_back})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.login_back:
                ((MainActivity) getActivity()).goBack();//返回上一层页面
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
