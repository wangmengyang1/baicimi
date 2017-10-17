package com.baicimi.fragments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.baicimi.MainActivity;
import com.baicimi.R;
import com.baicimi.adapter.MyorderFormEntryAdapter;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MyOrderFormEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 * 个人中心，政府采购  我的政府采购
 */
public class GovernmentPurchaseMyorderformFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;

    private ListView listView;
    private List<MyOrderFormEntry> list = new ArrayList<>();
    private MyorderFormEntryAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.government_purchase_myorderform_fragment , container ,false);

        back = (ImageView) view.findViewById(R.id.government_purchase_fragment_myorderform_back);
        back.setOnClickListener(this);


        //listview布局填充
        initListView();

        return view;
    }



    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.usercenter_homepage_head_government_purchase_myorderform_fragment_listview);
        list.clear();
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "退款成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "已退款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "准备中" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "发货中" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("政府采购订单") , "待付款" , new String("10:05")));
        adapter = new MyorderFormEntryAdapter(list , getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(list.get(i).getPayment().equals("待付款")){
                    startFragment(new PaymentAdencyFragment("政府采购订单"));
                } else if (list.get(i).getPayment().equals("准备中")){
                    startFragment(new OrderFormFragmentReadly("政府采购订单"));
                }else if (list.get(i).getPayment().equals("发货中")){
                    startFragment(new OrderFormFragmentDeliver("政府采购订单"));
                }else if (list.get(i).getPayment().equals("交易成功")){
                    startFragment(new OrderFormFragmentDealsucced("政府采购订单"));
                }else if (list.get(i).getPayment().equals("已撤销")){
                    startFragment(new OrderFormFragmentRevocation("政府采购订单"));
                }else if (list.get(i).getPayment().equals("已退货")){
                    startFragment(new OrderFormFragmentSales("政府采购订单"));
                }else if (list.get(i).getPayment().equals("已退款")){
                    startFragment(new OrderFormFragmentRefundesucceed("政府采购订单"));
                }else if (list.get(i).getPayment().equals("我的订单")){
                    startFragment(new OrderFormFragmentReadly());
                }
            }
        });
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.government_purchase_fragment_myorderform_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级界面
                break;
        }
    }
}
