package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.JingCaiSaysListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.MiYouQuanBean;
import com.baicimi.ui.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/10.
 * 精彩文章界面
 */
public class JingCaiSaysFragment extends BaseFragment{
    private ListView mlist;
    private List<MiYouQuanBean> listBeen;
    private JingCaiSaysListAdapter xuanGvAdapter;
    final MiYouQuanBean miYouQuanBean=new MiYouQuanBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_jingcai_says,container,false);
        mlist= (ListView) view.findViewById(R.id.jingcai_says_list);

        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            miYouQuanBean.setZhuanfa_time("人生就像一杯茶，会苦一阵子，但不会苦一辈子");
            listBeen.add(miYouQuanBean);
        }
        xuanGvAdapter=new JingCaiSaysListAdapter(getActivity(),listBeen);
        mlist.setAdapter(xuanGvAdapter);

        return view;
    }

    @Override
    protected void initData() {
    }
}
