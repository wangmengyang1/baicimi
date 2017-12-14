package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.PaymentAdencyGovernmentCusEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
public class PaymentAdencyGovernmentCusListAdapter extends BaseAdapter{

    private  List<PaymentAdencyGovernmentCusEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public PaymentAdencyGovernmentCusListAdapter(List<PaymentAdencyGovernmentCusEntry> list, Context context) {
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
        PaymentAdencyGovernmentCusListHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.payment_adency_government_cuslist_adapter , null);
            holder = new PaymentAdencyGovernmentCusListHolder();
            holder.date = (TextView) view.findViewById(R.id.payment_adency_government_cuslist_adapter_date);
            holder.lible = (TextView) view.findViewById(R.id.payment_adency_government_cuslist_adapter_lible);
            holder.code = (TextView) view.findViewById(R.id.payment_adency_government_cuslist_adapter_code);
            holder.state = (TextView) view.findViewById(R.id.payment_adency_government_cuslist_adapter_state);
            holder.particulars = (TextView) view.findViewById(R.id.payment_adency_government_cuslist_adapter_particulars);

            view.setTag(holder);
        }else{
            holder = (PaymentAdencyGovernmentCusListHolder) view.getTag();
        }

        PaymentAdencyGovernmentCusEntry init = (PaymentAdencyGovernmentCusEntry) getItem(i);

        holder.date.setText(init.getDate());
        holder.lible.setText(init.getLible());
        holder.code.setText(init.getCode());
        holder.state.setText(init.getState());

        return view;
    }

    public class PaymentAdencyGovernmentCusListHolder{
        private TextView date;
        private TextView lible;
        private TextView code;
        private TextView state;
        private TextView particulars;
    }

}
