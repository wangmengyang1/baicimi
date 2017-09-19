package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.baicimi.R;
import com.baicimi.adapter.GeRenGoodsGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.GeRenYongPinGridViewBean;
import com.baicimi.ui.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/10/20.
 * 活动户外运动界面
 */
public class HuWaiFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    /** 母婴用品gridview
     */
    private MyGridView gridView;
    private List<GeRenYongPinGridViewBean> listBeen;
    private GeRenGoodsGvAdapter geRenGoodsGvAdapter;
    final GeRenYongPinGridViewBean shaiXuanListBean_list=new GeRenYongPinGridViewBean();



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.head_gridview,container,false);
        /**
         * 母婴用品gridview
         * */
//        gridView= (MyGridView) view.findViewById(R.id.persan_bottom_vp);
//        listBeen=new ArrayList<>();
//        for (int i=0;i<9;i++){
//            shaiXuanListBean_list.setTv_goods_message("自然堂乐园补水保湿");
//            shaiXuanListBean_list.setTv_now_price("¥39");
//            listBeen.add(shaiXuanListBean_list);
//        }
//
//        geRenGoodsGvAdapter=new GeRenGoodsGvAdapter(getActivity(),listBeen);
//        gridView.setAdapter(geRenGoodsGvAdapter);
//        gridView.setOnItemClickListener(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //需要数据进行传送（暂无数据）
        startFragment(new GoodsDetailsFragment(),null);
    }
}

