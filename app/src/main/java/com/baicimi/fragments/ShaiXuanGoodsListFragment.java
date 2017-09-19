package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.ShaiXuanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;

/**
 * Created by tan on 2016/9/2.
 * 筛选界面ListView模式
 */
public class ShaiXuanGoodsListFragment extends BaseFragment{
    private ListView mList;
    private ArrayList<ShaiXuanListBean> arrayList;
    private ShaiXuanListAdapter xuanListAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_shaixuan_list,container,false);
        mList= (ListView) view.findViewById(R.id.shaixuan_list);

        arrayList=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setTv_goods_name("湿美白蚕丝面膜贴女没...");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            arrayList.add(shaiXuanListBean_list);
        }
        xuanListAdapter=new ShaiXuanListAdapter(getActivity(),arrayList);
        mList.setAdapter(xuanListAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startFragment(new GoodsDetailsFragment(),null);
            }
        });


        return view;
    }

    @Override
    protected void initData() {

    }
}
