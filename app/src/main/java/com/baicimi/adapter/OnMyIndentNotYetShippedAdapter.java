package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.OnMyIndentNotYetShippedEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */
public class OnMyIndentNotYetShippedAdapter extends BaseAdapter{

    private Context context;
    private List<OnMyIndentNotYetShippedEntry> list;
    private LayoutInflater inflater;

    public OnMyIndentNotYetShippedAdapter(Context context, List<OnMyIndentNotYetShippedEntry> list) {
        this.context = context;
        this.list = list;
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
        OnMyIndentNotYetShippedHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.onmy_indent_notyetshipped_adapter , null);
            holder = new OnMyIndentNotYetShippedHolder();
            holder.store = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_store);
            holder.state = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_state);
            holder.imageUrl = (ImageView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_imageurl);
            holder.newMoney = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_newmoney);
            holder.oldMoney = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_oldmoney);
            holder.content = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_content);
            holder.number = (TextView) view.findViewById(R.id.onmy_indent_not_yetshipped_adapter_number);
            holder.aggregate = (TextView) view.findViewById(R.id.onmy_indent_notyetshipped_adapter_aggregate);
            holder.lookLogistics = (TextView) view.findViewById(R.id.onmy_indent_notyetshipped_adapter_lookLogistics);
            view.setTag(holder);
        }else{
            holder = (OnMyIndentNotYetShippedHolder) view.getTag();
        }
        OnMyIndentNotYetShippedEntry init = (OnMyIndentNotYetShippedEntry) getItem(i);
        holder.store.setText(init.getStore());
        holder.state.setText(init.getState());
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.newMoney.setText(init.getNewMoney());
        holder.number.setText(init.getNumber());
        holder.oldMoney.setText(init.getOldMoney());
        holder.content.setText(init.getContent());
        holder.aggregate.setText(init.getAggregate());




        return view;
    }

    public class OnMyIndentNotYetShippedHolder{
        private TextView store;
        private TextView state;
        private ImageView imageUrl;
        private TextView newMoney;
        private TextView oldMoney;
        private TextView content;
        private TextView number;
        private TextView aggregate;
        private TextView lookLogistics;
    }

}
