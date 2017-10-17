package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PaymentAdencyEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */
public class PaymentAdencyAdapter extends BaseAdapter{

    private List<PaymentAdencyEntry> list;
    private Context context;
    private LayoutInflater inflater;
    private boolean isCheck;


    public PaymentAdencyAdapter(List<PaymentAdencyEntry> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public PaymentAdencyAdapter(List<PaymentAdencyEntry> list, Context context, boolean isCheck) {
        this.list = list;
        this.context = context;
        this.isCheck = isCheck;
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
        PaymentAdencyHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.payment_adency_adapter , null);
            holder = new PaymentAdencyHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.payment_adency_adapter_imageview);
            holder.lible = (TextView) view.findViewById(R.id.payment_adency_adapter_lible);
            holder.context = (TextView) view.findViewById(R.id.payment_adency_adapter_context);
            holder.specification = (TextView) view.findViewById(R.id.payment_adency_adapter_specification);
            holder.price = (TextView) view.findViewById(R.id.payment_adency_adapter_price);
            holder.isChecks = (TextView) view.findViewById(R.id.payment_adency_adaapter_integer_tv);
            view.setTag(holder);
        }else{
            holder = (PaymentAdencyHolder) view.getTag();
        }

        PaymentAdencyEntry init = (PaymentAdencyEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.context.setText(init.getContent());
        holder.specification.setText(init.getSpecification());
        holder.price.setText(init.getPrice());

        if (isCheck == true){
            holder.isChecks.setVisibility(View.VISIBLE);
        }else{
            holder.isChecks.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    public class PaymentAdencyHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView context;
        private TextView specification;
        private TextView price;
        private TextView isChecks;
    }

}
