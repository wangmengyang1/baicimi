package com.baicimi.fragments;

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
 * 个人中心  亲密付  我的亲密付页面
 */
public class UserCenterHomepageHeadIntimacyMyorderform extends BaseFragment implements View.OnClickListener {

    private View view;


    private ListView listView;
    private List<MyOrderFormEntry> list = new ArrayList<>();
    private MyorderFormEntryAdapter adapter;

    private ImageView back;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.usercenter_homepage_head_intimacy_myorderform , container , false);


        //listview布局填充
        initListView();

        back = (ImageView) view.findViewById(R.id.usercenter_homepagehead_myorderform_fragment_back);
        back.setOnClickListener(this);

        return view;
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.usercenter_homepage_head_intimacy_my_order_form_fragment_listview);
        list.clear();
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "待付款" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("亲密付订单") , "待付款" , new String("10:05")));
        adapter = new MyorderFormEntryAdapter(list , getContext());
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(lible.equals("待付款")){
//                    startFragment(new PaymentAdencyFragment());
//                }else if (lible.equals("准备中")){
//                    startFragment(new OrderFormFragmentReadly());
//                }else if (lible.equals("发货中")){
//                    startFragment(new OrderFormFragmentDeliver());
//                }else if (lible.equals("交易成功")){
//                    startFragment(new OrderFormFragmentDealsucced());
//                }else if (lible.equals("已撤销")){
//                    startFragment(new OrderFormFragmentRevocation());
//                }else if (lible.equals("已退货")){
//                    startFragment(new OrderFormFragmentSales());
//                }else if (lible.equals("退款成功")){
//                    startFragment(new OrderFormFragmentRefundesucceed());
//                }else if (lible.equals("我的订单")){
//                    startFragment(new OrderFormFragmentReadly());
//                }
//            }
//        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usercenter_homepagehead_myorderform_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回到上一级页面
                break;
        }
    }
}
