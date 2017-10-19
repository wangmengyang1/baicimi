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
 * Created by Administrator on 2017/10/18.
 * 个人中心分期订单   列表详情页
 */
public class ByStagesGroupFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView back;
    private ListView listView;
    private List<MyOrderFormEntry> list = new ArrayList<>();
    private MyorderFormEntryAdapter adapter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.by_stages_group_fragment , container ,false);

        back = (ImageView) view.findViewById(R.id.by_stages_group_fragment_back);
        back.setOnClickListener(this);


        //listview布局填充
        initListView();

        return view;
    }


    //listview布局填充
    private void initListView() {
        listView = (ListView) view.findViewById(R.id.by_stages_group_fragment_listview);
        list.clear();
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "准备中" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "已退货" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "已退货" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "发货中" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01 , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "退款成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_02  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "交易成功" , new String("10:05")));
        list.add(new MyOrderFormEntry(R.drawable.image_dingdan_01  , new String("¥39") , new String("广州市白云区太和镇民营科技园火炬大厦1501号，白云区55000 广东省，广州市") , new String("分期订单") , "交易成功" , new String("10:05")));
        adapter = new MyorderFormEntryAdapter(list , getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String payment = list.get(i).getPayment();
                if (payment.equals("准备中")){
                    startFragment(new OrderFormFragmentReadly("分期订单"));//未成团页面
                }else if (payment.equals("已成团")){
                    startFragment(new MyGroupPurchaseListViewReach());//已成团页面
                }else if (payment.equals("已退货")){
                    startFragment(new OrderFormFragmentSales("分期订单"));//已退货
                }else if (payment.equals("发货中")){
                    startFragment(new OrderFormFragmentDeliver("分期订单"));//发货中
                }else if (payment.equals("交易成功")){
                    startFragment(new OrderFormFragmentDealsucced("分期订单"));//交易成功
                }else if (payment.equals("退款成功")){
                    startFragment(new OrderFormFragmentRefundesucceed());//退款成功
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
            case R.id.by_stages_group_fragment_back:
                ((MainActivity)getActivity()).goBack();//返回
                break;
        }
    }
}
