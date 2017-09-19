package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapter;
import com.baicimi.adapter.HeadPinPaiActivityGvAdapterSecond;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class SevenMonFragmentGridViewFragment extends BaseFragment {

    private View view;
    private List<ShaiXuanListBean> listBeen;
    private HeadPinPaiActivityGvAdapterSecond xuanGvAdapter;
    private GridView gridView;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.seven_mon_fragment_gridview_fragment , container , false);



        gridView= (GridView) view.findViewById(R.id.seven_mon_fragment_gridview_grideview);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_name("洗发水");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new HeadPinPaiActivityGvAdapterSecond(getContext(),listBeen  , this);
        gridView.setAdapter(xuanGvAdapter);

        return view;
    }

    @Override
    protected void initData() {

    }
}
