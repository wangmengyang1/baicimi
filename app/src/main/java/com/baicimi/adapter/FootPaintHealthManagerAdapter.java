package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.FootPaintHealthManagerEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */
public class FootPaintHealthManagerAdapter extends BaseAdapter{

    private List<FootPaintHealthManagerEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public FootPaintHealthManagerAdapter(List<FootPaintHealthManagerEntry> list, Context context) {
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
        FootPaintHealthManagerHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.foot_paint_health_manager_adapter , null);
            holder = new FootPaintHealthManagerHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.foot_paint_health_manager_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.foot_paint_health_manager_adapter_lible);
            holder.date = (TextView) view.findViewById(R.id.foot_paint_health_manager_adapter_date);
            holder.content = (TextView) view.findViewById(R.id.foot_paint_health_manager_adapter_content);

            view.setTag(holder);
        }else{
            holder = (FootPaintHealthManagerHolder) view.getTag();
        }

        FootPaintHealthManagerEntry init = (FootPaintHealthManagerEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.date.setText(init.getDate());
        holder.content.setText(init.getContent());

        return view;
    }

    public class FootPaintHealthManagerHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView  date;
        private TextView content;
    }

}
