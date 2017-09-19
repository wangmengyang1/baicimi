package com.baicimi.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baicimi.R;
import com.baicimi.adapter.GouWuCheGvAdapter;
import com.baicimi.adapter.MyDingDanListAdapter;
import com.baicimi.adapter.MyDingDanNoEvaluateAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.GouWuCheGvBean;
import com.baicimi.bean.MyDingDanLvBean;
import com.baicimi.ui.MyGridView;
import com.baicimi.ui.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 * 未评价订单
 */
public class NoPingJiaDingDanFragment extends BaseFragment{
    private MyListView mList;
    private ArrayList<MyDingDanLvBean> arrayList;
//    private MyDingDanListAdapter myListAdapter;
    private MyDingDanNoEvaluateAdapter myListAdapter;
    final MyDingDanLvBean myDingdanListBean_list=new MyDingDanLvBean();

    private MyGridView gvList;
    private GouWuCheGvAdapter wuCheGvAdapter;
    private List<GouWuCheGvBean> gvBeanArrayList;
    final GouWuCheGvBean gouWuCheGvBean = new GouWuCheGvBean();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_mydingdan,container,false);
        mList= (MyListView) view.findViewById(R.id.my_dingdan_list);
        gvList = (MyGridView) view.findViewById(R.id.my_dingdan_gv);


        arrayList=new ArrayList<>();
        for (int i=0;i<5;i++){
            myDingdanListBean_list.setTv_my_dingdan_goods_message("懒人手机支架床头桌面创意架子多功能通用配...");
            myDingdanListBean_list.setTv_my_dingdan_goods_color("颜色:【加强版】NZJ-02白色双夹");
            myDingdanListBean_list.setTv_my_dingdan_goods_price("¥124");
            myDingdanListBean_list.setTv_my_dingdan_goods_num("x1");
            myDingdanListBean_list.setTv_my_dingdan_goods_allprice("¥124");
            myDingdanListBean_list.setTv_my_dingdan_goods_allnum("共1件");
            arrayList.add(myDingdanListBean_list);
        }
        myListAdapter=new MyDingDanNoEvaluateAdapter(getActivity(),arrayList);
        mList.setAdapter(myListAdapter);



        /**
         * 购物车列表GridView
         */
        gvBeanArrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            gouWuCheGvBean.setTv_gouwuche_gv_goods_message("包邮韩国进口品驰长效补水祛痘控油收缩毛用温和保...");
            gouWuCheGvBean.setTv_gouwuche_gv_goods_price("¥138.80");
            gouWuCheGvBean.setTv_gouwuche_gv_goods_paynum("0人付款");
            gvBeanArrayList.add(gouWuCheGvBean);
        }
        wuCheGvAdapter = new GouWuCheGvAdapter(getContext(), gvBeanArrayList);
        gvList.setAdapter(wuCheGvAdapter);
        return view;
    }

    @Override
    protected void initData() {

    }
}
