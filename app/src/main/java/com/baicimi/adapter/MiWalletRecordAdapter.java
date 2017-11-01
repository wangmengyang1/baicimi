package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MiWalletRecordEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public class MiWalletRecordAdapter extends BaseAdapter{

    private List<MiWalletRecordEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MiWalletRecordAdapter(List<MiWalletRecordEntry> list, Context context) {
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
        MiWalletRecordHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.miwallet_record_adapter , null);
            holder = new MiWalletRecordHolder();
            holder.date = (TextView) view.findViewById(R.id.miwallet_record_adapter_date);
            holder.content = (TextView) view.findViewById(R.id.miwallet_record_adapter_content);
            holder.state = (TextView) view.findViewById(R.id.miwallet_record_adapter_state);
            holder.money = (TextView) view.findViewById(R.id.miwallet_record_adapter_money);

            view.setTag(holder);
        }else{
            holder = (MiWalletRecordHolder) view.getTag();
        }

        MiWalletRecordEntry init = (MiWalletRecordEntry) getItem(i);
        holder.date.setText(init.getDate());
        holder.content.setText(init.getContent());
        holder.state.setText(init.getState());
        holder.money.setText(init.getMoney());

        return view;
    }

    public class MiWalletRecordHolder{
        private TextView date;
        private TextView content;
        private TextView state;
        private TextView money;

    }

}
