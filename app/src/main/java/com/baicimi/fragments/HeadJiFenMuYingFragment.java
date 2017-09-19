package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baicimi.R;
import com.baicimi.adapter.MuYingGoodsGvAdapter;
import com.baicimi.adapter.NanShiGoodsGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.MuYingYongPinGridViewBean;
import com.baicimi.ui.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/21.
 * 首页积分商城男士
 */
public class HeadJiFenMuYingFragment extends BaseFragment{
    /**
     * 母婴用品gridview
     * */
    private MyGridView gridView;
    private List<MuYingYongPinGridViewBean> listBeen;
    private NanShiGoodsGvAdapter xuanGvAdapter;
    final MuYingYongPinGridViewBean shaiXuanListBean_list=new MuYingYongPinGridViewBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
    view=inflater.inflate(R.layout.nanshi_gridview,container,false);


        /**
         * 母婴用品gridview
         * */
        gridView= (MyGridView) view.findViewById(R.id.nanshi_gv);
        listBeen=new ArrayList<>();
        for (int i=0;i<6;i++){
            shaiXuanListBean_list.setTv_goods_message("官方授权 自然堂乐园补水保湿");
            shaiXuanListBean_list.setTv_buy_um("45643人已购买");
            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new NanShiGoodsGvAdapter(getActivity(),listBeen);
        gridView.setAdapter(xuanGvAdapter);


        return view;
    }

    @Override
    protected void initData() {

    }
}
