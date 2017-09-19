package com.baicimi.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.base.BaseFragment;
import com.baicimi.entity.MyOrderFormEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */
public class MyorderFormEntryAdapter extends BaseAdapter{

    private List<MyOrderFormEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MyorderFormEntryAdapter(List<MyOrderFormEntry> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyOrderFormHoldre holdre = null;
        if(view == null){
            view = inflater.inflate(R.layout.my_order_form_entry_adapter , null);
            holdre = new MyOrderFormHoldre();
            holdre.imageUrl = (ImageView) view.findViewById(R.id.my_order_form_entry_adapter_imageurl);
            holdre.money = (TextView) view.findViewById(R.id.my_order_form_entry_adapter_money);
            holdre.address = (TextView) view.findViewById(R.id.my_order_form_entry_adapter_address);
            holdre.state = (TextView) view.findViewById(R.id.my_order_form_entry_adapter_state);
            holdre.payment = (TextView) view.findViewById(R.id.my_order_form_entry_adapter_payment);
            holdre.date = (TextView) view.findViewById(R.id.my_order_form_entry_adapter_date);

            view.setTag(holdre);
        }else{
            holdre = (MyOrderFormHoldre) view.getTag();
        }

        MyOrderFormEntry init = (MyOrderFormEntry) getItem(i);
        holdre.imageUrl.setImageResource(init.getImageUrl());
        holdre.money.setText(init.getMoney());
        holdre.address.setText(init.getAddress());
        holdre.state.setText(init.getState());
        holdre.payment.setText(init.getPayment());
        holdre.date.setText(init.getDate());
        return view;
    }

    public class MyOrderFormHoldre{
        private ImageView imageUrl;
        private TextView money;
        private TextView address;
        private TextView state;
        private TextView payment;
        private TextView date;

    }

}
