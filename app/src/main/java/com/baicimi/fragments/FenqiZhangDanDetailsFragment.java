package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.FenQiZhangDanDetailListAdapter;
import com.baicimi.adapter.ZhangDanDetailListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.FenQiZhangDanDetailsBean;
import com.baicimi.bean.ZhangDanDetailsBean;
import com.baicimi.ui.MyListView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/12/22.
 * 账单分期明细
 */
public class FenqiZhangDanDetailsFragment extends BaseFragment{
    private MyListView myListView;
    private ArrayList<FenQiZhangDanDetailsBean> arrayList;
    private FenQiZhangDanDetailListAdapter eduListAdapter;
    final FenQiZhangDanDetailsBean eduBean=new FenQiZhangDanDetailsBean();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_zhangdanfenqi_detail,container,false);

        myListView= (MyListView) view.findViewById(R.id.check_zhangdan_list);

        arrayList=new ArrayList<>();
        for (int i=0;i<10;i++){
            eduBean.setTime("03-01");
            eduBean.setGoods_name("澳门十月初五  开心小八礼袋");
            eduBean.setMony_num("118.50");
            arrayList.add(eduBean);
        }
        eduListAdapter=new FenQiZhangDanDetailListAdapter(getActivity(),arrayList);
        myListView.setAdapter(eduListAdapter);

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
