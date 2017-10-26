package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.EranEntry;
import com.baicimi.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class EranListViewAdater extends BaseAdapter{

    private List<EranEntry> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;


    public EranListViewAdater(List<EranEntry> list, Context context) {
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
        EranListViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.eran_listview_adapter , null);
            holder = new EranListViewHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.eran_listview_adapter_imageurl);
            holder.lible = (TextView) view.findViewById(R.id.eran_listview_adapter_lible);
            holder.moreFirst = (TextView) view.findViewById(R.id.eran_listview_adapter_morefirst);
            holder.moreSecond = (TextView) view.findViewById(R.id.eran_listview_adapter_moresecond);
            holder.content = (TextView) view.findViewById(R.id.eran_listview_adapter_content);
            view.setTag(holder);
        }else{
            holder = (EranListViewHolder) view.getTag();
        }

        EranEntry init = (EranEntry) getItem(i);

        holder.imageUrl.setImageResource(init.getImageUrl());
        holder.lible.setText(init.getLible());
        if (init.getMoreFirst().equals("null")){
            holder.moreFirst.setVisibility(View.GONE);
        }else {
            holder.moreFirst.setVisibility(View.VISIBLE);
            holder.moreFirst.setText(init.getMoreFirst());
        }

        holder.moreSecond.setText(init.getMoreSecond());
        holder.content.setText(init.getContent());

        return view;
    }

    public class EranListViewHolder{
        private ImageView imageUrl;
        private TextView lible;
        private TextView moreFirst;
        private TextView moreSecond;
        private TextView content;
    }

}