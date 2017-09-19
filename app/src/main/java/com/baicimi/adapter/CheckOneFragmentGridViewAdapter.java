package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.baicimi.R;
import com.baicimi.entity.CheckOneFragmentGridViewEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */
public class CheckOneFragmentGridViewAdapter extends BaseAdapter{

    private Context context;
    private List<CheckOneFragmentGridViewEntry> list_gv;
    private LayoutInflater inflater;

    public CheckOneFragmentGridViewAdapter(Context context, List<CheckOneFragmentGridViewEntry> list_gv) {
        this.context = context;
        this.list_gv = list_gv;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list_gv.size();
    }

    @Override
    public Object getItem(int i) {
        return list_gv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckOneFragmentGridViewHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.check_one_fragment_gridview_adapter , null);
            holder = new CheckOneFragmentGridViewHolder();
            holder.imageUrl = (ImageView) view.findViewById(R.id.check_one_fragment_gridview_adapter_imageurl);
            view.setTag(holder);
        }else{
            holder = (CheckOneFragmentGridViewHolder) view.getTag();
        }
        CheckOneFragmentGridViewEntry init = (CheckOneFragmentGridViewEntry) getItem(i);
        holder.imageUrl.setImageResource(init.getImageUrl());

        return view;
    }

    public class CheckOneFragmentGridViewHolder{
        private ImageView imageUrl;
    }

}
