package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.RosePersonalAllEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 * 个人中心首页适配器（未完成）
 */
public class RosePersonalAllAdapter extends BaseAdapter{
    private List<RosePersonalAllEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public RosePersonalAllAdapter(List<RosePersonalAllEntry> list, Context context) {
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
        RosePersonalHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.rose_personal_all_adapter , null);
            holder = new RosePersonalHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.rose_personal_all_adaapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.rose_personal_all_adaapter_lible);
            holder.name = (TextView) view.findViewById(R.id.rose_personal_all_adaapter_username);
            holder.address = (TextView) view.findViewById(R.id.rose_personal_all_adaapter_address);
            view.setTag(holder);
        }else{
            holder = (RosePersonalHolder) view.getTag();
        }
        RosePersonalAllEntry init = (RosePersonalAllEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.name.setText(init.getName());
        holder.address.setText(init.getAddress());
        return view;
    }

    public class RosePersonalHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView name;
        private TextView address;
    }

}
