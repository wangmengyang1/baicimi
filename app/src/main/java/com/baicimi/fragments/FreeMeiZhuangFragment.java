package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.FreeAreaGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ChangeRankingLvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/12/9.
 * 免费专区男士
 */
public class FreeMeiZhuangFragment extends BaseFragment{
    private GridView listView;
    private List<ChangeRankingLvBean> listBeen;
    private FreeAreaGvAdapter xuanGvAdapter;
    final ChangeRankingLvBean shaiXuanListBean_list=new ChangeRankingLvBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_free_man,container,false);

        listView= (GridView) view.findViewById(R.id.free_gv);
        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setName("动感婴儿车");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new FreeAreaGvAdapter(getActivity(),listBeen);
        listView.setAdapter(xuanGvAdapter);

        return view;
    }

    @Override
    protected void initData() {

    }
}
