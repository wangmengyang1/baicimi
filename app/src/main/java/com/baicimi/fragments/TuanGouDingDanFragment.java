package com.baicimi.fragments;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.TuanGouDingDanLvtAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.bean.TuanGouDingDanLvBean;
import com.baicimi.view.TuanGouFootView;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;

/**
 * Created by tan on 2016/9/14.\
 * 团购订单界面
 */
public class TuanGouDingDanFragment extends BaseFragment{
    private ListView mList;
    private Button btn_tijiao;
    private ArrayList<TuanGouDingDanLvBean> arrayList;
    private TuanGouDingDanLvtAdapter tuanGouDingDanLvtAdapter;
    final TuanGouDingDanLvBean tuanGouDingDanLvBean_list=new TuanGouDingDanLvBean();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view=inflater.inflate(R.layout.fragment_tuangou_dingdan,container,false);
        mList= (ListView) view.findViewById(R.id.tuangou_dingdan_list);
        btn_tijiao= (Button) view.findViewById(R.id.btn_tuangou_tijiao);
        mList.addFooterView(new TuanGouFootView(getActivity()));
        arrayList=new ArrayList<>();
        for (int i=0;i<6;i++){
            tuanGouDingDanLvBean_list.setTv_tuangoods_message("包邮品驰专柜进口韩国面膜保湿补水正品女士祛痘疤去印修复蚕丝贴");
            tuanGouDingDanLvBean_list.setTv_tuangoods_yanse_num("颜色分类:韩国5片装");
            tuanGouDingDanLvBean_list.setTv_tuang_sendgoods_time("发货时间:卖家承诺24小时内发货");
            tuanGouDingDanLvBean_list.setTv_tuanggoods_price("¥130.80");
            tuanGouDingDanLvBean_list.setTv_tuanggoods_num("x1");
            tuanGouDingDanLvBean_list.setTv_tuanggoods_receive_man("收货人:");
            tuanGouDingDanLvBean_list.setTv_tuanggoods_receive_address("收货地址:广东省广州市白云区太和镇");
            arrayList.add(tuanGouDingDanLvBean_list);
        }
        tuanGouDingDanLvtAdapter=new TuanGouDingDanLvtAdapter(getActivity(),arrayList);
        mList.setAdapter(tuanGouDingDanLvtAdapter);


        btn_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new TuangouDingdanPurchaseFragment(),null);
            }
        });

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
