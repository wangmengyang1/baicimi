package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.entity.HomePageBrandHeadEntry;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class GridViewHeadAdapter extends BaseAdapter{

    private Context context;
    private List<HomePageBrandHeadEntry> list_gvHead;
    private LayoutInflater inflater;

    public GridViewHeadAdapter(Context context, List<HomePageBrandHeadEntry> list_gvHead) {
        this.context = context;
        this.list_gvHead = list_gvHead;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_gvHead.size();
    }

    @Override
    public Object getItem(int i) {
        return list_gvHead.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GridViewHeadHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.gridview_head_adapter , null);
            holder = new GridViewHeadHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.gridview_head_adapter_image);
            view.setTag(holder);
        }else{
            holder = (GridViewHeadHolder) view.getTag();
        }
        HomePageBrandHeadEntry init = (HomePageBrandHeadEntry) getItem(i);
        Glide.with(context)
                .load(init.getImagerUrl())
                .into(holder.imageUrl);
//        holder.imageUrl.setImageResource(init.getImagerUrl());


        return view;
    }

    public class GridViewHeadHolder{
        private ImageView imageUrl;
    }

}
