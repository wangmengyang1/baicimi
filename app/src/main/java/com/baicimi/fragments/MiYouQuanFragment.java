package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.JingCaiSaysListAdapter;
import com.baicimi.adapter.MiYouQuanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.MiYouQuanBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tan on 2016/10/10.
 * 幂友圈界面
 */
public class MiYouQuanFragment extends BaseFragment{
    private ListView mlist;
    private List<MiYouQuanBean> listBeen;
    private MiYouQuanListAdapter miYouQuanListAdapter;
    final MiYouQuanBean miYouQuanBean=new MiYouQuanBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_miyouquan,container,false);
        mlist= (ListView) view.findViewById(R.id.miyouqan_list);

        listBeen=new ArrayList<>();
        for (int i=0;i<3;i++){
            miYouQuanBean.setZhuanfa_time("33分钟前");
            listBeen.add(miYouQuanBean);
        }
        miYouQuanListAdapter=new MiYouQuanListAdapter(getActivity(),listBeen);
        mlist.setAdapter(miYouQuanListAdapter);

        return view;
    }

    @Override
    protected void initData() {
    }
}
