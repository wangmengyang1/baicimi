package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PhoneTopUpBillEntry;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */
public class PhoneTopUpBillAdapter extends BaseAdapter{

    private List<PhoneTopUpBillEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public PhoneTopUpBillAdapter(List<PhoneTopUpBillEntry> list, Context context) {
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
        PhoneTopUpBillHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.phone_topup_bill_adapter , null);
            holder = new PhoneTopUpBillHolder();
            holder.date = (TextView) view.findViewById(R.id.phone_topup_bill_adapter_date);
            holder.imageUrl = (ImageView) view.findViewById(R.id.phone_topup_bill_adapter_imageurl);
            holder.money = (TextView) view.findViewById(R.id.phone_topup_bill_adapter_money);
            holder.content = (TextView) view.findViewById(R.id.phone_topup_bill_adapter_content);
            view.setTag(holder);
        }else{
            holder = (PhoneTopUpBillHolder) view.getTag();
        }


        PhoneTopUpBillEntry init = (PhoneTopUpBillEntry) getItem(i);

        holder.date.setText(init.getDate());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.money.setText(init.getMoney());
        holder.content.setText(init.getContent());

        return view;
    }

    public class PhoneTopUpBillHolder{
        private TextView date;
        private ImageView imageUrl;
        private TextView money;
        private TextView content;

    }

}
