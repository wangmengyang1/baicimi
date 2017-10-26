package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.UseEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class GatherListViewAdapter extends BaseAdapter {

    private List<UseEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public GatherListViewAdapter(List<UseEntry> list, Context context) {
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
        GatherListViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.gather_listview_adapater, null);
            holder = new GatherListViewHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.gether_listview_adapter_imageurl);
            holder.content = (TextView) view.findViewById(R.id.gether_listview_adapter_content);
            holder.more = (TextView) view.findViewById(R.id.gether_listview_adapter_more);
            view.setTag(holder);
        } else {
            holder = (GatherListViewHolder) view.getTag();
        }

        UseEntry init = (UseEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.content.setText(init.getContent());
        holder.more.setText(init.getMore());
        return view;
    }

    public class GatherListViewHolder {
        private ImageView imageUrl;
        private TextView content;
        private TextView more;

    }
}
