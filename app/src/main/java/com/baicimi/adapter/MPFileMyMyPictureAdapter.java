package com.baicimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baicimi.R;
import com.baicimi.entity.MPFileMyMyPictureEntry;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MPFileMyMyPictureAdapter extends BaseAdapter{

    private List<MPFileMyMyPictureEntry> list;
    private Context context;
    private LayoutInflater inflater;

    public MPFileMyMyPictureAdapter(List<MPFileMyMyPictureEntry> list, Context context) {
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
        MPFileMyMyPictureHolder holder = null;
        if (view == null){
            view = inflater.inflate(R.layout.mp_file_mymy_picture_adapter , null);
            holder = new MPFileMyMyPictureHolder();
            holder.lible = (TextView) view.findViewById(R.id.mp_file_mymy_picture_adapter_lible);
            holder.date = (TextView) view.findViewById(R.id.mp_file_mymy_picture_adapter_date);
            holder.imageUrl = (ImageView) view.findViewById(R.id.mp_file_mymy_picture_adapter_imageurl);
            view.setTag(holder);
        }else{
            holder = (MPFileMyMyPictureHolder) view.getTag();
        }

        MPFileMyMyPictureEntry init = (MPFileMyMyPictureEntry) getItem(i);

        holder.lible.setText(init.getLible());
        holder.date.setText(init.getDate());
        holder.imageUrl.setImageResource(init.getImageUrl());
        return view;
    }

    public class MPFileMyMyPictureHolder{
        private TextView lible;
        private ImageView imageUrl;
        private TextView date;
    }

}
