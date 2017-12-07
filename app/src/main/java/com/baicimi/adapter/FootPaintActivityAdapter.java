package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.FootPaintActivityEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */
public class FootPaintActivityAdapter extends BaseAdapter{

    private List<FootPaintActivityEntry> list;
    private Context context;
    private LayoutInflater inflater;


    public FootPaintActivityAdapter(List<FootPaintActivityEntry> list, Context context) {
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
        FootPaintActivityHolder holder  = null;
        if (view == null){
            view = inflater.inflate(R.layout.foot_paint_activity_adapter , null);
            holder = new FootPaintActivityHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.foot_paint_activity_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.foot_paint_activity_adapter_lible);
            holder.content = (TextView) view.findViewById(R.id.foot_paint_activity_adapter_content);
            view.setTag(holder);
        }else{
            holder = (FootPaintActivityHolder) view.getTag();
        }

        FootPaintActivityEntry init = (FootPaintActivityEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        holder.content.setText(init.getContent());

        return view;
    }

    public class FootPaintActivityHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView content;

    }

}
