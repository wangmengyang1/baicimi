package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.baicimi.R;
import com.baicimi.adapter.PinPaiGvAdapter;
import com.baicimi.adapter.ShaiXuanGvAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.PinPaiGvBean;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan on 2016/9/2.
 * 品牌筛选界面GridView模式
 */
public class PinPaiChooseGvFragment extends BaseFragment{
    private GridView gridView;
    private List<PinPaiGvBean> listBeen;
    private PinPaiGvAdapter xuanGvAdapter;
    final PinPaiGvBean shaiXuanListBean_list=new PinPaiGvBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_pinpai_gv,container,false);
        gridView= (GridView) view.findViewById(R.id.pinpai_gv);
        listBeen=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setName("【天天特价】正品韩国品驰长效补水修复去痘印面膜贴...");
            shaiXuanListBean_list.setPrice("¥67.94");
            shaiXuanListBean_list.setBuy_num("31人付款");

            listBeen.add(shaiXuanListBean_list);
        }
        xuanGvAdapter=new PinPaiGvAdapter(getActivity(),listBeen);
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
