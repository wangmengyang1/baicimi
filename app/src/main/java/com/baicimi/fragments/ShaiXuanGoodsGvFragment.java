package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.ShaiXuanGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/2.
 * 筛选界面GridView模式
 */
public class ShaiXuanGoodsGvFragment extends BaseFragment{
    private GridView gridView;
    private List<ShaiXuanListBean> listBeen;
    private ShaiXuanGvAdapter xuanGvAdapter;
    final ShaiXuanListBean shaiXuanListBean_list=new ShaiXuanListBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_shaixuan_gv,container,false);
        gridView= (GridView) view.findViewById(R.id.shaixuan_gv);
        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setTv_goods_name("湿美白蚕丝面膜贴女没...");
            shaiXuanListBean_list.setTv_jifendikou_num("5000");
            shaiXuanListBean_list.setJifendikou_mony_num("100");
            shaiXuanListBean_list.setTv_now_price("8908.00");
            shaiXuanListBean_list.setTv_used_price("9008.00");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new ShaiXuanGvAdapter(getActivity(),listBeen);
        gridView.setAdapter(xuanGvAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
