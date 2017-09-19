package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.ChangeRankingListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ChangeRankingLvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/12/9.
 * 兑换排行男士
 */
public class ChangeRankingPersonFragment extends BaseFragment{
    private ListView listView;
    private List<ChangeRankingLvBean> listBeen;
    private ChangeRankingListAdapter xuanGvAdapter;
    final ChangeRankingLvBean shaiXuanListBean_list=new ChangeRankingLvBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_change_ranking_lv,container,false);

        listView= (ListView) view.findViewById(R.id.change_ranking_list);
        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setName("官方授权  自然堂乐园补水保湿");
            shaiXuanListBean_list.setNo("NO.1");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new ChangeRankingListAdapter(getActivity(),listBeen);
        listView.setAdapter(xuanGvAdapter);

        return view;
    }

    @Override
    protected void initData() {

    }
}
