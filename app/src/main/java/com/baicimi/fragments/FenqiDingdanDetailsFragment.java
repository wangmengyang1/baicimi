package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.FenqiDingdanDetailsAdpter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.FenqiDingdanDetailsBean;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/12/24.
 * 银行卡分期订单详情/还款
 */
public class FenqiDingdanDetailsFragment extends BaseFragment{
    private ListView mList;
    private ArrayList<FenqiDingdanDetailsBean> arrayList;
    private FenqiDingdanDetailsAdpter xuanListAdapter;
    final FenqiDingdanDetailsBean shaiXuanListBean_list=new FenqiDingdanDetailsBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_fenqidingdan_details,container,false);

        mList= (ListView) view.findViewById(R.id.kafenqi_details_list);
        arrayList=new ArrayList<>();
        for (int i=0;i<3;i++){
            shaiXuanListBean_list.setMony_num("¥1770");
            arrayList.add(shaiXuanListBean_list);
        }
        xuanListAdapter=new FenqiDingdanDetailsAdpter(this,getActivity(),arrayList);
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


    public void starSeceesePayFragment(){
        startFragment(new SeccesePayMonyFragment(),null);
    }


    @Override
    protected void initData() {

    }
}
