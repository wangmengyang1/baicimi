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
public class UseListViewAdapter extends BaseAdapter{

    private List<UseEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public UseListViewAdapter(List<UseEntry> list, Context context) {
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
        UseListViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.use_listview_adapater, null);
            holder = new UseListViewHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.use_listview_adapter_imageurl);
            holder.content = (TextView) view.findViewById(R.id.use_listview_adapter_content);
            holder.more = (TextView) view.findViewById(R.id.use_listview_adapter_more);
            view.setTag(holder);
        }else{
            holder = (UseListViewHolder) view.getTag();
        }

        UseEntry init = (UseEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.content.setText(init.getContent());
        if (init.getMore().equals("null")){
            holder.more.setVisibility(View.GONE);
        }else{
            holder.more.setVisibility(View.VISIBLE);
            holder.more.setText(init.getMore());
        }

        return view;
    }

    public class UseListViewHolder{
        private ImageView imageUrl;
        private TextView content;
        private TextView more;

    }

}
