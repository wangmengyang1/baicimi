package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.NoreachEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
public class NoreachListViewAdapter extends BaseAdapter{

    private List<NoreachEntry> listLV;
    private Context context;
    private LayoutInflater inflater;

    public NoreachListViewAdapter(List<NoreachEntry> listLV, Context context) {
        this.listLV = listLV;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listLV.size();
    }

    @Override
    public Object getItem(int i) {
        return listLV.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NoReachHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.noreach_listview_adapter , null);
            holder = new NoReachHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.noreach_listview_adapter_imageurl);
            holder.name = (TextView) view.findViewById(R.id.noreach_listview_adapter_name);
            holder.number = (TextView) view.findViewById(R.id.noreach_listview_adapter_number);
            view.setTag(holder);
        }else {
            holder = (NoReachHolder) view.getTag();
        }
        NoreachEntry init = (NoreachEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.name.setText(init.getName());
        holder.number.setText(init.getNumber());

        return view;
    }

    public class NoReachHolder{
        private ImageView imageUrl;
        private TextView name;
        private TextView number;

    }

}
