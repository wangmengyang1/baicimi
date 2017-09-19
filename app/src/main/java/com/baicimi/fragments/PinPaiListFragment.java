package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.PinPaiLvAdapter;
import com.baicimi.adapter.ShaiXuanListAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.PinPaiLvBean;
import com.baicimi.bean.ShaiXuanListBean;

import java.util.ArrayList;

/**
 * Created by tan on 2016/9/2.
 * 品牌筛选界面ListView模式
 */
public class PinPaiListFragment extends BaseFragment{
    private ListView mList;
    private ArrayList<PinPaiLvBean> arrayList;
    private PinPaiLvAdapter xuanListAdapter;
    final PinPaiLvBean shaiXuanListBean_list=new PinPaiLvBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_pinpai_list,container,false);
        mList= (ListView) view.findViewById(R.id.pinpai_list);

        arrayList=new ArrayList<>();
        for (int i=0;i<10;i++){
            shaiXuanListBean_list.setName("【天天特价】正品韩国品驰长效补水修复去痘印面膜贴...");
            shaiXuanListBean_list.setPrice("¥67.94");
            shaiXuanListBean_list.setBuy_num("31人付款");
            shaiXuanListBean_list.setGood_pinglun("好评率95%");

            arrayList.add(shaiXuanListBean_list);
        }
        xuanListAdapter=new PinPaiLvAdapter(getActivity(),arrayList);
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
